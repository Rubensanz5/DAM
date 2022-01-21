package Practica_3;
import javax.swing.JOptionPane;
//usar la esa libreria para mostrar mensajes en un cuadro de dialogo
//Autor: Ruben Sanz Garcia
//Fecha: 11/11/2020
public class Ejercicio3_5 {
	public static void main(String[] args) {
		double aforo,entradas,aforoT,n1;
		int opcion = 0;
		
		aforo = Double.parseDouble(JOptionPane.showInputDialog("�Cuanto aforo tiene la sala?"));
		
		aforoT = aforo;
		n1 = aforo*0.20;
		
		while (opcion != 2) {
			JOptionPane.showMessageDialog(null,"�Que quiere hacer?");
			JOptionPane.showMessageDialog(null,"1. Vender entradas");
			JOptionPane.showMessageDialog(null,"2. Salir");
			opcion = Integer.parseInt(JOptionPane.showInputDialog("Elija una opcion: "));
			switch (opcion) {
				case 1:
					do {
						entradas = Double.parseDouble(JOptionPane.showInputDialog("�Cuantas entradas quiere?"));
						if (entradas>0) {
							aforo = aforo-entradas;
							if (aforo>=0) {	
								if (entradas<=aforoT) {
									JOptionPane.showMessageDialog(null,"Quedan " + aforo + " entradas");
									if (aforo<=n1) {
										JOptionPane.showMessageDialog(null,"Hay menos de un 20% de entradas");
									}
								} else {
									JOptionPane.showMessageDialog(null,"Error, pides mas entradas del aforo existente");
								}
							} else if (aforo==0) {
								aforo = 0;
							} else if (aforo<0) {
								JOptionPane.showMessageDialog(null,"No hay tantas entradas ");
								aforo = aforo + entradas;
							}
						} else {
							JOptionPane.showMessageDialog(null,"No puedes meter un numero negativo");
						}
					} while (aforo!=0);
					JOptionPane.showMessageDialog(null,"Ya no hay entradas");
				case 2 :
					break;
				default :	// Cualquier opci�n que introduzca distinta de 1 o 2  es incorrecta
					System.out.println("Opci�n incorrecta\n");
					break;
			}
		}
	}
}

