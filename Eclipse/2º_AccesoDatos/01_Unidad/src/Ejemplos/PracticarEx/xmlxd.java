package Ejemplos.PracticarEx;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public class xmlxd {
	
	static String [] nombres = {"Juan", "Pedro", "Maria"};
	static String [] apellidos = {"Sanchez", "fernandez", "Garcia"};
	static int [] edad = {23, 43, 16};

	public static void main(String[] args) {
		try {	
			escribirXML();
			
			leerXML(); 
			
			leerSAX();
			
			DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factoria.newDocumentBuilder();
			Document document = builder.parse(new File("ficheroXML.xml"));
			
			//Crear factoria XPATH
			XPathFactory factoriaXPath = XPathFactory.newInstance();
			
			//Crear objeto XPath
			XPath xp = factoriaXPath.newXPath();
			
			
			XPathExpression expresion = xp.compile("//ExAlumno[Nombre = 'Pedro']/Apellido/text()");
			NodeList resutl = (NodeList) expresion.evaluate(document, XPathConstants.NODESET);
			
			for (int i = 0; i < resutl.getLength(); i++) {
				System.out.println(resutl.item(i).getNodeValue());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void leerSAX() throws ParserConfigurationException, SAXException, IOException {
		SAXParserFactory factoria = SAXParserFactory.newInstance();
		SAXParser parser = factoria.newSAXParser();
		
		Saso seso = new Saso(); 
		
		parser.parse(new File("ficheroXML.xml"), seso);
	}

	private static void leerXML() throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factoria.newDocumentBuilder();
		
		Document doc = builder.parse(new File("ficheroXML.xml"));
		
		System.out.println(doc.getDocumentElement().getNodeName());
		
		Element alum = (Element) doc.getDocumentElement().getElementsByTagName("Alumno").item(0);
		System.out.println(alum.getNodeName());
		NodeList elemntAlum = alum.getChildNodes();
		
		for (int i = 0; i < elemntAlum.getLength(); i++) {
			System.out.println(elemntAlum.item(i).getNodeName());
			System.out.println(elemntAlum.item(i).getFirstChild().getNodeValue());
		} 
		
		Element exAlumnos = (Element) doc.getDocumentElement().getElementsByTagName("ExAlumnos").item(0);
		System.out.println(exAlumnos.getNodeName());
		
		NodeList exAlum = exAlumnos.getChildNodes();
		
		for (int i = 0; i < exAlum.getLength(); i++) {
			System.out.println(exAlum.item(i).getNodeName());
			NodeList valorEx = exAlum.item(i).getChildNodes();
			
			for (int j = 0; j < valorEx.getLength(); j++) {
				System.out.println(valorEx.item(j).getNodeName());
				System.out.println(valorEx.item(j).getFirstChild().getNodeValue());
			} 
		}
	}

	private static void escribirXML() throws ParserConfigurationException, TransformerConfigurationException,
			TransformerFactoryConfigurationError, TransformerException {
		DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
		DocumentBuilder build = factoria.newDocumentBuilder();
		
		DOMImplementation implementacion = build.getDOMImplementation();
		Document document = implementacion.createDocument(null,"Alumnos",null);
		document.setXmlVersion("1.0");

		Element alumno = document.createElement("Alumno");
		document.getDocumentElement().appendChild(alumno);
		
		crearElement("Nombre", nombres[0].trim(), alumno, document);
		crearElement("Apellido", apellidos[0].trim(), alumno, document);
		crearElement("Edad", Integer.toString(edad[0]), alumno, document);
		
		Element exAlumnos = document.createElement("ExAlumnos");
		document.getDocumentElement().appendChild(exAlumnos);
		
		for (int i = 1; i < nombres.length; i++) {
			Element exAlum = document.createElement("ExAlumno");
			exAlumnos.appendChild(exAlum);
			
			crearElement("Nombre", nombres[i].trim(), exAlum, document);
			crearElement("Apellido", apellidos[i].trim(), exAlum, document);
			crearElement("Edad", Integer.toString(edad[i]), exAlum, document);
		}
		File fichXML = new File("ficheroXML.xml");
		
		Source origen = new DOMSource(document);
		Result destino = new StreamResult(fichXML);
		
		Transformer transformacion = TransformerFactory.newInstance().newTransformer();
		transformacion.transform(origen,destino);
	}

	public static void crearElement(String etiqueta, String valor, Element alumno, Document document) {
		Element etiq = document.createElement(etiqueta);
		Text valEtiq = document.createTextNode(valor);
		
		alumno.appendChild(etiq);
		etiq.appendChild(valEtiq);
		
	}

}
