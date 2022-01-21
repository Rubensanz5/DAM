package recu_1_ev;

public class Gamer {
	String nombre;
	String videojuego;
	char liga;
	int primerosPuestos;
	int segundosPuestos;
	int tercerosPuestos;
	boolean esEstadounidense;
	
	final static double PREMIO_PRIMERO_LIGA_A = 1000;
	final static double PREMIO_SEGUNDO_LIGA_A = 750;
	final static double PREMIO_TERCERO_LIGA_A = 500;
	final static double PREMIO_PRIMERO_LIGA_B = 350;
	final static double PREMIO_SEGUNDO_LIGA_B = 250;
	final static double PREMIO_PRIMERO_LIGA_C = 200;
	final static double FIJO_LIGA_A = 5000;
	final static double FIJO_LIGA_B = 2000;
	
	public Gamer(String nombre, String videojeugo, char liga, int primerosPuestos, int segundosPuestos, int tercerosPuestos,boolean esEstadounidense) {
		this.nombre = nombre;
		this.videojuego = videojeugo;
		this.liga = liga;
		this.primerosPuestos = primerosPuestos;
		this.segundosPuestos = segundosPuestos;
		this.tercerosPuestos = tercerosPuestos;
		this.esEstadounidense = esEstadounidense;
	}

	public Gamer(String nombre, String videojuego) {
		this.nombre = nombre;
		this.videojuego = videojuego;
	}
	
	public double gananciasAnuales() {
		double ganancias = 0;
		switch (liga) {
			case 'A':
				ganancias = FIJO_LIGA_A + primerosPuestos * PREMIO_PRIMERO_LIGA_A
							+ segundosPuestos * PREMIO_SEGUNDO_LIGA_A
							+ tercerosPuestos * PREMIO_TERCERO_LIGA_A;
				break;
			case 'B':
				ganancias = FIJO_LIGA_B + primerosPuestos * PREMIO_PRIMERO_LIGA_B
				+ segundosPuestos * PREMIO_SEGUNDO_LIGA_B;
				break;
			case 'C':
				if (!esEstadounidense) {
					ganancias = -1;
				} else {
					ganancias = primerosPuestos + PREMIO_PRIMERO_LIGA_C;
				}
				break;
		}
		
		if (ganancias >= 10000 && esEstadounidense && liga != 'C') {
			ganancias += ganancias * 10 / 100;
		}
		
		return ganancias;
	}
	
}