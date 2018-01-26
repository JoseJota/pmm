package com.example.josluc.layout1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button botonPantalla2 = (Button) findViewById(R.id.botonPantalla2);
        final Button botonPantalla3 = (Button) findViewById(R.id.botonPantalla3);
        final Button botonPantalla4 = (Button) findViewById(R.id.botonPantalla4);

        botonPantalla2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent miIntent = new Intent(MainActivity.this, Pantalla2.class);
                startActivity(miIntent);
            }
        });
        botonPantalla3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent miIntent2 = new Intent(MainActivity.this, Pantalla3.class);
                startActivity(miIntent2);
            }
        });
    }
}
