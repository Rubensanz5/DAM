package Ejercicios.Ejercicio1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Ejercicio1_22 {
	public static void main(String[] args) {
		//Ejercicio 22 : Realizar un programa Java que permita leer de un fichero de bytes y escribir en otro su contenido.		
		
		try {
			//Lectura
			FileInputStream fileIn = new FileInputStream("Fichero2.txt");
			InputStreamReader fichI = new InputStreamReader(fileIn);
			
			int n;
			String cadena = "";
			
			while((n= fichI.read()) != -1) {
				cadena += (char) n;	
			}
			
			fichI.close();
			
			FileOutputStream fOut =new FileOutputStream("Fichero3.txt");
			OutputStreamWriter fichW = new OutputStreamWriter(fOut);

			fichW.write(cadena);
			
			fichW.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
