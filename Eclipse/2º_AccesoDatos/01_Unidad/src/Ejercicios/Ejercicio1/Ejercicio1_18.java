package Ejercicios.Ejercicio1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Ejercicio1_18 {
	public static void main(String[] args) {
		//Ejercicio 18 : Realizar un programa Java que escriba 10 filas de caracteres en un fichero de
		//				texto (línea 1, …, línea 10), y a continuación efectuar la lectura de dicho fichero
		//				línea a línea. Después de escribir cada fila se debe efectuar un salto de línea.
		
		try {	
			File fich = new File("fichero.txt");
			FileWriter fichModificar = new FileWriter(fich);
			BufferedWriter bw = new BufferedWriter(fichModificar);
			
			for (int i = 1; i <= 10; i++) {
				bw.write("Línea " + i);
				bw.newLine();
				bw.flush();
			}
			
			bw.close();
			
			FileReader fr = new FileReader(fich);
			BufferedReader br = new BufferedReader(fr);
			String linea;
			
			while((linea = br.readLine()) != null) {
				System.out.println(linea);
			}
			
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
