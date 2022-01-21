package Ejercicios.Ejercicio1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Ejercicio1_23 {
	public static void main(String[] args) {
		//Ejercicio 23 : Escribir bytes en un fichero (de 1 a 100) y después visualizar los mismos.
		
		try {
			FileOutputStream fileOut = new FileOutputStream("Fichero2.txt");
			OutputStreamWriter fichO = new OutputStreamWriter(fileOut);
			
			for (int i = 0; i <= 100; i++) {
				fichO.write(i);
				//fichI.write(i + " ");
			}
			
			fichO.close();
			
			FileInputStream fileIn = new FileInputStream("Fichero2.txt");
			InputStreamReader fichI = new InputStreamReader(fileIn);
			
			int n;
			String cadena = "";
			
			while((n= fichI.read()) != -1) {
				cadena += (char) n;	
			}
			
			System.out.println(cadena);
			
			fichI.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
