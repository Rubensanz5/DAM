package Ejercicios.Ejercicio1;

import java.io.File;

public class Ejercicio1_1 {
	public static void main(String[] args) {
		//Ejercicio 1 : Comprobar si existe el fichero ‘fichero.txt’ en el directorio actual.
		File fichero = new File("fichero.txt");
		if (fichero.exists()) {
			System.out.println("Existe el fichero \"fichero.txt\"");
		} else {
			System.out.println("No existe el fichero \"fichero.txt\"");
		}
		
	}
}
