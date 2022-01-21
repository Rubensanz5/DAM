package Practica_2;
import javax.swing.JOptionPane;
//usar la esa libreria para mostrar mensajes en un cuadro de dialogo
//Autor: Ruben Sanz Garcia
//Fecha: 3/11/2020
public class Ejercicio2_7 {
	public static void main(String[] args) {
		String modulo;
		float ev1,ev2,ev3,media ;
		
		modulo = JOptionPane.showInputDialog("Escribe el nombre del modulo");
		ev1 = Float.parseFloat(JOptionPane.showInputDialog("Escribe tu nota de la primera evaluacion"));
		ev2 = Float.parseFloat(JOptionPane.showInputDialog("Escribe tu nota de la segunda evaluacion"));
		ev3 = Float.parseFloat(JOptionPane.showInputDialog("Escribe tu nota de la tercera evaluacion"));
		
		
		media = (ev1 + ev2 + ev3)/ 3;
		
		if ((ev1<0 || ev1>10) || (ev2<0 || ev2>10) || (ev3<0 || ev3>10)) {
			JOptionPane.showMessageDialog(null,"Introduce una nota entre 0 y 10");
		} else if (media<5) {
			JOptionPane.showMessageDialog(null,"La nota final del modulo " + modulo + " es Suspenso");
		} else if (media>=5 && media<6) {
			JOptionPane.showMessageDialog(null,"La nota final del modulo " + modulo + " es Aprobado");
		} else if (media>=6 && media<7) {
			JOptionPane.showMessageDialog(null,"La nota final del modulo " + modulo + " es Bien");
		} else if (media>=7 && media<9) {
			JOptionPane.showMessageDialog(null,"La nota final del modulo " + modulo + " es Notable");
		} else if (media>=9 && media<=10) {
			JOptionPane.showMessageDialog(null,"La nota final del modulo " + modulo + " es Sobresaliente");
		}

	}
}
