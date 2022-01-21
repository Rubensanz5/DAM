package Ejercicios.Hilos.Practica6;

public class Fernando implements Runnable {

	private Thread hilo;
	

	public Fernando() {
		this.hilo = new Thread(this);
	}
	
	@Override
	public void run() {
		do {
			Principal.cuentaBancaria.setPersona("Fernando");
			try {
				Thread.sleep(1);
				Principal.cuentaBancaria.retirarSaldo(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while(Principal.cuentaBancaria.getSaldo() > 0);
	}

	public Thread getHilo() {
		return hilo;
	}

}
