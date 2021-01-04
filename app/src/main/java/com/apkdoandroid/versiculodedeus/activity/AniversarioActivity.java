package com.apkdoandroid.versiculodedeus.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.apkdoandroid.versiculodedeus.R;
import com.apkdoandroid.versiculodedeus.adapter.AdapterVersiculo;
import com.apkdoandroid.versiculodedeus.helper.VersiculoDao;
import com.apkdoandroid.versiculodedeus.model.Versiculo;

import java.util.ArrayList;
import java.util.List;

public class AniversarioActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private AdapterVersiculo adapterVersiculo;
    private List<Versiculo> versiculos = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aniversario);
        recyclerView = findViewById(R.id.recyclerViewAniversario);
        geradorversiculos();
        LinearLayoutManager layout = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layout);
        adapterVersiculo = new AdapterVersiculo(versiculos,this);
        recyclerView.setAdapter(adapterVersiculo);
    }
    private void geradorversiculos() {
        VersiculoDao dao = new VersiculoDao(this);
        for(Versiculo versiculo: dao.listarAniversario()){
            versiculos.add(versiculo);
        }
    }
}