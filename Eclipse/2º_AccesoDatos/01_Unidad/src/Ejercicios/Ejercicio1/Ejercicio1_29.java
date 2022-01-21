package Ejercicios.Ejercicio1;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Ejercicio1_29 {
public static void main(String[] args) {
		
		try {
			File fichero = new File("Ejer27.txt");
			RandomAccessFile fileR = new RandomAccessFile(fichero, "r");
			
			int id, edad, nMatricula;
			char[] nombre = new char[10];
			char[] apellido = new char[10];
			
			int posicion = (2-1) * 52;
			
			if(posicion >= fileR.length()) {
				System.err.println("No existe el alumno buscado");
			} else {
				//posicionamiento del puntero
				fileR.seek(posicion);
				
				//leer id
				id = fileR.readInt();
				
				//leer nombre
				for (int i = 0; i < nombre.length; i++) { 
					nombre[i] = fileR.readChar();
				}
				//convertir el array de char a String
				String nombres = new String(nombre);
				
				//leer apellido
				for (int i = 0; i < apellido.length; i++) { 
					apellido[i] = fileR.readChar();
				}
				//convertir el array de char a String
				String apellidos = new String(apellido);
				
				//leer edad
				edad = fileR.readInt();
				
				//leer nºmatricula
				nMatricula = fileR.readInt();
				
				System.out.println("ID " + id + " Nombre: " + nombres + ", Apellido: " + apellidos + " Edad " + edad +", Nº matricula: " + nMatricula + "\n");

				posicion = posicion + 52;
			}
			fileR.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
