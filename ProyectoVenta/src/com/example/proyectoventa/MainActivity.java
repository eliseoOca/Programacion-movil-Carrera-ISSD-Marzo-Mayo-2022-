package com.example.proyectoventa;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	EditText e1,e2; //e1: nombre e2: cantidad
	TextView t1;    // resultado
	
	RadioButton r1,r2,r3;
	CheckBox ch1,ch2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        e1 = (EditText) findViewById(R.id.editText1);
        e2 = (EditText) findViewById(R.id.editText2);
        
        t1 = (TextView) findViewById(R.id.textView7);
        
        r1 = (RadioButton) findViewById(R.id.radio0);
        r2 = (RadioButton) findViewById(R.id.radio1);
        r3 = (RadioButton) findViewById(R.id.radio2);
        
        ch1 = (CheckBox) findViewById(R.id.checkBox1);
        ch2 = (CheckBox) findViewById(R.id.checkBox2);
        
        
        
    }
    
    
    public void importe(View v){
    	
    	String nombre = e1.getText().toString();
    	String dato = e2.getText().toString();
    	int cantidad = Integer.parseInt(dato);
    	
    	float precio = 0;
    	
    	if(r1.isChecked())precio = 300;
    	else
    		if(r2.isChecked())precio = 150;
        	else
        		precio = 100;
    	
    	
    	if(ch1.isChecked())	precio = precio +300;//el en chequeck va sin else
    	if(ch2.isChecked())	precio = precio +500;
    	
    	float total = precio * cantidad;
    	
    	t1.setText("u$d " + total);
    
    	
    }
    
    
    public void factura(View v){
    	
    	Intent i = new Intent(this,Factura.class );//esto es para importar el segundo activity 
    	String nombre= e1.getText().toString();
    	String micro = "";
    	//aca tomo todos los datos para llevar al segundo activity
    	if (r1.isChecked()) micro = "Intel";
    	else
    		if (r2.isChecked()) micro = "Atlon";
        	else
        		if (r3.isChecked()) micro = "Pentium";
            	
    	String precio = t1.getText().toString();
    	
    	i.putExtra("nom", nombre);
    	i.putExtra("micro", micro);
    	i.putExtra("importe", precio);
    	
    	
    	startActivity(i);
    	
    }
   
}
