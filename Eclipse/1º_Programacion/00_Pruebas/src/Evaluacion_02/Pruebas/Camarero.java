package Evaluacion_02.Pruebas;

public class Camarero extends Trabajador {
	double propinas;
	
	void mostrarPropinas() {
		System.out.println("El camarero " + nombre + " tiene " + propinas + " € en propinas");
	}
	
	void datosTrabajador() {
		System.out.println("El trabajador " + nombre + " cobra unicamente: " + sueldo);
	}
}
