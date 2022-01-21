package Practica_14;

import java.util.Arrays;

public class SerieTV implements Colecionable{
	private String nombre;
	private int numTemporadas;
	private int[] capTemporada;
	
	
	public SerieTV(String nombre, int numTemporadas, int capTemporada[]) {
		this.nombre = nombre;
		this.numTemporadas = numTemporadas;
		this.capTemporada = capTemporada;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getNumTemporadas() {
		return numTemporadas;
	}


	public void setNumTemporadas(int numTemporadas) {
		this.numTemporadas = numTemporadas;
	}


	public int[] getCapTemporada() {
		return capTemporada;
	}


	public void setCapTemporada(int capTemporada[]) {
		this.capTemporada = capTemporada;
	}


	@Override
	public String mostrar() {
		String mensaje = SERIE_TV + "\n" + nombre + "\n" + numTemporadas + "\n" + Arrays.toString(capTemporada) + " capítulos";
		return mensaje;
	}

	
	
}
