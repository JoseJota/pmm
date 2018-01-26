package com.example.josluc.mylistasimple;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView lview;
    final static String semana[] = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String mensaje;
        lview = (ListView) findViewById(R.id.listView1);
        ArrayAdapter<String> miAdaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, semana);
        lview.setAdapter(miAdaptador);

        lview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

        }
    }

    private void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }

    private class ListaInfo implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> lista, View selectedView,
                                int selectedIndex, long id) {
            String selection = lista.getItemAtPosition(selectedIndex).toString();
            showToast(selection);
        }
    }

    public void onNothingSelected(AdapterView<?> lista) {
// Won’t be invoked unless you programmatically remove entries
    }
}