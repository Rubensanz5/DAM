package Practica_3;
import javax.swing.JOptionPane;
//usar la esa libreria
public class Ejercicio3_71 {
	public static void main(String[] args) {
		double precio,paga,dev,monedas,valorMon;
		String cambio = "Su cambio es: \n";
		
		valorMon = 0;
		
		do {
			precio = Double.parseDouble(JOptionPane.showInputDialog("�Cuanto vale el articulo que vas a comprar?"));
		} while(precio<0);
		do {
			paga = Double.parseDouble(JOptionPane.showInputDialog("�Con cuanto pagas el articulo?"));
		} while(paga<precio);
		
		dev = paga-precio;
		
		
		for (int i=1; i<9; i++) {
			monedas = 0;
			switch (i) {
				case 1:
					valorMon = 2;
					while (dev >= valorMon) {
						monedas = monedas + 1;
						dev = dev - valorMon;
					}
					cambio = cambio + (monedas + "moneda(s)" + " de " + valorMon + " euro(s) ");
					//break; habia usado break pero para evitar usarlo he copiado el bucle
				case 2:
					valorMon = 1;
					while (dev >= valorMon) {
						monedas = monedas + 1;
						dev = dev - valorMon;
					}
					cambio = cambio + (monedas + "moneda(s)" + " de " + valorMon + " euro(s) ");
					//break;
				case 3:
					valorMon = 0.50;
					while (dev >= valorMon) {
						monedas = monedas + 1;
						dev = dev - valorMon;
					}
					valorMon = valorMon*100;
					cambio = cambio + (monedas + "moneda(s)" + " de " + valorMon + " c�ntimo(s) ");
					//break;
				case 4:
					valorMon = 0.20;
					while (dev >= valorMon) {
						monedas = monedas + 1;
						dev = dev - valorMon;
					}
					valorMon = valorMon*100;
					cambio = cambio + (monedas + "moneda(s)" + " de " + valorMon + " c�ntimo(s) ");
					//break;
				case 5:
					valorMon = 0.10;
					while (dev >= valorMon) {
						monedas = monedas + 1;
						dev = dev - valorMon;
					}
					valorMon = valorMon*100;
					cambio = cambio + (monedas + "moneda(s)" + " de " + valorMon + " c�ntimo(s) ");
					//break;
				case 6:
					valorMon = 0.05;
					while (dev >= valorMon) {
						monedas = monedas + 1;
						dev = dev - valorMon;
					}
					valorMon = valorMon*100;
					cambio = cambio + (monedas + "moneda(s)" + " de " + valorMon + " c�ntimo(s) ");
					//break;
				case 7:
					valorMon = 0.02;
					while (dev >= valorMon) {
						monedas = monedas + 1;
						dev = dev - valorMon;
					}
					valorMon = valorMon*100;
					cambio = cambio + (monedas + "moneda(s)" + " de " + valorMon + " c�ntimo(s) ");
					//break;
				case 8:
					valorMon = 0.01;
					while (dev >= valorMon) {
						monedas = monedas + 1;
						dev = dev - valorMon;
					}
					valorMon = valorMon*100;
					cambio = cambio + (monedas + "moneda(s)" + " de " + valorMon + " c�ntimo(s) ");
					
			}
			/*while (dev >= valorMon) {
				monedas = monedas + 1;
				dev = dev - valorMon;
			}
			if (monedas > 0) {
				if (i > 2) {
					valorMon = valorMon*100;
					cambio = cambio + (monedas + "moneda(s)" + " de " + valorMon + " c�ntimo(s) ");
				} else {
					cambio = cambio + (monedas + "moneda(s)" + " de " + valorMon + " euro(s) ");
				}	
			}*/
		}
		JOptionPane.showMessageDialog(null,cambio);
	}
}