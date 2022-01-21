package Evaluacion_03.excepciones;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
//import java.nio.Buffer;
//import java.io.File;
//import java.io.IOException;
//import java.util.Scanner;

import javax.swing.JOptionPane;

public class FicheroApp {
	public static void main(String[] args) {
		
		String ruta = JOptionPane.showInputDialog("Introduce la ruta del archivo");
		
		try {
			leerFichero(ruta);
		}catch (IOException e) {
			System.out.print("el fichero no existe");
			e.printStackTrace();
		}
		
		
		
		
		
		
		//ej2
//		Scanner entrada = new Scanner(System.in);
//		System.out.println("Comienzo Prueba excepcioenes");
//		try {
//			System.out.println("\n Introduce el dividendo");
//			int dividendo = Integer.parseInt(entrada.nextLine());
//			System.out.println("\n Introduce el divisor");
//			int divisor = Integer.parseInt(entrada.nextLine());
//			System.out.println("\n Resultado: " + dividendo/divisor);
//		} catch (ArithmeticException ex){
//			System.out.println("Imposible dividir por 0");
//		} finally {
//			entrada.close();
//			System.out.println("FIN prueba excepciones");
//		}
		
		//ej1
		
//		File fichero = new File("D:\\fichero_nuevo.txt");
//		File fichero2 = null;
//		
//		
//		try {
//			fichero.createNewFile(); 
//			fichero2.createNewFile(); 
//		} catch (IOException | NullPointerException excepcion) {
//			System.out.println("Se ha lanzado la excepcion");
//			System.out.println(excepcion.getMessage());
//			
//		} catch (NullPointerException excepcion) {
//			System.out.println("NULL!!!!");
//		}
//		
//		System.out.print("fin del programa");
//		int num = 0;
//		
//		try {
//			
//		} catch (Exception ex ) {
//			// TODO: handle exception
//		}
	
	}
	
	public static void leerFichero(String rutaFichero) throws IOException{
		File archivo = new File(rutaFichero);
		FileReader fr = new FileReader(archivo);
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(fr);
		
		String linea;
		while((linea = br.readLine()) != null) {
			System.out.println(linea);
		}
	}
	
}
