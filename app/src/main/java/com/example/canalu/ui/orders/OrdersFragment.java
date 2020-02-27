package com.example.canalu.ui.orders;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.canalu.R;
import com.example.canalu.model.Orders;


import com.example.canalu.ui.orders.details.OrdersDetailsActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class OrdersFragment extends Fragment {

    private OrdersViewModel ordersViewModel;
    private View root;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ordersViewModel = ViewModelProviders.of(this).get(OrdersViewModel.class);
        root = inflater.inflate(R.layout.fragment_orders, container, false);

        FloatingActionButton fab = root.findViewById(R.id.fab_Order);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "agregar un pedido a un usuario", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            }
        });

        ordersViewModel.getOrders().observe(this, new Observer<ArrayList<Orders>>() {
            @Override
            public void onChanged(ArrayList<Orders> orders) {
                loadList(root, orders);
            }
        });

        ordersViewModel.getOrdersData();
        return root;
    }

    public void loadList(View root, final ArrayList<Orders> orders) {
        final ListView listView = root.findViewById(R.id.listOrders);
        ArrayAdapter<Orders> adapter = new AdapterList(getContext(), R.layout.item_view_orders, orders, getLayoutInflater());
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            LayoutInflater inflater;

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Orders order = orders.get(position);

            }
        });
    }

    void goToOrderDetails(View root, Orders order) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("order", order);

        Intent detailIntent = new Intent(getContext(), OrdersDetailsActivity.class);
        detailIntent.putExtras(bundle);
        startActivity(detailIntent);
    }
}