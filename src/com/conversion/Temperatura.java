package com.conversion;

import java.text.DecimalFormat;

public class Temperatura {
	
	
	public static String convertirTemp(String temp,String opcion) {
		
		double resultado=0;
		double temp_in = Double.valueOf(temp);
		
		if (opcion.equals("Celsius a Fahrenheit")) {resultado = temp_in * (9/5d) + 32d;}
		else if (opcion.equals("Celsius a Kelvin")) {resultado = temp_in + 273.15d;}
		else if (opcion.equals("Fahrenheit a Celsius")) {resultado = (temp_in - 32d) * (5/9d);}
		else if (opcion.equals("Fahrenheit a Kelvin")) {resultado = (temp_in - 32d) * (5/9d) + 273.15d;}
		else if (opcion.equals("Kelvin a Celsius")) {resultado = temp_in - 273.15d;}
		else if (opcion.equals("Kelvin a Fahrenheit")) {resultado = (temp_in - 273.15d) * (9/5d) + 32d;}
		
		resultado = Math.round(resultado*100.0d)/100.0d;
		 String d = "####################################";
	     return new DecimalFormat("#." + d + d + d+d).format(resultado);

	    
	}
		

}
