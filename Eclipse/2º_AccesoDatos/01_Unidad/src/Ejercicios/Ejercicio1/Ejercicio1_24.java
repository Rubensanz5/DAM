package Ejercicios.Ejercicio1;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ejercicio1_24 {
	public static void main(String[] args) {
		//Ejercicio 24 : Insertar datos de cinco alumnos en un fichero binario. Los datos deben tomarse de
		//			     cuatro arrays: nombre, apellidos, edad y número de matrícula. 		
		
		String [] nombres = {"Juan", "Pedro", "Maria"};
		String [] apellidos = {"Sanchez", "fernandez", "Garcia"};
		int [] edad = {23, 43, 16};
		int [] nMatricula = {56465465,4564654,546465};
		
		try {
			File fich = new File("fich01.txt");
			FileOutputStream fileOut = new FileOutputStream(fich);
			DataOutputStream dataOut = new DataOutputStream(fileOut);

			for (int i = 0; i < nombres.length; i++) {
				dataOut.writeUTF(nombres[i]);
				dataOut.writeUTF(apellidos[i]);
				dataOut.writeInt(edad[i]);
				dataOut.writeInt(nMatricula[i]);
			}
			
			
			dataOut.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
