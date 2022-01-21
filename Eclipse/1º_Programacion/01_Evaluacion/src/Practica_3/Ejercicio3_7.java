package Practica_3;
import javax.swing.JOptionPane;
//usar la esa libreria para mostrar mensajes en un cuadro de dialogo
//Autor: Ruben Sanz Garcia
//Fecha: 11/11/2020
public class Ejercicio3_7 {
	public static void main(String[] args) {
		double precio,paga,dev,m2,m1,m50,m20,m10,m05,m02,m01;
		
		do {
			precio = Double.parseDouble(JOptionPane.showInputDialog("�Cuanto vale el articulo que vas a comprar?"));
		} while(precio<0);
		do {
			paga = Double.parseDouble(JOptionPane.showInputDialog("�Con cuanto pagas el articulo? Tiene que ser mayor que el precio que pagas"));
		} while(paga<precio);
		
		m2 = 0;
		m1 = 0;
		m50 = 0;
		m20 = 0;
		m10 = 0;
		m05 = 0;
		m02 = 0;
		m01 = 0;
		
		dev = paga-precio;
		
		do {
			while (dev>=2.00) {
				if (dev>=2.00) {
					m2 = m2+1;
					dev = dev-2.00;
				}
			}
			while (dev>=1.00) {
				if (dev>=1.00) {
					m1 = m1+1;
					dev = dev-1.00;
				}
			}
			while (dev>=0.50) {
				if (dev>=0.50) {
					m50 = m50+1;
					dev = dev-0.50;
				}
			}
			while (dev>=0.20) {
				if (dev>=0.20) {
					m20 = m20+1;
					dev = dev-0.20;
				}
			}
			while (dev>=0.10) {
				if (dev>=0.10) {
					m10 = m10+1;
					dev = dev-0.10;
				}
			}
			while (dev>=0.05) {
				if (dev>=0.05) {
					m05 = m05+1;
					dev = dev-0.05;
				}
			}
			while (dev>=0.02) {
				if (dev>=0.02) {
					m02 = m02+1;
					dev = dev-0.02;
				}
			}
			while (dev>=0.01) {
				if (dev>=0.01) {
					m01 = m01+1;
					dev = dev-0.01;
				}
			}
		} while(dev==0);	
		
		JOptionPane.showMessageDialog(null,"Su cambio son: " + m2 + " moneda(s) de 2eur, " + m1 + " moneda(s) de 1eur, \n" + m50 + " moneda(s) de 50cent, " + m20 + " moneda(s) de 20cent, "
											+ m10 + " moneda(s) de 10cent, \n" + m05 + " moneda(s) de 05cent, " + m02 + " moneda(s) de 02cent, " + m01 + " moneda(s) de 01cent");
		
	}
}