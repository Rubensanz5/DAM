package Evaluacion_02.pdf2;

public abstract class Figura {
	private String color;
	
	public Figura(String color) {
		this.color = color;
	}

	public abstract double calcularArea();

	public String getColor() {
		return color;
	}
	
}
