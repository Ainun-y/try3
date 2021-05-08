package com.example.try3.main;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.try3.R;
import com.example.try3.model.PatientInfo;

import java.util.List;

public class PatientList extends ArrayAdapter<PatientInfo> {
    private Activity context;
    List<PatientInfo> patients;

    public PatientList(Activity context, List<PatientInfo>patients){
        super(context, R.layout.activity_patient_list,patients);
        this.context=context;
        this.patients=patients;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View listViewItem=inflater.inflate(R.layout.activity_patient_list, null, true);


        TextView textViewName=(TextView)listViewItem.findViewById(R.id.textViewPName);
        TextView textViewIC=(TextView)listViewItem.findViewById(R.id.textViewPIC);
        TextView textViewPhone=(TextView)listViewItem.findViewById(R.id.textViewPPhone);
        TextView textViewAddress=(TextView)listViewItem.findViewById(R.id.textViewPAddress);
        TextView textViewPoscode=(TextView)listViewItem.findViewById(R.id.textViewPPoscode);
        TextView textViewDistrict=(TextView)listViewItem.findViewById(R.id.textViewPDistrict);
        TextView textViewCountry=(TextView)listViewItem.findViewById(R.id.textViewPCountry);


        PatientInfo patientInfo=patients.get(position);
        textViewName.setText(patientInfo.getpName());
        textViewIC.setText(patientInfo.getpIC());
        textViewPhone.setText(patientInfo.getpPhoneNum());
        textViewAddress.setText(patientInfo.getpAddress());
        textViewPoscode.setText(patientInfo.getpPoscode());
        textViewDistrict.setText(patientInfo.getpDistrict());
        textViewCountry.setText(patientInfo.getpCountry());



        return listViewItem;
    }
}
