package com.example.try3.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.ListView;


import androidx.appcompat.app.AppCompatActivity;

import com.example.try3.R;
import com.example.try3.model.PatientInfo;
import com.google.firebase.database.DatabaseReference;
import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.util.ArrayList;
import java.util.List;


public class nursespace extends AppCompatActivity {


        public static final String PATIENT_NAME="com.example.try3";
        public static final String PATIENT_ID="com.example.try3";


        List<PatientInfo> patients;
        DatabaseReference databasePatient;
        GridLayout patientData, monitor, growth;
        ImageView img52,img62, img72;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.nurse_space);

            databasePatient= FirebaseDatabase.getInstance().getReference("Patient");
            patients=new ArrayList<>();

            patientData=(GridLayout)findViewById(R.id.datalayout);
            monitor=(GridLayout)findViewById(R.id.monitorlayout);
            growth=(GridLayout)findViewById(R.id.growthlayout);
         /*   img52=(ImageView)findViewById(R.id.img52);
            img62=(ImageView)findViewById(R.id.img62);
            img72=(ImageView)findViewById(R.id.img72);*/

            patientData.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(getApplicationContext(), patientlistDetails.class);

                    startActivity(intent);
                }
            });

            monitor.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(getApplicationContext(), patientlistall.class);

                    startActivity(intent);
                }
            });

            growth.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(getApplicationContext(), dashboardNurse.class);

                    startActivity(intent);
                }
            });

        }}
