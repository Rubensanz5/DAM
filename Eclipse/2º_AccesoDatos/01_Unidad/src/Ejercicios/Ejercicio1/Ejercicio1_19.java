package Ejercicios.Ejercicio1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Ejercicio1_19 {
	public static void main(String[] args) {
		//Ejercicio 19 : Comprobar la codificación de un fichero ya existente.
		try {
			FileOutputStream fOut = new FileOutputStream("fichero.txt");
			OutputStreamWriter fichW = new OutputStreamWriter(fOut);
			
			System.out.println(fichW.getEncoding());
			
			fichW.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
