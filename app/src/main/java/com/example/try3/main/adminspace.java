package com.example.try3.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.try3.R;

public class adminspace extends AppCompatActivity {

    GridLayout showplist, regnurse, regpatient, shownlist;
    ImageView img12,img22, img32, img42;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_space);
        regnurse=(GridLayout) findViewById(R.id.layoutnurseregistration);
        regpatient=(GridLayout) findViewById(R.id.layoutpatientregistration);
        showplist=(GridLayout) findViewById(R.id.layoutpatientdata);
     //   shownlist=(GridLayout) findViewById(R.id.layoutpatientdata);
       /* img12=(ImageView)findViewById(R.id.img12);
        img22=(ImageView)findViewById(R.id.img22);
        img32=(ImageView)findViewById(R.id.img32);
        img42=(ImageView)findViewById(R.id.img42);*/

        showplist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), patientlistDetails.class);
                startActivity(intent);
            }
        });




        regpatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), PatientInsert.class);
                startActivity(intent);

            }
        });

        regnurse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), NurseInsert.class);
                startActivity(intent);

            }
        });

    }}
