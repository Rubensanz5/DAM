package Practica_4;
import javax.swing.JOptionPane;
//usar la esa libreria para mostrar mensajes en un cuadro de dialogo
//Autor: Ruben Sanz Garcia
//Fecha: 12/11/2020
public class Ejercicio4_3 {
	public static void main(String[] args) {
		int numero;
		
		numero = Integer.parseInt(JOptionPane.showInputDialog("Escribe un numero entero para saber la posicion en la serie de Fibonacci"));
		
		if (numero<=0) {
			JOptionPane.showMessageDialog(null,"Se pide un numero positivo o mayor que 0");
		} else {
			JOptionPane.showMessageDialog(null,"El numero en la posicion " + numero + " es: " + fibo(numero));
		}
	}
	
	public static int fibo(int num) {
		int elementN,n1,n2,sum,i,j;
		
		elementN = 0;
		
		switch (num) {
			case 1:
				n1 = 0;
				elementN = n1;
				break;
			case 2:
				n1 = 0;
				n2 = 1;
				elementN = n2;
				break;
			default:
				n1 = 0;
				n2 = 1;
				j =  num-3;
				for (i=0; i<=j; i++) {
					sum = n1 + n2;
					n1 = n2;
					n2 = sum;
					elementN = sum;
				}
				break;
		}
		return elementN;
	}
}