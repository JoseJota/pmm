package com.example.josluc.holamundo;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by josluc on 19/09/17.
 */

public class Pantalla2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);

        final TextView otroSaludo = (TextView) findViewById(R.id.saludo2);
        Bundle recogerBundle = getIntent().getExtras();
        otroSaludo.setText(recogerBundle.getString("TEXTO"));

    }

    protected void showToast(CharSequence text){
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}