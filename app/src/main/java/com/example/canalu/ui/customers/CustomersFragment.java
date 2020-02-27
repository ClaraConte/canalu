package com.example.canalu.ui.customers;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.canalu.R;
import com.example.canalu.model.MapsItems;
import com.example.canalu.ui.customers.details.CustomersDetailsActivity;

import java.io.Serializable;
import java.util.ArrayList;

public class CustomersFragment extends Fragment {

    private CustomersViewModel customersViewModel;

    private ArrayList<MapsItems> lista = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        customersViewModel =
                ViewModelProviders.of(this).get(CustomersViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_customers, container, false);
        final TextView textView = root.findViewById(R.id.text_list_routes);

        customersViewModel.getRoutes();
        customersViewModel.getError().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String string) {
                textView.setText(string);
            }
        });
        customersViewModel.getMapsRoutes().observe(this, new Observer<MapsItems>() {
            @Override
            public void onChanged(MapsItems mapsItems) {
            lista.add(mapsItems);
            // Carga vista contenedora con el ListView
            final ListView listView = root.findViewById(R.id.listCustomers );

            // crea un inmueble_item para cada elemento de la lista asignados
            ArrayAdapter<MapsItems> adapter = new AdapterCustomersDetails(getContext(), R.layout.item_view_list_customers, lista, getLayoutInflater());
            listView.setAdapter(adapter);

            // Crea un listener para cada elemento
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                LayoutInflater inflater;

                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                    MapsItems mapsItems = new MapsItems();
                    mapsItems = lista.get(position);


                    Bundle bundle = new Bundle();
                    bundle.putSerializable("list", mapsItems);

                    Intent i = new Intent(getContext(), CustomersDetailsActivity.class);
                    i.putExtras(bundle);
                    startActivity(i);
                }
            });
            }
        });
        return root;
    }
}