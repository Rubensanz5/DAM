package ejercicio2;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAX extends DefaultHandler {
	
	String nomEtiq;

	@Override
	public void startDocument() throws SAXException {
		System.out.println("Inicio del documento");
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("-----------------------");
		System.out.println("Fin del documento");
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		nomEtiq = qName;
		if (qName.equalsIgnoreCase("trabajos")) {
			System.out.println(qName);
		} else if(qName.equalsIgnoreCase("artista")) {
			System.out.println("-----------------------");
		}
		
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		System.out.println(nomEtiq + " " + new String(ch, start, length));
	}
	
	
}
