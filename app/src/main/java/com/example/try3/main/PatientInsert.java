package com.example.try3.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.try3.R;
import com.example.try3.model.PatientInfo;
import com.example.try3.patientlisthistory;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class PatientInsert extends AppCompatActivity {

    public static final String PATIENT_NAME="com.example.try3";
    public static final String PATIENT_ID="com.example.try3";



    EditText editTextName, editTextPhone, editTextAddress, editTextpId, editTextpIC,editTextpPoscode, editTextpDistrict, editTextpCountry;
    Spinner spinnercountry;
    Button btnAdd;
   // ListView listViewPatient;

    List<PatientInfo>patients;

    DatabaseReference databasePatient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_insert);

        databasePatient= FirebaseDatabase.getInstance().getReference("Patient");

        editTextpPoscode=(EditText)findViewById(R.id.editTextPoscode);
        editTextpDistrict=(EditText)findViewById(R.id.editTextDistrict);
        spinnercountry=(Spinner)findViewById(R.id.spinnerCountry);
        editTextName=(EditText)findViewById(R.id.editTextPName);

        editTextpIC=(EditText)findViewById(R.id.editTextPIC);
        editTextName=(EditText)findViewById(R.id.editTextPName);
        editTextPhone=(EditText)findViewById(R.id.editTextPPhone);
        editTextAddress=(EditText)findViewById(R.id.editTextPAddress);

        btnAdd=(Button)findViewById(R.id.btnPAdd);

        patients=new ArrayList<>();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addPatient();
            }
        });
/*
        listViewPatient.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                PatientInfo patientInfo=patients.get(i);

                Intent intent=new Intent(getApplicationContext(), historyactivity.class);
                intent.putExtra(PATIENT_ID, patientInfo.getpId());
                intent.putExtra(PATIENT_NAME,patientInfo.getpName());
                intent.putExtra(PATIENT_PHONE,patientInfo.getpPhoneNum());
                intent.putExtra(PATIENT_POSCODE,patientInfo.getpPoscode());
                intent.putExtra(PATIENT_IC,patientInfo.getpIC());
                intent.putExtra(PATIENT_ADDRESS,patientInfo.getpAddress());
                intent.putExtra(PATIENT_COUNTRY,patientInfo.getpCountry());
                intent.putExtra(PATIENT_DISTRICT,patientInfo.getpDistrict());

                startActivity(intent);
            }
        });

        listViewPatient.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int i, long l) {
                PatientInfo patientInfo=patients.get(i);
                showUpdateDeleteDialog(patientInfo.getpId(), patientInfo.getpIC(),patientInfo.getpName(), patientInfo.getpPhoneNum(),
                        patientInfo.getpAddress(), patientInfo.getpPoscode(), patientInfo.getpDistrict(), patientInfo.getpCountry());
                return true;
            }
        });*/
    }

    private void addPatient() {
        String name=editTextName.getText().toString().trim();
        String phone=editTextPhone.getText().toString().trim();
        String address=editTextAddress.getText().toString().trim();
        String id=databasePatient.push().getKey();
        String IC= editTextpIC.getText().toString().trim();
        String poscode=editTextpPoscode.getText().toString().trim();
        String dictrict=editTextpDistrict.getText().toString().trim();
        String country=spinnercountry.getSelectedItem().toString();


        if (!TextUtils.isEmpty(name)){

            PatientInfo patientInfo= new PatientInfo(id,IC, name, phone,address, poscode, dictrict, country);
            databasePatient.child(id).setValue(patientInfo);
            Toast.makeText(this,"Patient Added", Toast.LENGTH_LONG).show();
            Intent intent=new Intent(getApplicationContext(), patientlisthistory.class);
            startActivity(intent);


        }
    }

 /*   @Override
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

                PatientList patientAdapter=new PatientList(PatientInsert.this,patients);
                listViewPatient.setAdapter(patientAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }*/


}
