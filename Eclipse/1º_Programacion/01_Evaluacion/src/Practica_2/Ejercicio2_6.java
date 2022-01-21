package Practica_2;
import javax.swing.JOptionPane;
//usar la esa libreria para mostrar mensajes en un cuadro de dialogo
//Autor: Ruben Sanz Garcia
//Fecha: 3/11/2020
public class Ejercicio2_6 {
	public static void main(String[] args) {
		int anio;
		anio = Integer.parseInt(JOptionPane.showInputDialog("Escribe un a\u00f1o para saber si es bisiesto"));
		
		if (anio % 4 == 0){
			if (anio % 100 == 0){
				if (anio % 400 != 0){
					JOptionPane.showMessageDialog(null,"El a\u00f1o " + anio + " es bisiesto");
				} else {
					JOptionPane.showMessageDialog(null,"El a\u00f1o " + anio + " no es bisiesto");
				}
			} else {
				JOptionPane.showMessageDialog(null,"El a\u00f1o " + anio + " es bisiesto");
			}
		} else {
			JOptionPane.showMessageDialog(null,"El a\u00f1o " + anio + " no es bisiesto");
		}
	}
}
