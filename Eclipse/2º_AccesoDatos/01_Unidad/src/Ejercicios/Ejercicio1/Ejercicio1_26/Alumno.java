package Ejercicios.Ejercicio1.Ejercicio1_26;

import java.io.Serializable;

public class Alumno implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private int edad;
	private int nMatricula;
	
	public Alumno(String nombre, String apellido1, String apellido2, int edad, int nMatricula) {
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.edad = edad;
		this.nMatricula = nMatricula;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido1() {
		return apellido1;
	}
	
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	
	public String getApellido2() {
		return apellido2;
	}
	
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public int getnMatricula() {
		return nMatricula;
	}
	
	public void setnMatricula(int nMatricula) {
		this.nMatricula = nMatricula;
	}

	@Override
	public String toString() {
		return nombre + " " + apellido1 + " " + apellido2 + " " + edad + " " + nMatricula;
	}
	
	
}
