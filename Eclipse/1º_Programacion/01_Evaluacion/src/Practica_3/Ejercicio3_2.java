package Practica_3;
import javax.swing.JOptionPane;
//usar la esa libreria para mostrar mensajes en un cuadro de dialogo
//Autor: Ruben Sanz Garcia
//Fecha: 10/11/2020
public class Ejercicio3_2 {
	public static void main(String[] args) {
		float n1,n2,i;
		
		n1 = Float.parseFloat(JOptionPane.showInputDialog("Escribe un numero para calcular la suma de los multiplos de 3"));
		n2 = 0;
		
		for (i=1; i<=n1; i++) {
			n2 = n2 + i*3;	
		}
		
		JOptionPane.showMessageDialog(null,"La suma de los multiplos es : " + n2);
	}
}
