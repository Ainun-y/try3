package com.example.try3.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.try3.R;
import com.example.try3.model.NurseInfo;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class nurseLogin extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference ref, ref1;


    private Button btnlogin;
    private EditText editTextNurseName, editTextNursePassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nurse_login);

        database = FirebaseDatabase.getInstance();
        ref=database.getReference("Nurse");


        btnlogin = (Button) findViewById(R.id.btnLogin2);
        editTextNurseName = (EditText) findViewById(R.id.editTextName2);
        editTextNursePassword = (EditText) findViewById(R.id.editTextPassword2);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();
               }
        });
    }

    public void validate() {
        final String nurseuser = editTextNurseName.getText().toString();
        final String nursePassword = editTextNursePassword.getText().toString();

            ref1=database.getReference().child("Nurse");
            ref1.child(nurseuser).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            NurseInfo nurseInfo = dataSnapshot.getValue(NurseInfo.class);
                            if (nursePassword.equals(nurseInfo.getnPassword())) {
                                Toast.makeText(nurseLogin.this, "Login Successful", Toast.LENGTH_LONG).show();
                                Intent intent=new Intent(getApplicationContext(), nursespace.class);
                                startActivity(intent);

                            } else {
                                Toast.makeText(nurseLogin.this, "You enter wrong password ", Toast.LENGTH_LONG).show();
                            }
                       }
                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Toast.makeText(nurseLogin.this, "Data Error!", Toast.LENGTH_LONG).show();

                }
            });


        }
    }

