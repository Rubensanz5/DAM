package Practica_8;

public class Coche1 {
	double precio_base, peso, potencia, consumo;
	String color, gama;
	
	final double PRECIO_BASE = 12000;
	
	final String COLOR_BLANCO = "Blanco";
	final String COLOR_NEGRO = "Negro";
	final String COLOR_AZUL = "Azul";
	final String COLOR_ROJO = "ROJO";
	final String COLOR_VERDE = "Verde";
	final String COLOR_GRIS= "Gris";
	
	final String GAMA_BAJA = "Baja";
	final String GAMA_MEDIA = "Media";
	final String GAMA_ALTA = "Alta";

	final double PESO = 1500;
	final double POTENCIA = 110;
	final double CONSUMO = 5.5;
	
	public Coche1() {
		precio_base = PRECIO_BASE;
		color = COLOR_BLANCO;
		gama = GAMA_MEDIA;
		peso = PESO;
		potencia = POTENCIA;
		consumo = CONSUMO;
	}
	
	public Coche1(double precio,double peso) {
		this.precio_base = precio;
		color = COLOR_BLANCO;
		gama = GAMA_MEDIA;
		this.peso = peso;
		potencia = POTENCIA;
		consumo = CONSUMO;
	}
	
	public Coche1(double precio, String color, String gama, double peso, double potencia, double consumo) {
		this.precio_base = precio;
		this.color = comprobarColor(color);
		this.gama = comprobarGama(gama);
		this.peso = peso;
		this.potencia = potencia;
		this.consumo = consumo;
	}
	
	public String comprobarGama(String gama) {
		if (gama.equalsIgnoreCase(GAMA_BAJA) || gama.equalsIgnoreCase(GAMA_MEDIA) || gama.equalsIgnoreCase(GAMA_ALTA)) {
			this.gama = gama;
		} else {
			this.gama = GAMA_MEDIA;
		}
		
		return gama;
	}
	
	public String comprobarColor(String color) {
		if (color.equalsIgnoreCase(COLOR_BLANCO) || color.equalsIgnoreCase(COLOR_NEGRO) || color.equalsIgnoreCase(COLOR_GRIS) ||
		color.equalsIgnoreCase(COLOR_AZUL) || color.equalsIgnoreCase(COLOR_ROJO) || color.equalsIgnoreCase(COLOR_VERDE)) {
			this.color = color;
		} else {
			this.color = COLOR_BLANCO;
		}
		
		return color;		
	}
	
	public double precioFinal() {
		if (gama.equalsIgnoreCase(GAMA_BAJA)) {
			this.precio_base = precio_base + 600;
		} else if (gama.equalsIgnoreCase(GAMA_MEDIA)){
			this.precio_base = precio_base + 1200;
		} else if (gama.equalsIgnoreCase(GAMA_ALTA)) {
			this.precio_base = precio_base + 2000;
		}
		
		if (peso < 1200) {
			
		} else if (peso >= 1200 && peso < 1400) {
			this.precio_base = precio_base + 350;
		} else if (peso >= 1400 && peso < 1800) {
			this.precio_base = precio_base + 1000;
		} else if (peso >= 1800) {
			this.precio_base = precio_base + 1500;
		}
		
		if (potencia >= 110) {
			this.precio_base = precio_base + 800;
		}
		
		return precio_base;
	}
	
}
