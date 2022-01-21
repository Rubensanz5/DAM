package Ejemplos.PracticarEx;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Saso extends DefaultHandler{

	String nomEtiqueta;
	
	@Override
	public void startDocument() throws SAXException {
		System.out.println("Inicio XML");
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("-------------------------------------");
		System.out.println("Fin XML");
	}

	@Override
	public void startElement(String uri, String localName, String nomEtiq, Attributes attr) throws SAXException {
		nomEtiqueta = nomEtiq;
		if(!nomEtiq.equalsIgnoreCase("Nombre") && !nomEtiq.equalsIgnoreCase("Apellido") 
				&& !nomEtiq.equalsIgnoreCase("Edad")) {
			System.out.println("-------------------------------------");
			System.out.println(nomEtiq);
		}
		
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		System.out.println(nomEtiqueta + " " + new String(ch,start,length));
	}
	
	

}
