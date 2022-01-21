package ejercicio2;

import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;



public class Apartado2 {

	public static void main(String[] args) {
		File fichXML = new File("artistasXML.xml");
		try {
			SAXParserFactory factoria = SAXParserFactory.newInstance();
			SAXParser parser;
			
			SAX rs1 = new SAX();
			
			parser = factoria.newSAXParser();
			parser.parse(fichXML,rs1);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
