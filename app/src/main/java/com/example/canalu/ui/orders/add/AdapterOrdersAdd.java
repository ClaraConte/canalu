package com.example.canalu.ui.orders.add;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;

import com.example.canalu.R;
import com.example.canalu.model.MapsItems;

import java.util.ArrayList;
import java.util.List;

    public class AdapterOrdersAdd extends ArrayAdapter<MapsItems> {
        private Context context;
        private ArrayList<MapsItems> lista;
        private LayoutInflater li;


        public AdapterOrdersAdd(@NonNull Context context, int resource, @NonNull ArrayList<MapsItems> objects, LayoutInflater li) {
            super(context, resource, objects);
            this.context = context;
            this.lista = objects;
            this.li = li;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View itemView = convertView;
            MapsItems customers = lista.get(position);

            if(itemView == null){
                itemView = li.inflate(R.layout.item_orders_add,parent,false);
            }

            TextView nameStore = itemView.findViewById(R.id.name_store_add);
            TextView addressStore = itemView.findViewById(R.id.address_store_add);

            nameStore.setText(customers.getUsers().getAddress().get(0).getCommerces().getCommercesName());
            addressStore.setText(customers.getUsers().getAddress().get(0).getAddressStreet()+", "
                    +customers.getUsers().getAddress().get(0).getAddressNumber()+", "
                    +customers.getUsers().getAddress().get(0).getLocations().getLocationsName()+", "
                    +customers.getUsers().getAddress().get(0).getLocations().getProvinces().getProvincesName());

            return itemView;
        }

    }
