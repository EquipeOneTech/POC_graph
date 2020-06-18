package com.equipeonetech.graphs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Pie;

import java.util.ArrayList;
import java.util.List;

public class PieGraph extends AppCompatActivity {
    private AnyChartView anyChartView;
    private Button btNextScreen;
    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**Initi graph component*/
        initGraph();

        /**Set values and formatting graph*/
        setParametersGraph();

        /**Event click*/
        eventClick();
    }

    private void eventClick() {
        btNextScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent barGraphScreen = new Intent(context, BarGraph.class);
                startActivity(barGraphScreen);
            }
        });
    }

    private void setParametersGraph() {
        Pie pie = AnyChart.pie();
        List<DataEntry> data = new ArrayList<>();
        data.add(new ValueDataEntry("iniciante", 10000));
        data.add(new ValueDataEntry("Experiente", 12000));
        data.add(new ValueDataEntry("Veterano", 18000));
        data.add(new ValueDataEntry("Master", 1000));
        pie.data(data);
        anyChartView.setChart(pie);
    }
    public void initGraph() {
        anyChartView = findViewById(R.id.myGraph);
        btNextScreen = findViewById(R.id.btNextGraph);
    }
}
