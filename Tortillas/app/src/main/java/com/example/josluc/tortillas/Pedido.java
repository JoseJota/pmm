package com.example.josluc.tortillas;

import java.io.Serializable;


public class Pedido implements Serializable{

    private int cantidad ;
    private String sandwich,envio,extras;
    private float precio;
    private int id_food;


    public Pedido(float pre,String ext,int cant,String sand,String envi){

        this.extras = ext;
        this.cantidad = cant;
        this.sandwich = sand;
        this.envio = envi;
        this.precio = pre;

    }

    public int getId_food() {
        return id_food;
    }

    public float getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getExtras() {
        return extras;
    }

    public String getEnvio() {
        return envio;
    }

    public String getSandwich() {
        return sandwich;
    }
}
