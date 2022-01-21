package Practica_Navidad.farkle;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Farkle {
	
	static int puntuacion_maxima = 2000;
	
	static Scanner scn = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("\nBienvenido al juego del Farkle, desarrollado por A.David Temiño Monedero\n\n\n");
		try {
			int opcion = -1;

			while(true) {
				System.out.println("Bienvenido al juego del Farkle, elige una opcion:"
						+ "\nOpcion [1]: Empezar partida"
						+ "\nOpcion [2]: Tutorial"
						+ "\nOpcion [3]: Modificar puntuacion maxima"
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
					jugar();
					break;
				case 2:
					tutorial();
					break;
				case 3:
					modificarMaximo();
					break;
				}
			}
		}catch(InputMismatchException e) {

		}
	}

	private static void modificarMaximo() {
		String entrada = "";
		
		System.out.println("Introduce la nueva puntuacion "
				+ "maxima de juego, minimo 2000 y solo numeros enteros");
		do {
			do {
				entrada = scn.nextLine();
				for (int i = 0; i < entrada.length(); i++) {
					if(!Character.isDigit(entrada.charAt(i))) {
						entrada = "";
						i = entrada.length();
					}
				}
			}while(entrada.isEmpty());
			puntuacion_maxima = Integer.parseInt(entrada);
		}while(puntuacion_maxima < 2000);
	}

	private static void tutorial() {
		System.out.println("En el juego del Farkle se enfrentan dos jugadores,"
				+ "\ncada jugador dispone de seis dados que debera tirar"
				+ "\nen su turno, una vez tirados los dados se debara (si es posible)"
				+ "\nelegir los dados puntuables para sumar los puntos"
				+ "\ny volver a tirar los dados restantes o pasar el turno."
				+ "\nSi se logra puntuar todos los dados, se volveran a tirar"
				+ "todos manteniendo los puntos ya acumulados."
				+ "\nSi se tiran los dados y no existe ningun dado puntuable"
				+ "se perdera el turno y los puntos acumulados en dicho turno."
				+ "\n\nLas diferentes puntuaciones posibles son:"
				+ "\n1 dado con un [1] = 100 puntos"
				+ "\n1 dado con un [5] = 50 puntos"
				+ "\n3 dados con un [1] = 1000 puntos"
				+ "\n3 dados con tres numeros iguales (excepto el 1) = numero * 100"
				+ "\n4 dados con cuatro numeros iguales = numero * 200"
				+ "\n5 dados con cinco numeros iguales = numero * 300"
				+ "\n\nEscaleras:"
				+ "\ndel 1 al 5 = 500 puntos"
				+ "\ndel 2 al 6 = 750 puntos"
				+ "\ndel 1 al 6 = 1500 puntos"
				+ "");
	}

	private static void jugar() {
		Jugador j1 = new Jugador();
		Jugador j2 = new Jugador();
		
		int turno = 1;
		
		System.out.println("Introduce el nombre del primer juegador:");
		do {
			j1.nombre = scn.nextLine();
		}while(j1.nombre.isEmpty());
		System.out.println("Introduce el nombre del segundo juegador:");
		do {
			j2.nombre = scn.nextLine();
		}while(j2.nombre.isEmpty());
		
		do {
			System.out.println("Turno [" + turno + "]\nTirada de " + j1.nombre + ":");
			//metodo
			turno++;
			System.out.println("Turno [" + turno + "]\nTirada de " + j2.nombre +":");
			//metodo
			turno++;
		}while(j1.puntos < puntuacion_maxima && j2.puntos < puntuacion_maxima);
	}
	
	@SuppressWarnings("unused")
	private static void jugada(Jugador jj) {
		String pasar = "", seleccion;
		String cadena_numeros = "";
		int d1, d2, d3, d4, d5, d6, numeros_repes = 0;
		
		boolean sd1 = false, sd2 = false, sd3 = false,
				sd4 = false, sd5 = false, sd6 = false;
		
		do {
			if(sd1 == false && sd2 == false && sd3 == false &&
				sd4 == false && sd5 == false && sd6 == false) {
				d1 = (int) (Math.random()*6);
				d2 = (int) (Math.random()*6);
				d3 = (int) (Math.random()*6);
				d4 = (int) (Math.random()*6);
				d5 = (int) (Math.random()*6);
				d6 = (int) (Math.random()*6);
				System.out.println("Dados: [" + d1 + "] [" + d2 + "]"
						+ " [" + d3 + "] [" + d4 + "]"
						+ " [" + d5 + "] [" + d6 + "]");
				
				cadena_numeros = cadena_numeros + d1;
				cadena_numeros = cadena_numeros + d2;
				cadena_numeros = cadena_numeros + d3;
				cadena_numeros = cadena_numeros + d4;
				cadena_numeros = cadena_numeros + d5;
				cadena_numeros = cadena_numeros + d6;
				
				for(int i = 0; i < cadena_numeros.length(); i++) {
					for (int j = 1; j < (cadena_numeros.length() + 1); j++) {
						if(j == cadena_numeros.charAt(i)) {
							numeros_repes++;
						}
					}
				}
				
				if(d1 == 1 || d2 == 1 || d3 == 1 || d4 == 1 || d5 == 1 || d6 == 1
					|| d1 == 5 || d2 == 5 || d3 == 5 || d4 == 5 || d5 == 5 || d6 == 5
					|| numeros_repes > 1) {
					System.out.println("Que dados vas a seleccionar? "
							+ "(introduce la posicion de los dados de uno en uno o pon \"pasar\"): ");
					
				}
				
			}
		}while(!pasar.equalsIgnoreCase("pasar"));
		
	}
}
