package com.example.canalu.ui.login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.example.canalu.R;
import com.example.canalu.model.Login;
import com.example.canalu.ui.main.MainActivity;

public class LoginActivity extends AppCompatActivity {

    private Button btnLogin;
    private EditText usuario;
    private EditText password;
    private TextView result;
    private LoginViewModel loginViewModel;
    private ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.login);
        usuario = findViewById(R.id.editTextUser);
        password = findViewById(R.id.editTextPass);
        result = findViewById(R.id.result);
        pDialog = new ProgressDialog(this);
        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);

        loginViewModel.getError().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String string) {
                result.setText(string);
                pDialog.cancel();
            }
        });

        loginViewModel.getToken().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Login login = new Login();
            login.setUsuario(usuario.getText().toString());
            login.setClave(password.getText().toString());

            //POST
            loginViewModel.sendPost(login);
            progress();

            //GET
            //loginViewModel.getUser();
            }

        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        pDialog.cancel();
    }

    private void progress(){
        pDialog.setMessage("Cargando datos ...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();
    }
}
