package com.app.ludus.healer.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.app.ludus.healer.R;
import com.app.ludus.healer.dao.DAOMedicamento;
import com.app.ludus.healer.model.ModelMedicamento;

import java.util.List;

public class DailyActivity extends AppCompatActivity
{
    private ImageButton btn1,btn2,btn3,btnConfirma,btnMenu;
    private boolean tomou1,tomou2,tomou3;
    private TextView txvNome;
    private DAOMedicamento daoMedicamento;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        daoMedicamento = new DAOMedicamento(getApplicationContext());

        setContentView(R.layout.activity_daily);
        tomou1=tomou2=tomou3=false;

        List<ModelMedicamento> lista = daoMedicamento.getListMedicamentoByTratamento(0);

        btn1 = (ImageButton)findViewById(R.id.daily_btn_med1);
        btn2 = (ImageButton)findViewById(R.id.daily_btn_med2);
        btn3 = (ImageButton)findViewById(R.id.daily_btn_med3);
        btnConfirma = (ImageButton)findViewById(R.id.daily_ibtn_confirma);
        btnMenu = (ImageButton)findViewById(R.id.daily_ibtn_menu);
        txvNome = (TextView)findViewById(R.id.daily_txv_nome_medicamento);
        //if(!lista.isEmpty())
          //  txvNome.setText(lista.get(0).getNomeMedicamento());

        Toolbar toolbar = (Toolbar) findViewById(R.id.daily_cst_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);

        btn1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(!tomou1)
                    btn1.setImageResource(R.drawable.pilula_verde_);
                else
                    btn1.setImageResource(R.drawable.pilula_cinza_);
                tomou1 = !tomou1;

            }
        });

        btn2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(!tomou2)
                    btn2.setImageResource(R.drawable.pilula_verde_);
                else
                    btn2.setImageResource(R.drawable.pilula_cinza_);
                tomou2 = !tomou2;

            }
        });

        btn3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                if(!tomou3)
                    btn3.setImageResource(R.drawable.pilula_verde_);
                else
                    btn3.setImageResource(R.drawable.pilula_cinza_);
                tomou3 = !tomou3;

            }
        });

        btnConfirma.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String mensagem = "";
                if(tomou1&&tomou2&&tomou3)
                {
                   mensagem = "Todos os medicamentos foram tomados";
                    startActivity(new Intent(getApplicationContext(),MenuActivity.class));
                    finish();
                }
                else
                    mensagem = "Faltam alguns medicamentos a serem tomados";
                Toast.makeText(getApplicationContext(),mensagem,Toast.LENGTH_LONG).show();

            }
        });

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),MenuActivity.class));
            }
        });
    }

}
