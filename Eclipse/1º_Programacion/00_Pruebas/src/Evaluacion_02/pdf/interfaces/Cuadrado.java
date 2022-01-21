package Evaluacion_02.pdf.interfaces;

public class Cuadrado implements Figura{

	private String color;
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getLado() {
		return lado;
	}

	public void setLado(double lado) {
		this.lado = lado;
	}

	private double lado;
	
	public Cuadrado(String color, double lado) {
		this.lado = lado;
		this.color = color;
	}
	
	@Override
	public double calcularArea() {
		return lado * lado;
	}

}
