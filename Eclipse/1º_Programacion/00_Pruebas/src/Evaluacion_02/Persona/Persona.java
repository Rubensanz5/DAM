package Evaluacion_02.Persona;

public class Persona implements Comparable<Persona>{
	private String nombre;
	private String apellidos;
	private int edad;
	
	
	public Persona(String nombre, String apellidos, int edad) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		if(edad <= 0) {
			throw new IllegalArgumentException("La edad debe ser mayor que 0");
		}
		this.edad = edad;
	}
	
	@Override
	public int hashCode() {
		return nombre.hashCode() + apellidos.hashCode() + edad;
	}
	
//	public boolean equals() {
//		
//		return false;
//		
//	}


	@Override
	public int compareTo(Persona p2) {
		if (this.edad < p2.edad) {
			return -1;
		} else if (this.edad > p2.edad) {
			return 1;
		} else {
			return 0;
		}
	}
	
}
