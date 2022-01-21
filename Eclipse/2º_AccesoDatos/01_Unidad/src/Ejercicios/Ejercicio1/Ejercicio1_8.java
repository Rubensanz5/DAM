package Ejercicios.Ejercicio1;

import java.io.File;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Ejercicio1_8 {
	public static void main(String[] args) {
		//Ejercicio 8 : Realizar un programa Java que muestre los ficheros de un directorio. 
		//				El nombre del directorio se pasará al programa desde la línea de comandos al ejecutarlo.
		
		//con scanner
		@SuppressWarnings("resource")
		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduce el nombre del directorio: ");
		String dir = entrada.nextLine();
		System.out.println("Ficheros en el directorio " + dir);
		
		File fichero0 = new File(dir);
		File[] archivos = fichero0.listFiles();
		
		for (int i = 0; i < archivos.length; i++) {
			if(archivos[i].isFile()) {
				System.out.println(archivos[i]);
			}	
		}
		
		//Con JOptionPane
		String directorio1 = JOptionPane.showInputDialog("Introduce la ruta del directorio que quieres que se muestre");
		File dir1 = new File(directorio1);
		File[] archivos1 = dir1.listFiles();
		
		for (int i = 0; i < archivos1.length; i++) {
			if(archivos1[i].isFile()) {
				JOptionPane.showMessageDialog(null, archivos1[i]);
			}	
		}

	}
}
