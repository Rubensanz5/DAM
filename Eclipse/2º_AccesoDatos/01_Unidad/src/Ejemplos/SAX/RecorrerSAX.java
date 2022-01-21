package Ejemplos.SAX;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class RecorrerSAX extends DefaultHandler {
	boolean id = false;
	boolean nombre = false;
	boolean apellido = false;
	boolean edad = false;
	boolean nMatricula = false;
	
	public void startDocument() {
		System.out.println("Comienzo del documento XML");
		System.out.println("--------------------------");
	}
	
	public void endDocument() {
		System.out.println("Final del documento XML");
		System.out.println("--------------------------");
	}
	
	public void startElement(String uri,String localName, String nombreE, Attributes atts) {
		System.out.println("Inicio elemento: " + nombreE);
		
		if(nombreE.equalsIgnoreCase("id")) {
			id = true;
		} 
		
		if(nombreE.equalsIgnoreCase("nombre")) {
			nombre = true;
		} 
		
		if(nombreE.equalsIgnoreCase("apellidos")) {
			apellido = true;	
		}
	
		if(nombreE.equalsIgnoreCase("edad")) {
			edad = true;
		}
		
		if(nombreE.equalsIgnoreCase("nMatricula")) {
			nMatricula = true;
		}
		
		
	}
	
	public void characters(char[] ch, int inicio, int longitud) {
		if(id) {
			System.out.println("\tTexto: " + new String(ch,inicio,longitud));
			id = false;
		}
		
		if(nombre) {
			System.out.println("\tTexto: " + new String(ch,inicio,longitud));
			nombre = false;
		}
		
		if(apellido) {
			System.out.println("\tTexto: " + new String(ch,inicio,longitud));
			apellido = false;
		}
		
		if(edad) {
			System.out.println("\tTexto: " + new String(ch,inicio,longitud));
			edad = false;
		}
		
		if(nMatricula) {
			System.out.println("\tTexto: " + new String(ch,inicio,longitud));
			nMatricula = false;
		}
		
	}
	
	
}
