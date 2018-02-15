package com.example.josluc.tortillas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by josluc on 15/02/18.
 */

public class VariedadArrayAdapter extends ArrayAdapter<Tortillas> {

        Context context;
        Tortillas[] sandwiches;
        private TextView textViewPrecio, textViewNombre,textViewIngredientes,TVid;
        ImageView imageView ;



        public VariedadArrayAdapter(Context context, Tortillas[] sandwiches) {
            super(context, R.layout.spinner_helper, sandwiches);
            this.context = context;
            this.sandwiches= sandwiches ;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = convertView;
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            if (view == null){
                view = inflater.inflate(R.layout.spinner_helper,null);
            }
            textViewPrecio = view.findViewById(R.id.Precio);
            textViewNombre =  view.findViewById(R.id.nombre);
            textViewIngredientes =  view.findViewById(R.id.ingredientes);


            imageView= view.findViewById(R.id.image);

            String cast = Float.toString(sandwiches[position].getPrecio());

            String cast2 = Integer.toString(sandwiches[position].getId());



            textViewPrecio.setText(cast);
            textViewNombre.setText(sandwiches[position].getNombre());
            textViewIngredientes.setText(sandwiches[position].getIngredientes());


            switch (sandwiches[position].getId()){
                case 1:
                    imageView.setImageResource(R.drawable.francesa);
                    break;
                case 2:
                    imageView.setImageResource(R.drawable.concebolla);
                    break;
                case 3:
                    imageView.setImageResource(R.drawable.sincebolla);
                    break;
            }

            return view;
        }

        @Override
        public View getDropDownView(int position, View convertView, ViewGroup parent) {
            return getView(position,convertView,parent);
        }


    }
