package Practica_1;
import javax.swing.JOptionPane;
//usar la esa libreria para mostrar mensajes en un cuadro de dialogo
//Autor: Ruben Sanz Garcia
//Fecha: 30/10/2020
public class Ejercicio1_1 {
	public static void main(String[] args) {
		int n1,n2,suma;
		
		n1 = Integer.parseInt(JOptionPane.showInputDialog("Escribe un numero entero"));
		n2 = Integer.parseInt(JOptionPane.showInputDialog("Escribe otro numero entero"));
		
		suma = n1 + n2;
		
		JOptionPane.showMessageDialog(null,"La suma de " + n1 + " y " + n2 + " es igual a : " + suma);
	}
}
