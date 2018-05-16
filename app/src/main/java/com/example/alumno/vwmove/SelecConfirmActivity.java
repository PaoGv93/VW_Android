package com.example.alumno.vwmove;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SelecConfirmActivity extends AppCompatActivity {

    TextView user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selec_confirm);

        user = (TextView)findViewById(R.id.textView10);

        Bundle datos = this.getIntent().getExtras();
        String username = datos.getString("user");
        user.setText(username);

    }

    public void login(View v){
        Intent i = new Intent(this, RouteActivity.class);
        String username = user.getText().toString();
        i.putExtra("user", username);
        startActivity(i);
    }

    public void go_back(View v){
        Intent i = new Intent(this, SelectionActivity.class);
        startActivity(i);
    }
}
