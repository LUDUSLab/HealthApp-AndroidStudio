package com.app.ludus.healer.activity;

import android.content.Intent;
import android.os.Bundle;;
import android.support.v7.app.AppCompatActivity;


import com.app.ludus.healer.activity.SplashLudusActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setContentView(R.layout.activity_paciente);
        startActivity(new Intent(getApplicationContext(),MenuActivity.class));
        finish();
    }

}
