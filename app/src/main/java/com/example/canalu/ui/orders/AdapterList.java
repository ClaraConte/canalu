package com.example.canalu.ui.orders;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.canalu.R;
import com.example.canalu.model.Orders;
import com.example.canalu.model.Users;

import java.util.ArrayList;
import java.util.List;

public class AdapterList extends ArrayAdapter<Orders> {

    private  Context context;
    private  List<Orders> lista;
    private  LayoutInflater li;


    public AdapterList(@NonNull Context context, int resource, @NonNull ArrayList<Orders> objects, LayoutInflater li) {
        super(context, resource, objects);
        this.context = context;
        this.lista = objects;
        this.li = li;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View itemView = convertView;
        Orders orders = lista.get(position);

        if(itemView == null){
            itemView = li.inflate(R.layout.item_view_orders,parent,false);
        }

        TextView nameStore = itemView.findViewById(R.id.order_name_store);
        nameStore.setText(orders.getUsers().getUsersFirstName()+","+orders.getUsers().getUsersLastName());

        return itemView;
    }
}

