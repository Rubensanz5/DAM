package Ejercicios.Ejercicio1;

import java.io.FileOutputStream;
import java.io.IOException;

public class Ejercicio1_20 {
	public static void main(String[] args)   {
		//Ejercicio 20 : Escribir el abecedario en un fichero de datos de bytes.
		
		try {
			FileOutputStream fOut =new FileOutputStream("Fichero2.txt");
			
			for (char i = 'A'; i <= 'Z'; i++) {
				fOut.write(i);	
			}
			
			fOut.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
