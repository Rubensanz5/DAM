package Ejemplos.runneable;

public class HiloConPrioridad implements Runnable {

	int contar;
    Thread hilo;

    static boolean stop = false;
    static String actualNombre;

    // Construye un nuevo hilo.
    HiloConPrioridad(String nombre) {
        hilo = new Thread(this, nombre);
        contar = 0;
        actualNombre = nombre;
    }

    //  Punto de entrada de hilo.
    public void run() {
        System.out.println(hilo.getName() + " iniciando.");
        do {
            contar++;
            if (!actualNombre.equals(hilo.getName())) {
                actualNombre = hilo.getName();
                System.out.println("En "+ actualNombre);
            }
        } while (stop == false && contar < 100000000);
        stop = true;
        System.out.println("\n" + hilo.getName() + " terminado.");
    }
}