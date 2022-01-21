package Ejemplos.XML;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
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

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class Ejemplo {

	public static void main(String[] args) {
		try {
			File fich = new File("ficheros\\xml\\empleados.dat");
			FileInputStream fileI = new FileInputStream(fich);
			DataInputStream dataI = new DataInputStream(fileI);
	
			//Crear instancia de DocumentBuiderFactory xa construir el parser DOM 
			//q permite construir el DocumentBuilder
			
			DocumentBuilderFactory factoria =  DocumentBuilderFactory.newInstance();
		
			DocumentBuilder builder = factoria.newDocumentBuilder();
			
			//Creamos un document vacio con el nodo raiz de nombre empleados y asignar version de XML
			
			DOMImplementation miImplementacion = builder.getDOMImplementation();
			Document documento = miImplementacion.createDocument(null, "Empleados", null);
			
			documento.setXmlVersion("1.0");
			
			//Recorrer el fich xa obtener datos y x cada registro se crea un nodo empleado con 5 hijos (id, apellidos, nombre ,depto y sueldo)
			
			for (int i = 0; i < 3; i++) {
				//primero crear el nodo raiz empleado
				Element raiz = documento.createElement("Empleado");
				//Añadir el nodo al documento
				documento.getDocumentElement().appendChild(raiz);
				
				//Leer fich
				int id;
				String nombre, apellidos, depto;
				double sueldo;
				
				id = dataI.readInt();
				apellidos = dataI.readUTF();
				nombre = dataI.readUTF();
				depto = dataI.readUTF();
				sueldo = dataI.readDouble();
				
				crearElemento("id",Integer.toString(id),raiz,documento);
				crearElemento("apellidos",apellidos.trim(),raiz,documento);
				crearElemento("nombre",nombre.trim(),raiz,documento);
				crearElemento("depto",depto.trim(),raiz,documento);
				crearElemento("sueldo",Double.toString(sueldo),raiz,documento);
			}
			
			//Creamos el fichero xml a partir del arbol DOM creado
			File fichXml = new File("ficheros\\xml\\empleadosXml.xml");
			Source origen = new DOMSource(documento);
			Result destino = new StreamResult(fichXml);
			Transformer transformacion = TransformerFactory.newInstance().newTransformer();
			transformacion.transform(origen, destino);
			
			Result consola = new StreamResult(System.out);
			transformacion.transform(origen, consola);
			dataI.close();
		} catch (ParserConfigurationException | IOException | TransformerException | TransformerFactoryConfigurationError e) {
			e.printStackTrace();
		}
		
	}

	public static void crearElemento(String etiqueta, String valor, Element raiz, Document documento) {
		//Crear elemento tipo
		Element etiq = documento.createElement(etiqueta);
		
		//Le damos valor
		Text texto = documento.createTextNode(valor);
		
		//Enlazar con el elemeto superior
		raiz.appendChild(etiq);
		etiq.appendChild(texto);	
	}

}
