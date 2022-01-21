package Practica_Navidad.monopoly;

public class Calles {
	String nombre;
	int precio;
	int posicion;
	int alquiler;
	boolean comprado = false;
	Jugador dueño = null ;
	
	
	public Calles (String nombre, int precio, int posicion, int alquiler, boolean comprado, Jugador dueño) {
		this.nombre = nombre;
		this.precio = precio;
		this.posicion = posicion;
		this.alquiler = alquiler;
		this.comprado = comprado;
		this.dueño = dueño;
	}
	
	
}
