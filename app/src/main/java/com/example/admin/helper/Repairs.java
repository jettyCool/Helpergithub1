package com.example.admin.helper;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class Repairs extends AppCompatActivity {

    ListView lv;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repairs);

        lv=(ListView)findViewById(R.id.listrepair);
        context=this;

        CustomRepairsList crl=new CustomRepairsList(context);
        lv.setAdapter(crl);


    }


}
