package com.apkdoandroid.versiculodedeus.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.apkdoandroid.versiculodedeus.R;
import com.apkdoandroid.versiculodedeus.model.MenuModel;

import java.util.List;

public class AdapterMenu extends RecyclerView.Adapter<AdapterMenu.MyViewModel> {
    List<MenuModel> menus;

    public AdapterMenu(List<MenuModel> menus) {
        this.menus = menus;
    }

    @NonNull
    @Override
    public MyViewModel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View lista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_menu_principal,parent,false);
        return new MyViewModel(lista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewModel holder, int position) {
        MenuModel menu = menus.get(position);
        holder.titulo.setText(menu.getTitulo());
        holder.imagem.setImageResource(menu.getImagem());
    }

    @Override
    public int getItemCount() {
        return menus.size();
    }

    class MyViewModel extends RecyclerView.ViewHolder{
        private ImageView imagem;
        private TextView titulo;

        public MyViewModel(@NonNull View itemView) {
            super(itemView);
            imagem = itemView.findViewById(R.id.imageViewMenu);
            titulo = itemView.findViewById(R.id.textViewTituloMenu);
        }
    }
}
