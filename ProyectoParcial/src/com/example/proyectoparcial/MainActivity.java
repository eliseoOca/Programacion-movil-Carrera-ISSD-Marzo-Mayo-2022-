package com.example.proyectoparcial;

import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	EditText e1, e2, e3, e4;
	CheckBox ch1;
	RadioButton r1, r2;
	Button b1, b2, b3;
	TextView t5;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		e1 = (EditText) findViewById(R.id.et1);
		e2 = (EditText) findViewById(R.id.et2);
		e3 = (EditText) findViewById(R.id.et3);
		e4 = (EditText) findViewById(R.id.et4);

		ch1 = (CheckBox) findViewById(R.id.cb1);

		r1 = (RadioButton) findViewById(R.id.rb1);
		r2 = (RadioButton) findViewById(R.id.rb2);

		b1 = (Button) findViewById(R.id.b1);
		b2 = (Button) findViewById(R.id.b2);
		b3 = (Button) findViewById(R.id.b3);

		t5 = (TextView) findViewById(R.id.tv5);

	}

	public void altas(View v) {

		Administrador a = new Administrador(this, "ventas", null, 1);
		SQLiteDatabase db = a.getWritableDatabase();

		String codigo = e1.getText().toString();
		String nombre = e2.getText().toString();
		String genero = e3.getText().toString();
		String precio = e4.getText().toString();

		ContentValues registro = new ContentValues();

		registro.put("codigo", codigo);
		registro.put("nombre", nombre);
		registro.put("genero", genero);
		registro.put("precio", precio);

		db.insert("ventas", null, registro);

		Toast.makeText(this, "El producto se grabó correctamente",
				Toast.LENGTH_LONG).show();

		e1.setText("");
		e2.setText("");
		e3.setText("");
		e4.setText("");

		db.close();

	}

	public void consultas(View v) {
		Administrador a = new Administrador(this, "ventas", null, 1);
		SQLiteDatabase db = a.getWritableDatabase();

		String lx = e2.getText().toString();

		String sql = "Select codigo, nombre, genero, precio from ventas where nombre='"
				+ lx + "'";
		Cursor fila = db.rawQuery(sql, null);

		if (fila.moveToFirst()) {
			e1.setText(fila.getString(0));
			e2.setText(fila.getString(1));
			e3.setText(fila.getString(2));
			e4.setText(fila.getString(3));
			

		} else {
			Toast t1 = Toast.makeText(this, "No se encontró la consulta registrada " + lx,
					Toast.LENGTH_LONG);

			t1.setGravity(Gravity.CENTER, 0, 0);

			t1.show();
			e1.setText("");
		}
		db.close();

	}

	public void importes(View v) {

		String nombre = e2.getText().toString();
		String precio = e4.getText().toString();
		float pre = Float.parseFloat(precio);
		
		if(e2.getText().length() == 0 ){
    		
		    Toast toast1=Toast.makeText(this, "Rellenar los campos obligatorios, para que la factura se imprima correctamente",Toast.LENGTH_LONG);
		    		toast1.show();}
		if(e3.getText().length() == 0 ){
    		
		    Toast toast2=Toast.makeText(this, "Rellenar los campos obligatorios, para que la factura se imprima correctamente",Toast.LENGTH_LONG);
		    		toast2.show();}
		

		
		
		float pagar=100;
		
	    if (r1.isChecked()) {
			pre = pre -(pre * 0.10f);
			t5.setText("$ " + pre);
		}else 
			if (r2.isChecked()) {
			pre =pre + ( pre * 0.20f);
			t5.setText("$ " + pre );
        }
        	
	    if (ch1.isChecked()) {
			pre = pre + pagar;
		}
	    
	    

		t5.setText("$ " + pre);
		
		String total = t5.getText().toString();
		
		Intent i = new Intent(this, Factura.class);

		i.putExtra("nombre", nombre);
		i.putExtra("precio", total);

		startActivity(i);

	}

}
