package com.example.try3.main;

import android.content.Intent;
import android.graphics.Color;

import android.os.Bundle;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.try3.R;
import com.example.try3.model.History;
import com.example.try3.model.PatientInfo;
import com.example.try3.model.patientcondition;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;

import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class graphmonitorpatient extends AppCompatActivity {

    public static final String PATIENT_NAME="com.example.try3";
    public static final String PATIENT_ID="com.example.try3";

    ArrayList<BarEntry> barEntryArrayList;
    ArrayList<String>labelsNames;

    ArrayList<patientcondition>pArrayList= new ArrayList<>();
    BarChart barchart;

    DatabaseReference dbRate;
    List<patientcondition> patientcon;
    int i = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graphmonitorpatient);
        barchart = findViewById(R.id.idPieChart);


        patientcon=new ArrayList<>();




        /*barEntryArrayList= new ArrayList<>();*/
        labelsNames =new ArrayList<>();
         fillMonthSales();


     //   textViewname.setText(intent.getStringExtra(patientlistall.PATIENT_NAME));
    }


    private void showChart(ArrayList<BarEntry> barEntryArrayList) {

        BarDataSet barDataSet=new BarDataSet(this.barEntryArrayList, "Patient Name");
      //  barDataSet.setValues(barEntryArrayList);
        barDataSet.setColor(Color.RED);
        Description description= new Description();
        description.setText("Patient Name");
        barchart.setDescription(description);
        BarData barData= new BarData(barDataSet);
        barData.setBarWidth(0.1f);
        barchart.setData(barData);
        XAxis xAxis= barchart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(labelsNames));
        //set position of labels
        xAxis.setPosition(XAxis.XAxisPosition.TOP);
        xAxis.setDrawGridLines(false);
        xAxis.setDrawAxisLine(false);
        xAxis.setGranularity(1f);
        xAxis.setLabelCount(labelsNames.size());
        xAxis.setLabelRotationAngle(360);
        barchart.animateY(2000);
        barchart.invalidate();


    }


/*

    Intent intent=getIntent();
    String name=intent.getStringExtra(patientlistall.PATIENT_NAME);
    databaseReference= FirebaseDatabase.getInstance().getReference("History").child(name);
        txt14.setText(name);

        databaseReference.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot snapshot) {
            for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                History history= dataSnapshot.getValue(History.class);

                txt1.setText(history.getChRheumaticFever());
            }

        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {

        }
    });
*/


    private void fillMonthSales() {
        Intent intent=getIntent();
       String name=intent.getStringExtra(patientslistdetail2.PATIENT_NAME);

        dbRate= FirebaseDatabase.getInstance().getReference("Rate").child(name);
        dbRate.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                barEntryArrayList= new ArrayList<BarEntry>();
                if(dataSnapshot.hasChildren()){
                    patientcondition patientCondition = dataSnapshot.getValue(patientcondition.class);
                            pArrayList.add(patientCondition);
                            int rOedema = patientCondition.getRatingOedema();
                            for (int i = 0; i < pArrayList.size(); i++) {
                                barEntryArrayList.add(new BarEntry(pArrayList.size(), rOedema));
                            }

                            showChart(barEntryArrayList);



                    }else {
                    Intent intent=new Intent(getApplicationContext(), patientslistdetail2.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
        }


