package Ejemplos.runneable;

public class HiloRunneable implements Runnable {
	private int c;
	private int numHilo;
	
	public HiloRunneable(int hilo) {
		this.numHilo = hilo;
		System.out.println("CREANDO HILO: " + hilo);
	}
	
	@Override
	public void run() {
		c = 0;
		while(c <= 5){
			System.out.println("Hilo: " + numHilo + " Contador = " + c);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			c++;
		}
	}
}
