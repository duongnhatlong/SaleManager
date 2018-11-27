package com.team2.salemanager;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;

public class StatisticsActivity extends AppCompatActivity {

    private static String TAG = "StatisticsActivity";

    private double[] yData = {25f, 34.2f, 27f, 40.12f, 54.5f, 65.3f, 23.5f, 34.3f, 23.5f, 45.2f, 34.4f, 35.6f};
    private String[] xData = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
        setTitle("Statistic");


        Log.d(TAG, "onCreate");

        pieChart = (PieChart) findViewById(R.id.pieChart);

        pieChart.getDescription().setText("Sales of Statistics(In Thousands VND)");
        pieChart.setRotationEnabled(true);
        pieChart.setHoleRadius(2.5f);
        pieChart.setTransparentCircleAlpha(1);

        addDataset(pieChart);
    }

    private void addDataset(PieChart chart) {
        Log.d(TAG, "addDataset");

        ArrayList<PieEntry> entries = new ArrayList<>();

        for (int i = 0; i < yData.length; i++) {
            entries.add(new PieEntry((float) yData[i], xData[i]));
        }

        //Create the data set
        PieDataSet pieDataSet = new PieDataSet(entries, null);
        pieDataSet.setSliceSpace(3);
        pieDataSet.setValueTextSize(12);

        //Add colors to dataset
        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(ContextCompat.getColor(this, R.color.colorTeal));
        colors.add(ContextCompat.getColor(this, R.color.colorSilver));
        colors.add(ContextCompat.getColor(this, R.color.colorAgedPaper));
        colors.add(ContextCompat.getColor(this, R.color.colorAntiqueGold));
        colors.add(ContextCompat.getColor(this, R.color.colorThistle4));
        colors.add(ContextCompat.getColor(this, R.color.colorThistle3));
        colors.add(ContextCompat.getColor(this, R.color.colorMediumPurple4));
        colors.add(ContextCompat.getColor(this, R.color.colorMediumPurple2));
        colors.add(ContextCompat.getColor(this, R.color.colorChocolate));
        colors.add(ContextCompat.getColor(this, R.color.colorBurlywood));
        colors.add(ContextCompat.getColor(this, R.color.colorOliveDrab3));
        colors.add(ContextCompat.getColor(this, R.color.colorAzure1));

        pieDataSet.setColors(colors);

//        RelativeLayout rltLayout = findViewById(R.id.rltLayout);
//
//        TextView tit = new TextView(StatisticsActivity.this);
//        tit.setText("CIRCLE CHART");
//        tit.setTextSize(20);
//        tit.setTextColor(Color.BLACK);
//        tit.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
//        tit.setGravity(Gravity.CENTER_HORIZONTAL);
//        rltLayout.addView(tit);
        //Add legend to chart
        Legend legend = pieChart.getLegend();
        legend.setForm(Legend.LegendForm.CIRCLE);
//        legend.setFormToTextSpace(2f);
//        legend.setFormSize(6f);
        legend.setTextSize(15);
        legend.setWordWrapEnabled(true);
        legend.setPosition(Legend.LegendPosition.BELOW_CHART_LEFT);

        //Create pie data object
        PieData pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieChart.invalidate();
    }
}
