package Ejercicio1;

public class Consumer implements Runnable {
	private GeneradorDeNumeros genNum;
	private int numero;

	public Consumer(GeneradorDeNumeros genNum, int numero) {
		this.genNum = genNum;
		this.numero = numero;
	}

	@Override
	public void run() {
		synchronized (genNum) {
			try {
				for (int i = 0; i < 10; i++) {
					while (!genNum.isNumGen()) {
						genNum.wait();
					}
					System.out.println("Consumidor #" + this.numero + " obtiene: " + genNum.getNumeroGenerado());
					Thread.sleep((int) (Math.random() * 100));
					genNum.notifyAll();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
