package com.example.erigom.proyectoexamen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import static com.example.erigom.proyectoexamen.R.id.editText;

public class MainActivity extends AppCompatActivity {

    Spinner miSpinner;
    final static String zonas[] = {"Zona A: Asia y Oceanía: 30 €","Zona B: América y África, 20 €","Zona C: Europa 10 €"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String mensaje;
        miSpinner = (Spinner) findViewById(R.id.spinner1);
        final EditText miTexto= (EditText) findViewById(editText);

        ArrayAdapter<String> miAdaptador = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, zonas);
        miAdaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        miSpinner.setAdapter(miAdaptador);

        Bundle miBundle = new Bundle();
        String mensajeZonas = " " + miTexto.getText();

        miBundle.putString("TEXTO", mensajeZonas);

        miSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView arg0, View arg1, int position, long id) {
                String mensaje = "La zona seleccionada es: " + zonas[position];
                showToast(mensaje);
            }
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });


        final Button botonpasar = (Button) findViewById(R.id.btnCalcular);
        botonpasar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent miIntent = new Intent(MainActivity.this, Pantalla2.class);
                Bundle miBundle = new Bundle();
                String mensajePaso = "El peso es: " + miTexto.getText();

                miBundle.putString("TEXTO", mensajePaso);
                miIntent.putExtras(miBundle);

                startActivity(miIntent);
            }
        });
    }
    public void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}