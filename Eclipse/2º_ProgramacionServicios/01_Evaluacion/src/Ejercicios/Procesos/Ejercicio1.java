package Ejercicios.Procesos;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;


public class Ejercicio1 {

	public static void main(String[] args) {
		try {
			ProcessBuilder builder = new ProcessBuilder("java", "Ejercicios.Suma");
			builder.directory(new File("bin"));
			builder.redirectErrorStream(true);
		
			Process process = builder.start();
			
			
			OutputStream os = process.getOutputStream();
			//introduce num que quieres q se sume
			os.write("50\n".getBytes());
			os.write("50\n".getBytes());
			os.flush();
			
			InputStream is = process.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String num;
			
			while((num = br.readLine()) != null){
				System.out.println(num);
			}
			
			br.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}


}
