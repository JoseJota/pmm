package com.example.josluc.layout1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;

public class Pantalla3 extends AppCompatActivity {

    RadioButton rojo;
    RadioButton verde;
    RadioButton azul;
    Button cambiar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla3);
        initialUISetup();

    public void initialUISetup() {

        azul = (RadioButton) findViewById(R.id.azul);
        rojo = (RadioButton) findViewById(R.id.azul);
        verde = (RadioButton) findViewById(R.id.verde);
        cambiar = (Button) findViewById(R.id.cambiar);
    }
    class myCheckBoxChangeClicker implements CheckBox.OnCheckedChangeListener
}


    }
