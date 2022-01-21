package Practica_1;
import javax.swing.JOptionPane;
//usar la esa libreria para mostrar mensajes en un cuadro de dialogo
//Autor: Ruben Sanz Garcia
//Fecha: 30/10/2020
public class Ejercicio1_2 {
	public static void main(String[] args) {
		int n1,n2,n3;
		
		n1 = Integer.parseInt(JOptionPane.showInputDialog("Escribe un numero entero"));
		n2 = Integer.parseInt(JOptionPane.showInputDialog("Escribe otro numero entero"));
		
		n3 = n2;
		n2 = n1;
		n1 = n3;
		
		JOptionPane.showMessageDialog(null,"El primer numero es : " + n1 + " y el segundo es: " + n2 );
	}
}
