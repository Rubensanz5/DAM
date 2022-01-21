package Ejercicios.Ejercicio1;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class Ejercicio1_14 {
	public static void main(String[] args) {
		//Ejercicio 14 : Realizar un programa Java que permita leer de un fichero de 20 en 20 caracteres y visualizarles por pantalla.
		
		try {
			File ficheroLeer = new File("fichero.txt");
			FileReader fich = new FileReader(ficheroLeer);
			int texto = 0;
			
			
			while(texto != -1) {
				String textoEntero = "";
				for (int i = 0; i < 20; i++) {
					texto = fich.read();
					textoEntero += (char) texto;
				}
				System.out.println(textoEntero);
			}
			
			fich.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
