package Evaluacion_02.pdf2;

import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner teclado = new Scanner(System.in);
		
		String colorDelCuadrado;
		double ladoDelCuadrado;
		
		System.out.println("Introduzca el color del cuadrado");
		colorDelCuadrado = teclado.nextLine();
		System.out.println("Introduzca el lado del cuadrado");
		ladoDelCuadrado = teclado.nextDouble();
		
		Cuadrado cuadrado1 = new Cuadrado(colorDelCuadrado, ladoDelCuadrado);
		
		System.out.println("El area del cuadrado es: " + cuadrado1.calcularArea());
		
		String colorDelTriangulo;
		double baseDelTriangulo;
		double alturaDelTriangulo;
		
		System.out.println("Introduzca el color del Triangulo");
		colorDelTriangulo = teclado.nextLine();
		System.out.println("Introduzca la base del Triangulo");
		baseDelTriangulo = teclado.nextDouble();
		System.out.println("Introduzca la altura del Triangulo");
		alturaDelTriangulo = teclado.nextDouble();
		
		Triangulo triangulo1 = new Triangulo(colorDelTriangulo,baseDelTriangulo, alturaDelTriangulo);
	
		System.out.println("El area del triangulo es: " + triangulo1.calcularArea());
	
		Cuadrado cuadrado2 = new Cuadrado("Rosa", 8.5);
		Triangulo triangulo2 = new Triangulo("Morado", 9, 5.9);
		
		System.out.println("La suma de las areas del cuarado y del triangulo es: " + sumarAreas(cuadrado2, triangulo2));
		
	}

	private static double sumarAreas(Figura figura1, Figura figura2) {
		return figura1.calcularArea() + figura2.calcularArea();

	}
}
