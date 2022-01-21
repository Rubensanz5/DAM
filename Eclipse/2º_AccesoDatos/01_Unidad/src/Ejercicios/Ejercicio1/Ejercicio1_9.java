package Ejercicios.Ejercicio1;

import java.io.IOException;
import java.io.StringReader;

public class Ejercicio1_9 {
	public static void main(String[] args) {
		//Ejercicio 9 : A partir de la cadena de texto ‘En un lugar de la Mancha de cuyo…’, realizar un programa Java que muestre dicha cadena carácter a carácter.
		
		String texto = "En un lugar de la Mancha de cuyo";
		for (int i = 0; i < texto.length(); i++) {
			System.out.println("Cadena escrita: " + texto.charAt(i));
		}
		
		//Otra forma
		
		try {
			
			StringReader sr = new StringReader(texto);
			//StringWriter sw = new StringWriter();
			
			int i = 0;
			int c = 0;
			char[] cadena = new char[texto.length()];
		
			while ((c = sr.read()) != -1) {
				//Se añade el caracter leido a la cadena
				//sw.write(c);
				cadena[i] = (char) c;
				i++;
			}
			
			for (int j = 0; j < cadena.length; j++) {
				System.out.println("Cadena Escrita: " + cadena[j]);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
