package com.example.canalu.ui.orders;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.canalu.R;
import com.example.canalu.model.Users;
import com.example.canalu.ui.rutes.details.RoutesDetailsActivity;
import com.example.canalu.ui.rutes.list.AdapterListRoutes;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class OrdersFragment extends Fragment {

    private OrdersViewModel ordersViewModel;
    private ArrayList<Users> clientes = new ArrayList<>();


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ordersViewModel =
                ViewModelProviders.of(this).get(OrdersViewModel.class);
        View root = inflater.inflate(R.layout.fragment_orders, container, false);

        FloatingActionButton fab = root.findViewById(R.id.fab_Order);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "agregar un pedido a un usuario", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        ordersViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

                Users usuario = new Users(2, "Juan","perez", (long) 23323,2,"los lapachos 232","2323234","mnnd@mksdc.com","24-02-2012");
                clientes.add(usuario);
                Users usuario1 = new Users(2, "Nicolas","Conte", (long) 23323,2,"los molinos 232","2323234","mnnd@mksdc.com","24-02-2012");
                clientes.add(usuario1);

            }
        });


        // Carga vista contenedora con el ListView
        final ListView listView = root.findViewById(R.id.listOrders);

        // crea un inmueble_item para cada elemento de la lista asignados
        ArrayAdapter<Users> adapter = new AdapterList(getContext(), R.layout.item_view_orders, clientes, getLayoutInflater());
        listView.setAdapter(adapter);

        // Crea un listener para cada elemento
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            LayoutInflater inflater;

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ArrayList<Users> list= new ArrayList<Users>();
                list.add(clientes.get((int)id));

                Bundle bundle = new Bundle();
                bundle.putSerializable("list", clientes);

                /*Intent i = new Intent(getContext(), RoutesDetailsActivity.class);
                i.putExtras(bundle);
                startActivity(i);*/

            }
        });
        return root;
    }
}