package Practica_SS;

import java.util.Arrays;


public class JuegosDeCartas extends Recursos {
 
	private int numCartas;
	private String[] complementos;
	
	public JuegosDeCartas(String nombre, int unidadesTotales, int numCartas, String imagen) {
		super(nombre, unidadesTotales, imagen);
		this.numCartas = numCartas;
	}
	
	public int getNumCartas() {
		return numCartas;
	}
	
	public void setNumCartas(int numCartas) {
		this.numCartas = numCartas;
	}
	
	public String[] getComplementos() {
		return complementos;
	}

	public void setComplementos(String[] complementos) {
		this.complementos = complementos;
	}
	
	@Override
	public String verIncidencias() {
		String mensaje =  "Las incidencias de este juego de cartas son: \n";
		for(String incidencia : getIncidencias()){
			mensaje += incidencia;
		}
		return mensaje;
		
	}
	@Override
	public String mostrarInformacion() {
		String mensaje;
		mensaje = getNombre() + "\n\nNumero de cartas: " + numCartas + "\nNecesita: " +  (complementos == null ? "No necesita nada" : Arrays.toString(complementos)) + "\n\nUnidades totales --> " + getUnidadesTotales() 
		+ "\nUnidades disponibles --> " + (getUnidadesTotales() - getUnidadesUsandose());
		return mensaje;
	}
	
	

	
	
}
