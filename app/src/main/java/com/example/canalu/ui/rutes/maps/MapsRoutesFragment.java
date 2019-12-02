package com.example.canalu.ui.rutes.maps;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.canalu.R;

public class MapsRoutesFragment extends Fragment {

    private MapsRoutesViewModel mapsRoutesViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mapsRoutesViewModel =
                ViewModelProviders.of(this).get(MapsRoutesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_maps_routes, container, false);
        final TextView textView = root.findViewById(R.id.text_maps_routes);
        mapsRoutesViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

}