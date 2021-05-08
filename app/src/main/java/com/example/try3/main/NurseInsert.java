package com.example.try3.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.try3.R;
import com.example.try3.model.NurseInfo;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class NurseInsert extends AppCompatActivity {

    public static final String NURSE_NAME="com.example.try3";
    public static final String NURSE_ID="com.example.try3";

    EditText editTextName, editTextPhone, editTextEmail, editTextPassword, editTextUser;
    Button btnAdd;
    List<NurseInfo>nurses;
    Spinner spinnergender;
    long maxid=0;


    DatabaseReference databaseNurse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nurse_insert);

        databaseNurse= FirebaseDatabase.getInstance().getReference("Nurse");
        editTextUser=(EditText)findViewById(R.id.editTextNUser);
        editTextName=(EditText)findViewById(R.id.editTextNName);
        editTextPhone=(EditText)findViewById(R.id.editTextNPhone);

        editTextEmail=(EditText)findViewById(R.id.editTextNEmail);
        editTextPassword=(EditText)findViewById(R.id.editTextNPassword);
        spinnergender=(Spinner)findViewById(R.id.spinnerGender);

        btnAdd=(Button)findViewById(R.id.btnNAdd);
        nurses=new ArrayList<>();
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNurse();

            }
        });

        databaseNurse.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    maxid=(dataSnapshot.getChildrenCount());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

    private void addNurse() {
        String id= databaseNurse.push().getKey();
        String name=editTextName.getText().toString().trim();
        String phone=editTextPhone.getText().toString().trim();
        String user=editTextUser.getText().toString().trim();
        String gender=spinnergender.getSelectedItem().toString();
        String email=editTextEmail.getText().toString().trim();
        String password=editTextPassword.getText().toString().trim();

        if (!TextUtils.isEmpty(name)){

       NurseInfo nurseInfo= new NurseInfo(id, name, phone,gender, email,user, password);


       databaseNurse.child(user).setValue(nurseInfo);

        Toast.makeText(this,"Nurse Added", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this,"Please insert data", Toast.LENGTH_LONG).show();
        }

    }

    private boolean updateNurse(String id, String nName, String nPhoneNum, String nGender, String nEmail, String nUser, String nPassword){
    DatabaseReference dr=FirebaseDatabase.getInstance().getReference("Nurse").child(id);
        NurseInfo nurseInfo=new NurseInfo(id, nName, nPhoneNum,  nGender,  nEmail, nUser, nPassword);
        dr.setValue(nurseInfo);
        Toast.makeText(getApplicationContext(), "Nurse Updated", Toast.LENGTH_LONG).show();
        return true;
    }

    private void showUpdateDeleteDialog(final String id, final String nName,final String nPhoneNum,final String nGender, final String nEmail, final String nUser,final String nPassword){
        AlertDialog.Builder dialogBuilder=new AlertDialog.Builder(this);
        LayoutInflater inflater=getLayoutInflater();
        final  View dialogView=inflater.inflate(R.layout.update_dialog, null);
        dialogBuilder.setView(dialogView);

        final EditText editTextPhone=(EditText)dialogView.findViewById(R.id.editTextPhone);
        final EditText editTextEmail=(EditText)dialogView.findViewById(R.id.editTextEmail);
        final EditText editTextPassword=(EditText)dialogView.findViewById(R.id.editTextPassword);
        final EditText editTextDepartment=(EditText)dialogView.findViewById(R.id.editTextDepartment);



        final Button btnUpdate=(Button)dialogView.findViewById(R.id.buttonUpdate);
        final Button btnDelete=(Button)dialogView.findViewById(R.id.buttonDelete);

        dialogBuilder.setTitle(nName);
        final AlertDialog b=dialogBuilder.create();
        b.show();

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String phone=editTextPhone.getText().toString().trim();
                String gender=spinnergender.getSelectedItem().toString();
                String password=editTextPassword.getText().toString().trim();

                if(!TextUtils.isEmpty(phone)){
                    updateNurse(id,nName,phone,nGender,nEmail,nUser, nPassword);
                    b.dismiss();
                }else if (!TextUtils.isEmpty(gender)){
                    updateNurse(id,nName,nPhoneNum,gender,nEmail,nUser, nPassword);
                    b.dismiss();
                }else if (!TextUtils.isEmpty(password)){
                    updateNurse(id,nName,nPhoneNum,nGender, nEmail, nUser, password);
                    b.dismiss();
                }else {
                    b.dismiss();
                }

            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteNurse(id);
                b.dismiss();
            }
        });
    }

    private boolean deleteNurse(String id){
        DatabaseReference dr=FirebaseDatabase.getInstance().getReference("Nurse").child(id);

        dr.removeValue();
        Toast.makeText(getApplicationContext(), "Nurse Deleted", Toast.LENGTH_LONG).show();

        return true;

    }


}
