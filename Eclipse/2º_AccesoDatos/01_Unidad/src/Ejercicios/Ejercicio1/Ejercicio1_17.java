package Ejercicios.Ejercicio1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio1_17 {
	public static void main(String[] args) {
		//Ejercicio 17 : Escribir las provincias de Castilla y León en un fichero de texto. El nombre de las
		//				provincias se debe obtener de un array de String y se irán grabando una a
		//				continuación de la otra sin saltos de línea.
		
		try {	
			File fich = new File("fichero.txt");
			FileWriter fichModificar = new FileWriter(fich);
			BufferedWriter bw = new BufferedWriter(fichModificar);
			String[] provincias = {"Ávila", "Burgos", "León", "Palencia", "Salamanca", "Segovia", "Soria", "Salamanca", "Valladolid", "Zamora"};
			
			for (int i = 0; i < provincias.length; i++) {
				if(provincias[i] != null) {
					bw.write(provincias[i] + "-");
					bw.flush();
				}	
			}
			
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
