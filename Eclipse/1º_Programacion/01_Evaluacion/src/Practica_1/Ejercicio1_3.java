package Practica_1;
import javax.swing.JOptionPane;
//usar la esa libreria para mostrar mensajes en un cuadro de dialogo
//Autor: Ruben Sanz Garcia
//Fecha: 30/10/2020
public class Ejercicio1_3 {
	public static void main(String[] args) {
		int n1,n2,suma,resta,multi,div;
		
		n1 = Integer.parseInt(JOptionPane.showInputDialog("Escribe un numero entero"));
		n2 = Integer.parseInt(JOptionPane.showInputDialog("Escribe otro numero entero"));
		
		suma = n1 + n2;
		resta = n1 - n2;
		multi = n1 * n2;
		div = n1 / n2;
		
		JOptionPane.showMessageDialog(null,"La suma de " + n1 + " y " + n2 + " es igual a : " + suma);
		JOptionPane.showMessageDialog(null,"La resta de " + n1 + " y " + n2 + " es igual a : " + resta);
		JOptionPane.showMessageDialog(null,"La multiplicacion de " + n1 + " y " + n2 + " es igual a : " + multi);
		JOptionPane.showMessageDialog(null,"La division de " + n1 + " y " + n2 + " es igual a : " + div);
	}
}
