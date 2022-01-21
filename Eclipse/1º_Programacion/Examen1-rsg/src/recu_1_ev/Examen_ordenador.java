package recu_1_ev;

import javax.swing.JOptionPane;

public class Examen_ordenador {

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		String gamerTop;
		String menuSalir;
		double gananciasGamerTop = 0;
		
		do {
			menuSalir = JOptionPane.showInputDialog("TOP GAMERS \n 1. Para registrar \n 0. Salir");
		
			if (menuSalir.equals("1")) {
				String nombre = JOptionPane.showInputDialog("Nombre");
				String videojuego = JOptionPane.showInputDialog("En que videojuego");
				char liga = JOptionPane.showInputDialog("En que liga? (A, B o C)").toUpperCase().charAt(0);
				int primerosPuestos = Integer.parseInt(JOptionPane.showInputDialog("Cuantos 1os puestos tiene?"));
				int segundosPuestos = Integer.parseInt(JOptionPane.showInputDialog("Cuantos 2os puestos tiene?"));
				int tercerosPuestos = Integer.parseInt(JOptionPane.showInputDialog("Cuantos 3os puestos tiene?"));
				String estadounidense = JOptionPane.showInputDialog("Es estadounidense?");
				boolean esEstadounidense = "S".equalsIgnoreCase(estadounidense);
				
				Gamer gamer1 = new Gamer(nombre, videojuego, liga, primerosPuestos, segundosPuestos, tercerosPuestos, esEstadounidense);
				
				double gananciasAnuales = gamer1.gananciasAnuales();
				String ganancias;
				
				if (gananciasAnuales == -1) {
					ganancias = "Gamer no profesional";
				} else {
					ganancias = gananciasAnuales + "$";
					if (gananciasAnuales > gananciasGamerTop) {
						gamerTop = gamer1.nombre;
						gananciasGamerTop = gananciasAnuales;
					}
				}
				
				JOptionPane.showMessageDialog(null, gamer1.nombre.toUpperCase() + "\n" + gamer1.videojuego + "\n Liga: " + gamer1.liga + 
						"\n 1º " + gamer1.primerosPuestos + "vece(s) \n 2º " + gamer1.segundosPuestos + "vece(s) \n 3º "
						+ gamer1.tercerosPuestos + "vece(s) \n Es Estadounidense: " + (gamer1.esEstadounidense ? "Si" : "No") + 
						"\n Ganancias Anuales: " + ganancias , "Gamers Top: ", JOptionPane.INFORMATION_MESSAGE);
				
			}
		} while (!(menuSalir.equals("0")));
		
		
	}

}
