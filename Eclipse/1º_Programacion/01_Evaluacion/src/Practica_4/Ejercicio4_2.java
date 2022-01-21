package Practica_4;
import javax.swing.JOptionPane;
//usar la esa libreria para mostrar mensajes en un cuadro de dialogo
//Autor: Ruben Sanz Garcia
//Fecha: 12/11/2020
public class Ejercicio4_2 {
	public static void main(String[] args) {
		float numero;
		
		numero = Float.parseFloat(JOptionPane.showInputDialog("Introduce un numero para saber si es primo"));
		
		while (numero<2) {
			numero = Float.parseFloat(JOptionPane.showInputDialog("El numero escrito no es valido por que es negativo, 0 o 1"));
		}
		
		//error en el if preguntar por que
		if (esPrimo(numero)==true) {
			JOptionPane.showMessageDialog(null,"El numero " + numero + " es primo");
		} else {
			JOptionPane.showMessageDialog(null,"El numero " + numero + " no es primo");
		}
	}
	
	public static boolean esPrimo(float num) {
		boolean valor;
		float i,num1;
		
		num1 = 1;
		i = 0;
		
		while (num1<=num) {
			if ((num % num1)==0) {
				i = i + 1;
			}
			num1 = num1 +1;
		}
		
		if (i == 2) {
			valor = true;
		} else {
			valor = false;
		}
		return valor;
	}
}