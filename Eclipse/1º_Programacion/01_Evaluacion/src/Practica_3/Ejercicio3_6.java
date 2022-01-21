package Practica_3;
import javax.swing.JOptionPane;
//usar la esa libreria para mostrar mensajes en un cuadro de dialogo
//Autor: Ruben Sanz Garcia
//Fecha: 11/11/2020
public class Ejercicio3_6 {
	public static void main(String[] args) {
		float intentos,num,num_sec;
		
		intentos = 6;
		
		
		do {
			num_sec =  Float.parseFloat(JOptionPane.showInputDialog("Introduzca un numero secreto que est� entre 1 y 100"));
			if (num_sec<1 || num_sec>100) {
				JOptionPane.showMessageDialog(null,"Error, Tiene que estar entre 1 y 100");
			}
		} while (num_sec<1 || num_sec>100);
		
		do {
			num = Float.parseFloat(JOptionPane.showInputDialog("Adivine el numero secreto que esta entre 1 y 100"));
			if (num<1 || num>100) {
				JOptionPane.showMessageDialog(null,"Error, el numero a adivinar tiene que estar entre 1 y 100");
			}
		} while (num<1 || num>100);
		
		while (num_sec!=num && intentos>1) {
			if (num_sec>num) {
				JOptionPane.showMessageDialog(null,"Muy bajo");
			} else {
				JOptionPane.showMessageDialog(null,"Muy alto");
			}
			intentos = intentos-1;
			JOptionPane.showMessageDialog(null,"Te quedan " + intentos + "intento(s)");
			num = Float.parseFloat(JOptionPane.showInputDialog("Ese no es intentelo de nuevo"));
		}
		
		if (num_sec==num) {
			JOptionPane.showMessageDialog(null,"�Enhorabuena! Usted adivino el numero en: " + (7-intentos) + " intentos");
		} else {
			JOptionPane.showMessageDialog(null,"Fin de la partida, el numero era: " + num_sec);
		}		
	}
}