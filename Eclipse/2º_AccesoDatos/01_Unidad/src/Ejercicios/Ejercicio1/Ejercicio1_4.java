package Ejercicios.Ejercicio1;

import java.io.File;
import java.sql.Date;

public class Ejercicio1_4 {
	public static void main(String[] args) {
		//Ejercicio 4 : Obtener la última fecha de modificación del fichero ‘fichero.txt’.
		File fichero = new File("fichero.txt");
		Date fecha = new Date(fichero.lastModified());
		System.out.println(fecha);
	}
}
