package com.example.proyectoventa;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class Factura extends Activity {
	
	
	TextView t1, t2, t3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_factura);
		
		
		t1 = (TextView) findViewById(R.id.textViewA);
		t2 = (TextView) findViewById(R.id.textViewB);
		t3 = (TextView) findViewById(R.id.textViewC);
		
		
		Bundle b = getIntent().getExtras();// aca es ´para levantar todo del otro formulario
		t1.setText(b.getString("nom"));
		t2.setText(b.getString("micro"));
		t3.setText(b.getString("importe"));
	}
	
	public void retornar(View v){
		finish();
	}

}
