package Practica_1;
import javax.swing.JOptionPane;
//usar la esa libreria para mostrar mensajes en un cuadro de dialogo
//Autor: Ruben Sanz Garcia
//Fecha: 30/10/2020
public class Ejercicio1_5 {
	public static void main(String[] args) {
		int peso,altura,IMC;
		
		peso = Integer.parseInt(JOptionPane.showInputDialog("Escribe tu peso en Kg"));
		altura = Integer.parseInt(JOptionPane.showInputDialog("Escribe tu altura en cm"));
		
		altura = altura / 100;
		IMC = peso / (altura^2);
		
		JOptionPane.showMessageDialog(null,"Su IMC es: " + IMC);
	}
}
