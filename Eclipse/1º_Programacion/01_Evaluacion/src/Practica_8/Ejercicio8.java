package Practica_8;

import javax.swing.JOptionPane;

public class Ejercicio8 {
	public static void main(String[] args) {
		//declaracion de variables
		String gama, color;
		double precioBase, consumo, potencia, peso, suma, preCoche1, preCoche2 ,preCoche3;
		
		//creacion del 1er objeto con el 1er constructor
		Coche primerCoche = new Coche();
		
		//peticion de dos atributos
		do {
			precioBase = Double.parseDouble(JOptionPane.showInputDialog("Introduce el precio del 2º coche"));
		} while (precioBase < 0);
		
		do {
			peso = Double.parseDouble(JOptionPane.showInputDialog("¿Cuanto pesa el 2º coche?"));
		} while (peso < 0);
		
		//creacion del 2º objeto con el 2º constructor
		Coche segundoCoche = new Coche(precioBase, peso);
		
		//peticion de todos los atributos
		do {
			precioBase = Double.parseDouble(JOptionPane.showInputDialog("Introduce el precio del 3er coche"));
		} while (precioBase < 0);
		
		color = JOptionPane.showInputDialog("Introduce el color del 3er coche (disponibles: blanco, negro, rojo, azul, verde y gris)");
		gama = JOptionPane.showInputDialog("Introduce la gama del 3er coche (Alta, Media, Baja)");
		
		do {
			consumo = Double.parseDouble(JOptionPane.showInputDialog("Introduce el consumo del 3er coche"));
		} while (consumo < 0);
		
		do {
			peso = Double.parseDouble(JOptionPane.showInputDialog("¿Cuanto pesa el 3er coche?"));
		} while (peso < 0);
		
		do {
			potencia = Integer.parseInt(JOptionPane.showInputDialog("Introduce la potencia del 3er coche"));
		} while (potencia < 0);
		
		//creacion del 3er objeto con el 3er constructor
		Coche tercerCoche = new Coche(precioBase, color, gama, consumo, peso, potencia);
		
//		System.out.println(primerCoche.precioBase + " " + primerCoche.color + " " + primerCoche.gama + " " + primerCoche.consumo + " " + primerCoche.peso + " " + primerCoche.potencia);
//		System.out.println(segundoCoche.precioBase + " " + segundoCoche.color + " " + segundoCoche.gama + " " + segundoCoche.consumo + " " + segundoCoche.peso + " " + segundoCoche.potencia);
//		System.out.println(tercerCoche.precioBase + " " + tercerCoche.color + " " + tercerCoche.gama + " " + tercerCoche.consumo + " " + tercerCoche.peso + " " + tercerCoche.potencia);
		
		// si se llama al metrodo desde el println y se suma en el propio println tiene que entrar dos veces y se suma dos veces
		//por eso se ha asignado cada valor a una variable para que solo llame una vez al metodo por objeto y se muestre y sume correctamente
		preCoche1 = primerCoche.precioFinal();
		preCoche2 = segundoCoche.precioFinal();
		preCoche3 = tercerCoche.precioFinal();
		suma = preCoche1 + preCoche2 + preCoche3 ;
		
		JOptionPane.showMessageDialog(null,"El precio del primer coche es: " + preCoche1 + " € \n" +
				"El precio del segundo coche es: " + preCoche2 + " € \n" + 
				"El precio del tercer coche es: " + preCoche3 + " € \n" +
				"El precio total de los tres coches es: " + suma + " €");
		
	}
}
