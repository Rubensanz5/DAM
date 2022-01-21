package Practica_3;
import javax.swing.JOptionPane;
//usar la esa libreria para mostrar mensajes en un cuadro de dialogo
//Autor: Ruben Sanz Garcia
//Fecha: 10/11/2020
public class Ejercicio3_4 {
	public static void main(String[] args) {
		float n1,nMax,nMin,cont,media,sum;
		
		nMax = -100000;
		//nMax es el numero maximo por tanto la inicializo con un numero muy bajo ya que si se inicializa a 0 si pones numeros negativos el 0 siempre es el mayor 
		nMin = 100000; 
		//nMin es el numero minimo por tanto la inicializo con un numero muy alto ya que si se inicializa a 0 si pones numeros positivos el 0 siempre es el menor 
		cont = 0;
		sum = 0;
		n1 = Float.parseFloat(JOptionPane.showInputDialog("Escribe un número para saber la media y cual es el mayor y menos (Con 0 sales del programa)"));
		
		if (n1!=0){
			do {
				if (n1!=0) {
					if (n1>nMax) {
						nMax = n1;
					} 
					if (n1<nMax || n1<nMin) {
						nMin = n1;
					}
					sum = sum+n1;
					cont = cont+1;
				}	
				n1 = Float.parseFloat(JOptionPane.showInputDialog("Escribe mas números"));
			} while (n1!=0);
			media = sum/cont;
			JOptionPane.showMessageDialog(null,"La media de los números que has puesto es: " + media);
			JOptionPane.showMessageDialog(null,"El numero maximo es: " + nMax + " y el minimo: " + nMin);
		} else {
			JOptionPane.showMessageDialog(null,"Has introducido 0 y has salido del programa");
		}
	}
}

