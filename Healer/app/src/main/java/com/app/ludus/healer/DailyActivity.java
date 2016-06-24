package com.app.ludus.healer;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class DailyActivity extends AppCompatActivity {
    private ImageButton btn1,btn2,btn3;
    private boolean tomou1,tomou2,tomou3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily);
        tomou1=tomou2=tomou3=false;
        btn1 = (ImageButton)findViewById(R.id.daily_btn_med1);
        btn2 = (ImageButton)findViewById(R.id.daily_btn_med2);
        btn3 = (ImageButton)findViewById(R.id.daily_btn_med3);

        Toolbar toolbar = (Toolbar) findViewById(R.id.daily_cst_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!tomou1)
                    btn1.setImageResource(R.drawable.pilula_verde);
                else
                    btn1.setImageResource(R.drawable.pilula_cinza);
                tomou1 = tomou1 && false;

            }
        });

    }

}
