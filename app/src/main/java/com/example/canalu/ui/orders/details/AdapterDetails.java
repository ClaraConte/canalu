package com.example.canalu.ui.orders.details;

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
import com.example.canalu.model.OrdersDetails;

import java.util.ArrayList;
import java.util.List;


public class AdapterDetails extends ArrayAdapter<OrdersDetails> {

    private Context context;
    private ArrayList<OrdersDetails> lista;
    private LayoutInflater li;

    public AdapterDetails(@NonNull Context context, int resource, @NonNull ArrayList<OrdersDetails> objects, LayoutInflater li) {
        super(context, resource, objects);
        this.context = context;
        this.lista = objects;
        this.li = li;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View itemView = convertView;
        OrdersDetails ordersDetails = lista.get(position);
        if(itemView == null){
            itemView = li.inflate(R.layout.items_orders_details,parent,false);
        }

        TextView nameStore = itemView.findViewById(R.id.name_products);
        TextView productUnit = itemView.findViewById(R.id.product_unit);
        TextView productSubtotal = itemView.findViewById(R.id.product_subtotal);

        Double subtotal = ordersDetails.getOrdersDetailsTotalProducts()*ordersDetails.getProducts().getProductsUnitPrice();

        nameStore.setText(ordersDetails.getProducts().getProductsName());
        productUnit.setText(ordersDetails.getOrdersDetailsTotalProducts()+"");
        productSubtotal.setText("[ "+subtotal.toString()+" ]");
        return itemView;
    }
}

