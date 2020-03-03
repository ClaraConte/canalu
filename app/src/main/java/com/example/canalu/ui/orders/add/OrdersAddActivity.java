package com.example.canalu.ui.orders.add;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.canalu.R;
import com.example.canalu.model.MapsItems;
import com.example.canalu.ui.customers.AdapterCustomersDetails;
import com.example.canalu.ui.customers.details.CustomersDetailsActivity;
import com.example.canalu.ui.orders.create.CreateOrderActivity;
import com.example.canalu.ui.rutes.details.RoutesDetailsActivity;
import com.example.canalu.ui.rutes.list.AdapterListRoutes;
import com.example.canalu.ui.rutes.list.ListRoutesViewModel;

import java.util.ArrayList;

public class OrdersAddActivity  extends AppCompatActivity {

    private OrdersAddViewModel ordersAddViewModel;
    private TextView textView;
    private ArrayList<MapsItems> lista = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders_add);
        ordersAddViewModel = ViewModelProviders.of(this).get(OrdersAddViewModel.class);
        ordersAddViewModel.getError().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String string) {
                textView.setText(string);
            }
        });
        ordersAddViewModel.getRoutes();
        ordersAddViewModel.getMapsRoutes().observe(this, new Observer<MapsItems>() {
            @Override
            public void onChanged(MapsItems mapsItems) {
                lista.add(mapsItems);
                // Carga vista contenedora con el ListView
                final ListView listView = findViewById(R.id.ordersAddListUser );

                // crea un inmueble_item para cada elemento de la lista asignados
                ArrayAdapter<MapsItems> adapter = new AdapterOrdersAdd(getApplicationContext(), R.layout.activity_orders_add, lista, getLayoutInflater());
                listView.setAdapter(adapter);

                // Crea un listener para cada elemento
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    LayoutInflater inflater;

                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                        MapsItems mapsItems = new MapsItems();
                        mapsItems = lista.get(position);


                        Bundle bundle = new Bundle();
                        bundle.putSerializable("list", mapsItems);

                        Intent i = new Intent(getApplicationContext(), CreateOrderActivity.class);
                        i.putExtras(bundle);
                        startActivity(i);
                    }
                });
            }
        });

    }

}
