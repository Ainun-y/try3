package com.example.try3.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.try3.R;
import com.example.try3.model.History;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class history2 extends AppCompatActivity {

    TextView txt1, txt2, txt3, txt4, txt5, txt6, txt7, txt8,txt9, txt10, txt11, txt12, txt13,txt14;
    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history2);

        txt1=(TextView)findViewById(R.id.h10);
        txt2=(TextView)findViewById(R.id.h11);
        txt3=(TextView)findViewById(R.id.h12);
        txt4=(TextView)findViewById(R.id.h13);
        txt5=(TextView)findViewById(R.id.h14);
        txt6=(TextView)findViewById(R.id.h15);
        txt7=(TextView)findViewById(R.id.h24);
        txt8=(TextView)findViewById(R.id.h17);
        txt9=(TextView)findViewById(R.id.h18);
        txt10=(TextView)findViewById(R.id.h19);
        txt11=(TextView)findViewById(R.id.h20);
        txt12=(TextView)findViewById(R.id.h21);
        txt13=(TextView)findViewById(R.id.h22);
        txt14=(TextView)findViewById(R.id.h23);
      /*  dbRate= FirebaseDatabase.getInstance().getReference("Rate").child(name);
        dbRate.addValueEventListener(new ValueEventListener() {*/

        Intent intent=getIntent();
        String name=intent.getStringExtra(patientlistall.PATIENT_NAME);
        databaseReference= FirebaseDatabase.getInstance().getReference("History").child(name);
        txt14.setText(name);
        txt7.setText(name);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                    History history= dataSnapshot.getValue(History.class);

                    txt1.setText(history.getChRheumaticFever());
                    txt2.setText(history.getChPolio());
                    txt3.setText(history.getChChickenPox());
                    txt4.setText(history.getChRubella());
                    txt5.setText(history.gethMeasles());
                    txt6.setText(history.gethMumps());

                    txt8.setText(history.getiHepatitis());
                    txt9.setText(history.getiMMR());
                    txt10.setText(history.getiTetanus());
                    txt11.setText(history.getiInfluenza());
                    txt12.setText(history.getiChickenPox());
                    txt13.setText(history.getiPneumonia());
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}