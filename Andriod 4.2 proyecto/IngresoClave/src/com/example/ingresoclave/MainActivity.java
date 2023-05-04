package com.example.ingresoclave;





import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;
import android.view.Gravity;

public class MainActivity extends Activity {
	
	private EditText et2;
	private TextView tv3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		et2=(EditText)findViewById(R.id.et2);
		tv3=(TextView)findViewById(R.id.tv3);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	

	
	
	public void verificar(View view){
		//String m1="Solo se puede ingresar 10 caracteres";
		//String m2="No hay ningun mensaje";
		String valor2=et2.getText().toString();
		String valor1=tv3.getText().toString();
		int length=et2.length();
		
		if(et2.length() > 0 && et2.length() <= 10)
		{//Toast toast1=Toast.makeText(this, "¡Correcto!",Toast.LENGTH_LONG);
		//toast1.setGravity(Gravity.CENTER, 0, 0);
		//toast1.show();
			tv3.setText("¡Correcto!");
		
			
		}
		if(et2.length() == 0)
		{//Toast toast1=Toast.makeText(this, "¡Ingresa una clave!",Toast.LENGTH_LONG);
		//toast1.setGravity(Gravity.CENTER, 0, 0);
		//toast1.show();
			tv3.setText("¡Ingresa una clave!");
		}
		if(et2.length() > 10)
		{//Toast toast1=Toast.makeText(this, "¡La clave no puede tener mas de 10 caracteres!",Toast.LENGTH_LONG);
		//toast1.setGravity(Gravity.CENTER, 0, 0);
		//toast1.show();
			tv3.setText("¡La clave no puede tener mas de 10 caracteres!");
		}
		
		
	}

}
