package com.example.try3.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.try3.R;
import com.example.try3.model.PatientInfo;
import com.example.try3.model.patientcondition;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class monitoPatient extends AppCompatActivity {
    public static final String PATIENT_NAME="com.example.try3";
    public static final String PATIENT_ID="com.example.try3";

    Button btnAddmonito;
    SeekBar seekBar1, seekBar2, seekBar3, seekBar4;
    TextView textViewr1,textViewr2, textViewr3, textViewr4, textViewname;

    DatabaseReference databasemonitor;
    List<PatientInfo> patients;
    int i = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monito_patient);
        Intent intent=getIntent();
        patients=new ArrayList<>();
        databasemonitor= FirebaseDatabase.getInstance().getReference("Rate").child(intent.getStringExtra(patientlistall.PATIENT_NAME));

        btnAddmonito=(Button)findViewById(R.id.btnaddRating);
        seekBar1=(SeekBar)findViewById(R.id.seekBarRatingOedema);
        seekBar2=(SeekBar)findViewById(R.id.seekBarRatingWounds);
        seekBar3=(SeekBar)findViewById(R.id.seekBarRatingMuscle);
        seekBar4=(SeekBar)findViewById(R.id.seekBarRatingContracture);
        textViewr1=(TextView)findViewById(R.id.textViewRatingOedema);
        textViewr2=(TextView)findViewById(R.id.textViewRatingWounds);
        textViewr3=(TextView)findViewById(R.id.textViewRatingMuscle);
        textViewr4=(TextView)findViewById(R.id.textViewRatingContracture);
        textViewname=(TextView)findViewById(R.id.textViewmonitoname);

        textViewname.setText(intent.getStringExtra(patientlistall.PATIENT_NAME));

        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                textViewr1.setText(String.valueOf(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                textViewr2.setText(String.valueOf(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBar3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                textViewr3.setText(String.valueOf(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBar4.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                textViewr4.setText(String.valueOf(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        btnAddmonito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveRating();
            }
        });

    }

    private void saveRating() {
        int rating1=seekBar1.getProgress();
        int rating2=seekBar2.getProgress();
        int rating3=seekBar3.getProgress();
        int rating4=seekBar4.getProgress();

        String date;
        String time;
        String id=databasemonitor.push().getKey();

                patientcondition patientcondition = new patientcondition(id, rating1, rating2, rating3, rating4);
                databasemonitor.child(id).setValue(patientcondition);
                Toast.makeText(this, "Saved", Toast.LENGTH_LONG).show();


    }

}
