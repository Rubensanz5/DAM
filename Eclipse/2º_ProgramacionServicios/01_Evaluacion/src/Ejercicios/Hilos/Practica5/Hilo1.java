package Ejercicios.Hilos.Practica5;

public class Hilo1 implements Runnable{

	private long sumaTotal;
	private Thread hilo;
	
	
	
	public Hilo1() {
		sumaTotal = 0;
		hilo = new Thread(this);
	}

	@Override
	public void run() {
		for (int i = 1; i <= 100000; i++) {
			sumaTotal += i * 3;
		}
		
	}

	public long getSumaTotal() {
		return sumaTotal;
	}

	public Thread getHilo() {
		return hilo;
	}

	public void setHilo(Thread hilo) {
		this.hilo = hilo;
	}
	
	

}
