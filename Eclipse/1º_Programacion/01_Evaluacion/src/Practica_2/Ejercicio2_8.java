package Practica_2;
import javax.swing.JOptionPane;
//usar la esa libreria para mostrar mensajes en un cuadro de dialogo
//Autor: Ruben Sanz Garcia
//Fecha: 3/11/2020
public class Ejercicio2_8 {
	public static void main(String[] args) {
		double precio;
		int tiempo;
		
		tiempo = Integer.parseInt(JOptionPane.showInputDialog("Escribe la estancia en el parking en minutos"));
		
		precio = 0.50;
		
		if (tiempo<0) {
			JOptionPane.showMessageDialog(null,"Introduce un tiempo valido");			
		} else if (tiempo>0 && tiempo<=60) {
			precio = precio + tiempo * (1.35/60);
			JOptionPane.showMessageDialog(null,"El precio de su estancia es: " + precio + " euros");			
		} else if (tiempo>60) {
			precio = (tiempo-60) * (0.90/60) + 1.35;
			JOptionPane.showMessageDialog(null,"El precio de su estancia es: " + precio + " euros");			
		} 
		
	}
}
