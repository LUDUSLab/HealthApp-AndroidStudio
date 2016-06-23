package com.app.ludus.healer;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.Toast;

import com.app.ludus.healer.dao.DAOTratamento;
import com.app.ludus.healer.model.ModelTratamento;

import java.io.Console;
import java.util.Date;

public class TratamentoActivity extends AppCompatActivity {

    private DatePicker dataInicial;
    private DatePicker dataFinal;

    private ModelTratamento modelTratamento;
    private DAOTratamento daoTratamento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tratamento);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        daoTratamento = new DAOTratamento(TratamentoActivity.this);
        modelTratamento = daoTratamento.getTratamentoById(1);


        dataInicial =(DatePicker) findViewById(R.id.tratamento_dtp_inicial);
        String a = dataInicial.toString();
        //dataFinal = findViewById(R.id.tratamento_dtp_final);

        //Preencher view
        //dataInicial.setDate();
        //dataFinal.setDate();

        //Salvar datas de inicio e fim

        //Button btnInicial =(Button) findViewById(R.id.tratamento_btn_inicial);
        //btnInicial.setOnClickListener(new View.OnClickListener()
        //{
       //     @Override
       //     public void onClick(View v)
    //        {
      //          modelTratamento.setDataInicio(dataInicial.toString());

      //          daoTratamento.updateTratamento(modelTratamento);

        //        Toast.makeText(getApplicationContext(), "Salvo", Toast.LENGTH_SHORT).show();
      //      }
     //   });
    }

}
