package com.example.admin.helper;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Admin on 12/14/2017.
 */

public class CustomRepairsList extends ArrayAdapter {

    Context context;
    static  int imagesr[]={R.drawable.geyserwaterheaterrepair,R.drawable.electricianrepair,R.drawable.plumberrepair,
            R.drawable.roorwaterrepair,R.drawable.washingmachinerepair,R.drawable.refrigratorrepair,
            R.drawable.geyserwaterheaterrepair,R.drawable.electricianrepair,R.drawable.plumberrepair,R.drawable.roorwaterrepair,
            R.drawable.washingmachinerepair,R.drawable.refrigratorrepair};
    static String titler[]={"Geyser / Water Heater Repair","Electrician","Plumber","RO or Water Purifier Repair",
            "Washing Machine Repair","Refrigrator Repair","Geyser / Water Heater Repair","Electrician","Plumber",
            "RO or Water Purifier Repair","Washing Machine Repair","Refrigrator Repair"};

    public CustomRepairsList(@NonNull Context context) {
        super(context, R.layout.custom_repairlist,titler);
        this.context=context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view=inflater.inflate(R.layout.custom_repairlist,null);

        ImageView imageview=(ImageView)view.findViewById(R.id.imagerepair);
        imageview.setImageResource(imagesr[position]);

        TextView textview=(TextView)view.findViewById(R.id.tvrepair);
        textview.setText(titler[position]);

        return view;
    }

}