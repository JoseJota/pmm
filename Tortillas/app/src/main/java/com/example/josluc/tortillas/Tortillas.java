package com.example.josluc.tortillas;

import java.io.Serializable;

/**
 * Created by josluc on 15/02/18.
 */

public class Tortillas implements Serializable {

    private String nombre;
    private float precio;
    private String ingredientes;
    int ids;

    public Tortillas(float pre, String nom, String ingr, int id) {
        ids=id;
        nombre = nom;
        precio = pre;
        ingredientes = ingr;
    }


    public String getIngredientes() {
        return ingredientes;
    }


    public float getPrecio() {
        return precio;
    }


    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return ids;
    }
}
