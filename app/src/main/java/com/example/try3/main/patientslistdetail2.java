package com.example.try3.main;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.try3.R;
import com.example.try3.model.PatientInfo;
import com.example.try3.model.patientcondition;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class patientslistdetail2  extends AppCompatActivity {
    public static final String PATIENT_NAME="com.example.try3";
    public static final String PATIENT_ID="com.example.try3";


    ListView listViewPatient;
    List<PatientInfo> patients;
    List<patientcondition> patientcon;
    DatabaseReference databasePatient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patientslistdetail2);

        databasePatient= FirebaseDatabase.getInstance().getReference("Patient");
        patients=new ArrayList<>();

        listViewPatient=(ListView)findViewById(R.id.listViewPatientsgraph);

        listViewPatient.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                PatientInfo patientInfo=patients.get(i);
                patientcondition patientCon=patientcon.get(i);

                Intent intent=new Intent(getApplicationContext(),graphmonitorpatient.class);
                intent.putExtra(PATIENT_ID, patientInfo.getpId());
                intent.putExtra(PATIENT_NAME,patientInfo.getpName());


                startActivity(intent);
            }
        });

     /*   listViewPatient.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int i, long id) {
                PatientInfo patientInfo=patients.get(i);

                Intent intent=new Intent(getApplicationContext(), monitoPatient.class);
                intent.putExtra(PATIENT_ID, patientInfo.getpId());
                intent.putExtra(PATIENT_NAME,patientInfo.getpName());

                startActivity(intent);
return true;
            }
        });*/
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

                PatientList patientAdapter=new PatientList(patientslistdetail2.this,patients);
                listViewPatient.setAdapter(patientAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }}

