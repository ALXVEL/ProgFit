package com.example.progfit;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Stats {

    private Date date;
    private int weight;

    public Stats(int weight){
        this.weight = weight;
        date = new Date();
    }

    public int getWeight() {
        return weight;
    }

    public String getDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("MMMMM dd, yyyy", Locale.CANADA);
        return formatter.format(date);
    }

    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("MMMMM dd, yyyy", Locale.CANADA);
        return "Lifted: " + weight + " lbs on " + formatter.format(date);
    }

}
