package Ejercicios.Ejercicio1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Ejercicio1_16 {
	public static void main(String[] args) {
		//Ejercicio 16 : Escribir caracteres en un fichero de texto (si no existe lo crea). Los caracteres se escriben uno a uno y se obtienen de un String.
		
		try {	
			File fich = new File("fichero.txt");
			if (!fich.exists()) {
				fich.createNewFile();
			}
			FileWriter fichModificar = new FileWriter(fich);
			BufferedWriter bw = new BufferedWriter(fichModificar);
			
			String texto = "Esta es la cadena que vamos a escribir con el FileWriter*";
			for (int i = 0; i < texto.length(); i++) {
				  bw.write(texto.charAt(i));
				  bw.flush();
			}
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
