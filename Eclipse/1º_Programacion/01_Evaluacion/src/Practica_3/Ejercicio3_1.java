package Practica_3;
import javax.swing.JOptionPane;
//usar la esa libreria para mostrar mensajes en un cuadro de dialogo
//Autor: Ruben Sanz Garcia
//Fecha: 10/11/2020
public class Ejercicio3_1 {
	public static void main(String[] args) {
		float n1,i;
		String suma,resta,multi,div;
		
		suma = "";
		resta = "";
		multi = "";
		div = "";
		n1 = 0;
		
		do {	
			n1 = Integer.parseInt(JOptionPane.showInputDialog("Introduce un numero del 1 al 10"));
		
			if ((n1>=1) && (n1<=10)) {
				for (i=1; i<=10; i++){
					suma = suma + ("\n" + n1 + " + " + i + " = " + (n1+i));
				}
				JOptionPane.showMessageDialog(null, "Tabla de la suma" + suma);
				
				for (i=1; i<=10; i++){
					resta = resta + ("\n" + n1 + " - " + i + " = " + (n1-i));	
				}
				JOptionPane.showMessageDialog(null,"Tabla de la resta" + resta);
				
				for (i=1; i<=10; i++){
					multi = multi + ("\n" + n1 + " * " + i + " = " + (n1*i));	
				}
				JOptionPane.showMessageDialog(null,"Tabla de la multiplicacion" + multi);
				
				for (i=1; i<=10; i++){
					div = div + ("\n" + n1 + " / " + i + " = " + (n1/i));	
				}
				JOptionPane.showMessageDialog(null,"Tabla de la division" + div);
				
			} else {
				JOptionPane.showMessageDialog(null,"Error, pon un numero del 1 al 10");			
			}
		} while (n1<1 || n1>10);
	}
}
