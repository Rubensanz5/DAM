package Practica_Navidad.ruleta_francesa;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RuletaFrancesa {
	
	static int numero_jugadores = 0;
	
	static Scanner scn = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("\nBienvenido al juego de la Ruleta Francesa, desarrollado por A.David Temi�o Monedero\n\n\n");
		
		int opcion = -1;
		
		while(true) {
			try {
				System.out.println("Bienvenido al juego de la Ruleta Francesa, elige una opcion:"
						+ "\nOpcion [1]: Empezar partida"
						+ "\nOpcion [2]: Tutorial"
						+ "\nOpcion [3]: Numero de jugadores, minimo es uno y maximo 5"
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
					if(numero_jugadores > 0)
						jugar();
					break;
				case 2:
					tutorial();
					break;
				case 3:
					modificarJugadores();
					break;
				}
				
			}catch(InputMismatchException e) {
				System.out.println("\nSe produjo un error, el juego se cerrara.");
				System.exit(0);
			}
		}	
	}

	private static void jugar() {
		String ubicacion = "";
		int turno = 0;
		boolean salir = false;
		
		if(numero_jugadores == 1) {
			Jugador j1 = crearJugador();
			do {
				if(j1.fichas < 1) {
					salir = true;
				}
				System.out.println("Tirada numero: " + turno++ + "\n" + j1.nombre + " (fichas restantes: "
						+ j1.fichas + ") donde desea colocar la ficha?:");
				Comprobar.tablero();
				ubicacion = "";
				do {
					ubicacion = scn.nextLine();
				}while(Comprobar.opcionesValidar(ubicacion));
				
				int aleatorio = (int) Math.floor(Math.random() * (37));
				
				if(ubicacion.equalsIgnoreCase("salir")){
					salir = true;
				}else {
					Comprobar.masMenosFichas(ubicacion, aleatorio, j1);
				}
				System.out.println("La bola callo en el numero: " + aleatorio + "\n");
			}while(salir == false && j1.fichas > 0);
			
		}else if(numero_jugadores == 2) {
			Jugador j1 = crearJugador();
			Jugador j2 = crearJugador();
			do {
				if(j1.fichas < 1 && j2.fichas < 1) {
					salir = true;
				}
				Comprobar.tablero();
				int aleatorio = (int) Math.floor(Math.random() * (37));
				
				if(j1.fichas > 0) {
					ubicacion = Comprobar.funcionJugador(j1, turno, ubicacion, scn, aleatorio);
					if(ubicacion.equalsIgnoreCase("salir")) {
						salir = true;
					}else {
						if(j2.fichas > 0) {
							ubicacion = Comprobar.funcionJugador(j2, turno, ubicacion, scn, aleatorio);
						}
					}
					if(ubicacion.equalsIgnoreCase("salir")) {
						salir = true;
					}else {
						turno++;
					}
				}
				System.out.println("La bola callo en el numero: " + aleatorio + "\n"
						+ "Puntuacion de " + j1.nombre + " es: " + j1.fichas
						+ "\nPuntuacion de " + j2.nombre + " es: " + j2.fichas);
			}while(salir == false);
		}else if(numero_jugadores == 3) {
			Jugador j1 = crearJugador();
			Jugador j2 = crearJugador();
			Jugador j3 = crearJugador();
			do {
				if(j1.fichas < 1 && j2.fichas < 1) {
					salir = true;
				}
				Comprobar.tablero();
				int aleatorio = (int) Math.floor(Math.random() * (37));

				if(j1.fichas > 0) {
					ubicacion = Comprobar.funcionJugador(j1, turno, ubicacion, scn, aleatorio);
					if(ubicacion.equalsIgnoreCase("salir")) {
						salir = true;
					}else {
						if(j2.fichas > 0) {
							ubicacion = Comprobar.funcionJugador(j2, turno, ubicacion, scn, aleatorio);
							if(ubicacion.equalsIgnoreCase("salir")) {
								salir = true;
							}else {
								if(j3.fichas > 0) {
									ubicacion = Comprobar.funcionJugador(j3, turno, ubicacion, scn, aleatorio);
								}
							}
						}
					}
				}
				turno++;
				System.out.println("La bola callo en el numero: " + aleatorio + "\n"
						+ "Puntuacion de " + j1.nombre + " es: " + j1.fichas
						+ "\nPuntuacion de " + j2.nombre + " es: " + j2.fichas
						+ "\nPuntuacion de " + j3.nombre + " es: " + j3.fichas);
			}while(salir == false);
		}else if(numero_jugadores == 4) {
			Jugador j1 = crearJugador();
			Jugador j2 = crearJugador();
			Jugador j3 = crearJugador();
			Jugador j4 = crearJugador();
			do {
				if(j1.fichas < 1 && j2.fichas < 1) {
					salir = true;
				}
				Comprobar.tablero();
				int aleatorio = (int) Math.floor(Math.random() * (37));

				if(j1.fichas > 0) {
					ubicacion = Comprobar.funcionJugador(j1, turno, ubicacion, scn, aleatorio);
					if(ubicacion.equalsIgnoreCase("salir")) {
						salir = true;
					}else {
						if(j2.fichas > 0) {
							ubicacion = Comprobar.funcionJugador(j2, turno, ubicacion, scn, aleatorio);
							if(ubicacion.equalsIgnoreCase("salir")) {
								salir = true;
							}else {
								if(j3.fichas > 0) {
									ubicacion = Comprobar.funcionJugador(j3, turno, ubicacion, scn, aleatorio);
									if(ubicacion.equalsIgnoreCase("salir")) {
										salir = true;
									}else {
										if(j4.fichas > 0) {
											ubicacion = Comprobar.funcionJugador(j4, turno, ubicacion, scn, aleatorio);
											if(ubicacion.equalsIgnoreCase("salir")) {
												salir = true;
											}
										}
									}
								}
							}
						}
					}
				}
				turno++;
				System.out.println("La bola callo en el numero: " + aleatorio + "\n"
						+ "Puntuacion de " + j1.nombre + " es: " + j1.fichas
						+ "\nPuntuacion de " + j2.nombre + " es: " + j2.fichas
						+ "\nPuntuacion de " + j3.nombre + " es: " + j3.fichas
						+ "\nPuntuacion de " + j4.nombre + " es: " + j4.fichas);
			}while(salir == false);
		}else if(numero_jugadores == 5) {
			Jugador j1 = crearJugador();
			Jugador j2 = crearJugador();
			Jugador j3 = crearJugador();
			Jugador j4 = crearJugador();
			Jugador j5 = crearJugador();
			do {
				if(j1.fichas < 1 && j2.fichas < 1) {
					salir = true;
				}
				Comprobar.tablero();
				int aleatorio = (int) Math.floor(Math.random() * (37));

				if(j1.fichas > 0) {
					ubicacion = Comprobar.funcionJugador(j1, turno, ubicacion, scn, aleatorio);
					if(ubicacion.equalsIgnoreCase("salir")) {
						salir = true;
					}else {
						if(j2.fichas > 0) {
							ubicacion = Comprobar.funcionJugador(j2, turno, ubicacion, scn, aleatorio);
							if(ubicacion.equalsIgnoreCase("salir")) {
								salir = true;
							}else {
								if(j3.fichas > 0) {
									ubicacion = Comprobar.funcionJugador(j3, turno, ubicacion, scn, aleatorio);
									if(ubicacion.equalsIgnoreCase("salir")) {
										salir = true;
									}else {
										if(j4.fichas > 0) {
											ubicacion = Comprobar.funcionJugador(j4, turno, ubicacion, scn, aleatorio);
											if(ubicacion.equalsIgnoreCase("salir")) {
												salir = true;
											}else {
												if(j5.fichas > 0) {
													ubicacion = Comprobar.funcionJugador(j4, turno, ubicacion, scn, aleatorio);
													if(ubicacion.equalsIgnoreCase("salir")) {
														salir = true;
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
				turno++;
				System.out.println("La bola callo en el numero: " + aleatorio + "\n"
						+ "Puntuacion de " + j1.nombre + " es: " + j1.fichas
						+ "\nPuntuacion de " + j2.nombre + " es: " + j2.fichas
						+ "\nPuntuacion de " + j3.nombre + " es: " + j3.fichas
						+ "\nPuntuacion de " + j4.nombre + " es: " + j4.fichas
						+ "\nPuntuacion de " + j5.nombre + " es: " + j5.fichas);
			}while(salir == false);
		}
	}

	private static Jugador crearJugador() {
		String nombre = "";
		
		Jugador jj = new Jugador();
		
		System.out.println("Escriba el nombre/alias del jugador:");
		do {
			nombre = scn.nextLine();
		}while(nombre.isEmpty());
		
		jj.nombre = nombre;
		
		return jj;
	}

	private static void modificarJugadores() {
		String entrada = "";
		System.out.println("Introduce el numero de jugadores:");
		
		do {
			try {
				do {
					entrada = scn.nextLine();
				}while(entrada.isEmpty());
				
				numero_jugadores = Integer.parseInt(entrada);
				
			}catch(NumberFormatException e) {
				System.out.println("\nSe introdujo un caracter no valido, se tomara el anterior valor"
						+ "\nvalido introducido excepto si es la primera vez que entonces"
						+ "\nse volvera a pedir un numero entero\n");
			}
		}while(numero_jugadores < 1 || numero_jugadores > 5);
	}

	private static void tutorial() {
		System.out.println("En el juego de la Ruleta Francesa, al igual que en la Ruleta Americana"
				+ "\ny la Ruleta Europea, hay dos partes, la ruleta, donde se lanza una bola y"
				+ "\ncae al azar en una casilla (desde el cero, hasta el 36) y un tapete, donde"
				+ "\nse realiza (antes de lanzar la bola) la apuesta."
				+ "\nEn esta version de consola del sistema no se vera graficamente el lanzamiento"
				+ "\nde la bola, tan solo se vera el numero correspondiente a la caida de la bola."
				+ "\n\nLas posibles apuestas son:"
				+ "\n\nNUMERO: se elige el numero que se cree en el que caera la bola, [35 a 1]"
				+ "\n\nROJO: se elige que la bola caera en un rojo, [1 a 1]"
				+ "\nNEGRO: se elige que la bola caera en un negro, [1 a 1]"
				+ "\nPAR: se elige que la bola caera en un par, [1 a 1]"
				+ "\nIMPAR: se elige que la bola caera en un impar, [1 a 1]"
				+ "\nFALTA: se elige que la bola caera entre el 1 y el 18, [1 a 1]"
				+ "\nPASA: se elige que la bola caera entre el 19 y el 36, [1 a 1]"
				+ "\n\nDOCENA: se elige que la bola caera en una docena, entre el 1 y el 12 (d1),"
				+ "\nentre el 13 y el 24 (d2) y entre el 25 y el 36 (d3), [2 a 1]"
				+ "\nCOLUMNA: se elige que la bola caera en una columna, [2 a 1]"
				+ "\n(c1) -> 1, 4, 7, 10, 13, 16, 19, 22, 25, 28, 31, o 34"
				+ "\n(c2) -> 2, 5, 8, 11, 14, 17, 20, 23, 26, 29, 32 o 35"
				+ "\n(c3) -> 3, 6, 9, 12, 15, 18, 21, 24, 27, 30, 33, o 36"
				+ "\n\nSolo se puede colocar una ficha por turno y en caso de salir 0"
				+ "\nse pierden todas las apuestas excepto las de tipo [NUMERO], es decir,"
				+ "\nsi se elige un numero diferente a cero y sale cero se gana igualmente.\n\n\n");
	}
}
