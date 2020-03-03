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
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.example.canalu.R;
import com.example.canalu.model.MapsItems;
import com.example.canalu.ui.customers.details.TestFragment;
import com.example.canalu.ui.rutes.details.RoutesDetailsActivity;
import com.example.canalu.ui.rutes.details.RoutesDetailsViewModel;

import java.util.ArrayList;

public class ListRoutesFragment extends Fragment {

    private ListRoutesViewModel listRoutesViewModel;
    private View root;
    private ListView listView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        listRoutesViewModel =
                ViewModelProviders.of(this).get(ListRoutesViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_list_routes, container, false);
        final TextView textView = root.findViewById(R.id.text_list_routes);

        listView = root.findViewById(R.id.listRoute);
        listRoutesViewModel.getError().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String string) {
                textView.setText(string);
            }
        });

        /////////   Test //////
        Bundle datosAEnviar = new Bundle();

        datosAEnviar.putLong("id", 123L);

        Fragment fragmento = new TestFragment();
        fragmento.setArguments(datosAEnviar);

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //fragmentTransaction.replace(R.id.fragment_home, fragmento);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();






        getMapsRoutes();

        return root;
    }

    public void getMapsRoutes() {
        listRoutesViewModel.getMapsRoutes().observe(this, new Observer<ArrayList<MapsItems>>() {
            @Override
            public void onChanged(ArrayList<MapsItems> mapsItems) {
                loadRoutesList(mapsItems);
            }
        });
        listRoutesViewModel.getRoutes();
    }

    void loadRoutesList(final ArrayList<MapsItems> items) {
        ArrayAdapter<MapsItems> adapter = new AdapterListRoutes(getContext(), R.layout.item_view_list_routes, items, getLayoutInflater());
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            LayoutInflater inflater;

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MapsItems mapsItems = items.get(position);

                Bundle bundle = new Bundle();
                bundle.putSerializable("item", mapsItems);

                Intent detailsIntent = new Intent(getContext(), RoutesDetailsActivity.class);
                detailsIntent.putExtras(bundle);
                startActivity(detailsIntent);
            }
        });
    }
}

