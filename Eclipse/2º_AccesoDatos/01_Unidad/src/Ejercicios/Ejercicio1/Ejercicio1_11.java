package Ejercicios.Ejercicio1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Ejercicio1_11 {
	public static void main(String[] args) {
		//Ejercicio 11 : Realizar un programa Java que permita escribir en un fichero de texto una serie de
		//				 cadenas solicitadas al usuario. El programa termina al introducir *.
		
		try {
			File fich = new File("fichero.txt");
			FileWriter fichModificar = new FileWriter(fich);
			BufferedWriter bw = new BufferedWriter(fichModificar);
			String texto = "";
			
			do {
				texto = JOptionPane.showInputDialog("Que quieres escribir en el fichero? \n(Para dejar de escribir introduce *)");
				if (!texto.equalsIgnoreCase("*")) {	
					bw.write(texto);
					bw.newLine();
				}
			} while(!texto.equalsIgnoreCase("*"));
			
			bw.append("----FIN----\n");
			bw.flush();
			bw.close();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
