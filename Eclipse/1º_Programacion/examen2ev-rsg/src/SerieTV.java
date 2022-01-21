

public class SerieTV implements Colecionable{
	private String nombre;
	private int numTemporadas;
	private int[] capTemporada;
	private boolean prestado;
	private boolean visto;
	
	
	public SerieTV(String nombre, int numTemporadas, int capTemporada[]) {
		this.nombre = nombre;
		this.numTemporadas = numTemporadas;
		this.capTemporada = capTemporada;
		prestado = false;
		visto = false;
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


	public boolean isPrestado() {
		return prestado;
	}


	public void setPrestado(boolean prestado) {
		this.prestado = prestado;
	}


	public boolean isVisto() {
		return visto;
	}


	public void setVisto(boolean visto) {
		this.visto = visto;
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
		if(!visto) {
			visto = true;
			return true;
		} else {
			return false;
		}
	}
	
	
	
	
	
	
}
