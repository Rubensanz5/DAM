package Evaluacion_02.knightsapp;

public class Caballero {
	
	private String nombre;
	private int vida;
	private int ataque;
	private int defensa;
	
	public Caballero(String nombre, int vida) {
		this.nombre = nombre;
		this.vida = vida;
		this.ataque = 0;
		this.defensa = 0;
	}
	
	public boolean estaVivo() {
		if (this.vida > 0) {
			return true;
		} else {
			return false;
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}
}
