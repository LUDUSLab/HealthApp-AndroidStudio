package com.app.ludus.healer;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;

import java.io.Console;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.app.ludus.healer.dao.DAOTratamento;
import com.app.ludus.healer.model.ModelMedicamento;
import com.app.ludus.healer.model.ModelTratamento;

import org.w3c.dom.Text;

public class MedicamentoActivity extends AppCompatActivity
{
    private LinearLayout linearLayoutInicial;
    private LinearLayout linearLayoutfinal;

    private DatePickerDialog datePickerDialogInicial;
    private DatePickerDialog datePickerDialogFinal;

    private TextView textViewInicialData;
    private TextView textViewInicialDia;
    private TextView textViewFinalData;
    private TextView textViewFinalDia;

    private ModelTratamento modelTratamento;
    private DAOTratamento daoTratamento;

    private Date dateInicio;
    private Date dateFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicamento);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Calendar newCalendar = Calendar.getInstance();

        daoTratamento = new DAOTratamento(MedicamentoActivity.this);
        modelTratamento = daoTratamento.getTratamentoById(1);

        try
        {
            dateInicio = new SimpleDateFormat("dd/MM/yyyy").parse(modelTratamento.getDataInicio());
            dateFinal = new SimpleDateFormat("dd/MM/yyyy").parse(modelTratamento.getDataTermino());
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }

        linearLayoutInicial =(LinearLayout) findViewById(R.id.medicamento_lnl_inicial);
        textViewInicialData = (TextView) findViewById(R.id.medicamento_txv_inicialdata);
        textViewInicialDia = (TextView) findViewById(R.id.medicamento_txv_inicialdia);

        textViewInicialData.setText( new SimpleDateFormat("MM/yyyy").format(dateInicio));
        textViewInicialDia.setText(new SimpleDateFormat("dd").format(dateInicio));

        linearLayoutfinal =(LinearLayout) findViewById(R.id.medicamento_lnl_final);
        textViewFinalData = (TextView) findViewById(R.id.medicamento_txv_finaldata);
        textViewFinalDia = (TextView) findViewById(R.id.medicamento_txv_finaldia);

        textViewFinalData.setText( new SimpleDateFormat("MM/yyyy").format(dateFinal));
        textViewFinalDia.setText(new SimpleDateFormat("dd").format(dateFinal));

        datePickerDialogInicial = new DatePickerDialog(this, new OnDateSetListener()
        {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth)
            {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);

                String txt;
                txt = new SimpleDateFormat("dd/MM/yyyy").format(newDate.getTime());
                modelTratamento.setDataInicio(txt);

                txt = new SimpleDateFormat("MM/yyyy").format(newDate.getTime());
                textViewInicialData.setText(txt);

                txt = new SimpleDateFormat("dd").format(newDate.getTime());
                textViewInicialDia.setText(txt);
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePickerDialogFinal = new DatePickerDialog(this, new OnDateSetListener()
        {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth)
            {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);

                String txt;
                txt = new SimpleDateFormat("dd/MM/yyyy").format(newDate.getTime());
                modelTratamento.setDataTermino(txt);

                txt = new SimpleDateFormat("MM/yyyy").format(newDate.getTime());
                textViewFinalData.setText(txt);

                txt = new SimpleDateFormat("dd").format(newDate.getTime());
                textViewFinalDia.setText(txt);
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        //Abrir calendario
        linearLayoutInicial.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                datePickerDialogInicial.show();
            }
        });

        linearLayoutfinal.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                datePickerDialogFinal.show();
            }
        });

        ImageButton btnSalvar =(ImageButton) findViewById(R.id.medicamento_btn_salvar);

        btnSalvar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                daoTratamento.updateTratamento(modelTratamento);

                Toast.makeText(getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
