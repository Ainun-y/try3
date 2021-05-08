package com.example.try3.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;

import com.example.try3.R;

public class dashboardAdmin extends AppCompatActivity {

    GridLayout gpatient, gcharacter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_admin);

        gpatient=(GridLayout)findViewById(R.id.gPATIENT);
        gcharacter=(GridLayout)findViewById(R.id.gCHARACTER);

        gpatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), patientslistdetail2.class);

                startActivity(intent);
            }
        });


        gcharacter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), dashboardNurse.class);

                startActivity(intent);
            }
        });

    }
}
