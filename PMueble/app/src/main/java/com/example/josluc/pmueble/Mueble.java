package com.example.josluc.pmueble;

import java.io.Serializable;

/**
 * Created by josluc on 28/11/17.
 */

public class Mueble implements Serializable{

    private int alto, ancho, fondo;
    private String nombre;

    public Mueble(String nombre, int alto, int ancho, int fondo) {
        this.alto = alto;
        this.ancho = ancho;
        this.nombre = nombre;
        this.fondo = fondo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getAlto() {
        return alto;
    }

    public int getAncho() {
        return ancho;
    }

    public  int getFondo() {
        return fondo;
    }
}
