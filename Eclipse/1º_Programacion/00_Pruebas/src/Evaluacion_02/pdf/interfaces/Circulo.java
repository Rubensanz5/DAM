package Evaluacion_02.pdf.interfaces;

public class Circulo implements Figura {
	private String color;
	private double radio;
	
	
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}

	public Circulo(String color, double radio) {
		this.color = color;
		this.radio = radio;
	}
	
	@Override
	public double calcularArea() {
		return PI * radio * radio;
	}
	
}
