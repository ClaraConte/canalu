package com.example.canalu.ui.rutes.list;

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
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.canalu.R;
import com.example.canalu.model.Address;
import com.example.canalu.model.Employees;
import com.example.canalu.model.Users;
import com.example.canalu.ui.rutes.details.RoutesDetailsActivity;

import java.util.ArrayList;

public class ListRoutesFragment extends Fragment {

    private ListRoutesViewModel listRoutesViewModel;

    private ArrayList<Users> clientes = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        listRoutesViewModel =
                ViewModelProviders.of(this).get(ListRoutesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_list_routes, container, false);
        final TextView textView = root.findViewById(R.id.text_list_routes);
        listRoutesViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
                ArrayList<Address> dir = new ArrayList<Address>();
                Employees employees = new Employees();
                //Users usuario = new Users(2, "Juan","perez", "23323",1,dir,employees,"2323234","mnnd@mksdc.com","24-02-2012");
                //clientes.add(usuario);

            }
        });


        // Carga vista contenedora con el ListView
        final ListView listView = root.findViewById(R.id.listRoute);

        // crea un inmueble_item para cada elemento de la lista asignados
        ArrayAdapter<Users> adapter = new AdapterListRoutes(getContext(), R.layout.item_view_list_routes, clientes, getLayoutInflater());
        listView.setAdapter(adapter);

        // Crea un listener para cada elemento
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            LayoutInflater inflater;

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ArrayList<Users> list= new ArrayList<Users>();
                list.add(clientes.get((int)id));

                Bundle bundle = new Bundle();
                bundle.putSerializable("list", clientes);

                Intent i = new Intent(getContext(), RoutesDetailsActivity.class);
                i.putExtras(bundle);
                startActivity(i);

            }
        });

        return root;
    }

}