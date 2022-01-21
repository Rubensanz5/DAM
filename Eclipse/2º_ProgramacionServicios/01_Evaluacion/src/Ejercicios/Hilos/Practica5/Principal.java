package Ejercicios.Hilos.Practica5;

public class Principal {
	static Hilo1 hilo1 = new Hilo1();
	
	public static void main(String[] args) {
		
		
		Hilo2 hilo2 = new Hilo2();
		
		hilo1.getHilo().start();
		hilo2.getHilo().start();
		
		do {
			System.out.println("Calculando resultado...");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while(hilo2.getHilo().isAlive()); 
		
		System.out.println("El resultado total es: " + hilo2.getTotal());
	}

}
