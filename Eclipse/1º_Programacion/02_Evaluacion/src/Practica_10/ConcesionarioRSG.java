package Practica_10;

import javax.swing.JOptionPane;

public class ConcesionarioRSG {

	public static void main(String[] args) {
		Vehiculo vehiculo = new Vehiculo();
		Coche coche = new Coche();
		Furgoneta furgoneta = new Furgoneta();
		
		double precioTotalVehiculo = vehiculo.precioFinal() + coche.precioFinal() + furgoneta.precioFinal();
		double precioTotalCoche = coche.precioFinal();
		double precioTotalFurgoneta = furgoneta.precioFinal();
		
		
		int preg, contador = 3, contCoche = 1,contFurgoneta = 1;
		
		do {
			
			preg = Integer.parseInt(JOptionPane.showInputDialog("Que quieres hacer: \n 0. Salir \n 1. Dar de alta")); 
			
			if (preg == 1){
				
				String[] opciones = {"Vehiculo", "Coche", "Furgoneta"};
				
				 int opcion = JOptionPane.showOptionDialog(null, "De que tipo será :", 
											  "Tipos ", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null , opciones, "Vehiculo");
				if (opcion == 0) {
					contador ++;
					Vehiculo vehiculo0 = crearVehiculo();
					precioTotalVehiculo += vehiculo0.precioFinal();
					vehiculo0.toString();
				} else if (opcion == 1) {
					contador ++;
					contCoche++;
					Coche coche0 = crearCoche();
					precioTotalCoche += coche0.precioFinal();
					precioTotalVehiculo += coche0.precioFinal();
					coche0.toString();
				} else if (opcion == 2){
					contador++;
					contFurgoneta++;
					Furgoneta furgoneta0 = crearFurgoneta();
					precioTotalFurgoneta += furgoneta0.precioFinal();	
					precioTotalVehiculo += furgoneta0.precioFinal();
					furgoneta0.toString();
				}
			}
			
		} while (preg != 0 );
		
		JOptionPane.showMessageDialog(null, "Has dado de alta: " + contador + " vehiculo(s), " + contCoche + " coche(s) y " + contFurgoneta + " furgoneta(s)\n"
									+ "1. El precio de los vehiculos es: " +  precioTotalVehiculo  + "€"
									+ "\n2. El precio de los coches es: " + precioTotalCoche + "€" 
									+ "\n3. El precio de las furgonetas es: " + precioTotalFurgoneta + "€");
	}
	
	
	
	public static Vehiculo crearVehiculo() {
		double precio, peso;
		String color, gama;
		
		
		String atributo = "precio";
		precio = comprobarAtributos(atributo);
		color = seleionarColor();
		gama = seleionarGama();
		atributo = "peso";
		peso = comprobarAtributos(atributo);
		
		Vehiculo vehiculo0 = new Vehiculo(precio, color, gama, peso);
		
		return vehiculo0;
	}
	
	
	public static Coche crearCoche() {
		double precio, peso, potencia;
		String color, gama;
		
		
		String atributo = "precio";
		precio = comprobarAtributos(atributo);
		color = seleionarColor();
		gama = seleionarGama();
		atributo = "peso";
		peso = comprobarAtributos(atributo);
		atributo = "potencia";
		potencia = comprobarAtributos(atributo);
		
		Coche coche0 = new Coche(precio, color, gama, peso,potencia);
		
		return coche0;
	}
	
	public static Furgoneta crearFurgoneta() {
		double precio, capacidad, peso;
		String color, gama, atributo;
		boolean electrico;
		
		
		atributo = "precio";
		precio = comprobarAtributos(atributo);
		color = seleionarColor();
		gama = seleionarGama();
		atributo = "peso";
		peso = comprobarAtributos(atributo);
		atributo = "capacidad";
		capacidad = comprobarAtributos(atributo);
		electrico = comprobarElectrico();
		
		
		Furgoneta furgoneta0 = new Furgoneta(precio, color, gama, peso, capacidad, electrico);
		
		return furgoneta0;
	}
	
	private static double comprobarAtributos(String atributo) {
		double valor;
		do {
			valor = Double.parseDouble(JOptionPane.showInputDialog("¿De cuanto es su " + atributo + "?"));
		} while (valor < 0);
		
		return valor;
	}
	
	public static boolean comprobarElectrico() {
		boolean si = false;
		int electrico;
		electrico = JOptionPane.showConfirmDialog(null,"¿Es electrica?");
		
		if(electrico == JOptionPane.OK_OPTION) {
			si = true;
		} else if(electrico == JOptionPane.NO_OPTION) {
			si = false;
		} else if(electrico == JOptionPane.CLOSED_OPTION) {
			
		}
		return si;
	}
	
	
	private static String seleionarColor() {
		String color = "";
		String[] opciones = {"Blanco", "Negro", "Rojo", "Azul", "Verde", "Gris"};
		
		 int opcion = JOptionPane.showOptionDialog(null, "De que color será :", 
									  "Colores ", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null , opciones, "Blanco");
		if (opcion == 0) {
			color = "Blanco";
		} else if (opcion == 1) {
			color = "Negro";
		} else if (opcion == 2){
			color = "Rojo";
		} else if (opcion == 3){
			color = "Azul";
		} else if (opcion == 4){
			color = "Verde";
		} else if (opcion == 5){
			color = "Gris";
		} 
		
		return color;
	}
	
	private static String seleionarGama() {
		String gama = "";
		String[] opciones = {"Alta", "Media", "Baja"};
		
		 int opcion = JOptionPane.showOptionDialog(null, "De que color será :", 
									  "Colores ", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null , opciones, "Media");
		if (opcion == 0) {
			gama = "Alta";
		} else if (opcion == 1) {
			gama = "Media";
		} else if (opcion == 2){
			gama = "Baja";
		}
		
		return gama;
	}

}
