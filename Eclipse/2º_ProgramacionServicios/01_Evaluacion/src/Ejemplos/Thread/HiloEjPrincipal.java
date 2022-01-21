package Ejemplos.Thread;

public class HiloEjPrincipal {
	public static void main(String[] args) {
		HiloEjemplo hilo;
		for (int i = 0; i < 3; i++) {
			hilo = new HiloEjemplo(i + 1);
			hilo.start();
		}
		System.out.println("Se han creado 3 hilos");
	}
}
