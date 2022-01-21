package Practica_4;
import javax.swing.JOptionPane;
//usar la esa libreria para mostrar mensajes en un cuadro de dialogo
//Autor: Ruben Sanz Garcia
//Fecha: 12/11/2020
public class Ejercicio4_1 {
	public static void main(String[] args) {
		float numero;
		
		numero = Float.parseFloat(JOptionPane.showInputDialog("Introduce un numero para saber si es par y multiplo de 3"));
		
		if (esParMultiploTres(numero)) {
			JOptionPane.showMessageDialog(null,"El numero " + numero + " es par y multiplo de 3");
		} else {
			JOptionPane.showMessageDialog(null,"El numero " + numero + " no es par y multiplo de 3");
		}
	}
	
	public static boolean esParMultiploTres(float num) {
		boolean valor;
		
		if ((num % 2)==0 && (num % 3)==0) {
			valor = true;
		} else {
			valor = false;
		}
		return valor;
	}
}
