package com.apkdoandroid.versiculodedeus.helper;


import com.apkdoandroid.versiculodedeus.model.Versiculo;

import java.util.List;

public interface DaoVersiculo {

    public Boolean salvar (Versiculo versiculo);
    public Boolean atualizar (Versiculo versiculo);
    public  Boolean deletar (Versiculo versiculo);
    public List<Versiculo> listar ();
    public List<Versiculo> listarfavorito ();
    public List<Versiculo> listarAmizade ();
    public List<Versiculo> listarAmor ();
    public List<Versiculo> listarAniversario ();
    public List<Versiculo> listarBomDia ();
    public List<Versiculo> listarCasamento ();
    public List<Versiculo> listarEncorajamento ();
    public List<Versiculo> listarMotivação ();
    public List<Versiculo> listarFe ();
    public List<Versiculo> listarMulher ();
    public List<Versiculo> listarOracao ();
    public List<Versiculo> listarPalavrasdeConforto ();



}
