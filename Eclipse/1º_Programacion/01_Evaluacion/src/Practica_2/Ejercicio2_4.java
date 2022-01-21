package Practica_2;
import javax.swing.JOptionPane;
//usar la esa libreria para mostrar mensajes en un cuadro de dialogo
//Autor: Ruben Sanz Garcia
//Fecha: 3/11/2020
public class Ejercicio2_4 {
	public static void main(String[] args) {
		float peso,altura,IMC;
		
		peso = Float.parseFloat(JOptionPane.showInputDialog("Escribe tu peso en Kg para saber tu IMC"));
		altura = Float.parseFloat(JOptionPane.showInputDialog("Escribe tu altura en metros"));
		
		IMC = peso / (altura * altura);
		
		if (peso<0 || altura<0) {
			JOptionPane.showMessageDialog(null,"Datos incorrectos");			
		} else if (IMC<20) {
			JOptionPane.showMessageDialog(null,"Peso insuficiente");
		} else if (IMC>=20 && IMC<25) {
			JOptionPane.showMessageDialog(null,"Peso normal");
		} else if (IMC>=25 && IMC<30) {
			JOptionPane.showMessageDialog(null,"Sobrepeso");
		} else if (IMC>30) {
			JOptionPane.showMessageDialog(null,"Obesidad");	
		}
	}
}
