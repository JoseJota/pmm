package com.example.josluc.controlpersonas;

import android.app.Activity;
import android.content.Intent;
import android.graphics.ColorSpace;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    ListView lstOpciones;

    private Titular[] datos = new Titular[]{
            new Titular("Titulo 1","Subtitulo largo 1",R.drawable.img1),
            new Titular("Titulo 2","Subtitulo largo 2",R.drawable.img2),
            new Titular("Titulo 3","Subtitulo largo 3",R.drawable.img3)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdaptadorTitulares adaptador = new AdaptadorTitulares(this);
        lstOpciones = (ListView)findViewById(R.id.LstOpciones);
        lstOpciones.setAdapter(adaptador);

        lstOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public  void onItemClick(AdapterView argO, View arg1, int position, long id){
                Titular titu2 = datos[position];

                Bundle bundle = new Bundle();
                bundle.putSerializable("seria",titu2);

                Intent intent = new Intent(MainActivity.this, Pantalla2.class);
                intent.putExtras(bundle);
                startActivity(intent);

                //String mensaje = "Titulo:"+datos[position].getTitulo()+".Subtitulo:"+datos[position].getSubtitulo();
                //Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_LONG).show();
            }
        });
    }
    static class ViewHolder{
        TextView titulo;
        TextView subtitulo;
        ImageView foto;
    }

    public class AdaptadorTitulares extends ArrayAdapter {
        Activity context;
        AdaptadorTitulares(Activity context){
            super(context, R.layout.listitem_titular, datos);
            this.context = context;
        }

        public View getView(int i, View convertView, ViewGroup parent){
            View item = convertView;
            ViewHolder holder;
            if(item ==null){
                LayoutInflater inflater = context.getLayoutInflater();
                item = inflater.inflate(R.layout.listitem_titular, null);
                holder = new ViewHolder();
                holder.titulo = (TextView)item.findViewById(R.id.tvTitulo);
                holder.subtitulo = (TextView)item.findViewById(R.id.tvSubtitulo);
                holder.foto = (ImageView)item.findViewById(R.id.ivImagen);
                item.setTag(holder);
            }else{
                holder = (ViewHolder)item.getTag();
            }

            holder.titulo.setText(datos[i].getTitulo());
            holder.subtitulo.setText(datos[i].getSubtitulo());
            holder.foto.setBackground(getDrawable(datos[i].getImagen()));
            return (item);
        }
    }

}