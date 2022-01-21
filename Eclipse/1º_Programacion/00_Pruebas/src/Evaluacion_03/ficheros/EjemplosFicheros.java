package Evaluacion_03.ficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class EjemplosFicheros {

	public static void main(String[] args) {
		//Escribir
//		try {
//			FileWriter fichero = new FileWriter("C:\\Users\\admin\\Desktop\\fichero.txt");
//			fichero.write("Ejemplo de escritura append con buffer de flujo de caracteres\n");
//			fichero.write("en un fichero de texto");
//			fichero.close();
//		} catch (IOException ex) {
//			ex.printStackTrace();
//		}
//		
//		try {
//			FileWriter fichero = new FileWriter("C:\\Users\\admin\\Desktop\\fichero.txt", true);
//			BufferedWriter bw = new BufferedWriter(fichero);
//			fichero.write("Ejemplo de escritura append con buffer de flujo de caracteres\n");
//			bw.newLine();
//			fichero.write("en un fichero de texto");
//			bw.close();
//			fichero.close();
//		} catch (IOException ex) {
//			ex.printStackTrace();
//		}
//		
//		try {
//			FileWriter fichero = new FileWriter("C:\\Users\\admin\\Desktop\\fichero1.txt", true);
//			PrintWriter pw = new PrintWriter(fichero);
//			
//			pw.println("Escribiendo en fichero");
//			pw.printf("Escribiendo en fichero por %dª vez\n",2);
//			pw.flush();
//			pw.close();
//			fichero.close();
//			
//			pw = new PrintWriter(System.out);
//			pw.println("Escribiendo en consola");
//			pw.printf("Escribiendo en consola por %dª vez\n",2);
//			pw.flush();
//			pw.close();
//			fichero.close();
//		} catch (IOException ex) {
//			ex.printStackTrace();
//		}
		
		//Leer
		try {
			File fichero = new File("C:\\Users\\admin\\Desktop\\fichero2.txt");
			FileReader fr = new FileReader(fichero);
			int carac;
			while ((carac = fr.read()) != -1) {
				System.out.print((char) carac);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		try {
			FileReader fr = new FileReader("C:\\Users\\admin\\Desktop\\fichero2.txt");
			BufferedReader br = new BufferedReader(fr);
			System.out.println(br.readLine());
			System.out.println("------------");
			String linea;
			while ((linea = br.readLine()) != null) {
				System.out.println(linea);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
	}

}
