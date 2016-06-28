package com.app.ludus.healer;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by LUDUS on 28/06/2016.
 */
public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MyViewHolder> {
    private List<MenuOpcao> opcoes;

    public MenuAdapter(List<MenuOpcao> opcoes){
        this.opcoes = opcoes;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.component_list_menu, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        MenuOpcao opcao = opcoes.get(position);
        holder.txvOpcao.setText(opcao.getOpcao());
        holder.imvIcone.setImageResource(opcao.getResourceId());
    }

    @Override
    public int getItemCount() {
        return opcoes.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView txvOpcao;
        public ImageView imvIcone;

        public MyViewHolder(View view) {
            super(view);
            txvOpcao = (TextView)view.findViewById(R.id.menu_txv_opcao);
            imvIcone = (ImageView)view.findViewById(R.id.menu_imv_icone);
        }
    }
}
