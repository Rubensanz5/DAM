package Evaluacion_02.pdf2;

public class Triangulo extends Figura {
	private double base;
	private double altura;
	
	public Triangulo(String color, double base, double altura) {
		super(color);
		this.base = base;
		this.altura = altura;
	}
	
	@Override
	public double calcularArea() {
		return (base * altura) / 2;
	}
}
