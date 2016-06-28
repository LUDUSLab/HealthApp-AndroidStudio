package com.app.ludus.healer;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

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

        cstOpcoes.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), cstOpcoes, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                MenuOpcao opcao = opcoes.get(position);
                switch (opcao.getOpcao()){
                    case "Tratamento":
                        startActivity(new Intent(getApplicationContext(),TratamentoActivity.class));
                        break;
                    case "Paciente":
                        startActivity(new Intent(getApplicationContext(),PacienteActivity.class));
                        break;
                    case "Responsável":
                        Toast.makeText(getApplicationContext(),"Falta criar essa activity",Toast.LENGTH_SHORT).show();
                        break;
                    case "Histórico":
                        Toast.makeText(getApplicationContext(),"Falta criar essa activity",Toast.LENGTH_SHORT).show();
                        break;
                    case "Sobre":
                        Toast.makeText(getApplicationContext(),"Falta criar essa activity",Toast.LENGTH_SHORT).show();
                        break;
                }
                //finish();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public interface ClickListener{
        void onClick(View view, int position);
        void onLongClick(View view,int position);
    }
    public static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener
    {
        private GestureDetector gestureDetector;
        private ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final ClickListener clickListener)
        {
            this.clickListener = clickListener;
            gestureDetector = new GestureDetector(context, new GestureDetector.OnGestureListener() {
                @Override
                public boolean onDown(MotionEvent motionEvent) {
                    return false;
                }

                @Override
                public void onShowPress(MotionEvent motionEvent) {

                }

                @Override
                public boolean onSingleTapUp(MotionEvent motionEvent) {
                    return true;
                }

                @Override
                public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
                    return false;
                }

                @Override
                public void onLongPress(MotionEvent motionEvent) {
                    View child = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
                    if (child != null && clickListener != null) {
                        clickListener.onLongClick(child, recyclerView.getChildPosition(child));
                    }
                }

                @Override
                public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
                    return false;
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
                clickListener.onClick(child, rv.getChildPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {

        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }
}