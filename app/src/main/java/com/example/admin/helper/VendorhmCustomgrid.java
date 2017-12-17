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
 * Created by Admin on 12/6/2017.
 */

public class VendorhmCustomgrid extends ArrayAdapter {

    Context context;
    static  int images[]={R.drawable.ic_carpanter_icon,R.drawable.ic_drycleaning_icon,R.drawable.ic_water_icon,R.drawable.ic_taxi_icon};
    static String title[]={"Electrician","Plumber"};

    public VendorhmCustomgrid(@NonNull Context context) {
        super(context,R.layout.custom_vhgridview,title);

        this.context=context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view=inflater.inflate(R.layout.custom_vhgridview,null);

        ImageView imageview=(ImageView)view.findViewById(R.id.imagevhgd);
        imageview.setImageResource(images[position]);

        TextView textview=(TextView)view.findViewById(R.id.textViewvhgd);
        textview.setText(title[position]);

        return view;

    }

}