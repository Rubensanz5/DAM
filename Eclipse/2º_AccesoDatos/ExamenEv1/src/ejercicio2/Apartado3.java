package ejercicio2;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class Apartado3 {

	public static void main(String[] args) {
		File fichXML = new File("artistasXML.xml");
		
		
		try {
			DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factoria.newDocumentBuilder();
			
			Document documento = builder.parse(fichXML);
			
			XPathFactory factoriaXPath = XPathFactory.newInstance();
			XPath xpath = factoriaXPath.newXPath();
			
			XPathExpression expresion = xpath.compile("//artista[nombre = 'Malu']/trabajos/*/text()");
			NodeList lista = (NodeList) expresion.evaluate(documento, XPathConstants.NODESET);
			
			for (int i = 0; i < lista.getLength(); i++) {
				System.out.println((i + 1) + " - " + lista.item(i).getNodeValue());
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
