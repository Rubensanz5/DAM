package Practica_1;
import javax.swing.JOptionPane;
//usar la esa libreria para mostrar mensajes en un cuadro de dialogo
//Autor: Ruben Sanz Garcia
//Fecha: 30/10/2020
public class Ejercicio1_8 {
	public static void main(String[] args) {
		int ev1,ev2,ev3,media;
		String modulo;
		
		modulo = JOptionPane.showInputDialog("Escribe el modulo");
		ev1 = Integer.parseInt(JOptionPane.showInputDialog("Escribe tu nota de la 1ª evaluacion"));
		ev2 = Integer.parseInt(JOptionPane.showInputDialog("Escribe tu nota de la 2ª evaluacion"));
		ev3 = Integer.parseInt(JOptionPane.showInputDialog("Escribe tu nota de la 3ª evaluacion"));
		
		media = (ev1 + ev2 + ev3) / 3;
		
		JOptionPane.showMessageDialog(null,"La nota final del modulo " + modulo + " es: " + media);
	}
}
