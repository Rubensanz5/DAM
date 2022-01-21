package Practica_4;
import javax.swing.JOptionPane;
//usar la esa libreria para mostrar mensajes en un cuadro de dialogo
//Autor: Ruben Sanz Garcia
//Fecha: 12/11/2020
public class Ejercicio4_5 {
	public static void main(String[] args) {
		double cant;
		String moneda;
		
		cant = Double.parseDouble(JOptionPane.showInputDialog("Escribe la cantidad en euros a convertir"));
		moneda = JOptionPane.showInputDialog("A que moneda lo quieres convertir (libra,yuan o dolar)");
		
		switch (moneda) {
			case "libra":
				JOptionPane.showMessageDialog(null,"Su cambio es: " + cambioMoneda(cant,moneda) + " Libras");
				break;

			case "dolar":
				JOptionPane.showMessageDialog(null,"Su cambio es: " + cambioMoneda(cant,moneda) + " Dolares");
				break;
				
			case "yuan":
				JOptionPane.showMessageDialog(null,"Su cambio es: " + cambioMoneda(cant,moneda) + " Yuanes");	
				break;
				
			default:
				JOptionPane.showMessageDialog(null,"La moneda introducida no es correcta");
		}
		 
	
	}
	
	public static double cambioMoneda(double canti, String mon) {
		double cambio = 0;
		
		switch (mon) {
			case "libra":
				canti = canti*0.91;
				cambio = canti;
				break;
				
			case "dolar":
				canti = canti*1.18;
				cambio = canti;
				break;
				
			case "yuan":
				canti = canti*7.89;
				cambio = canti;
				break;
		}
		return cambio;
	}
}
	