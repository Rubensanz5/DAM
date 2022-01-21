package Ejercicios.Ejercicio1;

import java.io.File;
import java.io.IOException;

public class Ejercicio1_7 {
	public static void main(String[] args) {
		//Ejercicio 7 : Crear un directorio (de nombre ‘FICHEROS’) en el directorio actual, a continuación,
		//				crear dos ficheros vacíos en dicho directorio. Renombrar uno de ellos. Finalmente,
		//				borrar uno de los ficheros creados.
		
		File directorioFICHEROS = new File(".\\FICHEROS");
		if (!directorioFICHEROS.exists()) {
			directorioFICHEROS.mkdirs();
		}
		
		if (directorioFICHEROS.exists()) {
			try {
				File fich1 = new File(".\\FICHEROS\\fich1");
				File fich2 = new File(".\\FICHEROS\\fich2");
				
				fich1.createNewFile();
				fich2.createNewFile();
				fich1.renameTo(new File(".\\FICHEROS\\ficher1"));
				fich2.delete();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
