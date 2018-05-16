package com.example.alumno.vwmove;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ProfileActivity extends AppCompatActivity {

    ImageButton goPerformance;
    ImageButton goPassword;
    ImageButton goComments;
    ImageButton goClose;
    ImageButton goBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        goPerformance = (ImageButton)findViewById(R.id.imagePerformance);
        goPassword = (ImageButton) findViewById(R.id.imagePassword);
        goComments = (ImageButton)findViewById(R.id.imageComments);
        goClose = (ImageButton) findViewById(R.id.imageClose);
        goBack = (ImageButton) findViewById(R.id.imageComeback);
    }

    public void changeToPerformance(View v){
        Intent performance = new Intent(this, PerformanceActivity.class);
        startActivity(performance);
    }

    public void changeToPassword(View v){
        Intent password = new Intent(this, PasswordActivity.class);
        startActivity(password);
    }

    public void changeToComments(View v){
        Intent comments = new Intent(this, CommentsActivity.class);
        startActivity(comments);
    }

    public void changeToClose(View v){
        Intent close = new Intent(this, MainActivity.class);
        startActivity(close);
    }

    public void changeToRoutes(View v){
        Intent routes = new Intent(this, RouteActivity.class);
        startActivity(routes);
    }
}
