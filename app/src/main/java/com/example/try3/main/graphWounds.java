package com.example.try3.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.example.try3.R;
import com.example.try3.model.PatientInfo;
import com.example.try3.model.patientcondition;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class graphWounds extends AppCompatActivity {

    ArrayList<BarEntry> barEntryArrayList;
    ArrayList<String>labelsNames;
    ArrayList<patientcondition>pArrayList= new ArrayList<>();

    BarChart barchartWounds;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference dbRate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph_wounds);

        barchartWounds = findViewById(R.id.idbarChartWounds);

        firebaseDatabase= FirebaseDatabase.getInstance();
        dbRate= firebaseDatabase.getReference("Rate");
        /*barEntryArrayList= new ArrayList<>();*/
        labelsNames =new ArrayList<>();
        fillMonthSales();



    }


    private void showChart(ArrayList<BarEntry> barEntryArrayList) {

        BarDataSet barDataSet=new BarDataSet(this.barEntryArrayList, "Rate of wounds and infection");
        //  barDataSet.setValues(barEntryArrayList);
        barDataSet.setColor(Color.BLACK);
        Description description= new Description();
        description.setText("Wounds and Infection");
        barchartWounds.setDescription(description);
        BarData barData= new BarData(barDataSet);
        barchartWounds.setData(barData);
        XAxis xAxis= barchartWounds.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(labelsNames));
        //set position of labels
        xAxis.setPosition(XAxis.XAxisPosition.TOP);
        xAxis.setDrawGridLines(false);
        xAxis.setDrawAxisLine(false);
        xAxis.setGranularity(1f);
        xAxis.setLabelCount(labelsNames.size());
        xAxis.setLabelRotationAngle(360);
        barchartWounds.animateY(2000);
        barchartWounds.invalidate();


    }

    private void fillMonthSales() {

        dbRate.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                barEntryArrayList= new ArrayList<BarEntry>();
                if(dataSnapshot.hasChildren()){

                    for(DataSnapshot myDataSnapShot : dataSnapshot.getChildren()){

                        for(DataSnapshot dataSnapshot1: myDataSnapShot.getChildren()){

                            patientcondition patientCondition= dataSnapshot1.getValue(patientcondition.class);
                            pArrayList.add(patientCondition);
                            int rWounds = patientCondition.getRatingWounds();

                            for (int i=0; i<pArrayList.size();i++) {
                                barEntryArrayList.add(new BarEntry(pArrayList.size(), rWounds));
                            }

                        }

                    }
                    showChart(barEntryArrayList);
                }



            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }



}
