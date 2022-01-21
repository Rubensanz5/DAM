package Ejemplos.runneable;

public class PrincipalRunneable {

	public static void main(String[] args) {
		HiloRunneable hilo;
		for (int i = 0; i < 3; i++) {
			hilo = new HiloRunneable(i + 1);
			new Thread(hilo).start();
		}
		System.out.println("Se han creado 3 hilos");

	}
}
