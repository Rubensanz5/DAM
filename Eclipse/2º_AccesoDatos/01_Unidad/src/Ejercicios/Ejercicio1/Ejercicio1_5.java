package Ejercicios.Ejercicio1;

import java.io.File;


public class Ejercicio1_5 {
	public static void main(String[] args) {
		/*Ejercicio 5 : Mostrar la siguiente información de un fichero de texto:
		a. Nombre del fichero.
		b. Ruta.
		c. Ruta absoluta.
		d. Nombre del directorio padre.
		e. ¿Se puede escribir?
		f. ¿Se puede leer?
		g. Tamaño.
		h. ¿Es un directorio?
		i. ¿Es un fichero? 
		*/
		
		File fichero = new File("fichero.txt");
		
		System.out.println(fichero.getName());
		System.out.println(fichero.getPath());
		System.out.println(fichero.getAbsolutePath());
		System.out.println(fichero.getParentFile());
		if (fichero.canWrite()) {
			System.out.println("Se puede escribir");
		} else {
			System.out.println("No se puede escribir");
		}
		
		if (fichero.canRead()) {
			System.out.println("Se puede Leer");
		} else {
			System.out.println("No se puede leer");
		}
		
		System.out.println(fichero.getTotalSpace());
		
		if (fichero.isDirectory()) {
			System.out.println("Es un directorio");
		} else {
			System.out.println("Es un fichero");
		}
	}
}
