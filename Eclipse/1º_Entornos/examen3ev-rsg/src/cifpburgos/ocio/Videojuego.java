package cifpburgos.ocio;

import cifpburgos.Usuario;

public class Videojuego implements Coleccionable {
	final static String PC = "PC";
	final static String MOBILE = "Mobile";
	final static String PLAYSTATION = "PlayStation";
	final static String XBOX = "XBOX";
	final static String SWITCH = "Switch";
	final static String OTHER = "Other";
	
	private String nombre;
	private String plataforma;
	private boolean acabado = false;
	private Usuario prestatario;
	

	
	public Videojuego(String nombre, String plataforma, boolean acabado, Usuario prestatario) {
		super();
		this.nombre = nombre;
		this.plataforma = plataforma;
		this.acabado = acabado;
		this.prestatario = prestatario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public boolean isAcabado() {
		return acabado;
	}

	public void setAcabado(boolean acabado) {
		this.acabado = acabado;
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
