package com.example.alumno.vwmove;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class SelectionActivity extends AppCompatActivity {

    TextView user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

        user = (TextView)findViewById(R.id.textView8);

        Bundle datos = this.getIntent().getExtras();
        String username = datos.getString("user");
        user.setText(username);
    }

    //go back
    public void log_in_2(View v){
        Intent login = new Intent(this, RouteActivity.class);
        startActivity(login);
    }

    //confirmar crafter
    public void confirmSelection(View v){

        Intent i = new Intent(this, SelecConfirmActivity.class);
        String username = user.getText().toString();
        i.putExtra("user", username);
        startActivity(i);
    }
}
