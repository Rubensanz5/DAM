package cifpburgos.ocio;

import cifpburgos.Usuario;

public class Libro implements Coleccionable {
	
	private String titulo;
	private String autor;
	private String editorial;
	private int paginas;
	private boolean prestado = false;
	private Usuario prestatario;
	
	
	public Libro(String titulo, String autor, String editorial, int paginas, boolean prestado, Usuario prestatario) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		this.paginas = paginas;
		this.prestado = prestado;
		this.prestatario = prestatario;
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

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}

	public boolean isPrestado() {
		return prestado;
	}

	public void setPrestado(boolean prestado) {
		this.prestado = prestado;
	}

	public Usuario getPrestatario() {
		return prestatario;
	}

	public void setPrestatario(Usuario prestatario) {
		this.prestatario = prestatario;
	}

	@Override
	public boolean prestar(Usuario user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean devolver(Usuario user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void marcarFinalizado() {
		// TODO Auto-generated method stub
		
	}

}
