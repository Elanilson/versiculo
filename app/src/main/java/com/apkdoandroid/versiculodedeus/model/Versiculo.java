package com.apkdoandroid.versiculodedeus.model;

public class Versiculo {
    private Long id;
    private  String texto;
    private  String autor;
    private  int favorito;
    private  String categoria;

    public Versiculo() {
    }

    public Versiculo(Long id, String texto, String autor, int favorito) {
        this.id = id;
        this.texto = texto;
        this.autor = autor;
        this.favorito = favorito;
    }

    public Versiculo(String texto, String autor) {
        this.texto = texto;
        this.autor = autor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getFavorito() {
        return favorito;
    }

    public void setFavorito(int favorito) {
        this.favorito = favorito;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
