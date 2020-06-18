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
import com.anychart.charts.Cartesian;
import com.anychart.core.cartesian.series.Bar;
import com.anychart.data.Mapping;
import com.anychart.enums.Anchor;
import com.anychart.enums.HoverMode;
import com.anychart.enums.LabelsOverlapMode;
import com.anychart.enums.ScaleStackMode;
import com.anychart.enums.TooltipDisplayMode;
import com.anychart.enums.TooltipPositionMode;

import java.util.ArrayList;
import java.util.List;
import com.anychart.data.Set;

public class BarGraph extends AppCompatActivity {
    AnyChartView anyChartView;
    private Button btNextGraph;
    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_graph);

        /**Init BarGraph*/
        initiComponentGraph();

        /**Init value in the graph*/
        setBarGraph();

        /**Event Click*/
        eventClick();
    }
    private void eventClick() {
        btNextGraph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent columnGraphScreen = new Intent(context, ColumnGraph.class);
                startActivity(columnGraphScreen);
            }
        });
    }

    private void setBarGraph() {
        Cartesian barChart = AnyChart.bar();

        barChart.animation(true);

        barChart.padding(10d,20d,5d,20);

        barChart.yScale().stackMode(ScaleStackMode.VALUE);

        barChart.yAxis(0).labels().format(
                "function() {\n" +
                        "    return Math.abs(this.value).toLocaleString();\n" +
                        "  }");

        barChart.yAxis(0d).title("Revenue in Dollars");

        barChart.xAxis(0d).overlapMode(LabelsOverlapMode.ALLOW_OVERLAP);

        barChart.title("Cosmetic Sales by Gender");

        barChart.interactivity().hoverMode(HoverMode.BY_X);

        barChart.tooltip()
                .title(false)
                .separator(false)
                .displayMode(TooltipDisplayMode.SEPARATED)
                .positionMode(TooltipPositionMode.POINT)
                .useHtml(true)
                .fontSize(12d)
                .offsetX(5d)
                .offsetY(0d)
                .format(
                        "function() {\n" +
                                "      return '<span style=\"color: #D9D9D9\">$</span>' + Math.abs(this.value).toLocaleString();\n" +
                                "    }");


        List<DataEntry> seriesData = new ArrayList<>();
        seriesData.add(new CustomDataEntry("Nail polish", 5376, -229));
        seriesData.add(new CustomDataEntry("Eyebrow pencil", 10987, -932));
        seriesData.add(new CustomDataEntry("Rouge", 7624, -5221));
        seriesData.add(new CustomDataEntry("Lipstick", 8814, -256));
        seriesData.add(new CustomDataEntry("Eyeshadows", 8998, -308));
        seriesData.add(new CustomDataEntry("Eyeliner", 9321, -432));
        seriesData.add(new CustomDataEntry("Foundation", 8342, -701));
        seriesData.add(new CustomDataEntry("Lip gloss", 6998, -908));
        seriesData.add(new CustomDataEntry("Mascara", 9261, -712));
        seriesData.add(new CustomDataEntry("Shampoo", 5376, -9229));
        seriesData.add(new CustomDataEntry("Hair conditioner", 10987, -13932));
        seriesData.add(new CustomDataEntry("Body lotion", 7624, -10221));
        seriesData.add(new CustomDataEntry("Shower gel", 8814, -12256));
        seriesData.add(new CustomDataEntry("Soap", 8998, -5308));
        seriesData.add(new CustomDataEntry("Eye fresher", 9321, -432));
        seriesData.add(new CustomDataEntry("Deodorant", 8342, -11701));
        seriesData.add(new CustomDataEntry("Hand cream", 7598, -5808));
        seriesData.add(new CustomDataEntry("Foot cream", 6098, -3987));
        seriesData.add(new CustomDataEntry("Night cream", 6998, -847));
        seriesData.add(new CustomDataEntry("Day cream", 5304, -4008));
        seriesData.add(new CustomDataEntry("Vanila cream", 9261, -712));

        Set set = Set.instantiate();
        set.data(seriesData);
        Mapping series1Data = set.mapAs("{ x: 'x', value: 'value' }");
        Mapping series2Data = set.mapAs("{ x: 'x', value: 'value2' }");

        Bar series1 = barChart.bar(series1Data);
        series1.name("Females")
                .color("HotPink");
        series1.tooltip()
                .position("right")
                .anchor(Anchor.LEFT_CENTER);

        Bar series2 = barChart.bar(series2Data);
        series2.name("Males");
        series2.tooltip()
                .position("left")
                .anchor(Anchor.RIGHT_CENTER);

        barChart.legend().enabled(true);
        barChart.legend().inverted(true);
        barChart.legend().fontSize(13d);
        barChart.legend().padding(0d, 0d, 20d, 0d);

        anyChartView.setChart(barChart);
    }
    private class CustomDataEntry extends ValueDataEntry {
        CustomDataEntry(String x, Number value, Number value2) {
            super(x, value);
            setValue("value2", value2);
        }
    }

    private void initiComponentGraph() {
        anyChartView = findViewById(R.id.myBarGraph);
        btNextGraph = findViewById(R.id.btNextGraph2);
    }
}
