package Practica_1;
import javax.swing.JOptionPane;
//usar la esa libreria para mostrar mensajes en un cuadro de dialogo
//Autor: Ruben Sanz Garcia
//Fecha: 30/10/2020
public class Ejercicio1_4 {
	public static void main(String[] args) {
		int base,altura,area;
		
		base = Integer.parseInt(JOptionPane.showInputDialog("Escribe la base del triangulo para calcular el area"));
		altura = Integer.parseInt(JOptionPane.showInputDialog("Escribe la altura del triangulo"));
	
		area = (base * altura) / 2;
	
		JOptionPane.showMessageDialog(null,"El area del triangulo es: " + area);
	}
}
