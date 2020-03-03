package com.example.canalu.ui.orders.details;

import android.app.ActionBar;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.canalu.R;
import com.example.canalu.model.Orders;
import com.example.canalu.model.OrdersDetails;
import com.example.canalu.ui.orders.OrdersViewModel;

import java.util.ArrayList;

public class OrdersDetailsActivity extends AppCompatActivity {

    private  OrdersDetailsViewModel ordersDetailsViewModel;
    private Orders orders= new Orders();
    private ArrayList<OrdersDetails> ordersDetails= new ArrayList<OrdersDetails>();
    private TextView nameProducts;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders_details);

        nameProducts = findViewById(R.id.name_products);

        ordersDetailsViewModel = ViewModelProviders.of(this).get(OrdersDetailsViewModel.class);
        ordersDetailsViewModel.getOrdersDetails().observe(this, new Observer<ArrayList<OrdersDetails>>() {
            @Override
            public void onChanged(ArrayList<OrdersDetails> ordersDetails) {
                loadList(ordersDetails);
            }
        });

        ordersDetailsViewModel.getTotalAmount().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                TextView totalAmount = findViewById(R.id.total_amount);
                totalAmount.setText(s);
            }
        });
        //ActionBar actionBar = getActionBar();
        //actionBar.setDisplayHomeAsUpEnabled(true);
        setOrdersDetails();

    }

    private void setOrdersDetails(){
        orders = this.getIntent().getExtras().getParcelable("detail");
        ordersDetails.addAll(orders.getOrdersDetails());
        ordersDetailsViewModel.setOrdersDetails(ordersDetails);
    }

    private void loadList(ArrayList<OrdersDetails> ordersDetails){
        final ListView listView = findViewById(R.id.listItemsOrders);

        ArrayAdapter<OrdersDetails> adapter = new AdapterDetails(this, R.layout.items_orders_details, ordersDetails, getLayoutInflater());
        listView.setAdapter(adapter);
    }
}
