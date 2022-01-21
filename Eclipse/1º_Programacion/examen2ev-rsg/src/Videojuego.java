

public class Videojuego implements Colecionable{
	public static int PC = 1;
	public static int MOVILE = 2;
	public static int PLAYSTATION = 3;
	public static int XBOX = 4;
	public static int SWITCH = 5;
	public static int OTHER = 6;
	
	
	private String nombre;
	private int plataforma;
	private boolean prestado;
	private boolean acabado;
	
	public Videojuego(String nombre, int plataforma) {
		this.nombre = nombre;
		this.plataforma = plataforma;
		prestado = false;
		acabado = false;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(int plataforma) {
		this.plataforma = plataforma;
	}

	public boolean isPrestado() {
		return prestado;
	}

	public void setPrestado(boolean prestado) {
		this.prestado = prestado;
	}

	public boolean isAcabado() {
		return acabado;
	}

	public void setAcabado(boolean acabado) {
		this.acabado = acabado;
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
		if(!acabado) {
			acabado = true;
			return true;
		} else {
			return false;
		}
	}
	
	
	
}
