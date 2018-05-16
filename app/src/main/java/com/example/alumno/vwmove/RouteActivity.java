package com.example.alumno.vwmove;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RouteActivity extends AppCompatActivity {

    Button profile;
    Button emergencies;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(listener);

        profile = (Button)findViewById(R.id.toolbar_profile);
        emergencies = (Button)findViewById(R.id.toolbar_sos);

        android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, new RoutesFragment() );
        transaction.commit();


    }

    public void go_profile(View v){
        Intent prof = new Intent(this, ProfileActivity.class);
        startActivity(prof);
    }

    public void go_Call(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle("SOS");
        builder.setMessage("Llamar al SOS");
        builder.setPositiveButton("Confirm",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
        builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    BottomNavigationView.OnNavigationItemSelectedListener listener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    android.support.v4.app.Fragment selectedFragment = null;

                    switch (item.getItemId()){
                        case R.id.navigation_routes:
                            selectedFragment = new RoutesFragment();
                            break;
                        case R.id.navigation_alerts:
                            selectedFragment = new AlertsFragment();
                            break;
                        case R.id.navigation_passengers:
                            selectedFragment = new PassengerFragment();
                            break;
                        case R.id.navigation_notifications:
                            selectedFragment = new NotificationsFragment();
                            break;

                    }

                    android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

                    transaction.replace(R.id.fragment_container, selectedFragment);
                    transaction.commit();

                    return true;
                }
            };
}

