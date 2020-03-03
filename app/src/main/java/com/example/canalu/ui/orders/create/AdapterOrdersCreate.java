package com.example.canalu.ui.orders.create;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.canalu.R;
import com.example.canalu.model.MapsItems;
import com.example.canalu.model.Products;

import java.util.ArrayList;

public class AdapterOrdersCreate extends ArrayAdapter<Products> {

    private Context context;
    private ArrayList<Products> lista;
    private LayoutInflater li;


    public AdapterOrdersCreate(@NonNull Context context, int resource, @NonNull ArrayList<Products> objects, LayoutInflater li) {
        super(context, resource, objects);
        this.context = context;
        this.lista = objects;
        this.li = li;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View itemView = convertView;
        Products products = lista.get(position);

        if(itemView == null){
            itemView = li.inflate(R.layout.items_orders_create,parent,false);
        }

        TextView nameProduct = itemView.findViewById(R.id.name_products);
        TextView productPrice = itemView.findViewById(R.id.product_price);

        nameProduct.setText(products.getProductsName());
        productPrice.setText("$ "+products.getProductsUnitPrice()+"");
        return itemView;
    }
}
