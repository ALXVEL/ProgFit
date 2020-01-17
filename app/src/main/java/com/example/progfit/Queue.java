package com.example.progfit;

import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Queue {

    private Stats[] list;
    private int size, numberOfItems = 0;

    private List<Stats> listOfStats;

    public Queue(int size){
        this.size = size;
        list = new Stats[size];
        Arrays.fill(list,null);
        listOfStats = new ArrayList<>();
    }

    public void add(Stats data){
        for(int i = 1; i < this.size; i++){
            list[this.size - i] = list[this.size - i - 1];
        }
        list[0] = data;
        numberOfItems++;
        if(numberOfItems > this.size){
            numberOfItems = this.size;
        }

        listOfStats.add(data);
    }

    public void remove(){
        for(int i = 0; i < this.size - 1; i++){
            list[i] = list[i+1];
        }
        list[this.size - 1] = null;
        numberOfItems--;
        if(numberOfItems < 0){
            numberOfItems = 0;
        }

        listOfStats.remove(listOfStats.size() - 1);
    }

    public int[] getWeightArray(){
        int[] weightArray = new int[listOfStats.size()];
        for(int i = 0; i < listOfStats.size(); i++){
            weightArray[i] = listOfStats.get(i).getWeight();
        }
        return weightArray;
    }

    public String[] getDateArray(){
        String[] dateArray = new String[listOfStats.size()];
        for(int i = 0; i < listOfStats.size(); i++){
            dateArray[i] = listOfStats.get(i).getDate();
        }
        return dateArray;
    }

    public void reset(){
        list = new Stats[size];
        Arrays.fill(list,null);
        listOfStats = new ArrayList<>();
    }

    @Override
    public String toString() {
        String s = "";
        for(Stats stats : list){
            s += stats + "\n";
        }
        return s;
    }
}
