package com.example.try3.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.try3.R;
import com.example.try3.model.PatientInfo;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class patientlistall extends AppCompatActivity {
    public static final String PATIENT_NAME="com.example.try3";
    public static final String PATIENT_ID="com.example.try3";


    ListView listViewPatient;
    List<PatientInfo> patients;
    DatabaseReference databasePatient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patientlistall);

        databasePatient= FirebaseDatabase.getInstance().getReference("Patient");
        patients=new ArrayList<>();

        listViewPatient=(ListView)findViewById(R.id.listViewPatients);

        listViewPatient.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                PatientInfo patientInfo=patients.get(i);

                Intent intent=new Intent(getApplicationContext(), monitoPatient.class);
                intent.putExtra(PATIENT_ID, patientInfo.getpId());
                intent.putExtra(PATIENT_NAME,patientInfo.getpName());


                startActivity(intent);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        databasePatient.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                patients.clear();

                for(DataSnapshot postSnapshot: dataSnapshot.getChildren()){
                    PatientInfo patientInfo=postSnapshot.getValue(PatientInfo.class);
                    patients.add(patientInfo);
                }

                PatientList patientAdapter=new PatientList(patientlistall.this,patients);
                listViewPatient.setAdapter(patientAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
}}
