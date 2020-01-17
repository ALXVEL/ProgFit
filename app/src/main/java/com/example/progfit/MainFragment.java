package com.example.progfit;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.gson.Gson;

public class MainFragment extends Fragment {

    private ImageButton sqtBtn;
    private ImageButton ohpBtn;
    private ImageButton benchBtn;
    private ImageButton dlBtn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_main, container, false);


        sqtBtn = (ImageButton)v.findViewById(R.id.squatBtn);
        sqtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).setViewPager(1);
            }
        });

        ohpBtn = (ImageButton)v.findViewById(R.id.ohpBtn);
        ohpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).setViewPager(4);
            }
        });

        benchBtn = (ImageButton)v.findViewById(R.id.benchBtn);
        benchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).setViewPager(3);
            }
        });

        dlBtn = (ImageButton)v.findViewById(R.id.dlBtn);
        dlBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).setViewPager(2);
            }
        });



        // Inflate the layout for this fragment
        return v;
    }


}
