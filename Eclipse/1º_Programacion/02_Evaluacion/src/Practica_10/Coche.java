package Practica_10;

import javax.swing.JOptionPane;

public class Coche extends Vehiculo {
	private double potencia;
	
	final static double POTENCIA_DEFECTO = 110;

	public Coche() {
		super();
	}

	public Coche(double precioBase, double peso) {
		super(precioBase, peso);
		this.potencia = POTENCIA_DEFECTO;
	}

	public Coche(double precioBase, String color, String gama, double peso, double potencia) {
		super(precioBase, color, gama, peso);
		this.potencia = potencia;
	}

	public double getPotencia() {
		return potencia;
	}
	
	@Override
	public String toString() {
		JOptionPane.showMessageDialog(null, "El coche se ha dado de alta con un precio final de: " + this.precioFinal() + "€");
		return null;
	}

	@Override
	public double precioFinal(){
		double precioFin = super.precioFinal();
		
		if (potencia >= POTENCIA_DEFECTO) {
			precioFin += 800;
		 } 

		return precioFin;
	}

	
	
}
