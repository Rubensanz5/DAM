package Practica_SS;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class pruebas {

	public static void main(String[] args) {

		Recursos solitario = new JuegosDeCartas("solitario", 3, 50, "img/solitario.jfif");
		Recursos juegoDeCartas2 = new JuegosDeCartas(null, 0, 0, null);
		Recursos juegoDeCartas3 = new JuegosDeCartas(null, 0, 0, null);
		Recursos juegoDeCartas4 = new JuegosDeCartas(null, 0, 0, null);
		Recursos[] array = new Recursos[] {solitario, juegoDeCartas2, juegoDeCartas3, juegoDeCartas4};

		
		int n = 0;
		String[] opciones = {"Anterior", "Prestamo", "Devolucion", "Ver Incidencias", "Ver Prestamos", "Siguiente"};
		String recurso = "";
		String mensaje = "";
		boolean seleccion = false;
		do {
			if(array[n] instanceof JuegosDeMesa) {
				JuegosDeMesa jue = (JuegosDeMesa) array[n];
				recurso = "Juego de Mesa";
				mensaje = jue.mostrarInformacion() ;
			} else if (array[n] instanceof JuegosDeCartas) {
				JuegosDeCartas jueCartas = (JuegosDeCartas) array[n];
				recurso = "Juego de Cartas";
				mensaje = jueCartas.mostrarInformacion() ;
			} else if (array[n] instanceof Libros) {
				Libros libro = (Libros) array[n];
				recurso = "Libro";
				mensaje = libro.mostrarInformacion() ;
			} else if (array[n] instanceof Videojuegos) {
				Videojuegos VideoJue = (Videojuegos) array[n];
				recurso = "Videojuego";
				mensaje = VideoJue.mostrarInformacion() ;
			}
		

			int opcion = JOptionPane.showOptionDialog(null, mensaje,
				 	  recurso + "--->" + array[n].getNombre() ,
					  JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, new ImageIcon(array[n].getImagen()), opciones, "Siguiente");
			
			
		 	switch (opcion) {
			 	case 0:
			 		if(n <= 0) {
			 			
			 		} else {
			 			n--;
			 		}
			 		break;
			 	case 1:
			 		seleccion = true;
			 		break;
			 	case 2:
			 		break;
			 	case 3:
			 		break;
			 	case 4:
			 		break;
			 	case 5:
					if(n >= array.length - 1) {
			 			
			 		} else {
			 			n++;
			 		}
					break;
			 	}
			} while (seleccion == false);

	}

}
