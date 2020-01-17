package com.example.progfit;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;


public class OHPFragment extends Fragment {

    private EditText weightLifted;
    private TextView list;
    private Button enterButton;
    private Button removeButton;
    private Button graphButton;

    private Queue queue;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_oh, container, false);

        weightLifted = (EditText)v.findViewById(R.id.editText);
        list = (TextView)v.findViewById(R.id.list);


        enterButton = (Button)v.findViewById(R.id.button);
        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                queue.add(new Stats(Integer.parseInt(weightLifted.getText().toString())));
                list.setText(queue.toString());
                saveData();
            }
        });
        removeButton = (Button)v.findViewById(R.id.button2);
        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                queue.remove();
                list.setText(queue.toString());
                saveData();
            }
        });

        graphButton = (Button)v.findViewById(R.id.button3);
        graphButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),GraphActivity.class);
                int[] weightData = queue.getWeightArray();
                i.putExtra("weightData", weightData);
                startActivity(i);
            }
        });


        return v;
    }

    private void saveData(){
        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences("sharedPreferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(queue);
        editor.putString("queue3", json);
        editor.apply();
    }

    private void loadData(){
        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences("sharedPreferences", Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("queue3",null);
        queue = gson.fromJson(json, Queue.class);

        if(queue == null){
            queue = new Queue(10);
        }
    }
}
