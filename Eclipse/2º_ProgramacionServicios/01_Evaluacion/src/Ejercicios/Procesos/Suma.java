package Ejercicios.Procesos;

import java.util.Scanner;

public class Suma {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int num1;
		int num2;
			
		System.out.println("Introduce un numero: ");
		num1 = pedirNum(sc);
		System.out.println("Introduce otro numero: ");
		num2 = pedirNum(sc);
	
		int suma = num1 + num2;
		System.out.println("La suma de " + num1 + " + " + num2 + " es: " + suma);
		
		sc.close();
		
	}
	public static int pedirNum(Scanner sc) {
		int num = -1;
		do {
			if(sc.hasNextInt()) {
				num = sc.nextInt();
				sc.nextLine();
			} else {
				sc.nextLine();
				num = -1;
			}
		} while (num < 0);
		return num;
	}
	
}
