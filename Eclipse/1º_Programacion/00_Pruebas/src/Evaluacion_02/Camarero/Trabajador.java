package Evaluacion_02.Camarero;

public class Trabajador {

	String nombre;
	int edad;
	double sueldo;
	
	
	public Trabajador(String nombre, int edad, double sueldo) {
		this.nombre = nombre;
		this.edad = edad;
		this.sueldo = sueldo;
	}
	
	void datosTrabajador() {
		System.out.println("El trabajador " + nombre + " tiene " + edad + " años y cobra: " + sueldo);
	}
	
	double calcularNetoMensual() {
		double sueldoBrutoMensual = sueldo / 14;
		double sueldoNetoMensual;
		
		if(edad >= 25) {
			sueldoNetoMensual = sueldoBrutoMensual - 0.2 * sueldoBrutoMensual;
		} else {
			sueldoNetoMensual = sueldoBrutoMensual;
		}
		return sueldoNetoMensual;
	}

	
}
