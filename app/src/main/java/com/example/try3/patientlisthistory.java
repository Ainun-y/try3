package com.example.try3;

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

import com.example.try3.main.PatientList;
import com.example.try3.main.history2;
import com.example.try3.main.historyactivity;
import com.example.try3.main.patientlistall;
import com.example.try3.model.PatientInfo;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class patientlisthistory extends AppCompatActivity {


    public static final String PATIENT_NAME="com.example.try3";
    public static final String PATIENT_ID="com.example.try3";

    EditText editTextName, editTextPhone, editTextAddress, editTextpId, editTextpIC,editTextpPoscode, editTextpDistrict, editTextpCountry;
    ListView listViewPatient;
    List<PatientInfo> patients;
    DatabaseReference databasePatient;
    Spinner spinnercountry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patientlisthistory);

        databasePatient= FirebaseDatabase.getInstance().getReference("Patient");
        patients=new ArrayList<>();
        editTextpPoscode=(EditText)findViewById(R.id.editTextPoscode);
        editTextpDistrict=(EditText)findViewById(R.id.editTextDistrict);
        spinnercountry=(Spinner)findViewById(R.id.spinnerCountry);
        listViewPatient=(ListView)findViewById(R.id.listViewpatientmonitor);


        listViewPatient.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                PatientInfo patientInfo=patients.get(i);

                Intent intent=new Intent(getApplicationContext(), historyactivity.class);
                intent.putExtra(PATIENT_ID, patientInfo.getpId());
                intent.putExtra(PATIENT_NAME,patientInfo.getpName());
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

                PatientList patientAdapter=new PatientList(patientlisthistory.this,patients);
                listViewPatient.setAdapter(patientAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private boolean updatePatient(String id,String IC, String name, String phone, String address, String poscode, String district, String country){
        DatabaseReference dr=FirebaseDatabase.getInstance().getReference("Patient").child(id);

        PatientInfo patientInfo=new PatientInfo(id,IC, name, phone, address,poscode, district, country);
        dr.setValue(patientInfo);
        Toast.makeText(getApplicationContext(), "Patient Updated", Toast.LENGTH_LONG).show();
        return true;
    }

    private void showUpdateDeleteDialog(final String patientId, final String patientIC, final String patientName, final String patientPhone,final String patientAddress, final String patientPoscode, final String patientDistrict, final String patientCountry){
        AlertDialog.Builder dialogBuilder=new AlertDialog.Builder(this);
        LayoutInflater inflater=getLayoutInflater();
        final  View dialogView=inflater.inflate(R.layout.update_dialog, null);
        dialogBuilder.setView(dialogView);

        final EditText editTextPhone=(EditText)dialogView.findViewById(R.id.editTextPhone);
        final EditText editTextAddress=(EditText)dialogView.findViewById(R.id.editTextAddress);

        final Button btnUpdate=(Button)dialogView.findViewById(R.id.buttonUpdate);
        final Button btnDelete=(Button)dialogView.findViewById(R.id.buttonDelete);

        dialogBuilder.setTitle(patientName);
        final AlertDialog b=dialogBuilder.create();
        b.show();

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String phone=editTextPhone.getText().toString().trim();
                String address=editTextAddress.getText().toString().trim();
                String poscode=editTextpPoscode.getText().toString().trim();
                String district=editTextpDistrict.getText().toString().trim();
                String country=spinnercountry.getSelectedItem().toString();
                if(!TextUtils.isEmpty(phone)){
                    updatePatient(patientId,patientIC,patientName,phone, patientAddress, patientPoscode,patientDistrict,patientCountry);
                    b.dismiss();
                }else if (!TextUtils.isEmpty(address)|| !TextUtils.isEmpty(poscode)||!TextUtils.isEmpty(district)|| !TextUtils.isEmpty(country)){
                    updatePatient(patientId,patientIC,patientName,patientPhone, address, poscode,district,country);
                }else{
                    updatePatient(patientId,patientIC,patientName,phone, address, poscode,district,country);
                }

            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deletePatient(patientId);
                b.dismiss();
            }
        });
    }

    private boolean deletePatient(String id){
        DatabaseReference dr=FirebaseDatabase.getInstance().getReference("Patient").child(id);
        dr.removeValue();
        DatabaseReference drHistory=FirebaseDatabase.getInstance().getReference("History").child(id);
        drHistory.removeValue();
        Toast.makeText(getApplicationContext(), "Patient Deleted", Toast.LENGTH_LONG).show();

        return true;

    }}
