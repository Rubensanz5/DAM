package Evaluacion_02;


public class AppPrueba {

	public AppPrueba() {
		
		Numeros primerObjeto = new Numeros(5, -7);
		Numeros segundoObjeto = new Numeros(10, 4);
		
		System.out.println("El mayor número del primer objeto es " + primerObjeto.compara());
		System.out.println("El mayor número del segundo objeto es " + segundoObjeto.compara());
	}

	public static void main(String[] args) {
		
		new AppPrueba();

	}

}
