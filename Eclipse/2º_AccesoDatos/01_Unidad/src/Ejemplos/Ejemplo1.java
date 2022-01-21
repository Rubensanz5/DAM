package Ejemplos;

import java.io.File;
import java.io.IOException;

public class Ejemplo1 {

	public static void main(String[] args) {
		File fichero = new File("C:\\acceso_datos\\ejemplo1.txt");
		try {
			if (fichero.createNewFile()) {
				System.out.println("el fichero se ha creado correctamente");
			} else {
				System.err.println("No se ha creado");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String directorio = "C:\\acceso_datos";
		@SuppressWarnings("unused")
		File fichero1 = new File(directorio, "ejemplo1.txt");
		
	}

}
