package com.example.canalu.ui.rutes.list;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.canalu.R;
import com.example.canalu.model.Users;

import java.util.List;

public class AdapterListRoutes extends ArrayAdapter<Users> {

    private  Context context;
    private  List<Users> lista;
    private  LayoutInflater li;


    public AdapterListRoutes(@NonNull Context context, int resource, @NonNull List<Users> objects, LayoutInflater li) {
        super(context, resource, objects);
        this.context = context;
        this.lista = objects;
        this.li = li;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View itemView = convertView;
        Users customers = lista.get(position);

        if(itemView == null){
            itemView = li.inflate(R.layout.item_view_list_routes,parent,false);
        }

        TextView nameStore= itemView.findViewById(R.id.name_store);
        nameStore.setText(customers.getUsersFirstName()+","+customers.getAddress());

        TextView addressStore = itemView.findViewById(R.id.address_store);
        addressStore.setText(customers.getAddress());

        return itemView;
    }
}
