package ejercicio1;

import java.io.File;
import java.io.RandomAccessFile;


public class Ejercicio1 {

	public static void main(String[] args) {
		File fich1 = new File("fichero1.dat");
		File fich2 = new File("fichero2.dat");
		File fichTotal = new File("ficheroTotal.dat");
		
		String cadena = "";
		int num;

		

		try {
			RandomAccessFile ra1 = new RandomAccessFile(fich1, "r");
			RandomAccessFile ra2 = new RandomAccessFile(fich2, "r");
			
			RandomAccessFile raT = new RandomAccessFile(fichTotal, "rw");
			// Me da un EOFException en el for pero los datos los escribe bien
			for (int i = 0; i < fich1.length(); i++) {
				cadena = "";

				num = ra1.readInt();
			
				for (int j = 0; j < 10; j++) {
					cadena += (char) ra1.readChar();	
				}
				
				if(num != 0) {
					int posicion = calcularPosicion(num);
					raT.seek(posicion);
					
					raT.writeInt(num);
					StringBuffer texto = new StringBuffer(cadena);
					texto.setLength(10);
					raT.writeChars(cadena);
				}
				
			}
			
			

			for (int i = 0; i < fich2.length(); i++) {
				cadena = "";
				num = ra2.readInt();
			
				for (int j = 0; j < 10; j++) {
					cadena += (char) ra2.readChar();	
				}
				if(num != 0) {
					int posicion = calcularPosicion(num);
					raT.seek(posicion);
					
					raT.writeInt(num);
					StringBuffer texto = new StringBuffer(cadena);
					texto.setLength(10);
					raT.writeChars(cadena);
					
				}
				
			}
			
			ra1.close();
			ra2.close();
			raT.close();

		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	public static int calcularPosicion (int id) {
		int posicion = (id - 1) * 24;
		return posicion;
	}
}
