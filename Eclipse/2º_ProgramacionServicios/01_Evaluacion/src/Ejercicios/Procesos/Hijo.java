package Ejercicios.Procesos;

import java.util.Scanner;

public class Hijo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String texto;
		
		do {
			texto = sc.nextLine().toUpperCase();
			System.out.println(texto);
		} while(!texto.equals("-1"));
		
		sc.close();

	}

}
