package com.example.admin.helper;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.admin.helper.utils.FontManager;

public class VerifyAndLogin extends AppCompatActivity {

    Context context;
    TextView otpdesc,mTextField;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = VerifyAndLogin.this;
        setContentView(R.layout.activity_verify_and_login);

        mTextField=findViewById(R.id.tvtimer);

        otpdesc= findViewById(R.id.otpdesc);

        otpdesc.setTypeface(FontManager.getTypeface(context,FontManager.FONTAWESOME));



        new CountDownTimer(120000, 1000) {

            public void onTick(long millisUntilFinished) {

                long timer = (millisUntilFinished/1000);
                long remainder = timer % 3600;
                long minutes = remainder / 60;
                long seconds = remainder % 60;
                String mins = (minutes < 10 ? "0" : "") + minutes;
                String secs = (seconds < 10 ? "0" : "") + seconds;

                mTextField.setText("" + mins + ":" + secs);
            }

            public void onFinish() {
                mTextField.setText("done!");
            }
        }.start();


        otpdesc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent inn=new Intent(getApplicationContext(),UserActivity.class);
                startActivity(inn);

            }
        });

    }
}