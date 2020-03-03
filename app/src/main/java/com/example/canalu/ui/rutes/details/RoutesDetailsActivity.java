package com.example.canalu.ui.rutes.details;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.example.canalu.R;
import com.example.canalu.model.MapsItems;

public class RoutesDetailsActivity extends AppCompatActivity {

    private MapsItems item = new MapsItems();
    private TextView address;
    private Button details_buton;
    private RadioGroup radioGroup;
    private RadioButton radioVisitedButton;
    private RadioButton visited;
    private RadioButton noVisited;
    private EditText observations;
    private MapsItems aux = new MapsItems();

    private RoutesDetailsViewModel routesDetailsViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routes_details);
        address = findViewById(R.id.details_address);
        details_buton = findViewById(R.id.details_buton);
        radioGroup = findViewById(R.id.radio_detail_routes);
        visited = findViewById(R.id.details_rb_visited);
        noVisited = findViewById(R.id.details_rb_not_visited);
        observations = findViewById(R.id.details_observation);

        routesDetailsViewModel = ViewModelProviders.of(this).get(RoutesDetailsViewModel.class);
        routesDetailsViewModel.getMapsItems().observe(this, new Observer<MapsItems>() {
            @Override
            public void onChanged(MapsItems mapsItems) {

                address.setText(mapsItems.getUsers().getAddress().get(0).getAddressStreet()+
                            " "+mapsItems.getUsers().getAddress().get(0).getAddressNumber()+
                            ", "+mapsItems.getUsers().getAddress().get(0).getLocations().getLocationsName());

               if(mapsItems.getMapsItemsVisited()){
                   visited.setChecked(true);
               }else{
                   noVisited.setChecked(true);
               }

                observations.setText(mapsItems.getMapsItemsObservations() );

                aux = mapsItems;
                System.out.println(mapsItems);
            }
        });
        routesDetailsViewModel.getError().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
            }
        });

        getViewModel();

        //Guarda datos de visita
        saveData();
    }

    private void getViewModel(){
        item = this.getIntent().getExtras().getParcelable("item");
        routesDetailsViewModel.getDetails(item);
    }

    private void saveData(){
        details_buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
           String var = observations.getText().toString();
            if(visited.isChecked()){
                aux.setMapsItemsVisited(true);
            }else {aux.setMapsItemsVisited(false);}
            aux.setMapsItemsObservations(var.toString());

            routesDetailsViewModel.saveDetails(aux);
            Toast.makeText(getApplicationContext(),"Datos guardados", Toast.LENGTH_SHORT).show();

            //Intent intent= new Intent(getApplicationContext(), RoutesFragment.class);
            //startActivity(intent);
            }
        });
    }
}
