package com.example.conversor.monedas;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
	
	// CAMPOS /////////////////////////////////////////////////////
	EditText dollars;
	EditText euros;
	EditText cambio;
    RadioButton dtoe;
    RadioButton etod;
	Button convert;
	// FIN CAMPOS //////////////////////////////////////////////////
	
	/** Al inicar la actividad ... */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_main);
        
        // INICIALIZACIÓN DE CAMPOS //////////////////////////////////////////////
        dollars = (EditText)this.findViewById(R.id.edtDolares);
        euros = (EditText)this.findViewById(R.id.edtEuros);
        cambio = (EditText)this.findViewById(R.id.etCambio);
        
        dtoe = (RadioButton)this.findViewById(R.id.rbDolarAeuro);
        dtoe.setChecked(true);
        etod = (RadioButton)this.findViewById(R.id.rbEuroAdolar);
        
        convert = (Button)this.findViewById(R.id.btnConvertir);
        // FIN INICIALIZACIÓN DE CAMPOS ////////////////////////////////////////////////
        
        
        // EVENTOS ///////////////////////////////////////////
        convert.setOnClickListener(this);
        dtoe.setOnClickListener(this);
        etod.setOnClickListener(this);
        // FIN EVENTOS ///////////////////////////////////////
        
    }
    
    /**
     * Convierte los euros a dólares o
     * los dólares a euros
     */
	public void onClick(View v) {
		
		// Controla el radioButtons chequeado
		if (v == convert){
			if (dtoe.isChecked()) {
				convertDollarsToEuros();
			}
			if (etod.isChecked()) {
				convertEurosToDollars();
			}
		}
		
		// Controla que no estén dos radioButtons chequeados
		if (v == dtoe){
			etod.setChecked(false);
		}
		
		if (v == etod){
			dtoe.setChecked(false);
		}
		
	}
	
	/**
	 * Convierte los dólares a euros
	 */
	protected void convertDollarsToEuros() {
		
		double val;
		double tmp;
		
		// Controla los campos introducidos
		if ("".equals(dollars.getText().toString())){
			val = 0;
		}
		else{
			val = Double.parseDouble(dollars.getText().toString());
		}
		
		if ("".equals(cambio.getText().toString())){
			tmp = 0;
		}
		else{
			tmp = Double.parseDouble(cambio.getText().toString());
		}
		
		// Convierte el cambio a euros
		euros.setText(Double.toString(val* tmp));
	}
	
	/**
	 * Convierte los euros a dólares
	 */
	protected void convertEurosToDollars() {
		
		double val;
		double tmp;
		
		// Controla los campos introducidos
		if ("".equals(euros.getText().toString())){
			val = 0;
		}
		else{
			val = Double.parseDouble(euros.getText().toString());
		}
		
		if ("".equals(cambio.getText().toString())){
			tmp = 0;
		}
		else{
			tmp = Double.parseDouble(cambio.getText().toString());
		}
		
		
		// Convierte los cambios a dólares
		dollars.setText(Double.toString(val/tmp));
	}
}

