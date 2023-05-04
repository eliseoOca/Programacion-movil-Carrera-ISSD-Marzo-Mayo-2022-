package com.example.proyectoparcial;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class Administrador extends SQLiteOpenHelper {

	public Administrador(Context context, String nombre, CursorFactory factory, int version) {
		super(context, nombre, factory, version);
		
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		
		db.execSQL("create table ventas (codigo integer primary key, nombre text, genero text, precio float)");
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		
		
	}

}
