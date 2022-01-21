package Practica_2;
import javax.swing.JOptionPane;
//usar la esa libreria para mostrar mensajes en un cuadro de dialogo
//Autor: Ruben Sanz Garcia
//Fecha: 3/11/2020
public class Ejercicio2_10 {
	public static void main(String[] args) {
		double notaExamen,notaPract,media;
		String practicas;
		
		practicas = JOptionPane.showInputDialog("¿Has realizado todas las practicas?");
		notaExamen = Double.parseDouble(JOptionPane.showInputDialog("Escribe tu nota del examen"));
		notaPract = Double.parseDouble(JOptionPane.showInputDialog("Cual es tu nota de las practicas"));
		
		if ((notaExamen>=0 && notaExamen<=10) || (notaPract>=0 && notaPract<=10)){
			if (!practicas.equalsIgnoreCase("si") && !practicas.equalsIgnoreCase("no")) {
				JOptionPane.showMessageDialog(null,"Inroduce si o no en la pregunta");
			} else if (practicas.equalsIgnoreCase("si")) {
				media = (notaExamen*0.7) + (notaPract*0.3);
				JOptionPane.showMessageDialog(null,"Su nota media es: " + media);
			} else if (practicas.equalsIgnoreCase("no")) {
				media = (notaExamen*0.7) + (notaPract*0.2);
				JOptionPane.showMessageDialog(null,"Su nota media es: " + media);
			}
		} else {
			JOptionPane.showMessageDialog(null,"Introduce una nota del 0 al 10");
		}
	}
}
