package Ejemplos.SAX;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class Ejemplo {

	public static void main(String[] args) {
		
		//Crear objeto SAXParser xa interpretar el documento XML
		try {
			SAXParserFactory factoria = SAXParserFactory.newInstance();
			SAXParser parser = factoria.newSAXParser();
			
			//crear instancia del manejador que sera el que recorra el doc XML secuencial
			RecorrerSAX rs = new RecorrerSAX();
			
			parser.parse("ficheros\\xml\\alumnosXml.xml", rs);
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
