package Practica_17;
import java.io.File;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class FicherosApp {
	public static boolean all = false;
	public static ArrayList<File> carpetas = new ArrayList<>(); 
	
	public static void main(String[] args) {
		File fichero = comprobarArgs(args);
		
		if(fichero != null) {
			if(fichero.exists()) {
				if(fichero.isDirectory()) {
					mostrar(fichero,all);
				} else {
					JOptionPane.showMessageDialog(null,datosFich(fichero));
				}
			} else {
				JOptionPane.showMessageDialog(null, "No existe ese parametro", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
	
	public static String datosFich(File fich) {
		String mensaje = "";
		
		if(fich.canRead()) {
			mensaje += "r";
		} else {
			mensaje += "-";
		}
		if (fich.canWrite()) {
			mensaje += "w";
		} else {
			mensaje += "-";
		}	
		if (fich.canExecute()) {
			mensaje += "x"; 
		} else {
			mensaje += "-";
		}
		
		
		long lastModified = fich.lastModified();

		String pattern = "dd 'de' MMMM 'de' yyyy hh:mm aa";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		
		Date lastModifiedDate = new Date(lastModified);

		double sizeKB = fich.length() / 1024.0;			
		mensaje += " ............ " + fich + " ............ " + sizeKB + " kB ............ " + simpleDateFormat.format(lastModifiedDate) + " \n";
		
		return mensaje;
	}
	
	
	public static void mostrar(File fichero, boolean mirarCarpetas) {
		String mensajeD = "";
		String mensajeF = "";
		double tamanoTotal = 0;
		
		File[] listado = fichero.listFiles();
//		Si por ejemplo pasas por parametro c: da error por que al llegar a 'archivos de programa' da nullPointerException por que esta en español y la ruta deberia ser 'Program files' 
//		pero aun dando este error puedes acceder a sus permisos y te dice que existe
//		System.out.println(fichero.getAbsolutePath());
//		System.out.println(fichero.exists());
//		System.out.println(fichero.canExecute());
//		System.out.println(fichero.canRead());
//		System.out.println(fichero.canWrite());
		
		try {
			for (File fich : listado) {
				if(fich.isDirectory()) {
					mensajeD += fich + "\\\n";
					if(mirarCarpetas) {
						carpetas.add(fich);
					}
				} else {
					mensajeF += datosFich(fich);
					tamanoTotal += fich.length() / 1024.0 / 1024.0 ;
				}	
			}
		} catch (NullPointerException ex) {
			ex.printStackTrace();
		}	
		JOptionPane.showMessageDialog(null,mensajeD + mensajeF + "\nTamaño total de: " + new BigDecimal(tamanoTotal).toPlainString() + " MB");
		
		if(mirarCarpetas) {
			for (File carpeta : carpetas) {
				mostrar(carpeta, false);
			}
			
		}
	}
	
	
	public static File comprobarArgs(String[] array) {
		final String ALL_TEXTO = "-all"; 
		File fich = null;
		switch(array.length) {
		 	case 0:
		 		fich = new File(".");
		 		break;
		 	case 1:
		 		if(array[0].equals(ALL_TEXTO)) {
		 			all = true;
		 			fich = new File(".");
		 		} else {
		 			fich = new File(array[0]);
		 		}
		 		break;
		 	case 2:
		 		if(array[0].equals(ALL_TEXTO) || array[1].equals(ALL_TEXTO)) {
		 			all = true;
		 			fich = new File(array[0].equals(ALL_TEXTO)? array[1] : array[0]);
		 		} else {
		 			JOptionPane.showMessageDialog(null, "No puedes meter dos rutas al mismo tiempo", "ERROR", JOptionPane.ERROR_MESSAGE);
		 		}
		 		break;
		 	default:
		 		JOptionPane.showMessageDialog(null, "Hay demasiados argumentos", "ERROR", JOptionPane.ERROR_MESSAGE);
		 		break;
		}
		return fich;
	}

}
