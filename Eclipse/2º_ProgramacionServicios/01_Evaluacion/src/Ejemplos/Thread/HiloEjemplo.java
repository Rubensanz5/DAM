package Ejemplos.Thread;

public class HiloEjemplo extends Thread {
	
	private int c;
	private int numHilo;
	
	public HiloEjemplo(int hilo) {
		this.numHilo = hilo;
		System.out.println("CREANDO HILO: " + hilo);
	}
	
	public void run() {
		c = 0;
		while(c <= 5){
			System.out.println("Hilo: " + numHilo + " Contador = " + c);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			c++;
		}
	}

}
