package com.example.alumno.vwmove;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

public class PerformanceActivity extends AppCompatActivity {

    ArrayList<String> itemsList;
    ArrayAdapter<String> adapter;
    EditText extraText;


    ImageButton send;

    ListView lv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_performance);

        lv = (ListView)findViewById(R.id._dynamicRendimiento);
        send = (ImageButton)findViewById(R.id.imageCloseThis);

        itemsList = new ArrayList<>();

        itemsList.add("Número de VIN");
        itemsList.add("Delta del Odómetro");
        itemsList.add("Distancia recorrida");
        itemsList.add("Estado de la Batería");
        itemsList.add("Tiempo de Motor Encendido");
        itemsList.add("RPM");
        itemsList.add("Velocidad Promedio");

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, itemsList);

        lv.setAdapter(adapter);

    }

    public void getBack(View v){
        Intent prof = new Intent(this, ProfileActivity.class);
        startActivity(prof);
    }
}
