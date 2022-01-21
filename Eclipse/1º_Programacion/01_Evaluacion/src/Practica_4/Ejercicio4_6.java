package Practica_4;
import javax.swing.JOptionPane;
//usar la esa libreria para mostrar mensajes en un cuadro de dialogo
//Autor: Ruben Sanz Garcia
//Fecha: 12/11/2020
public class Ejercicio4_6 {
	public static void main(String[] args) {
		float numeroS,n1,intentos;
		
		JOptionPane.showMessageDialog(null,"Introduce un numero secreto");
		numeroS = introducirNumero();
		
		intentos = 4;
		
		JOptionPane.showMessageDialog(null,"Pon un numero para adivinar el numero sercreto, tienes 4 intentos");
		n1 = introducirNumero();
		
		
		while ((n1!=numeroS) && (intentos>1)) {
			if (comprobarNumero(n1,numeroS)==1) {
				JOptionPane.showMessageDialog(null,"Mas alto");
				intentos = intentos-1;
				
				JOptionPane.showMessageDialog(null, "Te quedan " + intentos + " intento(s):");
				n1 = introducirNumero();
				
			} else if (comprobarNumero(n1,numeroS)==-1) {
				JOptionPane.showMessageDialog(null, "Mas bajo");
				intentos = intentos-1;
				
				JOptionPane.showMessageDialog(null, "Te quedan " + intentos + " intento(s):");
				n1 = introducirNumero();
			}	
		}
		
		if (comprobarNumero(n1,numeroS)==0) {
			JOptionPane.showMessageDialog(null, "¡Enhorabuena! Usted adivino el numero en: " + (5-intentos) + " intentos.");
		} else {
			JOptionPane.showMessageDialog(null, "Fin de la partida, el numero era: " + numeroS);
		}	
	}
	
	public static float introducirNumero() {
		float num,num1;
		
		num = 0;
		
		do {
			num1 = Float.parseFloat(JOptionPane.showInputDialog("Tiene que ser un numero entre el 1 y el 50"));
			if ((num1>=1) && (num1<=50)) {
				num = num1;
			} else {
				JOptionPane.showMessageDialog(null,"Has introducido un numero incorrecto");
			}
		} while ((num1<=1)  || (num1>=50));
		return num;
	}
	
	public static float comprobarNumero(float nUser, float nSec) {
		float val = 2;
		
		if (nUser == nSec) {
			val = 0;  
		}
		if (nUser < nSec) {
			val = 1;  
		}  
		if (nUser > nSec) {
			val = -1;
		}
		return val;
	}
}
	
	