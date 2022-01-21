package ejercicio2;

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

public class Apartado1 {

	public static void main(String[] args) {
		try {
			File fichero = new File("artistas.dat");
			FileInputStream fileI = new FileInputStream(fichero);
			DataInputStream dataI = new DataInputStream(fileI);
			
			DocumentBuilderFactory mifactoria = DocumentBuilderFactory.newInstance();
			DocumentBuilder miBuilder = mifactoria.newDocumentBuilder();
			DOMImplementation miImplementacion = miBuilder.getDOMImplementation();
			Document documento = miImplementacion.createDocument(null,"artistas",null);
			documento.setXmlVersion("1.0");
			
			for (int i = 0; i < 2; i++) {
				Element artista = documento.createElement("artista");
				documento.getDocumentElement().appendChild(artista);
				
				String nombre = dataI.readUTF();
				String actividad = dataI.readUTF();
				
				crearElemento("nombre", nombre.trim(), artista, documento);
				crearElemento("actividad", actividad.trim(), artista, documento);
				
				Element trabajos = documento.createElement("trabajos");
				artista.appendChild(trabajos);
				
				String trabajo1 = dataI.readUTF();
				int precio1 = dataI.readInt();
				String trabajo2 = dataI.readUTF();
				int precio2 = dataI.readInt();

				crearElemento("trabajo1", trabajo1.trim(), trabajos, documento);
				crearElemento("precio1", Integer.toString(precio1), trabajos, documento);
				crearElemento("trabajo2", trabajo2.trim(), trabajos, documento);
				crearElemento("precio2", Integer.toString(precio2), trabajos, documento);
			
			}
			
			File fichXML = new File("artistasXML.xml");
			
			Source fuente = new DOMSource(documento);
			Result resultado = new StreamResult(fichXML);
			
			Transformer transformacion=TransformerFactory.newInstance().newTransformer();
			transformacion.transform(fuente,resultado);
			
			dataI.close();
			
		} catch (IOException | ParserConfigurationException | TransformerException | TransformerFactoryConfigurationError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		

	}

	public static void crearElemento(String etiq, String valor, Element element, Document documento) {
		Element nomEtiqueta = documento.createElement(etiq);
		Text valorEtiqueta = documento.createTextNode(valor);
		
		element.appendChild(nomEtiqueta);
		nomEtiqueta.appendChild(valorEtiqueta);
		
	}

}
