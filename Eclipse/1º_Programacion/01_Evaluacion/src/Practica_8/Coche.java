package Practica_8;

public class Coche {
	
	//declaracion de variables miembro
	double precioBase, consumo, potencia, peso;
	String color, gama;
	
	//declaracion e inicializacion de las constantes
	final double PRECIO_BASE = 12000;
	
	final static String COLOR_BLANCO = "Blanco";
	final static String COLOR_NEGRO = "Negro";
	final static String COLOR_ROJO = "Rojo";
	final static String COLOR_AZUL = "Azul";
	final static String COLOR_VERDE = "Verde";
	final static String COLOR_GRIS = "Gris";
	
	final static String GAMA_BAJA = "Baja";
	final static String GAMA_MEDIA = "Media";
	final static String GAMA_ALTA = "Alta";
	
	final static double POTENCIA = 110;
	final static double CONSUMO = 5.5;
	
	final static double PESO_BASE = 1500;
	final static double PESO_BAJO = 1200;
	final static double PESO_MEDIO = 1400;
	final static double PESO_ALTO = 1800;
	
	//constructores
	public Coche() {
		this.precioBase = PRECIO_BASE;
		this.color = COLOR_BLANCO;
		this.gama = GAMA_MEDIA;
		this.consumo = CONSUMO;
		this.peso = PESO_BASE;
		this.potencia = POTENCIA;
	}
	
	public Coche(double precio, double peso) {
		this.precioBase = precio;
		this.color = COLOR_BLANCO;
		this.gama = GAMA_MEDIA;
		this.consumo = CONSUMO;
		this.peso = peso;
		this.potencia = POTENCIA;
	}
	
	public Coche(double precio, String color, String gama, double consumo, double peso, double potencia) {
		this.precioBase = precio;
		this.color = comprobarColor(color);
		this.gama = comprobarGama(gama);
		this.consumo = consumo;
		this.peso = peso;
		this.potencia = potencia;
	}

	//metodos
	 public String comprobarGama (String gama) {
		 if (gama.equalsIgnoreCase(GAMA_BAJA) || gama.equalsIgnoreCase(GAMA_MEDIA) || gama.equalsIgnoreCase(GAMA_ALTA)) {
			 return gama;
		 } else {
			 gama = GAMA_MEDIA;
		 }
		  return gama;
	 }
	 
	 
	 public String comprobarColor (String color) {
		 
		 if (color.equalsIgnoreCase(COLOR_BLANCO) || color.equalsIgnoreCase(COLOR_NEGRO) || color.equalsIgnoreCase(COLOR_ROJO) ||
		  color.equalsIgnoreCase(COLOR_AZUL) || color.equalsIgnoreCase(COLOR_VERDE) || color.equalsIgnoreCase(COLOR_GRIS)) {
			 return color;
		 } else {
			 color = COLOR_BLANCO;
		 }
		 return color;
	 }
	 
	 
	 public double precioFinal() {
		 
		 if (gama.equalsIgnoreCase(GAMA_ALTA)) {
			 this.precioBase = precioBase + 2000; 
		 } else if (gama.equalsIgnoreCase(GAMA_MEDIA)) {
			 this.precioBase = precioBase + 1200; 
		 } else if (gama.equalsIgnoreCase(GAMA_BAJA)) {
			 this.precioBase = precioBase + 600; 
		 } 
		 
		 if (peso < 1200) {
			 this.precioBase = precioBase + 0;
		 } else if (peso >= PESO_BAJO && peso < PESO_MEDIO) {
			 this.precioBase = precioBase + 350;
		 } else if (peso >= PESO_MEDIO && peso < PESO_ALTO) {
			 this.precioBase = precioBase + 1000;
		 } else if (peso >= PESO_ALTO) {
			 this.precioBase = precioBase + 1500;
		 }
		 
		 if (potencia > POTENCIA) {
			 this.precioBase = precioBase + 800;
		 } 
		
		 return this.precioBase;
	 }
}
