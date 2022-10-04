package com.conversion;

import java.io.IOException;
import java.text.DecimalFormat;
public class Moneda {
	
	
	public static String conversionMoneda(String moneda, String opcion){
		   
	double resultado = 0;
	double valor =  Double.valueOf(moneda);

	if (opcion == "Peso Dominicano a Dólar Estadounidense") {resultado = valor*0.01951d;}
	else if (opcion == "Peso Dominicano a Euro") {resultado = valor*0.01951d;}
	else if (opcion == "Peso Dominicano a Libra Esterlina") {resultado = valor*0.01744d;}
	else if (opcion == "Peso Dominicano a Yen") {resultado = valor*2.7183d;}
	else if (opcion == "Peso Dominicano a Rupia India") {resultado = valor*1.5324d;}
	else if (opcion == "Dólar Estadounidense a Peso Dominicano") {resultado = valor*53.14d;}
	else if (opcion == "Euro a Peso Dominicano") {resultado =valor*51.244d;}
	else if (opcion == "Libra Esterlina a Peso Dominicano") {resultado =valor*57.3494d;}
	else if (opcion == "Yen a Peso Dominicano") {resultado =valor*0.3679d;}
	else if (opcion == "Rupia India a Peso Dominicano") {resultado =valor*0.6526d;}
	

	
	 resultado = Math.round(resultado* 100)/100.0;
	 String d = "####################################";
     return new DecimalFormat("#." + d + d + d+d).format(resultado);
	


	
	
	}

}
