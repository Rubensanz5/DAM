package Practica_Navidad.monopoly;

import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Monopoly {
	static Scanner entrada = new Scanner(System.in);
	public static void main(String[] args) {
		Jugador jugador1 = crear();
		Jugador jugador2 = crear();
		Jugador jugador3 = crear();
		@SuppressWarnings("unused")
		Tablero monopoly = new Tablero ();
		int turno = 1;
		do {
			if (turno <= 3) {
				Turno(turno, jugador1, jugador2, jugador3);
				turno++;
			}else if (turno > 3) {
				turno = 1;
			}
			
		} while ( jugador1.dinero > 0 && jugador2.dinero > 0 && jugador3.dinero > 0);
		
		switch (turno){
		case 1:
			JOptionPane.showInputDialog(null, jugador1.nombre + " se ha quedado sin dinero, " + jugador2.nombre + " y " + jugador3.nombre + " ganan.", " Fin de partida");
			break;
		case 2:
			JOptionPane.showInputDialog(null, jugador2.nombre + " se ha quedado sin dinero, " + jugador1.nombre + " y " + jugador3.nombre + " ganan.", " Fin de partida");
			break;
		case 3 :
			JOptionPane.showInputDialog(null, jugador3.nombre + " se ha quedado sin dinero, " + jugador1.nombre + " y " + jugador2.nombre + " ganan.", " Fin de partida" );
			break;
			
		}
		
		
		
		
		

	}
	// crear jugadores
		public static Jugador crear () {
			
			String nombre;
			int posicion = 0;
			int numCalles = 0;
			int dinero = 500;
			
			System.out.print("\n Introduce el nombre del jugador: ");
			nombre = entrada.nextLine();
			
			Jugador Jugador = new Jugador (nombre , posicion, numCalles, dinero);
			
			return Jugador;
			
		}
		
		// decidir turno
		@SuppressWarnings("unused")
		public static void Turno (int turno, Jugador jugador1, Jugador jugador2, Jugador jugador3 ) {
			Random r = new Random();
			int dado = r.nextInt(6)+1;
			
			
			switch (turno){
			case 1:
				String [] opciones = {"Tirar dado"};
				int opcion = JOptionPane.showOptionDialog(null,"***TURNO DE " + jugador1.nombre + "***\nDispones de" + jugador1.dinero + "M", "INFORMACION DE " +  jugador1.nombre.toUpperCase() , JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE, null, opciones, "lanzar dado");
				jugador1.posicion =  jugador1.posicion + dado;
				if (jugador1.posicion > 20) {
					jugador1.posicion = jugador1.posicion - 20;
					if (jugador1.posicion!= 0) {
						jugador1.dinero = jugador1.dinero + 200;
					}
				}
				String [] moverFicha = {"Mover Ficha"};
				int moverFichas = JOptionPane.showOptionDialog(null," Has sacado un " + dado + " avanzas hasta la casilla " + jugador1.posicion , "INFORMACION DE " + jugador1.nombre.toUpperCase()  , JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE, null, moverFicha , "Mover Ficha");
				Tablero.casillas(jugador1.posicion, turno, jugador1, jugador2, jugador3 );
				break;
				
			case 2: 
				String [] opciones2 = {"Tirar dado"};
				int opcion2 = JOptionPane.showOptionDialog(null,"***TURNO DE " + jugador2.nombre + "***\nDispones de" + jugador2.dinero + "M", "INFORMACION DE " + jugador2.nombre.toUpperCase()  , JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE, null, opciones2, "lanzar dado");
				jugador2.posicion =  jugador2.posicion + dado;
				if (jugador2.posicion > 20) {
					jugador2.posicion = jugador2.posicion - 20;
					if (jugador2.posicion!= 0) {
						jugador2.dinero = jugador2.dinero + 200;
					}
				}
				String [] moverFicha2 = {"Mover Ficha"};
				int moverFichas2 = JOptionPane.showOptionDialog(null," Has sacado un " + dado + " avanzas hasta la casilla " + jugador1.posicion , "INFORMACION DE " + jugador2.nombre.toUpperCase() , JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE, null, moverFicha2 , "Mover Ficha");
				Tablero.casillas(jugador2.posicion, turno, jugador1, jugador2, jugador3 );
				break;
			case 3 :
				
				String [] opciones3 = {"Tirar dado"};
				int opcion3 = JOptionPane.showOptionDialog(null,"***TURNO DE " + jugador3.nombre + "***\nDispones de" + jugador3.dinero + "M", "INFORMACION DE " + jugador3.nombre.toUpperCase()  , JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE, null, opciones3, "lanzar dado");
				
				jugador3.posicion =  jugador3.posicion + dado;
				if (jugador3.posicion > 20) {
					jugador3.posicion = jugador3.posicion - 20;
					if (jugador3.posicion!= 0) {
						jugador3.dinero = jugador3.dinero + 200;
					}
				}
				String [] moverFicha3 = {"Mover Ficha"};
				int moverFichas3 = JOptionPane.showOptionDialog(null," Has sacado un " + dado + " avanzas hasta la casilla " + jugador1.posicion , "INFORMACION DE" + jugador1.nombre.toUpperCase()  , JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE, null, moverFicha3 , "Mover Ficha");
				Tablero.casillas(jugador3.posicion, turno, jugador1, jugador2, jugador3 );
				break;
			}
			
		}
}
