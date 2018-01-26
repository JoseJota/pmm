package com.example.josluc.listapersona2;

/**
 * Created by josluc on 20/10/17.
 */

public class Titular
{
    private String titulo;
    private String subtitulo;
    private int foto;

    public Titular(String tit, String sub, int im){
        titulo = tit;
        subtitulo = sub;
        foto = im;
    }

    public String getTitulo(){
        return titulo;
    }

    public String getSubtitulo(){
        return subtitulo;
    }
    public int getFoto(){
        return foto;
    }
}