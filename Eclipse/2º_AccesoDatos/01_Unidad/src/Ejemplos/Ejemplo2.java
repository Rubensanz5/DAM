package Ejemplos;

import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;

public class Ejemplo2 {
	public static void main(String[] args) {
		try {
			StreamTokenizer st = new StreamTokenizer(new FileReader("F:\\2º DAM\\Acceso a Datos\\UT01\\Practicas\\Fichero.txt"));
			int palabras = 0;
			int numeros = 0;
			
			while(st.nextToken() != StreamTokenizer.TT_EOF) {
				if (st.ttype == StreamTokenizer.TT_WORD) {
					palabras++;
				} else if (st.ttype == StreamTokenizer.TT_NUMBER) {
					numeros++;
				}
				
			}
			
			System.out.println("Num de palabras: " + palabras);
			System.out.println("Num de numeros: " + numeros);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
