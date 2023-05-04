package com.example.recuerdonumero;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private EditText et1;
	private int num;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		et1=(EditText)findViewById(R.id.et1);
		
		num=(int)(Math.random()*100001);
		String cadena=String.valueOf(num);
		Toast notificacion=Toast.makeText(this,"El numero aleatorio es: " + num, Toast.LENGTH_LONG);
		notificacion.show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	public void verificar(View view){
		
		String valorIngresado=et1.getText().toString();
		int valor=Integer.parseInt(valorIngresado);
		
		if(valor==num){
			Toast notificacion=Toast.makeText(this,"Muy bien recordaste el numero mostrado: " + num, Toast.LENGTH_LONG);
			notificacion.show();
		}
		else{
			Toast notificacion=Toast.makeText(this, "Incorrecto el numero era: " + num + " " + "y tu ingresaste : " + valor , Toast.LENGTH_LONG);
			notificacion.show();
		}
		
	}

}
