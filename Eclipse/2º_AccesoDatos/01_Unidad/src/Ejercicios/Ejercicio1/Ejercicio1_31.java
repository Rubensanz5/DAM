package Ejercicios.Ejercicio1;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Ejercicio1_31 {

	public static void main(String[] args) {
		try {
			File fichero = new File("Ejer27.txt");
			RandomAccessFile fileR = new RandomAccessFile(fichero, "rw");
			
			int edad = 58;
			
			int posicion = (12-1) * 52;
			
			fileR.seek(posicion + 44);
			
			fileR.writeInt(edad);
			
			fileR.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
