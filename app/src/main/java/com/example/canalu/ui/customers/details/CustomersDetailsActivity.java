package com.example.canalu.ui.customers.details;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.canalu.R;
import com.example.canalu.model.MapsItems;


import java.util.ArrayList;

public class CustomersDetailsActivity extends AppCompatActivity {
    private MapsItems list = new MapsItems();
    private CustomersDetailsViewModel customersDetailsViewModel;
    private TextView nombre;
    private TextView address;
    private TextView telephone;
    private TextView lastVisited;
    private TextView email;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customers_details);
        nombre = findViewById(R.id.details_nombre);
        address = findViewById(R.id.details_address);
        telephone = findViewById(R.id.details_telephone);
        email = findViewById(R.id.details_email);
        lastVisited = findViewById(R.id.details_last_visited);

        ImageView imageStore = findViewById(R.id.image_store);
        imageStore.setImageResource(R.drawable.image_default);
        customersDetailsViewModel = ViewModelProviders.of(this).get(CustomersDetailsViewModel.class);
        customersDetailsViewModel.getMapsItems().observe(this, new Observer<MapsItems>() {
            @Override
            public void onChanged(MapsItems mapsItems) {
               nombre.setText(mapsItems.getUsers().getUsersFirstName()+", "+mapsItems.getUsers().getUsersLastName());
               address.setText(mapsItems.getUsers().getAddress().get(0).getAddressStreet()+", "
                       +mapsItems.getUsers().getAddress().get(0).getAddressNumber()
                       +", "+mapsItems.getUsers().getAddress().get(0).getLocations().getLocationsName());
               telephone.setText(mapsItems.getUsers().getUsersPhone());
               email.setText(mapsItems.getUsers().getUsersEmail());
               lastVisited.setText(mapsItems.getMapsItemsDateTime());
            }
        });
        getViewModel();
    }

    private void getViewModel(){
        list = this.getIntent().getExtras().getParcelable("list");
        customersDetailsViewModel.getDetails(list);
    }
}
