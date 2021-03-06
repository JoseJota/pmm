package com.example.josluc.tortillas;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Resultados extends ListActivity {

    //acciones
    public static final int NEW_ITEM = 1;
    public static final int EDIT_ITEM = 2;

    String[] columnaspedidos = new String[]{"extras", "tortilla", "cantidad", "precio", "envio", "id_food"};

    int id;

    //elemento seleccionado
    private int mLastRowSelected = 0;
    public static DataBaseHelper mDbHelper = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);
        Bundle bundle = getIntent().getExtras();

        id = (int) bundle.getSerializable("id");

        try {
            fillData();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error");
        }
        registerForContextMenu(getListView());

    }


    private void fillData() {
        //Abre base de datos y se obtienen lops elementos

        DataBaseHelper dataBaseHelper = new DataBaseHelper(this, "DBTortilla", null, 1);
        SQLiteDatabase sqLiteDatabase = dataBaseHelper.getWritableDatabase();

        Cursor itemCursor = sqLiteDatabase.query("pedidos", columnaspedidos, null, null, null, null, null);
        InfoPedidos item = null;

        ArrayList<InfoPedidos> resultList = new ArrayList<>();

        while (itemCursor.moveToNext()) {
            float precioget = itemCursor.getFloat(itemCursor.getColumnIndex("precio"));
            String extrasget = itemCursor.getString(itemCursor.getColumnIndex("extras"));
            String envioget = itemCursor.getString(itemCursor.getColumnIndex("envio"));
            String tortillaget = itemCursor.getString(itemCursor.getColumnIndex("tortilla"));
            int cantidadget = itemCursor.getInt(itemCursor.getColumnIndex("cantidad"));
            int ids = itemCursor.getInt(itemCursor.getColumnIndex("id_food"));

            item = new InfoPedidos();

            item.id = ids;
            item.extas = extrasget;
            item.envio = envioget;
            item.precio = precioget;
            item.cantidad = cantidadget;
            item.tortilla = tortillaget;
            resultList.add(item);
        }
        //cerramos la base de datos
        itemCursor.close();
        sqLiteDatabase.close();
        //generar el adaptador
        TaskAdapter items = new TaskAdapter(this, R.layout.row_list, resultList, getLayoutInflater());
        //asignar adaptador a la lista
        setListAdapter(items);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo delW = (AdapterView.AdapterContextMenuInfo) item
                .getMenuInfo();
        mLastRowSelected = delW.position;

                //nueva actividad con el identificador como parámetro
                Intent i = new Intent(this, MainActivity.class);
                i.putExtra("id_food", ((Pedido) getListAdapter().getItem(mLastRowSelected)).getId_food());
                startActivityForResult(i, EDIT_ITEM);
                return true;

        }


    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == EDIT_ITEM || requestCode == NEW_ITEM) {
            if (resultCode == Activity.RESULT_OK) {
                try {
                    fillData();
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("Error");
                }
            }
        }
    }

    private class TaskAdapter extends ArrayAdapter<InfoPedidos> {
        private LayoutInflater mInflater;
        private List<InfoPedidos> mObjects;

        private TaskAdapter(Context context, int resource, List<InfoPedidos> objects, LayoutInflater mInflater) {
            super(context, resource, objects);
            this.mInflater = mInflater;
            this.mObjects = objects;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            InfoPedidos listEntry = mObjects.get(position);

            View row = mInflater.inflate(R.layout.row_list, null);

            TextView extras = (TextView) row.findViewById(R.id.row_extras);
            TextView envios = (TextView) row.findViewById(R.id.row_envio);
            TextView tortilla = (TextView) row.findViewById(R.id.row_tortilla);
            TextView precio = (TextView) row.findViewById(R.id.row_precio);
            TextView cantidad = (TextView) row.findViewById(R.id.row_cantidad);
            TextView cliente = (TextView) row.findViewById(R.id.clienteName);

            extras.setText(listEntry.extas);
            envios.setText(listEntry.envio);
            tortilla.setText(listEntry.tortilla);
            precio.setText(Float.toString(listEntry.precio));
            cantidad.setText(Integer.toString(listEntry.cantidad));
            cliente.setText(listEntry.client);

            return row;
        }
    }

    private class InfoPedidos {
        int id;
        String extas;
        String envio;
        int cantidad;
        String tortilla;
        float precio;
        String client;
    }
}

