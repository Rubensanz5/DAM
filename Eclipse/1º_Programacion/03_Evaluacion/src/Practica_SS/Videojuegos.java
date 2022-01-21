package Practica_SS;




public class Videojuegos extends Recursos {

	public final static String[] PLATAFORMAS = new String[] {"PC", "PlayStation", "XBOX", "Nintendo Switch"};

	
	private String compañia;
	private String plataforma;
	
	public Videojuegos(String nombre,String compañia,String plataforma, int unidadesTotales, String imagen) {
		super(nombre, unidadesTotales, imagen);
		this.compañia = compañia;
		this.plataforma = plataforma;
		
	}
	public String getCompañia() {
		return compañia;
	}
	
	public void setCompañia(String compañia) {
		this.compañia = compañia;
	}
	
	public String getPlataforma() {
		return plataforma;
	}
	
	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}
	
	
	@Override
	public String verIncidencias() {
		String mensaje =  "Las incidencias de este videojuego son: \n";
		for(String incidencia : getIncidencias()){
			mensaje += incidencia;
		}
		return mensaje;
		
	}
	@Override
	public String mostrarInformacion() {
		String mensaje;
		mensaje = getNombre() + "\n\nCompañia: " + compañia + "\nDisponible para " + plataforma + "\n\nUnidades totales --> " + getUnidadesTotales() 
		+ "\nUnidades disponibles --> " + (getUnidadesTotales() - getUnidadesUsandose());
		return mensaje;
	}
	
	
	

	
	
	
}
