package Evaluacion_02.knightsapp;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Combate {
	
	private Caballero primerCaballero;
	private Caballero segundoCaballero;
	private int rondas;
	
	public final static int RONDAS_POR_DEFECTO = 10;
	public final static int NUM_TIRADAS_DADO_POR_RONDA = 4;
	public final static int NUM_CARAS_DADO = 8;
	public final static int GANADOR_COMBATE_PRIMER_CABALLERO = 1;
	public final static int GANADOR_COMBATE_SEGUNDO_CABALLERO = 2;
	public final static int GANADOR_COMBATE_EMPATE = 3;
	
	public Combate(Caballero primerCaballero, Caballero segundoCaballero, int rondas) {
		this.primerCaballero = primerCaballero;
		this.segundoCaballero = segundoCaballero;
		if (rondas > 0) {
			this.rondas = rondas;
		} else {
			this.rondas = RONDAS_POR_DEFECTO;
		}
	}
	
	public int iniciar() {

		for (int rondaActual = 1; rondaActual <= this.rondas && primerCaballero.estaVivo() && segundoCaballero.estaVivo(); rondaActual++) {
			iniciarRondaDeCombate();
			mostrarResultadoRonda(rondaActual);
			prepararCaballerosNuevaRonda();
		}

		if (primerCaballero.estaVivo() && !segundoCaballero.estaVivo()) {
			return GANADOR_COMBATE_PRIMER_CABALLERO;
		} else if (segundoCaballero.estaVivo() && !primerCaballero.estaVivo()) {
			return GANADOR_COMBATE_SEGUNDO_CABALLERO;
		} else {
			return GANADOR_COMBATE_EMPATE;
		}
	}
	
	private void iniciarRondaDeCombate() {
		
		// Cálculo del ataque y defensa del primer caballero mediante tirada de dados
		for (int tiradaActual = 1; tiradaActual <= NUM_TIRADAS_DADO_POR_RONDA; tiradaActual++) {
			int numDado = tiradaDado(NUM_CARAS_DADO);
			calcularAtaqueDefensa(primerCaballero, numDado);
		}
		
		// Cálculo del ataque y defensa del segundo caballero mediante tirada de dados
		for (int tiradaActual = 1; tiradaActual <= NUM_TIRADAS_DADO_POR_RONDA; tiradaActual++) {
			int numDado = tiradaDado(NUM_CARAS_DADO);
			calcularAtaqueDefensa(segundoCaballero, numDado);
		}
		
		calcularResultadoRonda();
	}
	
	private void calcularAtaqueDefensa(Caballero caballero, int numDado) {
		if (numDado % 2 == 0) {
			caballero.setAtaque(caballero.getAtaque() + numDado);
		} else {
			caballero.setDefensa(caballero.getDefensa() + numDado);
		}
	}
	
	private void calcularResultadoRonda() {

		int danoPrimerCaballero = primerCaballero.getAtaque() - segundoCaballero.getDefensa();
		if (danoPrimerCaballero > 0) {
			segundoCaballero.setVida(segundoCaballero.getVida() - danoPrimerCaballero);
		}
		
		int danoSegundoCaballero = segundoCaballero.getAtaque() - primerCaballero.getDefensa();
		if (danoSegundoCaballero > 0) {
			primerCaballero.setVida(primerCaballero.getVida() - danoSegundoCaballero);
		}
	}
	
	private void mostrarResultadoRonda(int rondaActual) {
		JOptionPane.showMessageDialog(null, primerCaballero.getNombre() + " vs " + segundoCaballero.getNombre()
				+ " Ronda " + rondaActual + "\n ----------------------------------------------------\n"
				+ " Haces " + primerCaballero.getAtaque() + " puntos de daño\n"
				+ " Tienes " + primerCaballero.getDefensa() + " puntos de defensa\n"
				+ " El enemigo hace " + segundoCaballero.getAtaque() + " puntos de daño\n"
				+ " Y tiene " + segundoCaballero.getDefensa() + " puntos de defensa\n"
				+ "----------------------------------------------------", "Combate", JOptionPane.WARNING_MESSAGE, new ImageIcon("img/espadas.jpg"));
		JOptionPane.showMessageDialog(null, "La ronda se resuelve:\n "
				+ "--------------------------\n"
				+ primerCaballero.getNombre() + ": " + primerCaballero.getVida() + " puntos de vida\n"
				+ segundoCaballero.getNombre() + ": " + segundoCaballero.getVida() + " puntos de vida\n"
				+ "--------------------------", "Combate", JOptionPane.PLAIN_MESSAGE, new ImageIcon("img/espadas.jpg"));
	}
	
	private void prepararCaballerosNuevaRonda() {
		primerCaballero.setAtaque(0);
		segundoCaballero.setAtaque(0);
		primerCaballero.setDefensa(0);
		segundoCaballero.setDefensa(0);
	}
	
	private static int tiradaDado(int maximoDado) {
		int numero = (int) (Math.random() * maximoDado) + 1;
		return numero;
	}

	public Caballero getPrimerCaballero() {
		return primerCaballero;
	}

	public void setPrimerCaballero(Caballero primerCaballero) {
		this.primerCaballero = primerCaballero;
	}

	public Caballero getSegundoCaballero() {
		return segundoCaballero;
	}

	public void setSegundoCaballero(Caballero segundoCaballero) {
		this.segundoCaballero = segundoCaballero;
	}

	public int getRondas() {
		return rondas;
	}

	public void setRondas(int rondas) {
		this.rondas = rondas;
	}

}
