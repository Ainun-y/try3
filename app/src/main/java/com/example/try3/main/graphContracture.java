package com.example.try3.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

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
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class graphContracture extends AppCompatActivity {


    ArrayList<BarEntry> barEntryArrayList;
    ArrayList<String>labelsNames;
    ArrayList<patientcondition>pArrayList= new ArrayList<>();

    BarChart barchartContracture;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference dbRate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph_contracture);

        barchartContracture = findViewById(R.id.idbarChartContracture);

        firebaseDatabase= FirebaseDatabase.getInstance();
        dbRate= firebaseDatabase.getReference("Rate");
        /*barEntryArrayList= new ArrayList<>();*/
        labelsNames =new ArrayList<>();
        fillMonthSales();



    }


    private void showChart(ArrayList<BarEntry> barEntryArrayList) {

        BarDataSet barDataSet=new BarDataSet(this.barEntryArrayList, "Rate of contracture severe");
        //  barDataSet.setValues(barEntryArrayList);
        barDataSet.setColor(Color.BLUE);
        Description description= new Description();
        description.setText("Contracture");
        barchartContracture.setDescription(description);
        BarData barData= new BarData(barDataSet);
        barchartContracture.setData(barData);
        XAxis xAxis= barchartContracture.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(labelsNames));
        //set position of labels
        xAxis.setPosition(XAxis.XAxisPosition.TOP);
        xAxis.setDrawGridLines(false);
        xAxis.setDrawAxisLine(false);
        xAxis.setGranularity(1f);
        xAxis.setLabelCount(labelsNames.size());
        xAxis.setLabelRotationAngle(360);
        barchartContracture.animateY(2000);
        barchartContracture.invalidate();


    }


  /*  Intent intent=getIntent();
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

        dbRate.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                barEntryArrayList= new ArrayList<BarEntry>();
                if(dataSnapshot.hasChildren()){
                    for(DataSnapshot myDataSnapShot : dataSnapshot.getChildren()){
                        for(DataSnapshot dataSnapshot1: myDataSnapShot.getChildren()){
                            patientcondition patientCondition= dataSnapshot1.getValue(patientcondition.class);
                            pArrayList.add(patientCondition);
                            int rContracture = patientCondition.getRatingContracture();

                            for (int i=0; i<pArrayList.size();i++) {
                                barEntryArrayList.add(new BarEntry(pArrayList.size(), rContracture));
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
