package Evaluacion_02.Camarero;

public class PruebaHerencia {

	public static void main(String[] args) {
		Trabajador trabajador = new Trabajador("Luis", 27, 30000);
		Camarero camarero = new Camarero("Pedro", 30, 40000, 175.00);
		Cocinero cocinero = new Cocinero("Juan", 22, 26660);
		
		System.out.println(camarero.calcularNetoMensual());
		
		trabajador.datosTrabajador();
		camarero.datosTrabajador();
		cocinero.datosTrabajador();
	}

}
