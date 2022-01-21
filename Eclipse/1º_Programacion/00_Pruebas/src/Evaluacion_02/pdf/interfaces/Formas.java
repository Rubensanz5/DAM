package Evaluacion_02.pdf.interfaces;

public class Formas {

	public static void main(String[] args) {
		Cuadrado cuadrado = new Cuadrado("azul",7);
		Circulo circulo = new Circulo("morado", 15.0);
		
		System.out.println("La suma de las areas de cuadrado y circulo es: " + sumarAreas(cuadrado,circulo) + " y los colores son: " + cuadrado.getColor() + " y " + circulo.getColor());

	}

	public static double sumarAreas(Figura figura1, Figura figura2) {
		return figura1.calcularArea() + figura2.calcularArea();
	}

}
