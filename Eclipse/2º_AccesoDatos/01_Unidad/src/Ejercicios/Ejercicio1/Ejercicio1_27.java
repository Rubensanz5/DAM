package Ejercicios.Ejercicio1;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Ejercicio1_27 {
	public static void main(String[] args) {
		try {
			File fichero = new File("ficheros//Ejer27.txt");
			RandomAccessFile fileR = new RandomAccessFile(fichero, "rw");
			
			String [] nombres = {"Juan", "Pedro", "Maria"};
			String [] apellidos = {"Sanchez", "fernandez", "Garcia"};
			int [] edad = {23, 43, 16};
			int [] nMatricula = {56465465,4564654,546465};
			
			for (int i = 0; i < nombres.length; i++) {
				//ID del alumno
				fileR.writeInt(i+1);
				
				
				//apellidos
				//buffer xa almacenar el apellidos
				StringBuffer buffer_a = new StringBuffer(apellidos[i]);
				//nº de caracteres xa apellidos
				buffer_a.setLength(10);
				//Insertamos el apellidos
				fileR.writeChars(buffer_a.toString());
				
				//edad 
				fileR.writeInt(edad[i]);
				//nº matricula
				fileR.writeInt(nMatricula[i]);
				
			}
			
			fileR.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
