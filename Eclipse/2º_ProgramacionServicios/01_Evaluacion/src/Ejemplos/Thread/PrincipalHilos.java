package Ejemplos.Thread;

public class PrincipalHilos {

	public static void main(String[] args) {
		System.out.println("Se inicia la ejecucion del main");
		HiloDamThread hilo = new HiloDamThread();
		hilo.start();
		for (int i = 0; i < 99; i++) {
			try {
				System.out.println("Ejecucion del main");
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}

	}

}
