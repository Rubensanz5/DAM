package Ejemplo.tresenraya;

import javax.swing.JOptionPane;

public class TresEnRayaApp {
	
	public static final String TITULO_VENTANA = "3 en raya";
	
	private static Jugador jugador = new Jugador("Jugador");
	private static CPU cpu = new CPU("CPU");
	private static Tablero tablero = new Tablero();
	
	public static void main(String[] args) {
		
		Jugador ganador;
		int turno = Utils.random(0, 1); // Se elige aleatoriamente quién empieza la partida
		Integer casilla = 0;
		
		JOptionPane.showMessageDialog(null, "Empieza "
				+ (turno % 2 == 0 ? cpu.getNombre() : jugador.getNombre()),
				TITULO_VENTANA, JOptionPane.PLAIN_MESSAGE);
		
		do {
			if (turno++ % 2 != 0) {
				casilla = elegirCasillaJugador();
				if (casilla != null) {
					tablero.colocarFicha(Tablero.FICHA_J1, casilla);
				}
			} else {
				tablero.colocarFicha(Tablero.FICHA_CPU, elegirCasillaCPU());
			}
			
			ganador = comprobarGanador();
		} while (casilla != null && ganador == null && tablero.getTotalCasillasVacias() > 0);
		
		if (casilla == null) {
			JOptionPane.showMessageDialog(null, "Fin de la partida\n\n"
					+ tablero, TITULO_VENTANA, JOptionPane.PLAIN_MESSAGE);
		} else if (ganador != null) {
			JOptionPane.showMessageDialog(null, "El ganador es " + ganador.getNombre() + "\n\n"
					+ tablero, TITULO_VENTANA, JOptionPane.PLAIN_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "La partida ha terminado en empate\n\n"
					+ tablero, TITULO_VENTANA, JOptionPane.PLAIN_MESSAGE);
		}
		
	}
	
	private static Integer elegirCasillaJugador() {
		
		/*
		 * Si el usuario cierra la ventana se termina la partida
		 * Se utiliza un Integer en lugar de un int para poder utilizar
		 * el valor null
		 */
		Integer casilla = 0;
		
		do {
			casilla = Utils.pedirCasilla(jugador.getNombre() + "\n\n" +
					tablero + "\n\n\n\nElige la casilla que quieres ocupar",
					"Debes introducir el número de una casilla vacía");
			
			if (casilla != null && !tablero.comprobarCasillaVacia(--casilla)) {
				JOptionPane.showMessageDialog(null, "Esa casilla ya está ocupada",
						TITULO_VENTANA, JOptionPane.ERROR_MESSAGE);
			}
		} while (casilla != null && !tablero.comprobarCasillaVacia(casilla));
		
		return casilla;
		
	}
	
	private static int elegirCasillaCPU() {
		
		JOptionPane.showMessageDialog(null, cpu.getNombre() + "\n\n"
				+ tablero + "\n\n\n\nTurno de la CPU",
				TITULO_VENTANA, JOptionPane.PLAIN_MESSAGE);
		
		return cpu.elegirCasilla(tablero);
		
	}
	
	// Devuelve el Jugador que haya conseguido las tres en raya
	private static Jugador comprobarGanador() {
		
		char ganador = tablero.comprobarTresEnRaya();
		
		return ganador == Tablero.FICHA_J1 ? jugador
				: (ganador == Tablero.FICHA_CPU ? cpu : null);
		
	}
	
}