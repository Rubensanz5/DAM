package Ejercicios.Ejercicio1.Ejercicio1_26;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Ejercicio1_26 {
	public static void main(String[] args) {
		//Ejercicio 26: Crear la clase Alumno que implementa la interfaz Serializable y, que utilizaremos
//		para escribir y leer objetos en un fichero binario. La clase tiene cuatro atributos: el
//		nombre, los apellidos, la edad y el número de matrícula, y los métodos get para
//		obtener el valor del atributo y set para darle valor. Escribir objetos Alumno en un
//		fichero y finalmente leer dichos objetos del fichero. 
		
		Alumno alumno1 = new Alumno("Pedro", "Perez", "Fernandez", 26, 45642);
		Alumno alumno2 = new Alumno("Maria", "Garcia", "Sanchez", 19, 4521);
		Alumno alumno3 = new Alumno("Sandra", "Sanz", "jimenez", 22, 547456);
		
		
		try {
			FileOutputStream fichO = new FileOutputStream("fichAlumn.txt");
			ObjectOutputStream objOut = new ObjectOutputStream(fichO);
			
			
			objOut.writeObject(alumno1);
			objOut.writeObject(alumno2);
			objOut.writeObject(alumno3);
			
			objOut.close();
			
			FileInputStream fichI = new FileInputStream("fichAlumn.txt");
			ObjectInputStream objIn = new ObjectInputStream(fichI);
			
			Alumno alumn1 = (Alumno) objIn.readObject();
			Alumno alumn2 = (Alumno) objIn.readObject();
			Alumno alumn3 = (Alumno) objIn.readObject();
			
			System.out.println(alumn1.toString() + "\n" + 
					alumn2.toString() + "\n" +
					alumn3.toString() + "\n");
			
			objIn.close();
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}
}
