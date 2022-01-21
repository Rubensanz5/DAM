package Practica_4;
import javax.swing.JOptionPane;
//usar la esa libreria para mostrar mensajes en un cuadro de dialogo
//Autor: Ruben Sanz Garcia
//Fecha: 12/11/2020
public class Ejercicio4_4 {
	public static void main(String[] args) {
		float prestamo,meses,TAE,cuotas;
		
		do {
			prestamo = Float.parseFloat(JOptionPane.showInputDialog("¿De cuanto es su prestamo?"));
		} while (prestamo<=1);
		do {
			meses = Float.parseFloat(JOptionPane.showInputDialog("¿En cuantos meses lo va a devolver?"));
		} while (meses<=1);
		do {
			TAE = Float.parseFloat(JOptionPane.showInputDialog("¿Cual es su % de TAE?"));
		} while (TAE<1 && TAE>100);
		
		cuotas = interesMensualAPagar(prestamo,meses,TAE);
		JOptionPane.showMessageDialog(null,"La cuota mensual es de: " + cuotas + " euros");
	}
	
	public static float interesMensualAPagar(float prest,float mes,float interesAnual) {
		float interes,total;
		interes = (prest + ((prest*interesAnual*mes)/1200));
		
		JOptionPane.showMessageDialog(null,"El interes total es: " + interes + " euros");
		
		total  = ((prest + ((prest*interesAnual*mes)/1200))/mes);
		return total;
	}
}	