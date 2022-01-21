package Ejercicios.Ejercicio1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class Ejercicio1_12 {
	public static void main(String[] args) {
		//Ejercicio 12 : Leer el fichero anteriormente creado.
		
		try {
			File ficheroLeer = new File("fichero.txt");
			FileReader fich = new FileReader(ficheroLeer);
			BufferedReader bf = new BufferedReader(fich);
			String texto = "";
			
			while(texto != null) {
				texto = bf.readLine();
				if (texto != null) {
					System.out.println(texto);
				}
			}
			bf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
