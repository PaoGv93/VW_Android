package com.example.alumno.vwmove;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;


public class PassengerFragment extends Fragment {

    private ImageButton up;
    private ImageButton down;
    private TextView counter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_passenger, container, false);

        up = (ImageButton) view.findViewById(R.id.imageUp);
        down = (ImageButton) view.findViewById(R.id.imageDown);
        counter = (TextView) view.findViewById(R.id.number_passengers);


        up.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        upPassangers(v);
                    }
                }
        );

        down.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        downPassangers(v);
                    }
                }
        );

        return view;
    }

    public void upPassangers(View v) {
        String actualUnits = (String)counter.getText();
        int units = Integer.parseInt(actualUnits);
        units++;
        actualUnits = Integer.toString(units);
        counter.setText(actualUnits);
    }
    public void downPassangers(View v) {
        String actualUnits = (String)counter.getText();
        int units = Integer.parseInt(actualUnits);
        units--;
        if(units < 0){
            units = 0;
        }
        actualUnits = Integer.toString(units);
        counter.setText(actualUnits);
    }
}
