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
import com.example.try3.model.History;
import com.example.try3.model.PatientInfo;

import java.util.List;

public class HistoryList extends ArrayAdapter<History> {
    private Activity context;
    List<History>histories;

    public  HistoryList(Activity context, List<History>histories){
        super(context, R.layout.list_layout,histories);
        this.context=context;
        this.histories=histories;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.list_layout, null, true);



        TextView textViewName=(TextView)listViewItem.findViewById(R.id.textViewPName);
        TextView textViewIC=(TextView)listViewItem.findViewById(R.id.textViewPIC);
        TextView textViewPhone=(TextView)listViewItem.findViewById(R.id.textViewPPhone);
        TextView textViewAddress=(TextView)listViewItem.findViewById(R.id.textViewPAddress);
        TextView textViewPoscode=(TextView)listViewItem.findViewById(R.id.textViewPPoscode);
        TextView textViewDistrict=(TextView)listViewItem.findViewById(R.id.textViewPDistrict);
        TextView textViewCountry=(TextView)listViewItem.findViewById(R.id.textViewPCountry);



        History history=histories.get(position);
       
        textViewName.setText(history.gethId());
        textViewIC.setText(history.getChChickenPox());
        textViewPhone.setText(history.getChPolio());
        textViewAddress.setText(history.getChRheumaticFever());


          return listViewItem;

    }

}
