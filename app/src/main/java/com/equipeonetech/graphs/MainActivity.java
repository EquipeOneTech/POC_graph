package com.equipeonetech.graphs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Pie;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    AnyChartView anyChartView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**Initi graph component*/
        initGraph();

        /**Set values and formatting graph*/
        Pie pie = AnyChart.pie();

        List<DataEntry> data = new ArrayList<>();

        data.add(new ValueDataEntry("iniciante", 10000));
        data.add(new ValueDataEntry("Experiente", 12000));
        data.add(new ValueDataEntry("Veterano", 18000));

        pie.data(data);
        anyChartView.setChart(pie);


    }


    public void initGraph() {
        anyChartView = findViewById(R.id.myGraph);
    }
}
