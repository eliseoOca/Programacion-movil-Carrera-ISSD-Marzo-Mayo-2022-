package com.example.pruebatoast;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	public void mensaje2(View v){
		Toast toast1=Toast.makeText(this, "Toast en una determinada ubicacion",Toast.LENGTH_LONG);
		toast1.setGravity(Gravity.CENTER, 0, 0);
		toast1.show();
	}
	
	public void mensaje1(View v){
		Toast toast1=Toast.makeText(this, "Toast basico", Toast.LENGTH_SHORT);
		toast1.show();
	}

}
