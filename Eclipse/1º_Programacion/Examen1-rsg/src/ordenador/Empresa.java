package ordenador;
import javax.swing.JOptionPane;

public class Empresa {

	public static void main(String[] args) {
		int  opcion;

		opcion = Integer.parseInt(JOptionPane.showInputDialog("Introduce una opcion: \n 0. Para Salir \n 1. Dar de alta aun usuario"));
		
		switch (opcion) {
			case 0:
				break;
			case 1:
				String nombreCanal, nombreYoutuber, contenido, precio, adulto = "";
				int edad , numSuscriptores;
				boolean infantil = true;
				
				nombreCanal = JOptionPane.showInputDialog("Introduce el nombre del canal");
				nombreYoutuber = JOptionPane.showInputDialog("Introduce el nombre del youtuber");
				edad = Integer.parseInt(JOptionPane.showInputDialog("Introduce la edad del youtuber"));
				numSuscriptores = Integer.parseInt(JOptionPane.showInputDialog("Introduce el numero de suscriptores del youtuber"));
				contenido = JOptionPane.showInputDialog("El contenido es infantil o para adultos? (Introduce: infantil o adultos)");
				
				if (contenido.equalsIgnoreCase("infantil")) {
					infantil = true;
					adulto = "Infantil: Si";
				} else if (contenido.equalsIgnoreCase("adultos")) {
					infantil = false;
					adulto = "Infantil: No";
				}
				
				
				Youtuber youtuber1 = new Youtuber(nombreCanal, nombreYoutuber, edad, numSuscriptores, infantil);
				
				precio = youtuber1.carcularPrecio();
				
				JOptionPane.showMessageDialog(null, youtuber1.nombreCanal + "\n" +
						youtuber1.nombreYoutuber + "\n" +
						youtuber1.edad + "\n" +
						youtuber1.numSuscriptores + " suscriptores \n" +
						adulto + "\n" + 
						precio);
				break;
		}
	}
}


