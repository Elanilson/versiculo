package com.apkdoandroid.versiculodedeus.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.apkdoandroid.versiculodedeus.model.Versiculo;

import java.util.ArrayList;
import java.util.List;


public class VersiculoDao implements DaoVersiculo {

    private SQLiteDatabase escrever;
    private SQLiteDatabase ler;
    private Context context;

    public VersiculoDao(Context context){
    Banco_BD db = new Banco_BD(context);
    escrever = db.getWritableDatabase();
    ler = db.getReadableDatabase();
    this.context = context;

    }


    @Override
    public Boolean salvar(Versiculo versiculo) {
        return null;
    }

    @Override
    public Boolean atualizar(Versiculo versiculo) {
        ContentValues cv = new ContentValues();
        cv.put("autor",versiculo.getAutor());
        cv.put("texto",versiculo.getTexto());
        cv.put("categoria",versiculo.getCategoria());
        cv.put("favorito",versiculo.getFavorito());

        try {
            String [] args ={versiculo.getId().toString()};
            escrever.update(Banco_BD.TABELA,cv,"id=?",args);
            Log.i("INFO", "Dados Atualizado com sucesso!");
        }catch (Exception e){
            e.printStackTrace();
            Log.e("INFO", "Erro ao Atualizar Dados " + e.getMessage() );
            return false;
        }
        return true;
    }

    @Override
    public Boolean deletar(Versiculo versiculo) {
        return null;
    }

    @Override
    public List<Versiculo> listar() {
        return null;
    }

    @Override
    public List<Versiculo> listarAmizade() {
        List<Versiculo> versiculos = new ArrayList<>();
        String sql = " Select * from " +Banco_BD.TABELA+" where categoria ='Amizade';";
        Cursor c = ler.rawQuery(sql,null);

        while (c.moveToNext()){
            Versiculo versiculo = new Versiculo();
            Long id = c.getLong(c.getColumnIndex("id"));
            String autor = c.getString(c.getColumnIndex("autor"));
            String texto = c.getString(c.getColumnIndex("texto"));
            String categoria = c.getString(c.getColumnIndex("categoria"));
            String data = c.getString(c.getColumnIndex("data_hora"));
            int favorito = c.getInt(c.getColumnIndex("favorito"));
            versiculo.setId(id);
            versiculo.setAutor(autor);
            versiculo.setTexto(texto);
            versiculo.setFavorito(favorito);
            versiculo.setCategoria(categoria);
            versiculos.add(versiculo);
        }
        Log.i("INFO DB:", "LISTANDO Amizade" );


        return versiculos;
    }

    @Override
    public List<Versiculo> listarAmor() {
        List<Versiculo> versiculos = new ArrayList<>();
        String sql = " Select * from " +Banco_BD.TABELA+" where categoria ='Amor';";
        Cursor c = ler.rawQuery(sql,null);

        while (c.moveToNext()){
            Versiculo versiculo = new Versiculo();
            Long id = c.getLong(c.getColumnIndex("id"));
            String autor = c.getString(c.getColumnIndex("autor"));
            String texto = c.getString(c.getColumnIndex("texto"));
            String categoria = c.getString(c.getColumnIndex("categoria"));
            String data = c.getString(c.getColumnIndex("data_hora"));
            int favorito = c.getInt(c.getColumnIndex("favorito"));
            versiculo.setId(id);
            versiculo.setAutor(autor);
            versiculo.setTexto(texto);
            versiculo.setFavorito(favorito);
            versiculo.setCategoria(categoria);
            versiculos.add(versiculo);
        }
        Log.i("INFO DB:", "LISTANDO amor" );


        return versiculos;
    }

    @Override
    public List<Versiculo> listarAniversario() {
        List<Versiculo> versiculos = new ArrayList<>();
        String sql = " Select * from " +Banco_BD.TABELA+" where categoria ='Aniversário';";
        Cursor c = ler.rawQuery(sql,null);

        while (c.moveToNext()){
            Versiculo versiculo = new Versiculo();
            Long id = c.getLong(c.getColumnIndex("id"));
            String autor = c.getString(c.getColumnIndex("autor"));
            String texto = c.getString(c.getColumnIndex("texto"));
            String categoria = c.getString(c.getColumnIndex("categoria"));
            String data = c.getString(c.getColumnIndex("data_hora"));
            int favorito = c.getInt(c.getColumnIndex("favorito"));
            versiculo.setId(id);
            versiculo.setAutor(autor);
            versiculo.setTexto(texto);
            versiculo.setFavorito(favorito);
            versiculo.setCategoria(categoria);
            versiculos.add(versiculo);
        }
        Log.i("INFO DB:", "LISTANDO Aniversário" );


        return versiculos;
    }

    @Override
    public List<Versiculo> listarBomDia() {
        List<Versiculo> versiculos = new ArrayList<>();
        String sql = " Select * from " +Banco_BD.TABELA+" where categoria ='Bom Dia';";
        Cursor c = ler.rawQuery(sql,null);

        while (c.moveToNext()){
            Versiculo versiculo = new Versiculo();
            Long id = c.getLong(c.getColumnIndex("id"));
            String autor = c.getString(c.getColumnIndex("autor"));
            String texto = c.getString(c.getColumnIndex("texto"));
            String categoria = c.getString(c.getColumnIndex("categoria"));
            String data = c.getString(c.getColumnIndex("data_hora"));
            int favorito = c.getInt(c.getColumnIndex("favorito"));
            versiculo.setId(id);
            versiculo.setAutor(autor);
            versiculo.setTexto(texto);
            versiculo.setFavorito(favorito);
            versiculo.setCategoria(categoria);
            versiculos.add(versiculo);
        }
        Log.i("INFO DB:", "LISTANDO Bom Dia" );


        return versiculos;
    }

    @Override
    public List<Versiculo> listarCasamento() {
        List<Versiculo> versiculos = new ArrayList<>();
        String sql = " Select * from " +Banco_BD.TABELA+" where categoria ='Casamento';";
        Cursor c = ler.rawQuery(sql,null);

        while (c.moveToNext()){
            Versiculo versiculo = new Versiculo();
            Long id = c.getLong(c.getColumnIndex("id"));
            String autor = c.getString(c.getColumnIndex("autor"));
            String texto = c.getString(c.getColumnIndex("texto"));
            String categoria = c.getString(c.getColumnIndex("categoria"));
            String data = c.getString(c.getColumnIndex("data_hora"));
            int favorito = c.getInt(c.getColumnIndex("favorito"));
            versiculo.setId(id);
            versiculo.setAutor(autor);
            versiculo.setTexto(texto);
            versiculo.setFavorito(favorito);
            versiculo.setCategoria(categoria);
            versiculos.add(versiculo);
        }
        Log.i("INFO DB:", "LISTANDO Casamento" );


        return versiculos;
    }

    @Override
    public List<Versiculo> listarEncorajamento() {
        List<Versiculo> versiculos = new ArrayList<>();
        String sql = " Select * from " +Banco_BD.TABELA+" where categoria ='Encorajamento';";
        Cursor c = ler.rawQuery(sql,null);

        while (c.moveToNext()){
            Versiculo versiculo = new Versiculo();
            Long id = c.getLong(c.getColumnIndex("id"));
            String autor = c.getString(c.getColumnIndex("autor"));
            String texto = c.getString(c.getColumnIndex("texto"));
            String categoria = c.getString(c.getColumnIndex("categoria"));
            String data = c.getString(c.getColumnIndex("data_hora"));
            int favorito = c.getInt(c.getColumnIndex("favorito"));
            versiculo.setId(id);
            versiculo.setAutor(autor);
            versiculo.setTexto(texto);
            versiculo.setFavorito(favorito);
            versiculo.setCategoria(categoria);
            versiculos.add(versiculo);
        }
        Log.i("INFO DB:", "LISTANDO Encorajamento" );


        return versiculos;
    }

    @Override
    public List<Versiculo> listarMotivação() {
        List<Versiculo> versiculos = new ArrayList<>();
        String sql = " Select * from " +Banco_BD.TABELA+" where categoria ='Motivação';";
        Cursor c = ler.rawQuery(sql,null);

        while (c.moveToNext()){
            Versiculo versiculo = new Versiculo();
            Long id = c.getLong(c.getColumnIndex("id"));
            String autor = c.getString(c.getColumnIndex("autor"));
            String texto = c.getString(c.getColumnIndex("texto"));
            String categoria = c.getString(c.getColumnIndex("categoria"));
            String data = c.getString(c.getColumnIndex("data_hora"));
            int favorito = c.getInt(c.getColumnIndex("favorito"));
            versiculo.setId(id);
            versiculo.setAutor(autor);
            versiculo.setTexto(texto);
            versiculo.setFavorito(favorito);
            versiculo.setCategoria(categoria);
            versiculos.add(versiculo);
        }
        Log.i("INFO DB:", "LISTANDO Motivação" );


        return versiculos;
    }

    @Override
    public List<Versiculo> listarFe() {
        List<Versiculo> versiculos = new ArrayList<>();
        String sql = " Select * from " +Banco_BD.TABELA+" where categoria ='Fé';";
        Cursor c = ler.rawQuery(sql,null);

        while (c.moveToNext()){
            Versiculo versiculo = new Versiculo();
            Long id = c.getLong(c.getColumnIndex("id"));
            String autor = c.getString(c.getColumnIndex("autor"));
            String texto = c.getString(c.getColumnIndex("texto"));
            String categoria = c.getString(c.getColumnIndex("categoria"));
            String data = c.getString(c.getColumnIndex("data_hora"));
            int favorito = c.getInt(c.getColumnIndex("favorito"));
            versiculo.setId(id);
            versiculo.setAutor(autor);
            versiculo.setTexto(texto);
            versiculo.setFavorito(favorito);
            versiculo.setCategoria(categoria);
            versiculos.add(versiculo);
        }
        Log.i("INFO DB:", "LISTANDO Fé" );


        return versiculos;
    }

    @Override
    public List<Versiculo> listarMulher() {
        List<Versiculo> versiculos = new ArrayList<>();
        String sql = " Select * from " +Banco_BD.TABELA+" where categoria ='Mulher';";
        Cursor c = ler.rawQuery(sql,null);

        while (c.moveToNext()){
            Versiculo versiculo = new Versiculo();
            Long id = c.getLong(c.getColumnIndex("id"));
            String autor = c.getString(c.getColumnIndex("autor"));
            String texto = c.getString(c.getColumnIndex("texto"));
            String categoria = c.getString(c.getColumnIndex("categoria"));
            String data = c.getString(c.getColumnIndex("data_hora"));
            int favorito = c.getInt(c.getColumnIndex("favorito"));
            versiculo.setId(id);
            versiculo.setAutor(autor);
            versiculo.setTexto(texto);
            versiculo.setFavorito(favorito);
            versiculo.setCategoria(categoria);
            versiculos.add(versiculo);
        }
        Log.i("INFO DB:", "LISTANDO Mulher" );


        return versiculos;
    }

    @Override
    public List<Versiculo>listarOracao() {
        List<Versiculo> versiculos = new ArrayList<>();
        String sql = " Select * from " +Banco_BD.TABELA+" where categoria ='Oração';";
        Cursor c = ler.rawQuery(sql,null);

        while (c.moveToNext()){
            Versiculo versiculo = new Versiculo();
            Long id = c.getLong(c.getColumnIndex("id"));
            String autor = c.getString(c.getColumnIndex("autor"));
            String texto = c.getString(c.getColumnIndex("texto"));
            String categoria = c.getString(c.getColumnIndex("categoria"));
            String data = c.getString(c.getColumnIndex("data_hora"));
            int favorito = c.getInt(c.getColumnIndex("favorito"));
            versiculo.setId(id);
            versiculo.setAutor(autor);
            versiculo.setTexto(texto);
            versiculo.setFavorito(favorito);
            versiculo.setCategoria(categoria);
            versiculos.add(versiculo);
        }
        Log.i("INFO DB:", "LISTANDO Oração" );


        return versiculos;
    }

    @Override
    public List<Versiculo> listarPalavrasdeConforto() {
        List<Versiculo> versiculos = new ArrayList<>();
        String sql = " Select * from " +Banco_BD.TABELA+" where categoria ='Palavras de Conforto';";
        Cursor c = ler.rawQuery(sql,null);

        while (c.moveToNext()){
            Versiculo versiculo = new Versiculo();
            Long id = c.getLong(c.getColumnIndex("id"));
            String autor = c.getString(c.getColumnIndex("autor"));
            String texto = c.getString(c.getColumnIndex("texto"));
            String categoria = c.getString(c.getColumnIndex("categoria"));
            String data = c.getString(c.getColumnIndex("data_hora"));
            int favorito = c.getInt(c.getColumnIndex("favorito"));
            versiculo.setId(id);
            versiculo.setAutor(autor);
            versiculo.setTexto(texto);
            versiculo.setFavorito(favorito);
            versiculo.setCategoria(categoria);
            versiculos.add(versiculo);
        }
        Log.i("INFO DB:", "LISTANDO Palavras de Conforto" );


        return versiculos;
    }

    @Override
    public List<Versiculo> listarfavorito() {
        List<Versiculo> versiculos = new ArrayList<>();
        String sql = " Select * from " +Banco_BD.TABELA+" where favorito = 1;";
        Cursor c = ler.rawQuery(sql,null);

        while (c.moveToNext()){
            Versiculo versiculo = new Versiculo();
            Long id = c.getLong(c.getColumnIndex("id"));
            String autor = c.getString(c.getColumnIndex("autor"));
            String texto = c.getString(c.getColumnIndex("texto"));
            String categoria = c.getString(c.getColumnIndex("categoria"));
            String data = c.getString(c.getColumnIndex("data_hora"));
            int favorito = c.getInt(c.getColumnIndex("favorito"));
            versiculo.setId(id);
            versiculo.setAutor(autor);
            versiculo.setTexto(texto);
            versiculo.setFavorito(favorito);
            versiculo.setCategoria(categoria);
            versiculos.add(versiculo);
        }
        Log.i("INFO DB:", "LISTANDO Palavras de Conforto" );


        return versiculos;
    }
}
