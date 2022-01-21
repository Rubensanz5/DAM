package Ejercicios.Hilos.Practica5;

public class Hilo2 implements Runnable{

	private Thread hilo;
	private long suma; 
	private long total;
	
	public Hilo2() {
		suma = 0;
		total = 0;
		hilo = new Thread(this);
	}

	@Override
	public void run() {
		for (int i = 1; i <= 50000; i++) {
			suma += i * 4;
		}
		try {
			Principal.hilo1.getHilo().join();
			total = Principal.hilo1.getSumaTotal() - suma;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		
	}

	public Thread getHilo() {
		return hilo;
	}

	public void setHilo(Thread hilo) {
		this.hilo = hilo;
	}

	public long getSuma() {
		return suma;
	}

	public void setSuma(long suma) {
		this.suma = suma;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

}
