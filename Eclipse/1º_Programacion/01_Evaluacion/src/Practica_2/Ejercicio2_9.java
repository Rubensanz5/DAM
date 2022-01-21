package Practica_2;
import javax.swing.JOptionPane;
//usar la esa libreria para mostrar mensajes en un cuadro de dialogo
//Autor: Ruben Sanz Garcia
//Fecha: 3/11/2020
public class Ejercicio2_9 {
	public static void main(String[] args) {
		
		int dia,mes,anio;
		
		dia = Integer.parseInt(JOptionPane.showInputDialog("Escribe un dia de una fecha"));
		mes = Integer.parseInt(JOptionPane.showInputDialog("Escribe el mes de la fecha"));
		anio = Integer.parseInt(JOptionPane.showInputDialog("Escribe el a\u00f1o de la fecha"));	
		
		
		switch (mes) {
			case 1: 
				if (dia>1 && dia<31) {
					JOptionPane.showMessageDialog(null,"La fecha es: " + dia + " Enero " + anio);			
				} else {
					JOptionPane.showMessageDialog(null,"Escribe un dia valido");
				}
				break;
			case 2:
				if (dia>1 && dia<28) {
					JOptionPane.showMessageDialog(null,"La fecha es: " + dia + " Febrero " + anio);			
				} else {
					JOptionPane.showMessageDialog(null,"Escribe un dia valido");
				}
				break;
			case 3: 
				if (dia>1 && dia<31) {
					JOptionPane.showMessageDialog(null,"La fecha es: " + dia + " Marzo " + anio);			
				} else {
					JOptionPane.showMessageDialog(null,"Escribe un dia valido");
				}
			case 4: 
				if (dia>1 && dia<30) {
					JOptionPane.showMessageDialog(null,"La fecha es: " + dia + " Abril " + anio);			
				}
				break;
			case 5: 
				if (dia>1 && dia<31) {
					JOptionPane.showMessageDialog(null,"La fecha es: " + dia + " Mayo " + anio);			
				} else {
					JOptionPane.showMessageDialog(null,"Escribe un dia valido");
				}
				break;
			case 6: 
				if (dia>1 && dia<30) {
					JOptionPane.showMessageDialog(null,"La fecha es: " + dia + " Junio " + anio);			
				} else {
					JOptionPane.showMessageDialog(null,"Escribe un dia valido");
				}
				break;
			case 7: 
				if (dia>1 && dia<31) {
					JOptionPane.showMessageDialog(null,"La fecha es: " + dia + " Julio " + anio);			
				} else {
					JOptionPane.showMessageDialog(null,"Escribe un dia valido");
				}
				break;
			case 8: 
				if (dia>1 && dia<31) {
					JOptionPane.showMessageDialog(null,"La fecha es: " + dia + " Agosto " + anio);			
				} else {
					JOptionPane.showMessageDialog(null,"Escribe un dia valido");
				}
				break;
			case 9: 
				if (dia>1 && dia<30) {
					JOptionPane.showMessageDialog(null,"La fecha es: " + dia + " Septiembre " + anio);			
				} else {
					JOptionPane.showMessageDialog(null,"Escribe un dia valido");
				}
				break;
			case 10: 
				if (dia>1 && dia<31) {
					JOptionPane.showMessageDialog(null,"La fecha es: " + dia + " Octubre " + anio);			
				} else {
					JOptionPane.showMessageDialog(null,"Escribe un dia valido");
				}
				break;
			case 11: 
				if (dia>1 && dia<30) {
					JOptionPane.showMessageDialog(null,"La fecha es: " + dia + " Noviembre " + anio);			
				} else {
					JOptionPane.showMessageDialog(null,"Escribe un dia valido");
				}
				break;
			case 12: 
				if (dia>1 && dia<31) {
					JOptionPane.showMessageDialog(null,"La fecha es: " + dia + " Diciembre " + anio);			
				} else {
					JOptionPane.showMessageDialog(null,"Escribe un dia valido");
				}
				break;
			default:
				JOptionPane.showMessageDialog(null,"Escribe un mes valido");
				break;
		}
	}
}
