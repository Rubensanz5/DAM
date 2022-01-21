package Practica_10;

import javax.swing.JOptionPane;

public class Vehiculo {
	private double precio;
	private String color;
	private String gama;
	private double peso;
	
	
	final static String GAMA_BAJA = "Baja";
	final static String GAMA_MEDIA = "Media";
	final static String GAMA_ALTA = "Alta";
	
	final static double PRECIO_BASE = 12000;
	
	
	final static String COLOR_BLANCO = "Blanco";
	final static String COLOR_NEGRO = "Negro";
	final static String COLOR_ROJO = "Rojo";
	final static String COLOR_AZUL = "Azul";
	final static String COLOR_VERDE = "Verde";
	final static String COLOR_GRIS = "Gris";
	
	final static double PESO_BASE = 1500;
	final static double PESO_BAJO = 1200;
	final static double PESO_MEDIO = 1400;
	final static double PESO_ALTO = 1800;
	
	public Vehiculo(){
		this.precio = PRECIO_BASE;
		this.color = COLOR_BLANCO;
		this.gama = GAMA_MEDIA;
		this.peso = PESO_BASE;
		
	}
	
	public Vehiculo(double precio, double peso){
		this.precio = precio;
		this.color = COLOR_BLANCO;
		this.gama = GAMA_MEDIA;
		this.peso = peso;
		
	}
	
	public Vehiculo(double precioBase, String color, String gama, double peso) {
		this.precio = precioBase;
		this.color = comprobarColor(color);
		this.gama = comprobarGama(gama);
		this.peso = peso;
	}

	//metodos 
	
	public double getPrecio() {
		return precio;
	}
	
	public String getColor() {
		return color;
	}
	
	public String getGama() {
		return gama;
	}
	
	public double getPeso() {
		return peso;
	}
	
	@Override
	public String toString() {
		JOptionPane.showMessageDialog(null, "El vehiculo se ha dado de alta con un precio final de: " + this.precioFinal() + "€");
		return null;
	}
	
	private String comprobarGama(String gama) {
		
		if (gama.equalsIgnoreCase(GAMA_ALTA)) {
			gama = GAMA_ALTA;
		} else if (gama.equalsIgnoreCase(GAMA_MEDIA)) {
			gama = GAMA_MEDIA;
		} else if (gama.equalsIgnoreCase(GAMA_BAJA)) {
			gama = GAMA_BAJA;
		} else {
			gama = GAMA_MEDIA;
		}
		return gama;
	}
	
	private String comprobarColor(String color) {
		if(color.equalsIgnoreCase(COLOR_BLANCO)) {
			color = COLOR_BLANCO;
		} else if(color.equalsIgnoreCase(COLOR_NEGRO)) {
			color = COLOR_NEGRO;
		} else if(color.equalsIgnoreCase(COLOR_AZUL)) {
			color = COLOR_AZUL;
		} else if(color.equalsIgnoreCase(COLOR_ROJO)) {
			color = COLOR_ROJO;
		} else if(color.equalsIgnoreCase(COLOR_VERDE)) {
			color = COLOR_VERDE;
		} else if(color.equalsIgnoreCase(COLOR_GRIS)) {
			color = COLOR_GRIS;
		} else {
			color = COLOR_BLANCO;
		}
		
		return color;
	}

	
	protected double precioFinal() {
		double precio = this.precio;
		
		 if (gama.equalsIgnoreCase(GAMA_ALTA)) {
			 precio += 2000; 
		 } else if (gama.equalsIgnoreCase(GAMA_MEDIA)) {
			precio += 1200; 
		 } else if (gama.equalsIgnoreCase(GAMA_BAJA)) {
			 precio += 600; 
		 } 
		 
		 if (peso < PESO_BAJO) {
			 precio = this.precio;
		 } else if (peso >= PESO_BAJO && peso < PESO_MEDIO) {
			precio += 350;
		 } else if (peso >= PESO_MEDIO && peso < PESO_ALTO) {
			 precio += 1000;
		 } else if (peso >= PESO_ALTO) {
			 precio += 1500;
		 }
		
		 return precio;
	 }
	
}
