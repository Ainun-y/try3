package com.example.try3.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;

import com.example.try3.R;

public class dashboardNurse extends AppCompatActivity {

    GridLayout gOedema, gMuscle, gWound, gContracture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_nurse);

        gOedema=(GridLayout)findViewById(R.id.gOedema);
        gMuscle=(GridLayout)findViewById(R.id.gMuscle);
        gWound=(GridLayout)findViewById(R.id.gWound);
        gContracture=(GridLayout)findViewById(R.id.gContracture);

        gOedema.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), graphOedema.class);

                startActivity(intent);
            }
        });

        gMuscle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), graphMuscle.class);

                startActivity(intent);
            }
        });

        gContracture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), graphContracture.class);

                startActivity(intent);
            }
        });

        gWound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), graphWounds.class);

                startActivity(intent);
            }
        });



    }


}
