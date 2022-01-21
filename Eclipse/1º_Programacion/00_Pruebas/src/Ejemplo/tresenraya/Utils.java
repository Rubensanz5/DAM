package Ejemplo.tresenraya;

import javax.swing.JOptionPane;

public class Utils {
	
	public static final String REGEX_NUMERO_CASILLA = "[1-9]";
	
	public static Integer pedirCasilla(String mensaje, String mensajeError) {
		
		String numero;
		
		do {
			numero = (String) JOptionPane.showInputDialog(null, mensaje,
					TresEnRayaApp.TITULO_VENTANA, JOptionPane.PLAIN_MESSAGE);
			
			if (numero != null && !numero.matches(REGEX_NUMERO_CASILLA)) {
				JOptionPane.showMessageDialog(null, mensajeError,
						TresEnRayaApp.TITULO_VENTANA, JOptionPane.ERROR_MESSAGE);
			}
		} while (numero != null && !numero.matches(REGEX_NUMERO_CASILLA));
		
		return numero == null ? null : Integer.parseInt(numero);
		
	}
	
	public static int random(int min, int max) {
		
		return (int) Math.floor(Math.random() * (max - min + 1) + min);
		
	}
	
}