package com.example.canalu.ui.customers.details;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.canalu.R;
import com.example.canalu.ui.customers.CustomersViewModel;
import com.example.canalu.ui.home.HomeViewModel;

public class TestFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        String var;
        Bundle datosRecuperados = getArguments();
        long id = datosRecuperados.getLong("id");

        System.out.println(id);
        return root;
    }

}
