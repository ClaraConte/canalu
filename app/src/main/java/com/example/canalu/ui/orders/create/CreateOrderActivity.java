package com.example.canalu.ui.orders.create;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.canalu.R;
import com.example.canalu.model.MapsItems;
import com.example.canalu.model.Orders;
import com.example.canalu.model.OrdersDetails;
import com.example.canalu.model.Products;
import com.example.canalu.ui.orders.add.AdapterOrdersAdd;
import com.example.canalu.ui.orders.add.OrdersAddViewModel;

import java.util.ArrayList;

public class CreateOrderActivity  extends AppCompatActivity {
   private  CreateOrderViewModel createOrderViewModel;
    private TextView textView;
    private ArrayList<Products> lista = new ArrayList<>();
    private MapsItems mapsItems = new MapsItems();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders_create);
        mapsItems = this.getIntent().getExtras().getParcelable("list");

        createOrderViewModel = ViewModelProviders.of(this).get(CreateOrderViewModel.class);
        createOrderViewModel.getError().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String string) {
                Toast.makeText(getApplicationContext(),string.toString() ,Toast.LENGTH_LONG).show();
            }
        });

        createOrderViewModel.getProductsDetails();
        createOrderViewModel.getProducts().observe(this, new Observer<ArrayList<Products>>() {
            @Override
            public void onChanged(ArrayList<Products> products) {

                lista.addAll(products);
                // Carga vista contenedora con el ListView
                final ListView listView = findViewById(R.id.ordersCreateProducts );

                // crea un inmueble_item para cada elemento de la lista asignados
                ArrayAdapter<Products> adapter = new AdapterOrdersCreate(getApplicationContext(), R.layout.activity_orders_create, lista, getLayoutInflater());
                listView.setAdapter(adapter);

                // Crea un listener para cada elemento
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    LayoutInflater inflater;

                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        Products products = new Products();
                        products = lista.get(position);
                         ArrayList<OrdersDetails> ordersDetails  = new  ArrayList<OrdersDetails>();
                        Orders orders = new Orders();

                        orders.setUsers(mapsItems.getUsers());
                        ordersDetails.get(0).setProducts(products);
                        orders.setOrdersDetails(ordersDetails);

                        //llamar a guardar producto a cliente


                    }
                });
            }
        });
    }
}
