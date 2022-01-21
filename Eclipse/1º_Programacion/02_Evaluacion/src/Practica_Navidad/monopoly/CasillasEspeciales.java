package Practica_Navidad.monopoly;

public class CasillasEspeciales {
	String nombre;
	int posicion;
	int pagar;
	
	
	public CasillasEspeciales(String nombre, int posicion) {
		this.nombre = nombre;
		this.posicion = posicion;
		}
	public CasillasEspeciales(String nombre, int posicion, int pagar) {
		this.nombre = nombre;
		this.posicion = posicion;
		this.pagar = pagar;
		}

}
