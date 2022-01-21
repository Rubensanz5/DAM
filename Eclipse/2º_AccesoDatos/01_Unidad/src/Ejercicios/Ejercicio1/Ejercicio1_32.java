package Ejercicios.Ejercicio1;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

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

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public class Ejercicio1_32 {

	public static void main(String[] args) {
		try {
			crearFich();
			
			//Escribir
			File fichero = new File("ficheros\\xml\\Ejer32.dat");
			FileInputStream fileI = new FileInputStream(fichero);
			DataInputStream dataI = new DataInputStream(fileI);
			
			DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factoria.newDocumentBuilder();
			
			DOMImplementation imple = builder.getDOMImplementation();
			Document doc = imple.createDocument(null, "Alumnos", null);
			
			doc.setXmlVersion("1.0");
			
			
			
			while(dataI.available() > 0) {
				Element raiz = doc.createElement("Alumno");
				doc.getDocumentElement().appendChild(raiz);
				
				int id , nMatricula, edad;
				String nombre, apellidos;
				
				id = dataI.readInt();
				apellidos = dataI.readUTF();
				nombre = dataI.readUTF();
				edad = dataI.readInt();
				nMatricula = dataI.readInt();
				
				crearElemento("id",Integer.toString(id),raiz,doc);
				crearElemento("apellidos",apellidos.trim(),raiz,doc);
				crearElemento("nombre",nombre.trim(),raiz,doc);
				crearElemento("edad",Integer.toString(edad),raiz,doc);				
				crearElemento("nMatricula",Integer.toString(nMatricula),raiz,doc);				
			}
			
			File fichXML = new File("ficheros\\xml\\alumnosXml.xml");
			Source origen = new DOMSource(doc);
			Result destino = new StreamResult(fichXML);
			
			Transformer transf = TransformerFactory.newInstance().newTransformer();
			transf.transform(origen, destino);
			
			dataI.close();
			
			
			//Leer
			Document doc1 = builder.parse(fichXML);
			
			System.out.println("Elemento raiz: " + doc1.getDocumentElement().getNodeName());
			
			NodeList listEmp = doc.getElementsByTagName("Alumno");
			
			for (int i = 0; i < listEmp.getLength(); i++) {
				Node alumno = listEmp.item(i);
				if(alumno.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) alumno;
					System.out.println("ID: " + valor("id", element));
					System.out.println("APELLIDOS: " + valor("apellidos", element));
					System.out.println("NOMBRE: " + valor("nombre", element));
					System.out.println("EDAD: " + valor("edad", element));
					System.out.println("NUMERO MATRICULA: " + valor("nMatricula", element));
				}
				
			}
			
		} catch (IOException | ParserConfigurationException | TransformerException | TransformerFactoryConfigurationError | SAXException e) {
			e.printStackTrace();
		}
	}

	public static String valor(String etiqueta, Element elem) {
		NodeList nList = elem.getElementsByTagName(etiqueta).item(0).getChildNodes();
		Node nValor = nList.item(0);
		return nValor.getNodeValue();
	}

	public static void crearElemento(String etiqueta, String valor, Element raiz, Document doc) {
		Element etiq = doc.createElement(etiqueta);
		
		Text valorEtiq = doc.createTextNode(valor);
		raiz.appendChild(etiq);
		etiq.appendChild(valorEtiq);
		
	}
	
	public static void crearFich() {
		try {
			File fichero = new File("ficheros\\xml\\Ejer32.dat");
			RandomAccessFile fileR = new RandomAccessFile(fichero, "rw");
			
			String [] nombres = {"Juan", "Pedro", "Maria"};
			String [] apellidos = {"Sanchez", "fernandez", "Garcia"};
			int [] edad = {23, 43, 16};
			int [] nMatricula = {56465465,4564654,546465};
			
			for (int i = 0; i < nombres.length; i++) {
				
				fileR.writeInt(i+1);
				
				fileR.writeUTF(apellidos[i]);
				
				fileR.writeUTF(nombres[i]);
				 
				fileR.writeInt(edad[i]);
				
				fileR.writeInt(nMatricula[i]);
				
			}
			
			fileR.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
