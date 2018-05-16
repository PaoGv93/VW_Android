package com.example.alumno.vwmove;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Calendar;


public class RoutesFragment extends Fragment {

    private Handler mHandler = new Handler();
    private TextView mText;// the TextView
    private int mHour, mMinute; // variables holding the hour and minute


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_routes, container, false);

        mText = (TextView) view.findViewById(R.id.time_hour);


        return view;
    }


    private Runnable mUpdate = new Runnable() {

        @Override
        public void run() {
            mMinute += 1;
            // just some checks to keep everything in order
            if (mMinute >= 60) {
                mMinute = 0;
                mHour += 1;
            }
            if (mHour >= 24) {
                mHour = 0;
            }
            // or call your method
            mText.setText(mHour + ":" + mMinute);
            mHandler.postDelayed(this, 60000);
        }
    };

    @Override
    public void onResume() {
        super.onResume();
        // whenever the activity is built or resumed update the time and start posting updates

        Calendar c = Calendar.getInstance();
        mHour = c.get(Calendar.HOUR_OF_DAY);
        mMinute = c.get(Calendar.MINUTE);
        mText.setText(mHour + ":" + mMinute);
        mHandler.postDelayed(mUpdate, 60000); // 60000 a minute
    }

    @Override
    public void onStop() {
        super.onStop();
        mHandler.removeCallbacks(mUpdate);// we need to remove our updates if the activity isn't focused(or even destroyed) or we could get in trouble
    }
}
