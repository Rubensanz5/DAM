package Practica_14;

public class Libro implements Colecionable{
	private String titulo;
	private String autor;
	private String editorial;
	private int numPags;
	
	public Libro(String titulo, String autor, String editorial, int numPags) {
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		this.numPags = numPags;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
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

	public int getNumPags() {
		return numPags;
	}

	public void setNumPags(int numPags) {
		this.numPags = numPags;
	}


	@Override
	public String mostrar() {
		String mensaje = LIBRO + "\n" + titulo + "\n" + autor + "\n" + editorial + "\n" + numPags + " páginas";
		return mensaje;
	}



	
	
	
	
}
