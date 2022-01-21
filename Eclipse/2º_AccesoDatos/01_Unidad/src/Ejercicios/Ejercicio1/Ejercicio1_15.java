package Ejercicios.Ejercicio1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class Ejercicio1_15 {
	public static void main(String[] args) {
		//Ejercicio 15 : Realizar un programa Java que permita leer un fichero de texto línea por línea y visualizar cada línea por pantalla.
		
		try {
			File ficheroLeer = new File("fichero.txt");
			FileReader fich = new FileReader(ficheroLeer);
			BufferedReader bf = new BufferedReader(fich);
			String texto = "";
		
			do {	
				texto = bf.readLine();			
				if (texto != null) {
					System.out.println(texto);
				}
			} while(texto != null);
			
			bf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
