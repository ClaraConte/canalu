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
import com.example.canalu.ui.login.LoginActivity;
import com.example.canalu.ui.rutes.details.RoutesDetailsActivity;
import com.example.canalu.ui.rutes.details.RoutesDetailsViewModel;

import java.util.ArrayList;

public class ListRoutesFragment extends Fragment {

    private ListRoutesViewModel listRoutesViewModel;
    private View root;
    private ListView listView;
    private boolean isBackFromB;
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

        listRoutesViewModel.goToLogin().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean){
                Intent intent = new Intent(getContext(), LoginActivity.class);
                intent.putExtra("error",aBoolean);
                startActivity(intent);
                }
            }
        });

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

    @Override
    public void onResume() {
        super.onResume();
        getMapsRoutes();
    }
    @Override
    public void onPause() {
        super.onPause();
        getMapsRoutes();
    }
    @Override
    public void onStop() {
        super.onStop();
        getMapsRoutes();
    }
}

