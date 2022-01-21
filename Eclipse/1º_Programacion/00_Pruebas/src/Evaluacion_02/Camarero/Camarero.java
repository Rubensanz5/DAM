package Evaluacion_02.Camarero;

public class Camarero extends Trabajador {
	double propinas;
	
	
	public Camarero(String nombre, int edad, double sueldo, double propinas) {
		super(nombre, edad, sueldo);
		this.propinas = propinas;
		
	}

	void mostrarPropinas() {
		System.out.println("El camarero " + nombre + " tiene " + propinas + " € en propinas");
	}
	
	void datosTrabajador() {
		System.out.println("El trabajador " + nombre + " cobra unicamente: " + sueldo);
	}
}
