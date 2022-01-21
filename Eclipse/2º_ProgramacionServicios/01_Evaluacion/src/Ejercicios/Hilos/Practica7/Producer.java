package Ejercicios.Hilos.Practica7;

public class Producer implements Runnable {
	private GeneradorDeNumeros genNum;
	private int numero;

	public Producer(GeneradorDeNumeros genNum, int numero) {
		this.genNum = genNum;
		this.numero = numero;
	}

	@Override
	public void run() {
		synchronized (genNum) {
			try {
//				for (int i = 0; i < 30; i++) { para que se generen numero para todos los consumidores
				for (int i = 0; i < 10; i++) {
					while (genNum.isNumGen()) {
						genNum.wait();
					}
					genNum.setNumeroGenerado(i);
					System.out.println("Productor #" + this.numero + " pone: " + i);
					Thread.sleep((int) (Math.random() * 100));
					genNum.notifyAll();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
