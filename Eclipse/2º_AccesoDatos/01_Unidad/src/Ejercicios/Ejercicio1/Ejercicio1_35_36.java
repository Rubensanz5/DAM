package Ejercicios.Ejercicio1;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
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
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public class Ejercicio1_35_36 {

	public static void main(String[] args) {
		crearXMLDOM();
		try {
			//Generamos la factoria en la queleer el fich XML
			DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factoria.newDocumentBuilder();
			Document document = builder.parse("ficheros\\xml\\personasXML.xml");
			
			//Crear factoria XPATH
			XPathFactory factoriaXPath = XPathFactory.newInstance();
			
			//Crear objeto XPath
			XPath xp = factoriaXPath.newXPath();
			
			//Consulta 1
			XPathExpression expr1 = xp.compile("//Persona[nombre='Pedro']/apellido/text()");
			Object result1 = expr1.evaluate(document, XPathConstants.NODESET);
			NodeList nodos = (NodeList) result1;
			System.out.println("Apellidos de las personas que se llaman Pedro: ");
			
			for (int i = 0; i < nodos.getLength(); i++) {
				System.out.println((i + 1) + " - " + nodos.item(i).getNodeValue());
				
			}
			
			//Consulta 2
			XPathExpression expr2 = xp.compile("count(//Persona[nombre = 'Pedro'])");
			Object result2 = expr2.evaluate(document, XPathConstants.NUMBER);
			double numero = (double) result2;
			
			System.out.println("El numero de personas que se llama Pedro es : " + numero);
			
			//consulta 3 
			if (numero > 2) {
				System.out.println("Si hay mas de dos personas que se llaman Pedro");
			} else {
				System.out.println("No hay mas de dos personas que se llamen Pedro");
			}
			
			//EJERCICIO 36
			//a.)
			XPathExpression expr3 = xp.compile("//Persona[edad > 60]/nombre/text()");
			Object result3 = expr3.evaluate(document, XPathConstants.NODESET);
			NodeList nodos1 = (NodeList) result3;
			
			for (int i = 0; i < nodos1.getLength(); i++) {
				System.out.println("Las personas con mas de 60 años son: " + nodos1.item(i).getNodeValue());
			}
			
			//b.)
			XPathExpression expr4 = xp.compile("//Persona[ contains(email, 'gmail')]/nombre/text()");
			Object result4 = expr4.evaluate(document, XPathConstants.NODESET);
			NodeList nodos2 = (NodeList) result4;
			
			for (int i = 0; i < nodos2.getLength(); i++) {
				System.out.println("Las personas con gmail son: " + nodos2.item(i).getNodeValue());
			}
			
			
		} catch (SAXException | IOException | ParserConfigurationException | XPathExpressionException e) {
			e.printStackTrace();
		}
		
	}

	private static void crearXMLDOM() {
		String[] nombres = {"Pedro", "Pedro", "Pedro", "Marta"};
		String[] apellidos = {"Juez", "Martinez", "Barriuso", "Peña"};
		String[] localidades = {"Burgos", "Madrid", "Burgos", "Barcelona"};
		int[] edades = {25, 25, 65, 75};
		String[] emails = {"gmail", "pedromartinez@gmail.com", "pedrobarriuso@gmail.com", "martapeña@hotmail.com"};
	
		try {		
			DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factoria.newDocumentBuilder();
			
			DOMImplementation implementacion = builder.getDOMImplementation();
			Document documento = implementacion.createDocument(null, "Personas", null);
			
			documento.setXmlVersion("1.0");

			for (int i = 0; i < nombres.length; i++) {
				Element raiz = documento.createElement("Persona");
				documento.getDocumentElement().appendChild(raiz);
				
				String nombre = nombres[i];
				String apellido = apellidos[i];
				String localidad = localidades[i];
				int edad = edades[i];
				String email = emails[i];
				
				crearElemento("nombre", nombre.trim(), raiz, documento);
				crearElemento("apellido", apellido.trim(), raiz, documento);
				crearElemento("localidad", localidad.trim(), raiz, documento);
				crearElemento("edad", Integer.toString(edad), raiz, documento);
				crearElemento("email", email.trim(), raiz, documento);
			}
			
			File fichXML = new File("ficheros\\xml\\personasXML.xml");
			Source origen = new DOMSource(documento);
			Result destino = new StreamResult(fichXML);
			
			Transformer transform = TransformerFactory.newInstance().newTransformer();
			transform.transform(origen, destino);
			
		} catch (ParserConfigurationException | TransformerException | TransformerFactoryConfigurationError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void crearElemento(String etiqueta, String valor, Element raiz, Document doc) {
		Element etiq = doc.createElement(etiqueta);
		Text value = doc.createTextNode(valor);
		
		raiz.appendChild(etiq);
		etiq.appendChild(value);
		
	}
	
}
