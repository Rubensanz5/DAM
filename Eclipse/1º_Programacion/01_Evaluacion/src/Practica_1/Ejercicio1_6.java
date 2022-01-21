package Practica_1;
import javax.swing.JOptionPane;
//usar la esa libreria para mostrar mensajes en un cuadro de dialogo
//Autor: Ruben Sanz Garcia
//Fecha: 30/10/2020
public class Ejercicio1_6 {
	public static void main(String[] args) {
		int total,aprov,susp;
		
		aprov = Integer.parseInt(JOptionPane.showInputDialog("Escribe el numero de alumnos aprovados"));
		susp = Integer.parseInt(JOptionPane.showInputDialog("Escribe en numero de alumnos suspensos"));
		
		total = aprov + susp ;
		aprov = (aprov * 100) / total;
		susp = (susp * 100) / total;
		
		JOptionPane.showMessageDialog(null,"El porcentaje de aprovados es de: " + aprov + "% y el de suspensos es de: " + susp + "%");
	}
}
