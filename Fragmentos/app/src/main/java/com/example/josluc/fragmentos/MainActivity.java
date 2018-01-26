package com.example.josluc.fragmentos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class MainActivity extends AppCompatActivity {
CheckBox aparece;
    View mioFrag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mioFrag= (View) findViewByid(R.id.ejemplo);

        aparece= (CheckBox) findViewById(R.id.ch1);

        aparece.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener() {
            if (aparece.isChecked() mioFrag.setVisibility(View.VISIBLE);
            else mioFrag.setVisibility(View.VISIBLE);
                )
        }

        );
    }
}