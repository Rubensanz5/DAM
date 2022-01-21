package Practica_7;
import javax.swing.JOptionPane;

public class Ejercicio7_1 {
	public static void main(String[] args) {
		String texto;
		int opcion;
		
		texto = JOptionPane.showInputDialog("Introduce un texto: ");
		
		do {
			opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "1. Texto largo \n 2. Acaba en punto \n 3. En mayusculas \n 4. Sin espacios \n 5. Numero de vocales \n 6. Numero de veces de una cadena y posicion \n 7. Texto del reves \n 0. Salir"));
			
			switch (opcion) {
				case 1:
					JOptionPane.showMessageDialog(null,opcion1(texto));
					break;
				case 2:
					JOptionPane.showMessageDialog(null,opcion2(texto));
					break;
				case 3:
					JOptionPane.showMessageDialog(null,opcion3(texto));
					break;
				case 4:
					JOptionPane.showMessageDialog(null,opcion4(texto));
					break;
				case 5:
					JOptionPane.showMessageDialog(null,opcion5(texto));
					break;
				case 6:
					JOptionPane.showMessageDialog(null,opcion6(texto));
					break;
				case 7:
					JOptionPane.showMessageDialog(null,opcion7(texto));
					break;
			}
		} while (opcion != 0);
	}
	
	public static String opcion1(String text) {
		String mensaje = "";
		
		final int NMAX = 25;
		final int NMED = 10;
		final int NMIN = 0;
		
		if (text.length() > NMAX) {
			mensaje = "Texto Largo";
		} else if ((text.length() < NMAX) && (text.length() >= NMED)) {
			mensaje = "Texto medio";
		} else if ((text.length() < NMED) && (text.length() >= NMIN)) {
			mensaje = "Texto corto";
		} else if (text.equals("")) {
			mensaje = "Texto vacio";
		}
		
		return mensaje;
	}
	
	public static String opcion2(String text) {
		String mensaje = "";
		
		if (text.endsWith(".") ) {
			mensaje = "Acaba en punto";
		} else {
			mensaje = "No acaba en punto";
		}
		
		return mensaje;
	}
	
	public static String opcion3(String text) {
		int indice = text.indexOf(" ");
		
		if (indice < 0 ) {
			String mensaje = "Como hay solo una palabra sin espacios se convertira toda la cadena a mayusculas: \n" + text.toUpperCase();
			return mensaje;
		} else {
			String primeraPalabra = text.substring(0, indice) ; //primara palabra dentro de la subcadena
			String restoTexto = text.substring(indice, text.length());
			String palabra1Mayus = primeraPalabra.toUpperCase();
			
			return palabra1Mayus + restoTexto;
		}	
	}
	
	public static String opcion4(String text) {
		String mensaje = "";
		
		mensaje = text.replace(" ", ""); 
			
		return mensaje;
	}
	
	public static String opcion5(String text) {
		String mensaje = "";
		
	    // Contador 
	    int contador = 0;

	    for(int i = 0; i < text.length(); i++) {
	    	String chrs = Integer.toString(text.charAt(i));
	    	
	    	if (chrs.equalsIgnoreCase("a") || chrs.equalsIgnoreCase("e") || chrs.equalsIgnoreCase("i") || 
	    		chrs.equalsIgnoreCase("o") || chrs.equalsIgnoreCase("u")) { 
	    	    contador++;
	    	 }
	    }
	    mensaje = "El texto contiene: " + contador + " vocales";
	    return mensaje;
	}
	
	public static String opcion6(String text) {
		String mensaje = "";
		String busqueda = "";
		
		busqueda = JOptionPane.showInputDialog("Introduce una cadena de texto para saber el numero de veces que aparece y en que posiciones: ");
		
		// Contador de ocurrencias 
	    int contador = 0;
	    String posicion = "";
	    
	    if (busqueda.equals("")) {
	    	mensaje = "Has introducido una cadena vacia";
	    } else {
		    for(int i =  0; (i + busqueda.length()) <= text.length(); i++) {
		    	if (text.substring(i, busqueda.length() + i).equals(busqueda)) {
		    		contador++;
		    		posicion += i + " ";
		    	}
		    }
		    mensaje = "Aparece: " + contador + " vez(s) \n En las posicion(es): " + posicion;
	    }
		return mensaje;
	}
	
	public static String opcion7(String text) {
		String cadenaInvertida = "";
		
		for (int i = text.length() - 1; i >= 0; i--) {
			  cadenaInvertida = cadenaInvertida + text.charAt(i);
		}
		return cadenaInvertida;
	}
}