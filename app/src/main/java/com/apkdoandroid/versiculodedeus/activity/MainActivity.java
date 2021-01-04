package com.apkdoandroid.versiculodedeus.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.apkdoandroid.versiculodedeus.R;
import com.apkdoandroid.versiculodedeus.adapter.AdapterMenu;
import com.apkdoandroid.versiculodedeus.model.MenuModel;
import com.apkdoandroid.versiculodedeus.utils.RecyclerItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private AdapterMenu adapterMenu;
    private List<MenuModel> menus = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerviewMenu);
        geradordeMenu();
        GridLayoutManager layout = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layout);
        adapterMenu = new AdapterMenu(menus);
        recyclerView.setAdapter(adapterMenu);

        //Adicionar evento de clique
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(

                MainActivity.this, recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                //Recuperar tarefa para edicao
                switch (menus.get(position).getTitulo()){

                    case "Amizade":

                startActivity(new Intent(MainActivity.this,AmizadeActivity.class));
                        break;
                    case "Amor":

                        startActivity(new Intent(MainActivity.this,AmorActivity.class));
                        break;
                    case "Aniversário":

                        startActivity(new Intent(MainActivity.this,AniversarioActivity.class));
                        break;
                    case "Bom Dia":

                        startActivity(new Intent(MainActivity.this,BomDiaActivity.class));
                        break;
                    case "Casamento":

                        startActivity(new Intent(MainActivity.this,CasamentoActivity.class));
                        break;
                    case "Encorajamento":

                        startActivity(new Intent(MainActivity.this,EncorajamentoActivity.class));
                        break;
                    case "Fé":

                        startActivity(new Intent(MainActivity.this,FeActivity.class));
                        break;

                    case "Motivação":

                        startActivity(new Intent(MainActivity.this,MotivacaoActivity.class));
                        break;

                    case "Mulher":

                        startActivity(new Intent(MainActivity.this,MulherActivity.class));
                        break;
                    case "Oração":

                        startActivity(new Intent(MainActivity.this,OracaoActivity.class));
                        break;
                    case "Palavras de Conforto":

                        startActivity(new Intent(MainActivity.this,PalavrasdeConfortoActivity.class));
                        break;


                }

            }

            @Override
            public void onLongItemClick(View view, int position) {
                //Recuperar tarefa para edicao


            }

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        }
        ));

    }

    private void geradordeMenu() {
        MenuModel menuModel = new MenuModel(R.drawable.amizade,"Amizade");
        menus.add(menuModel);
        menuModel = new MenuModel(R.drawable.amor,"Amor");
        menus.add(menuModel);
        menuModel = new MenuModel(R.drawable.aniversario,"Aniversário");
        menus.add(menuModel);
        menuModel = new MenuModel(R.drawable.bomdia,"Bom Dia");
        menus.add(menuModel);
        menuModel = new MenuModel(R.drawable.casamento,"Casamento");
        menus.add(menuModel);
        menuModel = new MenuModel(R.drawable.encorajamento,"Encorajamento");
        menus.add(menuModel);
        menuModel = new MenuModel(R.drawable.fe,"Fé");
        menus.add(menuModel);
        menuModel = new MenuModel(R.drawable.motivacao,"Motivação");
        menus.add(menuModel);
        menuModel = new MenuModel(R.drawable.mulheres,"Mulher");
        menus.add(menuModel);
        menuModel = new MenuModel(R.drawable.oracao,"Oração");
        menus.add(menuModel);
        menuModel = new MenuModel(R.drawable.carinhoso,"Palavras de Conforto");
        menus.add(menuModel);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.meun_favoritos:
                startActivity(new Intent(MainActivity.this,FavoritooActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}