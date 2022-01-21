package Ejercicios.Ejercicio1;

import java.io.File;

public class Ejercicio1_2 {
	public static void main(String[] args) {
		//Ejercicio2 : Comprobar si existe el fichero ‘fichero.txt’ dando la ruta completa en la que encuentra.
		File fichero1 = new File("D:\\Workspace-AD\\01_Unidad\\fichero.txt");
		if (fichero1.exists()) {
			System.out.println("Existe el fichero \"fichero.txt\"");
		} else {
			System.out.println("No existe el fichero \"fichero.txt\"");
		}
	}
}
