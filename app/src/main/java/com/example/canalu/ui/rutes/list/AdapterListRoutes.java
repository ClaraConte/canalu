package com.example.canalu.ui.rutes.list;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.canalu.R;
import com.example.canalu.model.MapsItems;
import com.example.canalu.model.MapsRoutes;
import com.example.canalu.model.Users;

import java.util.ArrayList;
import java.util.List;

public class AdapterListRoutes extends ArrayAdapter<MapsItems> {

    private  Context context;
    private  List<MapsItems> lista;
    private  LayoutInflater li;


    public AdapterListRoutes(@NonNull Context context, int resource, @NonNull ArrayList<MapsItems> objects, LayoutInflater li) {
        super(context, resource, objects);
        this.context = context;
        this.lista = objects;
        this.li = li;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View itemView = convertView;
        MapsItems customers = new MapsItems();
        customers=  lista.get(position);

        if(itemView == null){
            itemView = li.inflate(R.layout.item_view_list_routes,parent,false);
        }

        TextView nameStore= itemView.findViewById(R.id.name_store);
        nameStore.setText(customers.getUsers().getAddress().get(0).getCommerces().getCommercesName()+"");

        TextView addressStore = itemView.findViewById(R.id.address_store);
        addressStore.setText(customers.getUsers().getAddress().get(0).getAddressStreet()+" "+customers.getUsers().getAddress().get(0).getAddressNumber());

        ImageView imageView = itemView.findViewById(R.id.imageView);
        if(customers.getMapsItemsVisited()){
            imageView.setImageResource(R.drawable.ic_check_black_24dp);
        }else{
            imageView.setImageResource(R.drawable.ic_place_black_24dp);
        }

        return itemView;
    }
}
