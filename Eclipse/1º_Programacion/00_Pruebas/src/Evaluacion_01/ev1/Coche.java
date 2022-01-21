package Evaluacion_01.ev1;

public class Coche {
	String marca;
	String modelo;
	String color;
	int potencia;
	double consumo;
	boolean cambioAutomatico;
	
	public Coche(String marca, String modelo) {
		this.marca = marca;
		this.modelo = modelo;
		this.color = "negro";
		this.potencia = 100;
		this.consumo = 5.5;
		this.cambioAutomatico = false;
	}
	
	public Coche(String marca, String modelo, String color, int potencia, double consumo, boolean cambioAutomatico) {
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.potencia = potencia;
		this.consumo = consumo;
		this.cambioAutomatico = cambioAutomatico;
	}
	
	public int calcularAutoomia (double litros) {
		int kilometros;
		kilometros = (int)((litros * 100) / consumo);
		return kilometros;
	}
	
	public boolean esRapido() {
		boolean rapidez;
		
		if (potencia > 150) {
			rapidez = true;
			return rapidez;
		} else {
			rapidez = false;
			return rapidez;
		}
	}
	
	public void metalizar () {
		color = color + "metalizar";
	}
	
}
