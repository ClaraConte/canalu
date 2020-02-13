package com.example.canalu.ui.profile;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.canalu.R;
import com.example.canalu.model.Login;
import com.example.canalu.model.Users;

public class ProfileFragment extends Fragment {

    private ProfileViewModel profileViewModel;
    private EditText nombre;
    private EditText phone;
    private EditText userName;
    private EditText password;
    private EditText passwordRepeat;
    private Button btnSave;
    protected Users usersSave = new Users();
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        profileViewModel =
                ViewModelProviders.of(this).get(ProfileViewModel.class);

        final View root = inflater.inflate(R.layout.fragment_profile, container, false);
        final TextView textView = root.findViewById(R.id.text_profile);
        btnSave = root.findViewById(R.id.btnSave);

        profileViewModel.getUser();

        profileViewModel.getUsuarios().observe(this, new Observer<Users>() {
            @Override
            public void onChanged(Users users) {
                nombre = root.findViewById(R.id.profile_name);
                phone = root.findViewById(R.id.profile_phone);
                userName = root.findViewById(R.id.profile_userName);
                password = root.findViewById(R.id.profile_pass);
                passwordRepeat = root.findViewById(R.id.profile_passRepeat);

                nombre.setText(users.getUsersFirstName()+", "+users.getUsersLastName());
                phone.setText(users.getUsersPhone());
                userName.setText(users.getUsersEmail());

                usersSave = users;
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if((!password.getText().toString().isEmpty() ) && (password.getText().toString().equals(passwordRepeat.getText().toString()))){
                    usersSave.getEmployees().setEmployeesKey(password.getText().toString());
                    profileViewModel.putUser(usersSave);
                    Toast.makeText(getContext(),"Datos guardados",Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(getContext(),"Contraseñas no coinciden",Toast.LENGTH_LONG).show();
                }
            }
        });

        return root;
    }
}