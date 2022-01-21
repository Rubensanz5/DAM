package Ejemplo.tresenraya;

import java.util.ArrayList;
import java.util.TreeMap;

public class CPU extends Jugador {
	
	/*
	 * Algoritmo de decisión:
	 *
	 * Para decidir en qué casilla colocar una ficha, primero se recorrerán las casillas
	 * del tablero buscando las casillas vacías.
	 *
	 * Una vez encontrada una casilla vacía
	 * se creará una copia del tablero y se colocará la ficha de la CPU en dicha casilla
	 * de la copia.
	 *
	 * A continuación se puntúa el tablero que resultaría de colocar la ficha en esa
	 * casilla comprobando todas las líneas horizontales, verticales y diagonales del
	 * tablero individualmente.
	 *
	 * Se puntúa cada línea según el número de fichas y a quién pertenecen.
	 *
	 * Tras puntuar un tablero se guarda en un TreeMap la casilla en la que se colocaría
	 * la ficha y su puntuación, siendo la puntuación la clave del TreeMap.
	 *
	 * En caso de que varias casillas compartan puntuación, para evitar que se vuelva
	 * predecible ya que la más nueva sobreescribe a la que ya se encuentra en el TreeMap,
	 * se utiliza un ArrayList que guarde todas las casillas con la misma puntuación.
	 *
	 * Finalmente, tras evaluar todas las posibilidades, se cogerá el mayor elemento del
	 * TreeMap (ArrayList con las casillas que obtuvieron la mayor puntuación) y se escogerá
	 * aleatoriamente un elemento del ArrayList.
	 */
	
	private static final int PUNTUACION_VICTORIA = 1000;
	private static final int PUNTUACION_VICTORIA_PERDIDA = 3;
	private static final int PUNTUACION_POSIBLE_VICTORIA = 10;
	private static final int PUNTUACION_DERROTA_EVITADA = 100;
	private static final int PUNTUACION_LINEA_DE_NADIE = 0;
	private static final int PUNTUACION_FICHA_PROPIA = 5;
	private static final int PUNTUACION_FICHA_PROPIA_EN_CENTRO = 0;
	private static final int PUNTUACION_DERROTA = -500;
	private static final int PUNTUACION_FICHA_AJENA = -1;
	private static final int PUNTUACION_FILA_VACIA = 0;
	
	public CPU(String nombre) {
		super(nombre);
	}
	
	public int elegirCasilla(Tablero tablero) {
		
		TreeMap<Integer, ArrayList<Integer>> posibilidades = new TreeMap<Integer, ArrayList<Integer>>();
		
		for (int i = 0; i < tablero.getCasillas().length; i++) {
			if (tablero.getCasillas()[i] == Tablero.VACIO) {
				
				Tablero copia = tablero.clone();
				copia.colocarFicha(Tablero.FICHA_CPU, i);
				int puntuacion = puntuarTablero(copia);
				
				if (posibilidades.containsKey(puntuacion)) {
					posibilidades.get(puntuacion).add(i);
				} else {
					ArrayList<Integer> arrayCasillas = new ArrayList<Integer>();
					arrayCasillas.add(i);
					posibilidades.put(puntuacion, arrayCasillas);
				}
				
			}
		}
		
		ArrayList<Integer> casillasEligibles = posibilidades.get(posibilidades.lastKey());
		return casillasEligibles.get(Utils.random(0, casillasEligibles.size() - 1));
		
	}
	
	private int puntuarTablero(Tablero tablero) {
		
		char[][] lineas = tablero.getLineas();
		int puntuacion = 0;
		
		for (int i = 0; i < lineas.length; i++) {
			puntuacion += puntuarLinea(lineas[i]);
		}
		
		return puntuacion;
		
	}
	
	private int puntuarLinea(char[] linea) {
		
		int puntuacion = 0;
		int fichasPropias = contarFichasPropias(linea);
		int fichasAjenas = contarFichasAjenas(linea);
		
		/*
		 * No se tiene en cuenta si la línea tiene 3 fichas ajenas
		 * porque la partida acabaría antes del turno de la CPU
		 */
		if (fichasPropias == 3) {
			puntuacion = PUNTUACION_VICTORIA;
			
		} else if (fichasPropias == 2 && fichasAjenas == 1) {
			puntuacion = PUNTUACION_VICTORIA_PERDIDA;
			
		} else if (fichasPropias == 2 && fichasAjenas == 0) {
			puntuacion = PUNTUACION_POSIBLE_VICTORIA;
			
		} else if (fichasPropias == 1 && fichasAjenas == 2) {
			puntuacion = PUNTUACION_DERROTA_EVITADA;
			
		} else if (fichasPropias == 1 && fichasAjenas == 1) {
			puntuacion = PUNTUACION_LINEA_DE_NADIE;
			
		} else if (fichasPropias == 1 && fichasAjenas == 0) {
			if (linea[1] == Tablero.FICHA_CPU) {
				puntuacion = PUNTUACION_FICHA_PROPIA_EN_CENTRO;
			} else {
				puntuacion = PUNTUACION_FICHA_PROPIA;
			}
			
		} else if (fichasPropias == 0 && fichasAjenas == 2) {
			puntuacion = PUNTUACION_DERROTA;
			
		} else if (fichasPropias == 0 && fichasAjenas == 1) {
			puntuacion = PUNTUACION_FICHA_AJENA;
			
		} else if (fichasPropias == 0 && fichasAjenas == 0) {
			puntuacion = PUNTUACION_FILA_VACIA;
			
		}
		
		return puntuacion;
		
	}
	
	private int contarFichasPropias(char[] linea) {
		
		return contarFichas(linea, Tablero.FICHA_CPU);
		
	}
	
	private int contarFichasAjenas(char[] linea) {
		
		return contarFichas(linea, Tablero.FICHA_J1);
		
	}
	
	private int contarFichas(char[] linea, char ficha) {
		
		int contador = 0;
		
		for (char casilla : linea) {
			if (casilla == ficha) {
				contador++;
			}
		}
		
		return contador;
		
	}
	
}
























