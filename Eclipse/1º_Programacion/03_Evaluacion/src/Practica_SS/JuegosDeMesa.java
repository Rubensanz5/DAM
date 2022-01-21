package Practica_SS;



public class JuegosDeMesa extends Recursos {
 
	private String editorial;
	private int numMinJugadores;
	private int numMaxJugadores;
	
	
	public JuegosDeMesa(String nombre, String editorial, int unidadesTotales,int numMinJugadores, int numMaxJugadores, String imagen) {
		super(nombre, unidadesTotales, imagen);
		this.editorial = editorial;
		this.numMinJugadores = numMinJugadores;
		this.numMaxJugadores = numMaxJugadores;
	}
	
	public String getEditorial() {
		return editorial;
	}
	
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	
	public int getNumMinJugadores() {
		return numMinJugadores;
	}
	
	public void setNumMinJugadores(int numMinJugadores) {
		this.numMinJugadores = numMinJugadores;
	}
	
	public int getNumMaxJugadores() {
		return numMaxJugadores;
	}
	
	public void setNumMaxJugadores(int numMaxJugadores) {
		this.numMaxJugadores = numMaxJugadores;
	}

	@Override
	public String verIncidencias() {
		String mensaje =  "Las incidencias de este juego de mesa son: \n ";
		for(String incidencia : getIncidencias()){
			mensaje += incidencia;
		}
		 return mensaje;
	}

	@Override
	public String mostrarInformacion() {
		String mensaje;
		mensaje = getNombre() + "\n\nEditora: " + editorial + "\n(" + numMinJugadores + "-" + numMaxJugadores + ") jugadores \n\nUnidades totales ---> " + getUnidadesTotales() 
		+ "\nUnidades disponibles --> " + (getUnidadesTotales() - getUnidadesUsandose());
		return mensaje;
	}
	
	

	
	
	
	
	
}
