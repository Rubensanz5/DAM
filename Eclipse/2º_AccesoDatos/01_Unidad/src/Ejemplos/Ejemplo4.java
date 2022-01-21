package Ejemplos;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ejemplo4 {

	public static void main(String[] args) {
		try {
			File fich = new File("ejemplo4.txt");
			FileOutputStream fileOut = new FileOutputStream(fich);
			DataOutputStream dataOut = new DataOutputStream(fileOut);

			dataOut.writeUTF("Madrid, España");
			dataOut.writeUTF("Lyon, Francia");
			dataOut.writeInt(111111);
			
			dataOut.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
