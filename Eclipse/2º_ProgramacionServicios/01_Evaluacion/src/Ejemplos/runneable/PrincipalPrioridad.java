package Ejemplos.runneable;

public class PrincipalPrioridad {

	public static void main(String[] args) {
		HiloConPrioridad hilo1 = new HiloConPrioridad("Prioridad Alta");
		HiloConPrioridad hilo2 = new HiloConPrioridad("Prioridad Baja");
		HiloConPrioridad hilo3 = new HiloConPrioridad("Prioridad Normal #1");
		HiloConPrioridad hilo4 = new HiloConPrioridad("Prioridad Normal #2");
		HiloConPrioridad hilo5 = new HiloConPrioridad("Prioridad Normal #3");

	    // Establecer prioridades
	    hilo5.hilo.setPriority(Thread.NORM_PRIORITY + 2);
	    hilo1.hilo.setPriority(Thread.NORM_PRIORITY - 2);

	    // Comenzar los hilos
	    hilo1.hilo.start();
	    hilo2.hilo.start();
	    hilo3.hilo.start();
	    hilo4.hilo.start();
	    hilo5.hilo.start();

	    try {
	        hilo1.hilo.join();
	        hilo2.hilo.join();
	        hilo3.hilo.join();
	        hilo4.hilo.join();
	        hilo5.hilo.join();
	    } catch (InterruptedException exc) {
	        System.out.println("Hilo principal interrumpido.");
	    }
	    
        System.out.println("Hilo de alta prioridad #1 ejecutó su bucle " + hilo1.contar);
        System.out.println("Hilo de baja prioridad #2 ejecutó su bucle " + hilo2.contar);
        System.out.println("Hilo prioridad estándar #3 ejecutó su bucle " + hilo3.contar);
        System.out.println("Hilo prioridad estándar #4 ejecutó su bucle " + hilo4.contar);
        System.out.println("Hilo prioridad estándar #5 ejecutó su bucle " + hilo5.contar);
	}

}
