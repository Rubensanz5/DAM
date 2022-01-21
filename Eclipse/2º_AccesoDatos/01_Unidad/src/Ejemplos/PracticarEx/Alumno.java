package Ejemplos.PracticarEx;

import java.io.Serializable;

public class Alumno implements Serializable {

	private static final long serialVersionUID = 1L;
	private String nombre;
	private String apellido;
	private int edad;
	private int nmatr;
	
	public Alumno(String nombre, String apellido, int edad, int nmatr) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.nmatr = nmatr;
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



	public int getEdad() {
		return edad;
	}



	public void setEdad(int edad) {
		this.edad = edad;
	}



	public int getNmatr() {
		return nmatr;
	}



	public void setNmatr(int nmatr) {
		this.nmatr = nmatr;
	}



	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", nmatr=" + nmatr + "]";
	}
	
}
