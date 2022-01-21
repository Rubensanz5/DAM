package Ejemplos.Thread;

public class HiloDamThread extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 99; i++) {
			try {
				System.out.println("ejecucion hilo");
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
	
}
