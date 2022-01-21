package Ejercicios.Hilos.Practica6;

public class Isabel implements Runnable {

	private Thread hilo;
	

	public Isabel() {
		this.hilo = new Thread(this);
	}
	
	@Override
	public void run() {
		do {
			Principal.cuentaBancaria.setPersona("Isabel");
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
