package com.example.laptop.linegraph;

import android.graphics.Color;
import android.graphics.LinearGradient;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static LineChart lineChart;
    public ArrayList<String> xAxis;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lineChart=(LineChart)findViewById(R.id.linechart);
        xAxis=new ArrayList<>();

        setData();
    }

    // This is used to store x-axis values
    private ArrayList<String> setXAxisValues(){
         xAxis = new ArrayList<String>();

        xAxis.add("02 Aug 17");
        xAxis.add("03 Aug 17");
        xAxis.add("04 Aug 17");
        xAxis.add("05 Aug 17");
        xAxis.add("06 Aug 17");
        xAxis.add("07 Aug 17");
        xAxis.add("08 Aug 17");
        xAxis.add("09 Aug 17");
        xAxis.add("10 Aug 17");
        xAxis.add("11 Aug 17");
        xAxis.add("12 Aug 17");


        return xAxis;
    }

    // This is used to store Y-axis values
    private ArrayList<Entry> setYAxisValues(){
        ArrayList<Entry> yVals = new ArrayList<Entry>();
        yVals.add(new Entry(38, 0,""));
        yVals.add(new Entry(25, 1,"24 Feb yesterday"));
        yVals.add(new Entry(39, 2,""));
        yVals.add(new Entry(30, 3,""));
        yVals.add(new Entry(22, 4,""));
        yVals.add(new Entry(28, 5,""));
        yVals.add(new Entry(28, 6,""));
        yVals.add(new Entry(34, 7,""));
        yVals.add(new Entry(31, 8,""));
        yVals.add(new Entry(21, 9,"25 Feb Today"));
        yVals.add(new Entry(50, 10,""));


        return yVals;
    }


    private void setData() {
        ArrayList<String> xVals = setXAxisValues();

        ArrayList<Entry> yVals = setYAxisValues();


        LineDataSet set1;


        // create a dataset and give it a type
        set1 = new LineDataSet(yVals, "");
        set1.setFillAlpha(110);
        // set1.setFillColor(Color.RED);

        // set the line to be drawn like this "- - - - - -"
       //  set1.enableDashedLine(10f, 5f, 0f);
         //set1.enableDashedHighlightLine(10f, 5f, 0f);
        set1.setColor(getResources().getColor(R.color.blue));
        set1.setCircleColor(getResources().getColor(R.color.blue));
        set1.setLineWidth(1f);
        set1.setCircleRadius(1f);
        set1.setDrawCircleHole(false);
        set1.setValueTextSize(12f);


      set1.setValueFormatter(new ValueFormatter() {
          @Override
          public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
              //return ""+((int)value);
              return  entry.getData().toString();

          }
      });
        ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
        dataSets.add(set1); // add the datasets

        // create a data object with the datasets
        LineData data = new LineData(xVals, dataSets);

        // set data
        lineChart.setData(data);
        lineChart.setScaleEnabled(false);



        /*//to remove background grid
        lineChart.getAxisLeft().setDrawGridLines(false);
        lineChart.getXAxis().setDrawGridLines(false);*/

        lineChart.getXAxis().enableGridDashedLine(1.0f,1.0f,1.0f);
        lineChart.getAxisLeft().enableGridDashedLine(1.0f,1.0f,1.0f);


        lineChart.setDescription(getResources().getString(R.string.chart_title));
        lineChart.setDescriptionTextSize(15);
        lineChart.setDescriptionPosition(850.0f,150.0f);

        Legend l = lineChart.getLegend();
        l.setFormSize(10f); // set the size of the legend forms/shapes
        l.setPosition(Legend.LegendPosition.BELOW_CHART_LEFT);
        l.setTextSize(15f);
        l.setTextColor(Color.BLACK);
        l.setXEntrySpace(5f); // set the space between the legend entries on the x-axis
        l.setYEntrySpace(5f); // set the space between the legend entries on the y-axis

        l.setCustom(new int[]{0,0},
                new String[]{"03 min\n 25feb2017","105 mins\n Total till date"});


        lineChart.getXAxis().setEnabled(false);
        YAxis yAxisRight = lineChart.getAxisRight();
        yAxisRight.setEnabled(false);
       //reduce the distance between the points
        lineChart.setVisibleXRange(35,35);

        lineChart.getXAxis().setAxisMinValue(-2f);






    }
}
