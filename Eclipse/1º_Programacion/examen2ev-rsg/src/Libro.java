

public class Libro implements Colecionable{
	private String titulo;
	private String autor;
	private String editorial;
	private int numPags;
	private boolean prestado;
	private boolean leido;
	
	public Libro(String titulo, String autor, String editorial, int numPags) {
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		this.numPags = numPags;
		prestado = false;
		leido = false;
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

	public boolean isPrestado() {
		return prestado;
	}

	public void setPrestado(boolean prestado) {
		this.prestado = prestado;
	}

	public boolean isLeido() {
		return leido;
	}

	public void setLeido(boolean leido) {
		this.leido = leido;
	}

	@Override
	public boolean prestar() {
		if (!prestado) {
			prestado = true;
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean devolver() {
		if (prestado) {
			prestado = false;
			return true;
		} else {
			return false;
		}
		
	}

	@Override
	public boolean marcarFinalizado() {
		if(!leido) {
			leido = true;
			return true;
		} else {
			return false;
		}
		
	}
	
	
	
	
}
