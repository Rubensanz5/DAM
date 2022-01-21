package Practica_14;

public class Videojuego implements Colecionable{
	public static String PC = "PC";
	public static String MOVILE = "Movil";
	public static String PLAYSTATION = "PlayStation";
	public static String XBOX = "XBOX";
	public static String SWITCH = "Switch";
	public static String OTHER = "Otros";
	
	public static String[] videojue = {PC,MOVILE,PLAYSTATION,XBOX,SWITCH,OTHER};
	
	private String nombre;
	private String plataforma;
	
	
	public Videojuego(String nombre, String plataforma) {
		this.nombre = nombre;
		this.plataforma = plataforma;
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


	@Override
	public String mostrar() {
		String mensaje = VIDEOJUEGO + "\n" + nombre + "\n" + plataforma;
		return mensaje;
	}
	
}
