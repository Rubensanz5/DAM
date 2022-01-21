package Ejemplos.Hilianonimo;


public class HiloAnonimo {
	public static void main(String[] args) {
	
		Thread hilo = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 3; i++) {
					System.out.println("Instrucciones dentro del hilo");
				}
			}
		});
		hilo.start();
		System.out.println("Hilo principal: sigo ejecutando");
		System.out.println("Fin del Hilo principal");

	}
}
