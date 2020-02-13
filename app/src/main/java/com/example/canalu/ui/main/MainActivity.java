package com.example.canalu.ui.main;

import android.os.Bundle;

import com.example.canalu.R;
import com.example.canalu.model.Users;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private TextView nombre;
    private TextView email;
    private MainViewModel mainViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
            R.id.nav_home, R.id.nav_routes, R.id.nav_customers,
            R.id.nav_orders, R.id.nav_profile, R.id.nav_settings, R.id.nav_exit)
            .setDrawerLayout(drawer)
            .build();

        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mainViewModel.getUser();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Intent val = getIntent();
        // String mail = val.getStringExtra("user");

        mainViewModel.getUsuarios().observe(this, new Observer<Users>() {
            @Override
            public void onChanged(Users users) {
                nombre = findViewById(R.id.tvUsuario);
                email = findViewById(R.id.tvEmail);
                nombre.setText(users.getUsersFirstName()+","+users.getUsersLastName());
                email.setText(users.getUsersEmail());
            }
        });

        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
