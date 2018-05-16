package com.example.alumno.vwmove;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class AlertsFragment extends Fragment {

    ArrayList<String> itemsList;
    ArrayAdapter<String> adapter;
    int confirm1;
    int confirm2;
    int confirm3;
    int confirm4;
    String alert = "";
    EditText extraText;


    Button send;

    ListView lv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_alerts, container, false);

        lv = (ListView)view.findViewById(R.id._dynamicAlerts);
        send = (Button)view.findViewById(R.id.buttonSend);
        extraText = (EditText)view.findViewById(R.id.editDescription);

        itemsList = new ArrayList<>();

        itemsList.add("Accidente");
        itemsList.add("Obstrucción");
        itemsList.add("Retraso");
        itemsList.add("Otro");

        confirm1 = 0;
        confirm2 = 0;
        confirm3 = 0;
        confirm4 = 0;

        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_multiple_choice, itemsList);

        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    if(confirm1 == 0){
                        alert += itemsList.get(position) + " ";
                        confirm1 = 1;
                    }else{
                        if( alert.contentEquals(itemsList.get(position)) == true){
                            alert = alert.replace(itemsList.get(position), "");
                        }
                        confirm1 = 0;
                    }

                }else if (position == 1){
                    if(confirm2 == 0){
                        alert = itemsList.get(position) + " ";
                        confirm2 = 1;
                    }else{
                        if( alert.contentEquals(itemsList.get(position)) == true){
                            alert = alert.replace(itemsList.get(position), "");
                        }
                        confirm2 = 0;
                    }

                }else if(position == 2){
                    if(confirm3 == 0){
                        alert = itemsList.get(position)+ " ";
                        confirm3 = 1;
                    }else{
                        if( alert.contentEquals(itemsList.get(position)) == true){
                            alert = alert.replace(itemsList.get(position), "");
                        }
                        confirm3 = 0;
                    }

                }else if(position == 3){
                    if(confirm4 == 0){
                        alert = itemsList.get(position)+ " ";
                        confirm4 = 1;
                    }else{
                        if( alert.contentEquals(itemsList.get(position)) == true){
                            alert = alert.replace(itemsList.get(position), "");
                        }
                        confirm4 = 0;
                    }

                }
            }
        });

        send.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        sendInfo(v);
                    }
                }
        );



        return view;
    }

    public void sendInfo(View v) {


        if(alert == null){

        }else{
            alert = alert+extraText.getText();
        }

    }
}
