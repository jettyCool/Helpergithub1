package com.example.admin.helper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Plumber extends AppCompatActivity {

    LinearLayout linearLayout;
    TextView  tvpldesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plumber);

        tvpldesc=findViewById(R.id.tvpldesc);
        tvpldesc.setText("Where do you need the\nservices");



        linearLayout=findViewById(R.id.llcontinue);

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent inn=new Intent(getApplicationContext(),VerifyAndLogin.class);
                startActivity(inn);

            }
        });

    }

}