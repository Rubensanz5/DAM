package Practica_10;

import javax.swing.JOptionPane;

public class Furgoneta extends Vehiculo {
	private double capacidad;
	private boolean electrico;
	
	final static double CAPACIDAD_DEFECTO = 6.5;
	final static double CAPACIDAD_MAX = 7.5;

	public Furgoneta() {
		super();
		this.capacidad = CAPACIDAD_DEFECTO;
	}

	public Furgoneta(double precioBase, double peso) {
		super(precioBase, peso);
		this.capacidad = CAPACIDAD_DEFECTO;
		this.electrico = false;
	}

	public Furgoneta(double precioBase, String color, String gama, double peso, double capacidad, boolean electrico) {
		super(precioBase, color, gama, peso);
		this.capacidad = capacidad;	
		this.electrico = electrico;
	}

	public double getCapacidad() {
		return capacidad;
	}


	public boolean isElectrico() {
		return electrico;
	}
	
	@Override
	public String toString() {
		JOptionPane.showMessageDialog(null, "La furgoneta se ha dado de alta con un precio final de: " + this.precioFinal() + "€");
		return null;
	}
	
	@Override
	public double precioFinal(){
		double precioFin = super.precioFinal();
		
		if (electrico) {
			precioFin += 2850;
		}
		
		if (capacidad > CAPACIDAD_MAX) {
			precioFin += precioFin * 0.3;
		 } 

		return precioFin;
	}
	
}
