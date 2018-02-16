package com.example.josluc.tortillas;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase sqLiteDatabase,sqLiteDatabasepedido ;
    private Spinner spinnerVariedad;
    Context context = this;
    private  Tortillas[] variedad;
    String[] columnaspedidos = new String[]{"extras","tortilla","cantidad","precio","envio"};
    String[] columnas = new String[] {"id","nombre","ingredientes","precio"};
    int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("Haz tu pedido");

        final Button botonpasar = findViewById(R.id.button);
        final RadioButton r1 = findViewById(R.id.rb1);
        final RadioButton r2 = findViewById(R.id.rb2);
        final CheckBox ch1 = findViewById(R.id.cb1);
        final CheckBox ch2 = findViewById(R.id.cb2);
        final CheckBox ch3 = findViewById(R.id.cb3);
        final EditText tvpizza = findViewById(R.id.editText);
        spinnerVariedad = findViewById(R.id.spinner);


        DataBaseHelper variedadHelper = new DataBaseHelper(this,"DBTortilla",null,1);

        sqLiteDatabase = variedadHelper.getWritableDatabase();






        Cursor cursor = sqLiteDatabase.query("variedad", columnas,null,null,null,null,null);

        variedad = new Tortillas[cursor.getCount()];

        int i = 0;
        int a = cursor.getCount();

        System.out.println(a);


        if (cursor.moveToFirst()){
            do {
                int id = cursor.getInt(0);
                String nombre = cursor.getString(1);
                String ingredientes = cursor.getString(2);
                float precio = cursor.getFloat(3);

                variedad[i] = new Tortillas(precio,nombre,ingredientes,id);

                i++;
            }while(cursor.moveToNext());
        }


        VariedadArrayAdapter variedadArrayAdapter = new VariedadArrayAdapter(this,variedad);
        spinnerVariedad.setAdapter(variedadArrayAdapter);


        spinnerVariedad.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView arg0, View arg1, int position, long id) {
                String result ="NOMBRE:"+variedad[position].getNombre()+
                        "\nPrecio"+ Float.toString(variedad[position].getPrecio());
                Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });



        //Boton final para pasar
        botonpasar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String cantida = tvpizza.getText().toString();
                float canti = Float.parseFloat(cantida);
                int pos = spinnerVariedad.getSelectedItemPosition();
                int catida = (int)canti;

                int cont =0;
                float cantidad = variedad[pos].getPrecio()*canti;
                float a= añadido(cantidad);
                float b = envio(a);
                float total = b;

                int resultado = (int) total;
                String tipoeenvio = envios();
                String tipoExtra = tipoExtra();

                String tortilla  = variedad[pos].getNombre();
                int id = variedad[pos].getId();
                Bundle mibundle = getIntent().getExtras();

                sqLiteDatabase.execSQL("INSERT INTO pedidos (id_food,extras,tortilla,cantidad,precio,envio) " +
                        "VALUES ( '"+id+"',' " +tipoExtra+"',' "+ tortilla +  "','" +catida +
                        "',' " +resultado+"','"+ tipoeenvio+"') ");

                Intent miIntent = new Intent(MainActivity.this, Resultados.class);

                Bundle bundle = new Bundle();
                bundle.putInt("id",id);
                miIntent.putExtras(bundle);
                startActivity(miIntent);

            }

            public float añadido(float cont) {
                if (ch1.isChecked() && contador % 2 != 0)
                    cont++;
                if (ch2.isChecked() && contador % 2 != 0)
                    cont++;
                if (ch3.isChecked() && contador % 2 != 0)
                    cont++;
                else
                    cont++;

                return cont;
            }

            public float envio(float precio) {
                float total = 0;
                if (r2.isChecked() && contador % 2 != 0){
                    total = (float) (precio + precio * 0.1);
                    return total;}
                else
                    contador++;

                return precio;

            }

            public float cantidad(float numero, float precio) {
                float total = numero * precio;
                return total;
            }

            public String envios() {
                String x = "";
                if (r1.isChecked() && contador % 2 != 0) {
                    x = "En local";
                    contador++;
                } else if (r2.isChecked() && contador %2 == 0) {
                    x = "A domicilio";
                    contador++;
                }else
                    contador++;
                return x;

            }
            String extra = " ";

            public String tipoExtra() {
                if (ch1.isChecked() ) {
                    extra = extra + "Ketchup ";

                }
                if (ch2.isChecked()) {
                    extra = extra + "Mayonesa ";

                }
                if (ch3.isChecked() ) {
                    extra = extra + "Alioli ";

                }else {

                }

                return extra;
            }
        });
    }
    private void showMessage(int message){
        Context context = getApplicationContext();
        CharSequence text = getResources().getString(message);
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.AcercaDe:
                Intent one = new Intent(MainActivity.this, AcercaDe.class);
                startActivity(one);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}