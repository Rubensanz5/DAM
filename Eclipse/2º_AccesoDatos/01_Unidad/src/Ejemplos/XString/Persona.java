package Ejemplos.XString;

public class Persona {
	private String nombre;
	private String apellido;
	private Tlfon telefono;
	private Tlfon fax;
	
	
	
	public Persona(String nombre, String apellido, Tlfon telefono, Tlfon fax) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.fax = fax;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Tlfon getTelefono() {
		return telefono;
	}
	public void setTelefono(Tlfon telefono) {
		this.telefono = telefono;
	}
	public Tlfon getFax() {
		return fax;
	}
	public void setFax(Tlfon fax) {
		this.fax = fax;
	}
	
	
	
	
}
