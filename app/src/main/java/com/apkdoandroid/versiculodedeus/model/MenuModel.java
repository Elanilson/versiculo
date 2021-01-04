package com.apkdoandroid.versiculodedeus.model;

public class MenuModel {
    private int imagem;
    private String titulo;

    public MenuModel() {
    }

    public MenuModel(int imagem, String titulo) {
        this.imagem = imagem;
        this.titulo = titulo;
    }


    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
