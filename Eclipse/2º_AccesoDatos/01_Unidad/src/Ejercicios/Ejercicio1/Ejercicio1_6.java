package Ejercicios.Ejercicio1;

import java.io.File;

public class Ejercicio1_6 {
	public static void main(String[] args) {
		//Ejercicio 6 : Crear el directorio ‘UT1’ y en su interior el directorio ‘Ejercicios’.
		File directorioUT1 = new File(".\\UT1\\Ejercicios");
		if (!directorioUT1.exists()) {
			directorioUT1.mkdirs();
		}
	}
}
