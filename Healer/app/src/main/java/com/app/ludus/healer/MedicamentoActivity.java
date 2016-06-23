package com.app.ludus.healer;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;

import java.io.Console;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.FrameLayout;

public class MedicamentoActivity extends AppCompatActivity {

    private DatePickerDialog fromDatePickerDialog;
    private EditText fromDateEtxt;

    private SimpleDateFormat dateFormatter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicamento);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        Calendar newCalendar = Calendar.getInstance();

        fromDatePickerDialog = new DatePickerDialog(this, new OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                fromDateEtxt.setText(dateFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));


    }

    public void onOpen(View view) {
        fromDatePickerDialog.show();
    }

    public void onAdd(View view){
        FrameLayout cardview = (FrameLayout) findViewById(R.id.layout_medicamento);


    }

}
