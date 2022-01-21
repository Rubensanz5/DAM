package Ejemplo.tresenraya;

import java.util.Arrays;

public class Tablero implements Cloneable {
	
	public static final int LINEA_HORIZONTAL_1 = 0;
	public static final int LINEA_HORIZONTAL_2 = 1;
	public static final int LINEA_HORIZONTAL_3 = 2;
	public static final int LINEA_VERTICAL_1 = 3;
	public static final int LINEA_VERTICAL_2 = 4;
	public static final int LINEA_VERTICAL_3 = 5;
	public static final int LINEA_DIAGONAL_1 = 6;
	public static final int LINEA_DIAGONAL_2 = 7;
	
	public static final char FICHA_J1 = 'X';
	public static final char FICHA_CPU = 'O';
	public static final char VACIO = ' ';
	
	private char[] casillas;
	
	public Tablero() {
		casillas = new char[9];
		Arrays.fill(casillas, VACIO);
	}
	
	@Override
	public Tablero clone() {
		
		Tablero clon = new Tablero();
		
		System.arraycopy(this.casillas, 0, clon.casillas, 0, this.casillas.length);
		
		return clon;
		
	}
	
	public void colocarFicha(char ficha, int casilla) {
		
		casillas[casilla] = ficha;
		
	}
	
	public char comprobarTresEnRaya() {
		
		char[][] lineas = getLineas();
		char fichaGanador = VACIO;
		
		for (int i = 0; fichaGanador == VACIO && i < lineas.length; i++) {
			if (lineas[i][0] == lineas[i][1] && lineas[i][0] == lineas[i][2]) {
				fichaGanador = lineas[i][0];
			}
		}
		
		return fichaGanador;
	}
	
	@Override
	public String toString() {
		
		return (casillas[0] == VACIO ? '1' : casillas[0]) + " | "
				+ (casillas[1] == VACIO ? '2' : casillas[1]) + " | "
				+ (casillas[2] == VACIO ? '3' : casillas[2]) + "\n"
			 + (casillas[3] == VACIO ? '4' : casillas[3]) + " | "
				+ (casillas[4] == VACIO ? '5' : casillas[4]) + " | "
				+ (casillas[5] == VACIO ? '6' : casillas[5]) + "\n"
			 + (casillas[6] == VACIO ? '7' : casillas[6]) + " | "
				+ (casillas[7] == VACIO ? '8' : casillas[7]) + " | "
				+ (casillas[8] == VACIO ? '9' : casillas[8]);
		
	}
	
	public int getTotalCasillasVacias() {
		
		int casillasVacias = 0;
		
		for (char casilla : casillas) {
			if (casilla == VACIO) {
				casillasVacias++;
			}
		}
		
		return casillasVacias;
		
	}
	
	public boolean comprobarCasillaVacia(int casilla) {
		return casillas[casilla] == VACIO;
	}
	
	/*
	 * Devuelve un array con cada una de las líneas horizontales,
	 * verticales y diagonales que componen el tablero
	 */
	public char[][] getLineas(){
		
		return new char[][] {
			{casillas[0], casillas[1], casillas[2]}, // linea horizontal 1
			{casillas[3], casillas[4], casillas[5]}, // linea horizontal 2
			{casillas[6], casillas[7], casillas[8]}, // linea horizontal 3
	
			{casillas[0], casillas[3], casillas[6]}, // linea vertical 1
			{casillas[1], casillas[4], casillas[7]}, // linea vertical 2
			{casillas[2], casillas[5], casillas[8]}, // linea vertical 3
	
			{casillas[0], casillas[4], casillas[8]}, // linea diagonal 1
			{casillas[2], casillas[4], casillas[6]} // linea diagonal 2
		};
		
	}
	
	public char[] getCasillas() {
		return casillas;
	}
	
}