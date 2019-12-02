package com.example.canalu.ui.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.canalu.R;
import com.example.canalu.model.Users;

public class ProfileFragment extends Fragment {

    private ProfileViewModel profileViewModel;
    private EditText nombre;
    private EditText phone;
    private EditText userName;
    private EditText pass;
    private EditText passRepeat;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        profileViewModel =
                ViewModelProviders.of(this).get(ProfileViewModel.class);

        final View root = inflater.inflate(R.layout.fragment_profile, container, false);
        final TextView textView = root.findViewById(R.id.text_profile);

        profileViewModel.getUser();

        profileViewModel.getUsuarios().observe(this, new Observer<Users>() {
            @Override
            public void onChanged(Users users) {
                nombre = root.findViewById(R.id.profile_name);
                phone = root.findViewById(R.id.profile_phone);
                userName = root.findViewById(R.id.profile_userName);
                pass = root.findViewById(R.id.profile_pass);
                passRepeat = root.findViewById(R.id.profile_passRepeat);

                nombre.setText(users.getUsersFirstName()+", "+users.getUsersLastName());
                phone.setText(users.getUsersPhone());
                userName.setText(users.getUsersEmail());
                pass.setText(users.getUsersDni()+"");
                passRepeat.setText(users.getUsersDni()+"");
            }
        });

        return root;
    }
}