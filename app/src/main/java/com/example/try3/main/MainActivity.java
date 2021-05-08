package com.example.try3.main;

import androidx.appcompat.app.AppCompatActivity;
//import android.support.annotation.NonNull;
//import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.try3.R;
import com.google.firebase.database.DatabaseReference;


public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    Button btnAdd;
    EditText editTextName, editTextPassword;
    DatabaseReference databaseReference;
    TextView textViewNurse;
    int counter=5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        btnAdd = (Button) findViewById(R.id.btnLogin);

        textViewNurse = (TextView) findViewById(R.id.textViewNurse);


      

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(editTextName.getText().toString(), editTextPassword.getText().toString());

            }
        });

        textViewNurse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), nurseLogin.class);
                startActivity(intent);
            }
        });

    }

    private void validate(String userName, String userPassword) {

        if((userName.equals("Admin"))&&(userPassword.equals("1234"))){
        Intent intent=new Intent(getApplicationContext(),adminspace.class);
        startActivity(intent);
        }else {
            Toast.makeText(this, "Try Again", Toast.LENGTH_LONG).show();
        }

    }
}
