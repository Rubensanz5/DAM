package Practica_2;
import javax.swing.JOptionPane;
//usar la esa libreria para mostrar mensajes en un cuadro de dialogo
//Autor: Ruben Sanz Garcia
//Fecha: 3/11/2020
public class Ejercicio2_2 {
	public static void main(String[] args) {
		float n1,n2,n3;
		
		n1 = Float.parseFloat(JOptionPane.showInputDialog("Escribe un numero"));
		n2 = Float.parseFloat(JOptionPane.showInputDialog("Escribe otro numero"));
		n3 = Float.parseFloat(JOptionPane.showInputDialog("Escribe otro numero para saber cual es mayor de los tres"));
		
		if (n1==n2 && n1==n3) {
			JOptionPane.showMessageDialog(null,"Los tres numeros son iguales " + n1 + " , " + n2 + " y " + n3);
		} else if (n1==n2 && n1>n3) {
			JOptionPane.showMessageDialog(null,"Los dos numeros son iguales " + n1 + " y " + n2);
		} else if (n1>n2) {
			if (n1>n3) {
				JOptionPane.showMessageDialog(null,"El numero mayor es: " + n1);
			} else if (n1<n3) {
				JOptionPane.showMessageDialog(null,"El numero mayor es: " + n3);
			} else {
				JOptionPane.showMessageDialog(null,"Los dos numeros son iguales " + n1 + " y " + n3);
			}
		} else {
			if (n2>n3) {
				JOptionPane.showMessageDialog(null,"El numero mayor es: " + n2);
			} else if (n2<n3) {
				JOptionPane.showMessageDialog(null,"El numero mayor es: " + n3);
			} else {
				JOptionPane.showMessageDialog(null,"Los dos numeros son iguales " + n2 + " y " + n3);
			}
		}
	}
}
