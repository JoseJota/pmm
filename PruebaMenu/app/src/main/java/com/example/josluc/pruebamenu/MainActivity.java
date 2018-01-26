package com.example.josluc.pruebamenu;

import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import static com.example.josluc.pruebamenu.R.id.lblMensaje;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
//Alternativa 1
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;

    public boolean onOptionsItemSelected(MenuItem item) {
        TextView lblMensaje = (TextView) findViewById(R.id.lblMensaje);
        switch (item.getItemId()) {
            case R.id.MnuOpc1:
                lblMensaje.setText("Uno!");
                return true;
            case R.id.MnuOpc2:
                lblMensaje.setText("Dos!");
                return true;
            case R.id.MnuOpc3:
                lblMensaje.setText("Submenu!");

            case R.id.SubMnuOpc1:
                lblMensaje.setText("Submenu: Opcion 1!");

                return true;
            case R.id.SubMnuOpc2:
                lblMensaje.setText ("Submenu: Opcion 2!");
                return true;
            case R.id.MnuOpc4:
                lblMensaje.setText("Cuatro!");

            default:
                return super.onOptionsItemSelected(item);
        }}

}
