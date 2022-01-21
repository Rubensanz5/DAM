package Ejercicios.Ejercicio1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Ejercicio1_10 {
	public static void main(String[] args) {
		//Ejercicio10 : Realizar un programa Java que permita leer de un fichero de texto y escribir en otro su contenido.
	
		try {
			File ficheroLeer = new File("F:\\2º DAM\\Acceso a Datos\\UT01\\Practicas\\fichero.txt");
			File ficheroEscribir = new File("F:\\2º DAM\\Acceso a Datos\\UT01\\Practicas\\fichero2.txt");
			
			FileReader fich = new FileReader(ficheroLeer);
			BufferedReader bf = new BufferedReader(fich);
			
			int texto = 0;
			
			FileWriter fich1 = new FileWriter(ficheroEscribir);
			BufferedWriter bw = new BufferedWriter(fich1);
						
			while(texto != -1) {
				texto = bf.read();
				if(texto != -1) {
					System.out.println(texto);
					bw.write(texto);
					bw.flush();
				}
			}	
			
			bw.close();
			bf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Otra forma
		try {
			File ficheroLeer = new File("F:\\2º DAM\\Acceso a Datos\\UT01\\Practicas\\fichero.txt");
			File ficheroEscribir = new File("F:\\2º DAM\\Acceso a Datos\\UT01\\Practicas\\fichero2.txt");
		
			FileReader fich = new FileReader(ficheroLeer);
			
			BufferedReader bf = new BufferedReader(fich);
			PrintWriter pw = new PrintWriter(ficheroEscribir);
			
			String linea;
			
			while ((linea = bf.readLine()) != null) {
				pw.println(linea);
			}
			
			bf.close();
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
