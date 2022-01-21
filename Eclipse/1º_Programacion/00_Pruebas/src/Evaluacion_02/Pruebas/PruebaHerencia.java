package Evaluacion_02.Pruebas;

public class PruebaHerencia {

	public static void main(String[] args) {
		Trabajador trabajador = new Trabajador();
		Camarero trabajador2 = new Camarero();
		Cocinero trabajador3 = new Cocinero();
		
		trabajador.edad = 43;
		trabajador.nombre = "Tomas";
		trabajador.sueldo = 19800;
		trabajador2.propinas = 50;
		
		trabajador.datosTrabajador();
		trabajador2.datosTrabajador();
		trabajador3.datosTrabajador();
	}

}
