package com.app.ludus.healer.activity;


import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import com.app.ludus.healer.MenuAdapter;
import com.app.ludus.healer.MenuOpcao;
import com.app.ludus.healer.R;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity
{

    private RecyclerView cstOpcoes;
    private List<MenuOpcao> opcoes = new ArrayList<>();
    private MenuAdapter menuAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        cstOpcoes = (RecyclerView)findViewById(R.id.menu_cst_opcoes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        menuAdapter = new MenuAdapter(opcoes);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        cstOpcoes.setLayoutManager(mLayoutManager);
        cstOpcoes.setItemAnimator(new DefaultItemAnimator());
        cstOpcoes.setAdapter(menuAdapter);

        preencherOpcoes();
    }

    private void preencherOpcoes() {
        opcoes.add( new MenuOpcao("Tratamento",R.mipmap.ic_launcher));
        opcoes.add(new MenuOpcao("Paciente",R.mipmap.ic_launcher));
        opcoes.add(new MenuOpcao("Responsável",R.mipmap.ic_launcher));
        opcoes.add(new MenuOpcao("Histórico",R.mipmap.ic_launcher));
        opcoes.add(new MenuOpcao("Sobre",R.mipmap.ic_launcher));


        menuAdapter.notifyDataSetChanged();
    }




}