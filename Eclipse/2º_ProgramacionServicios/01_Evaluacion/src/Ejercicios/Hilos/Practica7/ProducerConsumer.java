package Ejercicios.Hilos.Practica7;

public class ProducerConsumer {

	public static void main(String[] args) {
		GeneradorDeNumeros generator = new GeneradorDeNumeros();
		Producer productor = new Producer(generator, 1);
		Consumer consumidor1 = new Consumer(generator, 1);
		
		Consumer consumidor2 = new Consumer(generator, 2);
		Consumer consumidor3 = new Consumer(generator, 3);
		
		new Thread(productor).start();
		new Thread(consumidor1).start();
		
		new Thread(consumidor2).start();
		new Thread(consumidor3).start();

		
	}

}
