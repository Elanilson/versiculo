package com.apkdoandroid.versiculodedeus.helper;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Banco_BD extends SQLiteOpenHelper {
    public static int VERSION =1;
    public static String NOME_BD = "biblia_bd";
    public static String TABELA = "versiculo";
    private Context context;
//    public static String
//    public static String

    public Banco_BD(Context context) {
        super(context,NOME_BD , null, VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        try{
            String sql = "CREATE TABLE IF NOT EXISTS "+Banco_BD.TABELA+" ( id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                    "autor VARCHAR(50), texto TEXT,categoria VARCHAR(50), data_hora DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP, favorito INTEGER NOT NULL DEFAULT 0);";
            String sqlInset1 =  Sql.conteudo1();
            String sqlInset2 =  Sql.conteudo2();
            String sqlInset3 =  Sql.conteudo3();
//            String sqlInset4 =  Sql.carregarFrases4();
//            String sqlInset5 =  Sql.carregarFrases5();
//            String sqlInset6 =  Sql.carregarFrases6();
//            String sqlInset7 =  Sql.carregarFrases7();
//            String sqlInset8 =  Sql.carregarFrases8();

            db.execSQL(sql);
            db.execSQL(sqlInset1);
            db.execSQL(sqlInset2);
            db.execSQL(sqlInset3);
//            db.execSQL(sqlInset4);
//            db.execSQL(sqlInset5);
//            db.execSQL(sqlInset6);
//            db.execSQL(sqlInset7);
//            db.execSQL(sqlInset8);

            Log.i("INFO DB", "Sucesso ao criar TABELA" );
        }catch (SQLException e){
            e.printStackTrace();
            Log.i("INFO DB", "Erro ao criar TABELA" +e.getMessage());
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }




}
