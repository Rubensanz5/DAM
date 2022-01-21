package Ejercicios.Procesos;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Scanner;

public class Mayusculas {

	public static void main(String[] args) {
		 

		try {
			ProcessBuilder builder = new ProcessBuilder("java", "Ejercicios.Hijo");
			builder.directory(new File("bin"));
			builder.redirectErrorStream(true);
		
			Process process = builder.start();
			
			
			OutputStream os = process.getOutputStream();
			InputStream is = process.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			Scanner sc = new Scanner(System.in);
			String cadena;
			System.out.println("Escribe una cadena para transformar a mayusculas\ncon -1 sales");
			do {
				cadena = sc.nextLine();
				
				if(!cadena.equals("-1")) {
					os.write((cadena + "\n").getBytes());
					os.flush();
					
					String texto = br.readLine();
					
					System.out.println(texto);
				}
				
			} while(!cadena.equals("-1"));
			
			sc.close();
			br.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
