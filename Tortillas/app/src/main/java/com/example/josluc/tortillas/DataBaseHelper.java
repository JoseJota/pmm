package com.example.josluc.tortillas;

/**
 * Created by josluc on 15/02/18.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {
    public DataBaseHelper(Context context,String name, SQLiteDatabase.CursorFactory factory,int version) {
        super(context, name, factory, version);		}

    @Override
    public void onCreate(SQLiteDatabase db) {
        createTables(db);

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        dropTables(db);
    }
    private void createTables(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE variedad (id INTEGER primary key,nombre TEXT, ingredientes TEXT,precio INTEGER not null)");
        db.execSQL("CREATE TABLE pedidos (id_food INTEGER primary key,extras TEXT,tortilla TEXT,cantidad INTEGER not null,precio INTEGER not null,envio TEXT)");

        db.execSQL("INSERT INTO variedad (id,nombre, ingredientes,precio) VALUES (null,'Francesa','Sin patatas','3') ");
        db.execSQL("INSERT INTO variedad (id,nombre, ingredientes,precio) VALUES (null,'Con cebolla','Patatas/Cebolla','5') ");
        db.execSQL("INSERT INTO variedad (id,nombre, ingredientes,precio) VALUES (null,'Sin cebolla','Patatas','4') ");

    }

    private void dropTables(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS variedad");
        db.execSQL("DROP TABLE IF EXISTS pedidos");

    }
}