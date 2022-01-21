package Practica_SS;


public class Libros extends Recursos {

	private String autor;
	private String editorial;
	private int numPaginas;
	
	public Libros(String nombre, String autor, String editorial, int numPaginas, int unidadesTotales, String imagen) {
		super(nombre, unidadesTotales, imagen);
		this.autor = autor;
		this.editorial = editorial;
	}
	
	
	public String getAutor() {
		return autor;
	}
	
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public String getEditorial() {
		return editorial;
	}
	
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	
	public int getNumPaginas() {
		return numPaginas;
	}


	public void setNumPaginas(int numPaginas) {
		this.numPaginas = numPaginas;
	}

	@Override
	public String verIncidencias() {
		String mensaje =  "Las incidencias de este libro son: \n ";
		for(String incidencia : getIncidencias()){
			mensaje += incidencia;
		}
		return mensaje;
		
	}

	@Override
	public String mostrarInformacion() {
		String mensaje;
		mensaje = getNombre() + "\n\nAutor: " + autor + "\nEditorial: " + editorial + "\n\nUnidades totales --> " + getUnidadesTotales() 
		+ "\nUnidades disponibles --> " +  (getUnidadesTotales() - getUnidadesUsandose());
		return mensaje;
	}


	
	
}
