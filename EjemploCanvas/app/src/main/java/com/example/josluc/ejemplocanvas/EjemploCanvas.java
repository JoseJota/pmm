package com.example.josluc.ejemplocanvas;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class EjemploCanvas extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new EjemploView(this));
    }

    public class EjemploView extends View {
        public EjemploView(Context contexto) {
            super(contexto);
        }
        @Override
        protected void onDraw(Canvas canvas) {

            setBackgroundResource(R.drawable.degradado);

            Paint pincel = new Paint();

            pincel.setStrokeWidth(50);

            canvas.drawLine(600,300,950,100,pincel);
            canvas.drawLine(100,100,500,300,pincel);

            Resources res = this.getResources();
            BitmapDrawable miImagen;
            miImagen = (BitmapDrawable) res.getDrawable(R.drawable.nariz);
            miImagen.setBounds(new Rect(180,500,720,1100));

            miImagen.draw(canvas);

            pincel.setStyle(Paint.Style.FILL_AND_STROKE);
            pincel.setColor(Color.BLACK);
            pincel.setStrokeWidth(10);
            canvas.drawCircle(250,500,250,pincel);
            pincel.setColor(Color.WHITE);
            canvas.drawCircle(250,500,200,pincel);
            pincel.setColor(Color.argb(255,139,69,19));
            canvas.drawCircle(250,500,150,pincel);
            pincel.setColor(Color.BLACK);
            canvas.drawCircle(250,500,30,pincel);

            pincel.setColor(Color.BLACK);
            pincel.setStrokeWidth(10);
            canvas.drawCircle(850,500,250,pincel);
            pincel.setColor(Color.WHITE);
            canvas.drawCircle(850,500,200,pincel);
            pincel.setColor(Color.argb(255,139,69,19));
            canvas.drawCircle(850,500,150,pincel);
            pincel.setColor(Color.BLACK);
            canvas.drawCircle(850,500,30,pincel);



        }



        }
    }

