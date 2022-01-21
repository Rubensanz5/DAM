package Practica_Navidad.ruleta_francesa;

import java.util.Scanner;

public class Comprobar {
	/*
	 * Esta clase est� �nica y exclusivamente destinada
	 * a la eliminaci�n de codigo repetitivo del
	 * la clase principal, RuletaJugador.
	 * 
	 * Metodos:
	 * �opcionesValidar(): destinada a comprobar si el
	 * String introducido es valido para continuar
	 * con la ejecucui�n del codigo
	 * �masMenosFichas(): destinada a sumar o restar
	 * fichas del objeto Jugador() pasado por parametro
	 */
	static boolean opcionesValidar(String ubicacion) {
		if(ubicacion.isEmpty() || (!ubicacion.equalsIgnoreCase("negras") && !ubicacion.equalsIgnoreCase("rojas") &&
				!ubicacion.equalsIgnoreCase("par") && !ubicacion.equalsIgnoreCase("impar") &&
				!ubicacion.equalsIgnoreCase("falta") && !ubicacion.equalsIgnoreCase("pasa") &&
				!ubicacion.equalsIgnoreCase("d1") && !ubicacion.equalsIgnoreCase("d2") &&
				!ubicacion.equalsIgnoreCase("d3") && !ubicacion.equalsIgnoreCase("c1") &&
				!ubicacion.equalsIgnoreCase("c2") && !ubicacion.equalsIgnoreCase("c3") &&
				!ubicacion.equalsIgnoreCase("0") && !ubicacion.equalsIgnoreCase("1") &&
				!ubicacion.equalsIgnoreCase("2") && !ubicacion.equalsIgnoreCase("3") &&
				!ubicacion.equalsIgnoreCase("4") && !ubicacion.equalsIgnoreCase("5") &&
				!ubicacion.equalsIgnoreCase("6") && !ubicacion.equalsIgnoreCase("7") &&
				!ubicacion.equalsIgnoreCase("8") && !ubicacion.equalsIgnoreCase("9") &&
				!ubicacion.equalsIgnoreCase("10") && !ubicacion.equalsIgnoreCase("11") &&
				!ubicacion.equalsIgnoreCase("12") && !ubicacion.equalsIgnoreCase("13") &&
				!ubicacion.equalsIgnoreCase("14") && !ubicacion.equalsIgnoreCase("15") &&
				!ubicacion.equalsIgnoreCase("16") && !ubicacion.equalsIgnoreCase("17") &&
				!ubicacion.equalsIgnoreCase("18") && !ubicacion.equalsIgnoreCase("19") &&
				!ubicacion.equalsIgnoreCase("20") && !ubicacion.equalsIgnoreCase("21") &&
				!ubicacion.equalsIgnoreCase("22") && !ubicacion.equalsIgnoreCase("23") &&
				!ubicacion.equalsIgnoreCase("24") && !ubicacion.equalsIgnoreCase("25") &&
				!ubicacion.equalsIgnoreCase("26") && !ubicacion.equalsIgnoreCase("27") &&
				!ubicacion.equalsIgnoreCase("28") && !ubicacion.equalsIgnoreCase("29") &&
				!ubicacion.equalsIgnoreCase("30") && !ubicacion.equalsIgnoreCase("31") &&
				!ubicacion.equalsIgnoreCase("32") && !ubicacion.equalsIgnoreCase("33") &&
				!ubicacion.equalsIgnoreCase("34") && !ubicacion.equalsIgnoreCase("35") &&
				!ubicacion.equalsIgnoreCase("36") && !ubicacion.equalsIgnoreCase("salir"))){
			return true;
		}else {
			return false;
		}
	}

	public static void masMenosFichas(String ubicacion, int aleatorio, Jugador j1) {
		if(ubicacion.equalsIgnoreCase("par")) {
			if(aleatorio % 2 == 0) {
				j1.fichas++;
			}else {
				j1.fichas--;
			}
		}else if(ubicacion.equalsIgnoreCase("impar")) {
			if(aleatorio % 2 != 0) {
				j1.fichas++;
			}else {
				j1.fichas--;
			}
		}else if(ubicacion.equalsIgnoreCase("pasa")) {
			if(aleatorio <= 18) {
				j1.fichas++;
			}else {
				j1.fichas--;
			}
		}else if(ubicacion.equalsIgnoreCase("falta")) {
			if(aleatorio >= 19) {
				j1.fichas++;
			}else {
				j1.fichas--;
			}
		}else if(ubicacion.equalsIgnoreCase("rojas") || ubicacion.equalsIgnoreCase("negras")) {
			if(ubicacion.equalsIgnoreCase("rojas")) {
				if(aleatorio == 0) {
					j1.fichas--;
				} else if(aleatorio == 1 || aleatorio == 3 || aleatorio == 5 || aleatorio == 7
						|| aleatorio == 9 || aleatorio == 12 || aleatorio == 14 || aleatorio == 16
						|| aleatorio == 18 || aleatorio == 19 || aleatorio == 21 || aleatorio == 23
						|| aleatorio == 25 || aleatorio == 27 || aleatorio == 30 || aleatorio == 32
						|| aleatorio == 34 || aleatorio == 36) {
					j1.fichas++;
				}else {
					j1.fichas--;
				}
			}else if(ubicacion.equalsIgnoreCase("negras")) {
				if(aleatorio == 0) {
					j1.fichas--;
				} else if(aleatorio == 2 || aleatorio == 4 || aleatorio == 6 || aleatorio == 8
						|| aleatorio == 10 || aleatorio == 11 || aleatorio == 13 || aleatorio == 15
						|| aleatorio == 17 || aleatorio == 20 || aleatorio == 22 || aleatorio == 24
						|| aleatorio == 26 || aleatorio == 28 || aleatorio == 29 || aleatorio == 31
						|| aleatorio == 33 || aleatorio == 35) {
					j1.fichas++;
				}else {
					j1.fichas--;
				}
			}
		}else if(ubicacion.equalsIgnoreCase("c1") || ubicacion.equalsIgnoreCase("c2") || ubicacion.equalsIgnoreCase("c3")) {
			if(ubicacion.equalsIgnoreCase("c1")) {
				if(aleatorio == 0) {
					j1.fichas--;
				} else if(aleatorio == 1 || aleatorio == 4 || aleatorio == 7 || aleatorio == 10
						|| aleatorio == 13 || aleatorio == 16 || aleatorio == 19 || aleatorio == 22
						|| aleatorio == 25 || aleatorio == 28 || aleatorio == 31 || aleatorio == 34) {
					j1.fichas += 2;
				}else {
					j1.fichas--;
				}
			}else if(ubicacion.equalsIgnoreCase("c2")) {
				if(aleatorio == 0) {
					j1.fichas--;
				} else if(aleatorio == 2 || aleatorio == 5 || aleatorio == 8 || aleatorio == 11
						|| aleatorio == 14 || aleatorio == 17 || aleatorio == 20 || aleatorio == 23
						|| aleatorio == 26 || aleatorio == 29 || aleatorio == 32 || aleatorio == 35) {
					j1.fichas += 2;
				}else {
					j1.fichas--;
				}
			}else if(ubicacion.equalsIgnoreCase("c3")) {
				if(aleatorio == 0) {
					j1.fichas--;
				} else if(aleatorio == 3 || aleatorio == 6 || aleatorio == 9 || aleatorio == 12
						|| aleatorio == 15 || aleatorio == 18 || aleatorio == 21 || aleatorio == 24
						|| aleatorio == 27 || aleatorio == 30 || aleatorio == 33 || aleatorio == 36) {
					j1.fichas += 2;
				}else {
					j1.fichas--;
				}
			}
		}else if(ubicacion.equalsIgnoreCase("d1") || ubicacion.equalsIgnoreCase("d2") || ubicacion.equalsIgnoreCase("d3")) {
			if(ubicacion.equalsIgnoreCase("d1")) {
				if(aleatorio == 0) {
					j1.fichas -= 2;
				} else if(aleatorio > 0 && aleatorio <= 12) {
					j1.fichas += 2;
				}else {
					j1.fichas -= 2;
				}
			}else if(ubicacion.equalsIgnoreCase("d2")) {
				if(aleatorio == 0) {
					j1.fichas -= 2;
				} else if(aleatorio > 12 && aleatorio <= 24) {
					j1.fichas += 2;
				}else {
					j1.fichas -= 2;
				}
			}else if(ubicacion.equalsIgnoreCase("d3")) {
				if(aleatorio == 0) {
					j1.fichas -= 2;
				} else if(aleatorio > 24 && aleatorio <= 36) {
					j1.fichas += 2;
				}else {
					j1.fichas -= 2;
				}
			}
		}else {
			int numero = Integer.parseInt(ubicacion);
			if(aleatorio == 0) {
				j1.fichas += 35;
			}else if(aleatorio == numero) {
				j1.fichas += 35;
			}else {
				j1.fichas --;
			}
		}
	}

	public static void tablero() {
		System.out.println("_____________"
				+ "\n[-] [0] [-] |"
				+ "\n------------|"
				+ "\n(1) [2] (3) |"
				+ "\n[4] (5) [6] |"
				+ "\n(7) [8] (9) | {d1}"
				+ "\n[10][11](12)|"
				+ "\n------------|"
				+ "\n[13](14)[15]|"
				+ "\n(16)[17](18)|"
				+ "\n(19)[20](21)| {d2}"
				+ "\n[22](23)[24]|"
				+ "\n------------|"
				+ "\n(25)[26](27)|"
				+ "\n[28][29](30)|"
				+ "\n[31](32)[33]| {d3}"
				+ "\n(34)[35](36)|"
				+ "\n-------------"
				+ "\n{c1}{c2}{c3}"
				+ "\n\n(rojas)/[negras]"
				+ "\n  par  /  impar"
				+ "\n pasa  /  falta\n\n"
				+ "salir para dejar de jugar\n");
	}

	public static String funcionJugador(Jugador jj, int turno, String ubicacion, Scanner scn, int aleatorio) {
		System.out.println("Tirada numero: " + (turno + 1) + "\n" + jj.nombre + " (fichas restantes: "
				+ jj.fichas + ") donde desea colocar la ficha?:");
		
		ubicacion = "";
		do {
			ubicacion = scn.nextLine();
		}while(Comprobar.opcionesValidar(ubicacion));
		
		if(!ubicacion.equalsIgnoreCase("salir")){
			Comprobar.masMenosFichas(ubicacion, aleatorio, jj);
		}
		return ubicacion;
	}
}
