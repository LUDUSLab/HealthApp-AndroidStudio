package com.app.ludus.healer.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.app.ludus.healer.AdapterListView;
import com.app.ludus.healer.R;
import com.app.ludus.healer.TratamentoFase;
import com.app.ludus.healer.dao.DAOTratamento;
import com.app.ludus.healer.model.ModelTratamento;

import java.io.Console;
import java.util.ArrayList;
import java.util.Date;

public class TratamentoActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private FloatingActionButton fab;
    private ListView lstvFases;
    private ArrayList<TratamentoFase> fases;
    private AdapterListView adapterListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tratamento);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        fases = new ArrayList<>();//TODO: query para pegar todas as fases do tratamento

        fab = (FloatingActionButton)findViewById(R.id.tratamento_cst_fab);
        lstvFases = (ListView) findViewById(R.id.tratamento_lstv_fases);

        lstvFases.setOnItemClickListener(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fases.add(new TratamentoFase("Novo tratamento",R.mipmap.botao_add_medicamento));
                adapterListView = new AdapterListView(getApplicationContext(),fases);
                lstvFases.setAdapter(adapterListView);
                startActivity(new Intent(getApplicationContext(),MedicamentoActivity.class));
            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }
}
