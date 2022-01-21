package Ejercicios.Ejercicio1;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class Ejercicio1_25 {
	public static void main(String[] args) {
		//Ejercicio 25 : Visualizar los datos grabados anteriormente en el fichero. Se deben recuperar en
		//  			 el mismo orden en el que fueron insertados, es decir, nombre, apellidos, edad y
		//				 número de matrícula. 	
		
		String [] nombres = new String[3];
		String [] apellidos = new String[3];
		int [] edad = new int[3];
		int [] nMatricula = new int[3];
		
		try {
			File fich = new File("fich01.txt");
			FileInputStream fileIn = new FileInputStream(fich);
			DataInputStream dataIn = new DataInputStream(fileIn);

			for (int i = 0; i < nombres.length; i++) {
				nombres[i] = dataIn.readUTF();
				apellidos[i] = dataIn.readUTF();
				edad[i] = dataIn.readInt();
				nMatricula[i] = dataIn.readInt();
				
				System.out.println("Nombre: " + nombres[i] + ", Apellido: " + apellidos[i] + ", Nº matricula: " + nMatricula[i] + "\n");
			}
			
			
			
			dataIn.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
