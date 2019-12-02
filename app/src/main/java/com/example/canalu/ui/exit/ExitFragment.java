package com.example.canalu.ui.exit;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
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
import com.example.canalu.ui.main.MainActivity;

public class ExitFragment extends Fragment {

    private ExitViewModel exitViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        exitViewModel =
                ViewModelProviders.of(this).get(ExitViewModel.class);
        View root = inflater.inflate(R.layout.fragment_exit, container, false);
        final TextView textView = root.findViewById(R.id.text_exit);
        exitViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext());

        alertDialogBuilder.setTitle("Confirmar");

        alertDialogBuilder
                .setMessage("Realmente desea salir de la aplicación?")
                .setCancelable(false)
                .setPositiveButton("Si",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {

                        //Intent i = new Intent(getContext(), MainActivity.class);
                        //i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        //startActivity(i);

                        System.exit(0);
                    }
                })
                .setNegativeButton("No",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {

                        dialog.cancel();

                        Intent i = new Intent(getContext(), MainActivity.class);
                        startActivity(i);
                    }
                }).create().show();
        return root;
    }
}