package Ejemplos;

public class Jugadores {
	private String nombre;
	private String deporte;
	private String ciudad;
	private int edad;
	private String pais;
	
	public Jugadores(String nombre, String deporte, String ciudad, int edad, String pais) {
		this.nombre = nombre;
		this.deporte = deporte;
		this.ciudad = ciudad;
		this.edad = edad;
		this.pais = pais;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDeporte() {
		return deporte;
	}
	public void setDeporte(String deporte) {
		this.deporte = deporte;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	@Override
	public String toString() {
		return "Nombre: " + nombre + "\nDeporte: " + deporte  + "\nCuidad: " + ciudad + "\nEdad: " + edad  + "\nPais: " + pais;

	}
	
	
	
}
