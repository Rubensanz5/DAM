package Evaluacion_01.ev1;

//import javax.swing.JOptionPane;
//usar la esa libreria
public class Ejemplo {
	public static void main(String[] args) {
		suma(1,5);
	}
	
	public static int suma (int n1, int n2) {
		@SuppressWarnings("unused")
		String mensajeFinal;
		mensajeFinal = "suma 1";
		return n1 + n2;
	}
	public static int suma (int n1, int n2, int n3) {
		@SuppressWarnings("unused")
		String mensajeFinal;
		mensajeFinal = "suma 2";
		return n1 + n2 + n3;
	}
	public static int suma (double n1, double n2) {
		@SuppressWarnings("unused")
		String mensajeFinal;
		mensajeFinal = "suma 3";
		return (int) (n1 + n2);
	}
	public static String suma (int n1, int n2, String mensaje) {
		String mensajeFinal;
		mensajeFinal = mensaje + n1 + " mas " + n2 + " = " + (n1 + n2);
		return mensajeFinal;
	}
}
