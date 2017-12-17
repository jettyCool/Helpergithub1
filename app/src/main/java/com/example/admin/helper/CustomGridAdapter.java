package com.example.admin.helper;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import static android.R.attr.resource;
import static android.R.attr.title;

/**
 * Created by gurjeet on 11/9/2017.
 */

public class CustomGridAdapter extends ArrayAdapter {

    Context context;
    static  int images[]={R.drawable.ic_elecrician_icon,R.drawable.ic_plumber_icon,R.drawable.ic_carpanter_icon,R.drawable.ic_drycleaning_icon,R.drawable.ic_water_icon,R.drawable.ic_taxi_icon};
    static String tittle[]={"Electrician","Plumber","Carpenter","Dry Cleaning","Water Purifying","Hire Taxi"};

    public CustomGridAdapter(Context context) {
        super(context, R.layout.custom_gridview,tittle);
        this.context=context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view=inflater.inflate(R.layout.custom_gridview,null);

        ImageView imageview=(ImageView)view.findViewById(R.id.imageView);
        imageview.setImageResource(images[position]);

        TextView textview=(TextView)view.findViewById(R.id.textView);
        textview.setText(tittle[position]);

        return view;
    }

}