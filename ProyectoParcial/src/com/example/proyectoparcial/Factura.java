package com.example.proyectoparcial;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class Factura extends Activity {

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.factura);
		
		TextView t6, t7;
		
		t6 = (TextView) findViewById(R.id.tv6);
        t7 = (TextView) findViewById(R.id.tv7);
        
        Bundle b = getIntent().getExtras();

        t6.setText(b.getString("nombre"));
        t7.setText(b.getString("precio"));
        
        
    }
	
	public void b4(View v){
		finish();
	}
}
