package Practica_3;
import javax.swing.JOptionPane;
//usar la esa libreria para mostrar mensajes en un cuadro de dialogo
//Autor: Ruben Sanz Garcia
//Fecha: 10/11/2020
public class Ejercicio3_3 {
	public static void main(String[] args) {
		float n1,cont,media,sum;
		
		cont = 0;
		sum = 0;
		
		n1 = Float.parseFloat(JOptionPane.showInputDialog("Escribe un numero para saber su media"));
		
		sum = sum + n1;
		cont = cont + 1;
		
		if (n1!=-1) {
			while (n1!=-1) {
				n1 = Float.parseFloat(JOptionPane.showInputDialog("Escribe otro numero para calcular la media(Con -1 sales del programa)"));
				if (n1!=-1) {
					sum = sum + n1;
					cont = cont + 1;
				}			
			}
			media = sum/cont;
			JOptionPane.showMessageDialog(null,"La media de los numeros que has puesto es: " + media);
		} else {
			JOptionPane.showMessageDialog(null,"Has introducido -1 y has salido del programa");
		}
		
	}
}
