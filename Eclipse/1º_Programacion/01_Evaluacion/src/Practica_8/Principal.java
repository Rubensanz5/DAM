package Practica_8;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		double precio, peso, potencia, consumo, coche1, coche2, coche3;
		String color, gama;
		
		Coche1 miCoche = new Coche1();
		
		precio = Double.parseDouble(JOptionPane.showInputDialog("¿Cuanto vale el coche?"));
		peso = Double.parseDouble(JOptionPane.showInputDialog("¿Cuanto pesa el coche?"));
		
		Coche1 tuCoche = new Coche1(precio,peso);
		
		precio = Double.parseDouble(JOptionPane.showInputDialog("¿Cuanto vale el coche?"));
		color = JOptionPane.showInputDialog("De que color es su coche?");
		gama = JOptionPane.showInputDialog("A que gama pertenece su coche?");
		peso = Double.parseDouble(JOptionPane.showInputDialog("¿Cuanto pesa el coche?"));
		potencia = Double.parseDouble(JOptionPane.showInputDialog("¿Que potencia tiene su coche?"));
		consumo = Double.parseDouble(JOptionPane.showInputDialog("¿Cuanto consumo tiene su coche?"));
		
		Coche1 suCoche = new Coche1(precio, color, gama, peso, potencia, consumo);
		
		coche1 = miCoche.precioFinal();
		coche2 = tuCoche.precioFinal();
		coche3 = suCoche.precioFinal();
		
		JOptionPane.showMessageDialog(null, "El precio de mi coche es: " + coche1 + " €" +
											"El precio de tu coche es: " + coche2 + " €" + 
											"El precio de su coche es: " + coche3 + " €" + 
											"El precio total de los 3 coches es: " + (coche1 + coche2 + coche3 ) + " €");
		
		
	}

}
