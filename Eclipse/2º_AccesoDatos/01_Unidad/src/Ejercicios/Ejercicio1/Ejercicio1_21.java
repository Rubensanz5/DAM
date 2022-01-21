package Ejercicios.Ejercicio1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio1_21 {
	public static void main(String[] args) {
		//Ejercicio 21 : Leer el fichero anteriormente creado.
		
		try {
			
			FileInputStream fileIn = new FileInputStream("Fichero2.txt");
			InputStreamReader fichI = new InputStreamReader(fileIn);
			
			int n;
			String cadena1 = "";
			
			while((n= fichI.read()) != -1) {
				cadena1 += (char) n;	
			}
			
			System.out.println(cadena1);
			fichI.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
