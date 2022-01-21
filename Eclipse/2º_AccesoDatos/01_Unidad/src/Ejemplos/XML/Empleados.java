package Ejemplos.XML;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Empleados {
	public static void main(String[] args) {
		String[] apellidos = {"Perez Gutierrez", "Martin Almendro", "Jimenez Alvarez"};
		String[] nombres = {"Alberto", "Ana", "Rebeca"};
		String[] deptos = {"Compras", "Ventas", "Marketing"};
		double[] sueldo = {1325.514, 1548.54, 1254.35};
		
		try {
			File fich = new File(".\\ficheros\\xml\\empleados.dat");
			FileOutputStream fileO = new FileOutputStream(fich);
			DataOutputStream dataO = new DataOutputStream(fileO);
			
			//Escritura
			for (int i = 0; i < apellidos.length; i++) {
				 dataO.writeInt(i+1);
				 dataO.writeUTF(apellidos[i]);
				 dataO.writeUTF(nombres[i]);
				 dataO.writeUTF(deptos[i]);
				 dataO.writeDouble(sueldo[i]);	
			}
			
			
			dataO.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
}
