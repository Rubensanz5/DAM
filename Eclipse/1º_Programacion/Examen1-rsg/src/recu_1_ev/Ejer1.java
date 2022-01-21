package recu_1_ev;

public class Ejer1 {

	public static void main(String[] args) {
		//ejer1.1
		int a = 4, n;
		n = 14 - (a * 3) / 2;
		System.out.print(n);
		
		//resultado 8
		
		//ejer1.2
		int n1 = 0;
		for (int i = 0; i + n1 < 5; i--) {
		n1 = n1 + 4;
		}
		System.out.print(n);
		//resultado 8
		
		//ejer1.3
		int x = 0, y = 12;
		do {
		System.out.print(x * y + "-");
		x += 2;
		y -= 2;
		} while (x != y);
		//resultado 0-20-32-
		
		//ejer1.4
		int i, j = 28;
		for (i = 1; i + j <= 29; i++) {
		j = j - 2;
		}
		System.out.print(i);
		//bucle infinito
		
		//ejer1.5
		double n3 = 5.8;
		int n4 = (int) n3;
		System.out.print(n4);
		//no compila por 5,8
		
		//ejer1.6
		int x1 = 2, y1 = 3, z;
		z = (x1++ < y1) ? x1++ + 1 : y1--;
		System.out.print(x1 + "_" + y1 + "_" + z);
		//4_3_4
		
		//ejer1.7
		int edad = 40;
		boolean a1 = true;
		boolean esMillennial = 27 < edad && 39 >= edad;
		if (!(!(a1 || esMillennial) && a1)) {
			System.out.print("R1:" + esMillennial);
		} else {
			System.out.print("R2:" + esMillennial);
		}
		//falta un parentesis de cerrar en linea 54 no compila
		//con el parentesis saldria R1: false
		
		//ejer1.8
		final double IVA = 21;
		double precio = 1000;
		precio += precio * IVA / 100;
		System.out.print("Precio con IVA: " + precio);
		
		
		//ejer1.9
		
		
		
		//ejer1.10
		
		
		
		//ejer1.11
		
		
		
		
		//ejer1.12
		
		
	}

}
