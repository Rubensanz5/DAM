package Ejercicios.Ejercicio1.Ejercicio1_33;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class LeerSAX extends DefaultHandler{
	boolean id = false;
	boolean nMatricula = false;
	boolean apellido = false;
	boolean nombre = false;
	boolean ciclo = false;
	boolean curso = false;
	
	
	public void startDocument() {
		System.out.println("--------------------------");
	}
	
	public void endDocument() {
		System.out.println("--------------------------");
		System.out.println("--------------------------");
	}
	
	public void startElement(String uri,String localName, String nombreE, Attributes atts) {		
		if(nombreE.equalsIgnoreCase("alumno")) {
			System.out.println("-------------------------");
			String id = atts.getValue("id");
			System.out.println("ID: " + id);
		}
		
		if(nombreE.equalsIgnoreCase("nummat")) {
			nMatricula = true;
		}
		
		if(nombreE.equalsIgnoreCase("apellidos")) {
			apellido = true;	
		}
		
		if(nombreE.equalsIgnoreCase("nombre")) {
			nombre = true;
		} 

		if(nombreE.equalsIgnoreCase("ciclo")) {
			ciclo = true;
		}
		
		if(nombreE.equalsIgnoreCase("curso")) {
			curso = true;
		}
		
		
	}
	
	public void characters(char[] ch, int inicio, int longitud) {
		if(id) {
			System.out.println("ID: " + new String(ch,inicio,longitud));
			id = false;
		}
		
		if(nMatricula) {
			System.out.println("Numero Matricula: " + new String(ch,inicio,longitud));
			nMatricula = false;
		}
		
		if(apellido) {
			System.out.println("Apellido: " + new String(ch,inicio,longitud));
			apellido = false;
		}
		
		if(nombre) {
			System.out.println("Nombre: " + new String(ch,inicio,longitud));
			nombre = false;
		}
		
		if(ciclo) {
			System.out.println("Ciclo: " + new String(ch,inicio,longitud));
			ciclo = false;
		}
		
		if(curso) {
			System.out.println("Curso: " + new String(ch,inicio,longitud));
			curso = false;
		}
		
		
		
	}
}
