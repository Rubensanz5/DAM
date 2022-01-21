package Evaluacion_01.ev1;

import javax.swing.JOptionPane;

public class Principal {
	public static void main(String[] args) {
		String marca, modelo, color, cambioAutomatico1;
		int potencia;
		double consumo;
		boolean cambioAutomatico;
		
		marca = JOptionPane.showInputDialog("Introduce la marca");
		modelo = JOptionPane.showInputDialog("Introduce el modelo");
		color = JOptionPane.showInputDialog("Introduce el color");
		potencia = Integer.parseInt(JOptionPane.showInputDialog("Introduce la potencia"));
		consumo = Double.parseDouble(JOptionPane.showInputDialog("Introduce el consumo"));
		cambioAutomatico1 = JOptionPane.showInputDialog("¿Tiene cambio automatico?");
		
		if  (cambioAutomatico1.equalsIgnoreCase("si")) {
			cambioAutomatico = true;
		} else {
			cambioAutomatico = false;
		}
		
		Coche miCoche = new Coche(marca, modelo, color, potencia, consumo, cambioAutomatico);
		Coche miNuevoCoche = new Coche("ford", "mustang", "blanco", 150, 9.5, false);
		
		System.out.println(miCoche.calcularAutoomia(80) + "  kilometros");
		System.out.println(miNuevoCoche.calcularAutoomia(80) + "  kilometros");
		
//		miCoche.marca = "seat";
//		miCoche.modelo = "ibiza";
//		miCoche.color = "gris";
//		miCoche.potencia = 90;
//		miCoche.consumo = 80.5;
//		miCoche.cambioAutomatico = true;
		
		System.out.println(miCoche.marca + " " + miCoche.modelo + " " + miCoche.color + " " + miCoche.potencia + " CV " + miCoche.consumo + " " + miCoche.cambioAutomatico);
		System.out.println(miNuevoCoche.marca + " " + miNuevoCoche.modelo + " " + miNuevoCoche.color + " " + miNuevoCoche.potencia + " CV " + miNuevoCoche.consumo + " " + miNuevoCoche.cambioAutomatico);
	
		
		
	}
}
