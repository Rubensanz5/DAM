package Ejercicio1;

public class ejercicio1 {

	public static void main(String[] args) {
		//ejercicio 1.1
		int a = 2, n; 
		
		n= 4 + a / 2;
		
		System.out.println(n);
		//salida: n1 = 5
		
		//ejercicio 1.2
		int n1 = 0;
		
		for(int i = 0; i < 5; i++) {
			n1 = n1 + 2;
		}
		System.out.println(n1);
		//salida n1 = 10
		
		//ejercicio 1.3
		int n2 = 8 + 20 % 9 * 3;
		
		System.out.println(n2);
		//salida n2 = 14
		
		//ejercicio 1.4
		int ii, j = 33;
		for(ii = 1; ii < 29; ii++) {
			j = j - 9;
		}
		System.out.println(ii);
		//salida j = 28
		
		//ejercicio 1.5
		@SuppressWarnings("unused")
		int z = 1, suma = 0;
		
		while (z <= 0) {
			suma += z;
		}
		System.out.println(z);
		//bucle infinito
		
		//ejercicio 1.6
		double n3 = 5.8;
		
		n3 = (int) n3;
		System.out.println(n3);
		//salida : 5
		
		//ejer 1.7
		int x = 2, y = 3, z1;
		z1 = (x++ < y)? ++x + 1: y--;
		
		System.out.println(x + "_" + y + "_" + z1);
		//salida: 4_3_5
		
		//ejeer 1.8
		int a1 = 7, b = 15, c = 9;
		
		System.out.println("R:" + (a1 > 3 && b > 3 && c < 3) + " " + ((a1 + b == 8) || (a1 - b == 6)));
		//salida: R: false false
		
		//ejer 1.9
//		final double iva = 21;
//		
//		double precio = 1000;
//		
//		iva = precio * 21 / 100;
//		
//		System.out.println(iva);
		//no compila
		
		//ejer 1.10
		//se tiene: public class Coche{
		//int potencia;
		//}
//		Coche coche1;
//		int potencia = coche1.potencia;
//		System.out.println(potencia);
		//no compila
		
		//ejer 1.11
		int i = 2;
		int valor = i - 1;
		
		switch (valor){
			case 1: 		System.out.println("vale 1");
			case 2:		System.out.println("vale 2");
			default:		System.out.println("no vale");
		} 
		//salida imprime todo
		
		//ejer 1.12
//		public class Suma {
//			static int n5 = 50;
//			public static void main (String[] args) {
//				int n6 = 30;
//				int suma = 0;
//				suma = n5 + n6;
//			}
			//System.out.println(suma);
//		}
		//no compila x que no puede haber instrucciones fuera del metodo
	}

}
