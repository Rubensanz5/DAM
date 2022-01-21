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
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public class xml2 {
	static String [] nombres = {"Juan", "Pedro", "Maria"};
	static String [] apellidos = {"Sanchez", "fernandez", "Garcia"};
	static int [] edad = {23, 43, 16};
	static int[] movil = {123456,132654,654321};
	static int[] fijo = {9475155,4565654,9756321};
	static String[] ciclo = {"Dam", "Daw", "Asir"};
	static int[] curso = {1,2,1};
	
	static File fichXML = new File("ficheroTelefono.xml");
	
	public static void main(String[] args) {
		
		try {
			crarXML();
			
			leerDom();
			
			leerSAX();
			
			xpath();
			
		} catch (Exception e) {
			e.printStackTrace();
		}	

	}

	private static void xpath()
			throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
		DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factoria.newDocumentBuilder();
		Document document = builder.parse(fichXML);
		
		//Crear factoria XPATH
		XPathFactory factoriaXPath = XPathFactory.newInstance();
		
		//Crear objeto XPath
		XPath xp = factoriaXPath.newXPath();
		
		XPathExpression expr = xp.compile("//Alumno[nombre='Juan']/nombre/text()");
		NodeList result = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		
		for (int i = 0; i < result.getLength(); i++) {
			System.out.println(result.item(i).getNodeValue());
		}
		
		XPathExpression expr2 = xp.compile("count(//Alumno[nombre = 'Pedro'])");
		double result2 = (double) expr2.evaluate(document, XPathConstants.NUMBER);
  
		System.out.println("El numero de personas que se llama Pedro es : " + result2);
	}

	private static void leerSAX() throws ParserConfigurationException, SAXException, IOException {
		SAXParserFactory factoria = SAXParserFactory.newInstance();
		SAXParser parser = factoria.newSAXParser();
		
		Seso rs = new Seso();
		
		parser.parse(fichXML, rs);
	}

	private static void leerDom() throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factoria.newDocumentBuilder();
		
		Document doc = builder.parse(fichXML);
		
//		System.out.println(doc.getDocumentElement().getNodeName());
//		
//		NodeList alumno = doc.getElementsByTagName("Alumno");
//		
//		for (int i = 0; i < alumno.getLength(); i++) {
//			System.out.println(alumno.item(i).getNodeName());
//			
//			NodeList valorAlum = alumno.item(i).getChildNodes();
//			for (int j = 0; j < valorAlum.getLength(); j++) {
//				System.out.println(valorAlum.item(j).getNodeName());
//				if (valorAlum.item(j).getNodeName().equalsIgnoreCase("Telefono")) {
//					NodeList valorTlfn = valorAlum.item(j).getChildNodes();
//					for (int k = 0; k < valorTlfn.getLength(); k++) {
//						System.out.println(valorTlfn.item(k).getNodeName());
//						System.out.println(valorTlfn.item(k).getFirstChild().getNodeValue());
//					}
//					
//				} else {
//					System.out.println(valorAlum.item(j).getFirstChild().getNodeValue());
//				}
//			}
//			System.out.println("--------");
//		}
		NodeList lista = doc.getElementsByTagName("Alumno");
		
		for (int i = 0; i < lista.getLength(); i++) {
			
			//Obtener los elementos del nodo
			Element elemento = (Element) lista.item(i);
			System.out.println("NOMBRE: " + valor("nombre", elemento));
			System.out.println("APELLIDOS: " + valor("apellido", elemento));
			System.out.println("FIJO: " + valor("fijo", elemento));
			System.out.println("MOVIL: " + valor("movil", elemento));
			System.out.println("CICLO: " + valor("ciclo", elemento));
			System.out.println("CURSO: " + valor("curso", elemento));
		
			System.out.println("--------");
		}
	}
	
	public static String valor(String etiq, Element ele) {
		NodeList lista = ele.getElementsByTagName(etiq).item(0).getChildNodes();
		Node valor = lista.item(0);
		return valor.getNodeValue();
	}

	private static void crarXML() throws ParserConfigurationException, TransformerConfigurationException,
			TransformerFactoryConfigurationError, TransformerException {
		DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
		DocumentBuilder build = factoria.newDocumentBuilder();
		
		DOMImplementation implementacion = build.getDOMImplementation();
		Document document = implementacion.createDocument(null,"Alumnos",null);
		document.setXmlVersion("1.0");
		
		for (int i = 0; i < nombres.length; i++) {
			Element alumno = document.createElement("Alumno");
			document.getDocumentElement().appendChild(alumno);
			
			crearElemento("nombre", nombres[i].trim(),alumno, document);
			crearElemento("apellido", apellidos[i].trim(),alumno, document);
			
			Element telefono = document.createElement("Telefono");
			alumno.appendChild(telefono);
			
			crearElemento("fijo", Integer.toString(fijo[i]), telefono, document);
			crearElemento("movil", Integer.toString(movil[i]), telefono, document);
			
			crearElemento("ciclo", ciclo[i].trim(),alumno, document);
			crearElemento("curso", Integer.toString(curso[i]),alumno, document);
			
		}
		
		Source origen = new DOMSource(document);
		Result destino = new StreamResult(fichXML);
		
		Transformer transformacion = TransformerFactory.newInstance().newTransformer();
		transformacion.transform(origen,destino);
	}

	public static void crearElemento(String etiq, String valor, Element alumno, Document document) {
		Element etiquta = document.createElement(etiq);
		Text valorEtiq = document.createTextNode(valor);	
		
		alumno.appendChild(etiquta);
		etiquta.appendChild(valorEtiq);
		
	}

}
