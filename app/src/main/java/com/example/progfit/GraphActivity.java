package com.example.progfit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;

public class GraphActivity extends AppCompatActivity {

    private LineChart mLineChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        Intent i = getIntent();
        int[] weightData = i.getIntArrayExtra("weightData");

        ArrayList<Entry> yValues = new ArrayList<>();

        for(int u = 0; u < weightData.length; u++){
            yValues.add(new Entry(u, weightData[u]));
        }

        mLineChart = (LineChart)findViewById(R.id.lineChart);
        mLineChart.setDragEnabled(true);
        mLineChart.setScaleEnabled(false);

        LineDataSet set = new LineDataSet(yValues, "Data");

        //CUSTOMIZATION
        set.setColor(Color.GREEN);
        set.setLineWidth(3f);
        set.setValueTextSize(15f);
        mLineChart.setDescription(null);


        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(set);
        LineData data = new LineData(dataSets);
        mLineChart.setData(data);




    }
}
