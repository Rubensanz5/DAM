package Ejemplos.PracticarEx;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Seso extends DefaultHandler{
	String nomEti;
	
	@Override
	public void startDocument() throws SAXException {
		System.out.println("Ini document");
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("-------------------------------------");
		System.out.println("Fin document");
	}

	@Override
	public void startElement(String uri, String localName, String eti, Attributes attributes) throws SAXException {
		nomEti = eti;

		if(eti.equalsIgnoreCase("telefono")) {
			
			System.out.println(eti);
		} else if(eti.equalsIgnoreCase("Alumno")){
			System.out.println("-------------------------------------");

		}		

		
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {

		System.out.println(nomEti + " " + new String(ch, start, length));

	}
	

}
