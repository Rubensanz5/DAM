package Ejercicios.Ejercicio1;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Ejercicio1_30 {
	public static void main(String[] args) {
		try {
			File fichero = new File("Ejer27.txt");
			RandomAccessFile fileR = new RandomAccessFile(fichero, "rw");
			
			String nombre = "Ruben";
			String apellido = "Sanz";
			int edad = 23;
			int nMatricula = 65442145;
			
			int posicion = (12-1) * 52;
			
			fileR.seek(posicion);
			//ID del alumno
			fileR.writeInt(12);
			
			//Nombre
			//buffer xa almacenar el nombre
			StringBuffer buffer_n = new StringBuffer(nombre);
			//nº de caracteres xa nombre
			buffer_n.setLength(10);
			//Insertamos el nombre
			fileR.writeChars(buffer_n.toString());
			
			//apellidos
			//buffer xa almacenar el apellidos
			StringBuffer buffer_a = new StringBuffer(apellido);
			//nº de caracteres xa apellidos
			buffer_a.setLength(10);
			//Insertamos el apellidos
			fileR.writeChars(buffer_a.toString());
			
			//edad 
			fileR.writeInt(edad);
			//nº matricula
			fileR.writeInt(nMatricula);
			
			
			
			fileR.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
