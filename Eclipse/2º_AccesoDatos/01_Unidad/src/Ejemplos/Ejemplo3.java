package Ejemplos;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import javax.swing.JOptionPane;

public class Ejemplo3 {
	public static void main(String[] args) {
		try {
			//Escritura
			FileOutputStream fOut =new FileOutputStream("Ejemplo.txt");
			OutputStreamWriter fichW = new OutputStreamWriter(fOut);
			String cadena = "";
			
			do {
				cadena = JOptionPane.showInputDialog("Introduce una cadena: ");
				fichW.write(cadena + " ");
			}while(!cadena.equalsIgnoreCase("*"));
			
			fichW.append("\r\n---FIN---");
			
			fichW.close();
			
			//Lectura
			FileInputStream fileIn = new FileInputStream("Ejemplo.txt");
			InputStreamReader fichI = new InputStreamReader(fileIn);
			
			int n;
			String cadena1 = "";
			
			while((n= fichI.read()) != -1) {
				cadena1 += (char) n;	
			}
			
			System.out.println(cadena1);
			fichI.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
