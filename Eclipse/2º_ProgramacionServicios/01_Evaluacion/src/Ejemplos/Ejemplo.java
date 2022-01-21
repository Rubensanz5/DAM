package Ejemplos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ejemplo {

	public static void main(String[] args) {
		try {
			Runtime rt = Runtime.getRuntime();
			Process proceso = rt.exec("notepad");
			InputStream is = proceso.getInputStream();
			BufferedReader bf = new BufferedReader(new InputStreamReader(is));
			String linea;
			
			while((linea = bf.readLine()) != null){
				System.out.println(linea);
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

}
	