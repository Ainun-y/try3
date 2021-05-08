package com.example.try3.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.try3.R;
import com.example.try3.model.History;
import com.example.try3.model.PatientInfo;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class historyactivity extends AppCompatActivity {


    Button btnAdd;
    EditText editTextdetails;
    TextView textViewgetName;

    CheckBox measles, mumps, rubella, chickenpox, polio, rheumaticfever,
            tetanus, influenza, ichickenpox, hepatitis, pneumonia, mmr;
    History history;
    DatabaseReference reference;

    int i = 0;

    List<PatientInfo>patients;
    List<History> histories;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        Intent intent = getIntent();
        patients=new ArrayList<>();
        reference = FirebaseDatabase.getInstance().getReference("History").child(intent.getStringExtra(patientlistall.PATIENT_NAME));

        editTextdetails = (EditText) findViewById(R.id.editTextdetails);
        btnAdd = (Button) findViewById(R.id.btnHadd);
        measles = (CheckBox) findViewById(R.id.Measles);
        mumps = (CheckBox) findViewById(R.id.Mumps);
        rubella = (CheckBox) findViewById(R.id.Rubella);
        chickenpox = (CheckBox) findViewById(R.id.ChickenPox);
        polio = (CheckBox) findViewById(R.id.Polio);
        rheumaticfever = (CheckBox) findViewById(R.id.RheumaticFever);
        tetanus = (CheckBox) findViewById(R.id.Tetanus);
        influenza = (CheckBox) findViewById(R.id.Influenza);
        ichickenpox = (CheckBox) findViewById(R.id.ChickenPoxImmun);
        hepatitis = (CheckBox) findViewById(R.id.Hepatitis);
        pneumonia = (CheckBox) findViewById(R.id.Pneumonia);
        mmr = (CheckBox) findViewById(R.id.MMR);
        textViewgetName = (TextView) findViewById(R.id.textViewPatient);

        textViewgetName.setText(intent.getStringExtra(PatientInsert.PATIENT_NAME));


        history = new History();
        histories = new ArrayList<>();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addHistory();
            }
        });


    }


    private void addHistory() {
        String ch1 = "Measles";
        String ch2 = "Mumps";
        String ch3 = "Rubella";
        String ch4 = "Chicken Pox";
        String ch5 = "Polio";
        String ch6 = "Rheumatic Fever";
        String i1 = "Tetanus";
        String i2 = "Influenza";
        String i3 = "Chicken Pox";
        String i4 = "Hepatitis";
        String i5 = "Pneumonia";
        String i6 = "MMR";

        String historyDetails = editTextdetails.getText().toString().trim();

            String id = reference.push().getKey();

            if (measles.isChecked()) {
                history.sethMeasles(ch1);

            } else {
            }
            if (mumps.isChecked()) {
                history.sethMumps(ch2);

            } else {
            }
            if (rubella.isChecked()) {
                history.setChRubella(ch3);

            } else {
            }
            if (chickenpox.isChecked()) {
                history.setChChickenPox(ch4);

            } else {
            }
            if (polio.isChecked()) {
                history.setChPolio(ch5);

            } else {
            }
            if (rheumaticfever.isChecked()) {
                history.setChRheumaticFever(ch6);

            } else {
            }
            if (tetanus.isChecked()) {
                history.setiTetanus(i1);

            } else {
            }
            if (influenza.isChecked()) {
                history.setiInfluenza(i2);

            } else {
            }
            if (ichickenpox.isChecked()) {
                history.setiChickenPox(i3);

            } else {
            }
            if (hepatitis.isChecked()) {
                history.setiHepatitis(i4);

            } else {
            }
            if (pneumonia.isChecked()) {
                history.setiPneumonia(i5);

            } else {
            }
            if (mmr.isChecked()) {
                history.setiMMR(i6);

            } else {
            }
            History history = new History(id, historyDetails, ch1, ch2, ch3, ch4, ch5, ch6, i1, i2, i3, i4, i5, i6);
            reference.child(id).setValue(history);


            Toast.makeText(this, "History saved", Toast.LENGTH_LONG).show();

            Intent intent=new Intent(getApplicationContext(), adminspace.class);
            startActivity(intent);



    }

}