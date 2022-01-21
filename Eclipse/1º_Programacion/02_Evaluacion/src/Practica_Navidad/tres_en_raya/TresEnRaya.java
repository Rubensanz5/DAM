package Practica_Navidad.tres_en_raya;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TresEnRaya {
	
	static String tablero;
	
	static Scanner scn = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Juego del tres en raya, desarrollado de A.David Temi�o\n\n\n");
		try {
			int opcion = -1;
			
			while(true) {
				System.out.println("Bienvenido al juego del ahorcado, elige una opcion:"
						+ "\nOpcion [1]: Empezar partida"
						+ "\nOpcion [2]: Tutorial"
						+ "\nOpcion [0]: Salir");
				
				do {
					opcion = scn.nextInt();
				}while(opcion < 0 || opcion > 3);
				
				switch(opcion) {
				case 0:
					System.out.println("\n\n\nGracias por jugar, hasta pronto!");
					System.exit(0);
					break;
				case 1:
					tablero = "1 - 2 - 3\n"
							+ "| \\ | / |\n"
							+ "4 - 5 - 6\n"
							+ "| / | \\ |\n"
							+ "7 - 8 - 9";
					jugar();
					break;
				case 2:
					tutorial();
					break;
				}
			}
		}catch(InputMismatchException e) {
			System.out.println("Fatal ERROR 404, no se introdujo el caracter esperado,"
					+ " el programa se cerrara");
		}
	}
	
	@SuppressWarnings("unused")
	private static void jugar() {
		// TODO Auto-generated method stub
		String j1, j2;
		System.out.println("Introduce el nombre del primer juegador (jugara con las fichas circulo):");
		do {
			j1 = scn.nextLine();
		}while(j1.isEmpty());
		System.out.println("Introduce el nombre del segundo juegador (jugara con las fichas cruz):");
		do {
			j2 = scn.nextLine();
		}while(j2.isEmpty());
		
		String ficha;
		char f1 = 'O', f2 = 'X';
		int i = 0;
		int contO = 0;
		int contX = 0;
		
		do {
			for (i = 0; i < 9; i++) {
				if((i % 2) == 0) {
					System.out.println("\n\n\n" + tablero + "\nTurno del jugador: " + j1);
					System.out.println("Introduce la posicion donde colocar la ficha:");
					do {
						ficha = scn.nextLine();
					}while(!ficha.equalsIgnoreCase("1") && !ficha.equalsIgnoreCase("2") && !ficha.equalsIgnoreCase("3")
							&& !ficha.equalsIgnoreCase("4") && !ficha.equalsIgnoreCase("5") && !ficha.equalsIgnoreCase("6")
							&& !ficha.equalsIgnoreCase("7") && !ficha.equalsIgnoreCase("8") && !ficha.equalsIgnoreCase("9"));
					for (int j = 0; j < tablero.length(); j++) {
						if(ficha.equalsIgnoreCase(Character.toString(tablero.charAt(j)))) {
							tablero = tablero.replace(tablero.charAt(j), f1);
							j = tablero.length();
						}
					}
				}else {
					System.out.println("\n\n\n" + tablero + "\nTurno del jugador: " + j2);
					System.out.println("Introduce la posicion donde colocar la ficha:");
					do {
						ficha = scn.nextLine();
					}while(!ficha.equalsIgnoreCase("1") && !ficha.equalsIgnoreCase("2") && !ficha.equalsIgnoreCase("3")
							&& !ficha.equalsIgnoreCase("4") && !ficha.equalsIgnoreCase("5") && !ficha.equalsIgnoreCase("6")
							&& !ficha.equalsIgnoreCase("7") && !ficha.equalsIgnoreCase("8") && !ficha.equalsIgnoreCase("9"));
					for (int j = 0; j < tablero.length(); j++) {
						if(ficha.equalsIgnoreCase(Character.toString(tablero.charAt(j)))) {
							tablero = tablero.replace(tablero.charAt(j), f2);
							j = tablero.length();
						}
					}
				}
				
				if((tablero.charAt(0) == tablero.charAt(4) && tablero.charAt(0) == tablero.charAt(8)) 
						|| (tablero.charAt(20) == tablero.charAt(24) && tablero.charAt(20) == tablero.charAt(28))
						|| (tablero.charAt(40) == tablero.charAt(44) && tablero.charAt(40) == tablero.charAt(48))
						|| (tablero.charAt(0) == tablero.charAt(20) && tablero.charAt(0) == tablero.charAt(40))
						|| (tablero.charAt(4) == tablero.charAt(24) && tablero.charAt(4) == tablero.charAt(44))
						|| (tablero.charAt(8) == tablero.charAt(28) && tablero.charAt(8) == tablero.charAt(48))
						|| (tablero.charAt(0) == tablero.charAt(24) && tablero.charAt(0) == tablero.charAt(48))
						|| (tablero.charAt(8) == tablero.charAt(24) && tablero.charAt(8) == tablero.charAt(40))) {
					i = 9;
				}
			}
		}while(i < 9);
		System.out.println("\n\n\nFIN DEL JUEGO\n\nEl tablero quedo:\n" + comprobarGanador(j2, j1) + "\n\n\n");
	}
	
	private static String comprobarGanador(String j1, String j2) {
		if(tablero.charAt(0) == tablero.charAt(4) && tablero.charAt(0) == tablero.charAt(8)) {
			if(tablero.charAt(0) == 'X') {
				return tablero + "\n\nHa ganado el jugador: " + j1;
			}else {
				return tablero + "\n\nHa ganado el jugador: " + j2;
			}
		}else if(tablero.charAt(20) == tablero.charAt(24) && tablero.charAt(20) == tablero.charAt(28)) {
			if(tablero.charAt(20) == 'X') {
				return tablero + "\n\nHa ganado el jugador: " + j1;
			}else {
				return tablero + "\n\nHa ganado el jugador: " + j2;
			}
		}else if(tablero.charAt(40) == tablero.charAt(44) && tablero.charAt(40) == tablero.charAt(48)) {
			if(tablero.charAt(40) == 'X') {
				return tablero + "\n\nHa ganado el jugador: " + j1;
			}else {
				return tablero + "\n\nHa ganado el jugador: " + j2;
			}
		}else if(tablero.charAt(0) == tablero.charAt(20) && tablero.charAt(0) == tablero.charAt(40)) {
			if(tablero.charAt(0) == 'X') {
				return tablero + "\n\nHa ganado el jugador: " + j1;
			}else {
				return tablero + "\n\nHa ganado el jugador: " + j2;
			}
		}else if(tablero.charAt(4) == tablero.charAt(24) && tablero.charAt(4) == tablero.charAt(44)) {
			if(tablero.charAt(4) == 'X') {
				return tablero + "\n\nHa ganado el jugador: " + j1;
			}else {
				return tablero + "\n\nHa ganado el jugador: " + j2;
			}
		}else if(tablero.charAt(8) == tablero.charAt(28) && tablero.charAt(8) == tablero.charAt(48)) {
			if(tablero.charAt(8) == 'X') {
				return tablero + "\n\nHa ganado el jugador: " + j1;
			}else {
				return tablero + "\n\nHa ganado el jugador: " + j2;
			}
		}else if(tablero.charAt(0) == tablero.charAt(24) && tablero.charAt(0) == tablero.charAt(48)) {
			if(tablero.charAt(0) == 'X') {
				return tablero + "\n\nHa ganado el jugador: " + j1;
			}else {
				return tablero + "\n\nHa ganado el jugador: " + j2;
			}
		}else if(tablero.charAt(8) == tablero.charAt(24) && tablero.charAt(8) == tablero.charAt(40)) {
			if(tablero.charAt(8) == 'X') {
				return tablero + "\n\nHa ganado el jugador: " + j1;
			}else {
				return tablero + "\n\nHa ganado el jugador: " + j2;
			}
		}else {
			return tablero + "Se termino la partida en empate";
		}
	}
	
	private static void tutorial() {
		// TODO Auto-generated method stub
		System.out.println("\n\n[TUTORIAL]"
				+ "\n\nEl juego:"
				+ "\n\nEn el juego participan dos jugadores, el primer"
				+ "\njugador con las fichas cruz [X] y el segundo con"
				+ "\nlas fichas circulo [O]"
				+ "\n\nAparecera por pantalla el tablero de juego con"
				+ "\nlas posibles ubicaciones de las fichas marcadas"
				+ "\ncon numero el 1 al 9, para colocar una ficha,"
				+ "\nel jugador durante su turno debera introducir el"
				+ "\numero correspondiente a la posicion en la que"
				+ "\ndesea colocar la ficha, para terminar el juego uno"
				+ "\nde los dos jugadores debe colocar tres de sus fichas"
				+ "\nen posiciones consecutivas (tanto en horizontal,"
				+ "\ncomo vertical, como en diagonal) o haberse colocado"
				+ "\ntodas las fichas, cada jugador tiene un maximo"
				+ "\nde 5 fichas que se iran colocando por turnos, durante"
				+ "\ncada turno solo se puede colocar una ficha y si se"
				+ "\ncoloca una ficha en una posicion en la que ya hay"
				+ "\notra ficha se perdera el turno, en total hay un maximo de 9 turnos"
				+ "\n\n");
	}
}
//ficha != "1" && ficha != "2" && ficha != "3" && ficha != "4" && ficha != "5"
//&& ficha != "6" && ficha != "7" && ficha != "8" && ficha != "9"