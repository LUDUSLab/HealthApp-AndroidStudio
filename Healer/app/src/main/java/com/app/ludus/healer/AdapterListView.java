package com.app.ludus.healer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.app.ludus.healer.R;
import com.app.ludus.healer.TratamentoFase;

import java.util.ArrayList;

/**
 * Created by mps.ads on 29/06/2016.
 */
public class AdapterListView extends BaseAdapter {

    private LayoutInflater layoutInflater;
    private ArrayList<TratamentoFase> itens;

    public AdapterListView(Context context,ArrayList<TratamentoFase> itens){
        this.itens = itens;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return itens.size();
    }

    @Override
    public Object getItem(int i) {
        return itens.get(i);
    }

    @Override
    public long getItemId(int i) {
        return itens.get(i).getResourceId();
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        TratamentoFase fase = itens.get(i);
        view = layoutInflater.inflate(R.layout.component_list_tratamento,null);
        ((TextView)view.findViewById(R.id.tratamento_txv_nome_fase)).setText(fase.getNomeFase());
        ((ImageButton)view.findViewById(R.id.tratamento_ibtn_add_medicamento)).setImageResource(fase.getResourceId());
        ((ImageButton)view.findViewById(R.id.tratamento_ibtn_add_medicamento)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),"Adcionei remedio na fase "+String.valueOf(i),Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
