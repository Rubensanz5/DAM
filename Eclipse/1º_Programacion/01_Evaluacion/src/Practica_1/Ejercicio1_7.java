package Practica_1;
import javax.swing.JOptionPane;
//usar la esa libreria para mostrar mensajes en un cuadro de dialogo
//Autor: Ruben Sanz Garcia
//Fecha: 30/10/2020
public class Ejercicio1_7 {
	public static void main(String[] args) {
		float precio,descuento,preFinal;
		
		precio = Float.parseFloat(JOptionPane.showInputDialog("Escribe el precio del articulo"));
		descuento = Float.parseFloat(JOptionPane.showInputDialog("Escribe el descuento del articulo"));
		
		descuento = descuento / 100;
		
		preFinal = precio * descuento;
		preFinal = precio - preFinal;
		
		JOptionPane.showMessageDialog(null,"El precio final del articulo es: " + preFinal);
	}
}
