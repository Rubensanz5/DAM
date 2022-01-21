package Ejercicios.Ejercicio1.Ejercicio1_37;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import com.thoughtworks.xstream.XStream;

import Ejercicios.Ejercicio1.Ejercicio1_26.Alumno;

public class Ejercicio1_37 {
	public static void main(String[] args) {
		try {
			ListaAlumnos listaAlumn = new ListaAlumnos();
			
		
		
			FileInputStream fichI = new FileInputStream("ficheros\\fichAlumn.txt");
			ObjectInputStream objIn = new ObjectInputStream(fichI);
		
			while (fichI.available() != 0) {
				Alumno al = (Alumno) objIn.readObject();
				listaAlumn.add(al);
				
			}
			XStream xs = new XStream();
			
			xs.alias("Alumnos", ListaAlumnos.class);
			xs.alias("Alumno", Alumno.class);
			String xml = "";
			
			xs.addImplicitCollection(ListaAlumnos.class, "lista");
			xml = xs.toXML(listaAlumn);
			System.out.println(xml);
			
			xs.toXML(listaAlumn,new FileOutputStream("ficheros\\xml\\alumnos37.xml"));
			
			objIn.close();
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
