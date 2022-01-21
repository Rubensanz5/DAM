package Ejercicios.Hilos.Practica6;

public class Principal {
	
	public static Cuenta cuentaBancaria = new Cuenta();
	
	public static void main(String[] args) {
		Fernando hilo1 = new Fernando();
		Isabel hilo2 = new Isabel();
		
		hilo1.getHilo().start();
		hilo2.getHilo().start();
		
	}
}
