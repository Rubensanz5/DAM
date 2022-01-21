package Ejercicios.Ejercicio1;

import java.io.File;

public class Ejercicio1_3 {
	public static void main(String[] args) {
		//Ejercicio 3 : Mostrar la lista de ficheros existentes en el directorio actual.
		File directorio = new File("D:\\Workspace-AD\\01_Unidad");
		String[] directorios = directorio.list();
		for (int i = 0; i < directorios.length; i++) {
			System.out.println(directorios[i]);
		}
	}
}
