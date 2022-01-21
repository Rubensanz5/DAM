package Ejercicios.Ejercicio1;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class Ejercicio1_13 {
	public static void main(String[] args) {
		//Ejercicio 13 : Realizar un programa Java que permita leer de un fichero cada uno de los caracteres y visualizarlo por pantalla.
		
		try {
			File ficheroLeer = new File("fichero.txt");
			FileReader fich = new FileReader(ficheroLeer);
			int texto = 0;
			String textoEntero = "";
			
			do {
				texto = fich.read();
				if (texto != -1) {
					char caract = (char) texto ;
					textoEntero += caract;
					System.out.println("Caracter leido: " + caract);
				}
			} while(texto != -1);
			
			fich.close();
			
			System.out.println("CADENA LEIDA: " + textoEntero);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
