package Ejemplos.XML;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class EjemploLeer {
	public static void main(String[] args) {
		//Se genera la factoria para albergarel arbol
		
		try {
			DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factoria.newDocumentBuilder();
			
			Document doc = builder.parse("ficheros\\xml\\empleadosXml.xml");
			
			System.out.println("Elemento raiz: " + doc.getDocumentElement().getNodeName());
			
			//A partir del nodo se crea una lista de empleados
			NodeList listaEmp = doc.getElementsByTagName("Empleado");
			
			for (int i = 0; i < listaEmp.getLength(); i++) {
				
					//Obtener los elementos del nodo
					Element elemento = (Element) listaEmp.item(i);
					System.out.println("ID: " + valor("id", elemento));
					System.out.println("APELLIDOS: " + valor("apellidos", elemento));
					System.out.println("NOMBRE: " + valor("nombre", elemento));
					System.out.println("DEPARTAMENTO: " + valor("depto", elemento));
					System.out.println("SUELDO: " + valor("sueldo", elemento));
				
				
			}
			
		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

	public static String valor(String etiqueta, Element ele) {
		NodeList nList = ele.getElementsByTagName(etiqueta).item(0).getChildNodes();
		Node nValor = nList.item(0);
		return nValor.getNodeValue();
	}
}
