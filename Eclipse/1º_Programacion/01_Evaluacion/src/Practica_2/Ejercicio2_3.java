package Practica_2;
import javax.swing.JOptionPane;
//usar la esa libreria para mostrar mensajes en un cuadro de dialogo
//Autor: Ruben Sanz Garcia
//Fecha: 3/11/2020
public class Ejercicio2_3 {
	public static void main(String[] args) {
		float n1,resto;
		
		n1 = Float.parseFloat(JOptionPane.showInputDialog("Escribe un numero para saber si es par o impar"));
		
		resto = n1 % 2;
		
		if (n1==0) {

		} else if (resto==0) {
			JOptionPane.showMessageDialog(null,"El numero: " + n1 + " es par " );
		} else {
			JOptionPane.showMessageDialog(null,"El numero: " + n1 + " es impar " );
		}
	}
}
