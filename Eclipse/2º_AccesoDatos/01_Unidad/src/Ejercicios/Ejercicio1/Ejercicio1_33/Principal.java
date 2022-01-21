package Ejercicios.Ejercicio1.Ejercicio1_33;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
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

public class Principal {
	static Scanner sc = new Scanner(System.in);
	static File fichero = new File("Alumnos.dat");
	static File fichXML = new File("alumnosXML.xml");
	static ArrayList<Integer> ids = new ArrayList<>();
	static ArrayList<Integer> numMats = new ArrayList<>();
	static ArrayList<String> nombres = new ArrayList<>();
	static ArrayList<String> apellidos = new ArrayList<>();
	static ArrayList<String> ciclos = new ArrayList<>();
	static ArrayList<Integer> cursos = new ArrayList<>();
	
	
	public static void main(String[] args) {
		cargarDatosDefecto();
		
		if(!fichero.exists()) {
			crearFich();
		}
		
		escribirAlumnos();
		int opcion;
		do {
			System.out.println("MENU:\n1. Visualizar con DOM el fichero XML\n2. Añadir un nuevo alumno\n3. Leer fichero mediante SAX\n4. Salir");
			opcion = pedirNum(sc);
			switch (opcion) {
				case 1:
					leerFichero();
					break;
				case 2:
					crearNuevoAlumno();
					break;
				case 3:
					leerConSAX();
					break;
				case 4:
					break;
				default:
					break;
			}
		} while (opcion <= 3);
		
		sc.close();
	}
	

	private static void escribirAlumnos() {
		try {
			//Formar fichero XML y escribir los datos creando el arborlDOM
			File fich = new File("Alumnos.dat");
			FileInputStream fileI = new FileInputStream(fich);
			DataInputStream dataI = new DataInputStream(fileI);
		
			DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
			DocumentBuilder build = factoria.newDocumentBuilder();
			
			DOMImplementation impl = build.getDOMImplementation();
			Document doc = impl.createDocument(null, "Alumnos", null);
			doc.setXmlVersion("1.0");
			
			while(dataI.available() > 0) {
				Element raiz = doc.createElement("Alumno");
				doc.getDocumentElement().appendChild(raiz);
				
				//establecer el attr de alumno
				int id = dataI.readInt();
				raiz.setAttribute("id", String.valueOf(id));
				
				int nummat = dataI.readInt();
				String apellidos = dataI.readUTF();
				String nombre = dataI.readUTF();
				String ciclo = dataI.readUTF();
				int curso = dataI.readInt();
				
				crearElemento("nummat",Integer.toString(nummat),raiz,doc);	
				crearElemento("apellidos",apellidos.trim(),raiz,doc);
				crearElemento("nombre",nombre.trim(),raiz,doc);
				crearElemento("ciclo",ciclo.trim(),raiz,doc);
				crearElemento("curso",Integer.toString(curso),raiz,doc);	
			}
			
			Source origen = new DOMSource(doc);
			Result destino = new StreamResult(fichXML);
			
			Transformer transform = TransformerFactory.newInstance().newTransformer();
			transform.transform(origen, destino);
			
						
			dataI.close();
		} catch (IOException | ParserConfigurationException | TransformerException | TransformerFactoryConfigurationError e) {
			e.printStackTrace();
		}
	}
	
	
	private static void crearNuevoAlumno() {
		try {
			DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
			DocumentBuilder build = factoria.newDocumentBuilder();
			
			Document documento = build.parse(fichXML);
			
			Element raiz = documento.createElement("Alumno");
			documento.getDocumentElement().appendChild(raiz);
			
			//establecer el attr de alumno.
			System.out.println("Introduce el id del alumno: ");
			int id = pedirNum(sc);
			raiz.setAttribute("id", String.valueOf(id));
			ids.add(id);
			
			System.out.println("Introduce el numero de matricula del alumno: ");
			int nummat = pedirNum(sc);
			numMats.add(nummat);
			
			System.out.println("Introduce los apellidos del alumno: ");
			String apellido = sc.nextLine();
			apellidos.add(apellido);
			
			System.out.println("Introduce el nombre del alumno: ");
			String nombre = sc.nextLine();
			nombres.add(nombre);
			
			System.out.println("Introduce el ciclo del alumno: ");
			String ciclo = sc.nextLine();
			ciclos.add(ciclo);
			
			System.out.println("Introduce el curso del alumno: ");
			int curso = pedirNum(sc);
			cursos.add(curso);
			
			crearElemento("nummat",Integer.toString(nummat),raiz,documento);	
			crearElemento("apellidos",apellido.trim(),raiz,documento);
			crearElemento("nombre",nombre.trim(),raiz,documento);
			crearElemento("ciclo",ciclo.trim(),raiz,documento);
			crearElemento("curso",Integer.toString(curso),raiz,documento);	
	
			Source origen = new DOMSource(documento);
			Result destino = new StreamResult(fichXML);
			Transformer transform = TransformerFactory.newInstance().newTransformer();
			transform.transform(origen, destino);
			
			//Escribir los datos del nuevo alumno al fichero 
			RandomAccessFile fileR = new RandomAccessFile(fichero, "rw");
			
			//para escribirlos con valueOf(id) obtienes el numero de posicion en la q se encuentre el id pasado por parametro
			//y con el get obtienes esa posicion para escribirlo en el fichero
			fileR.writeInt(ids.get(ids.indexOf(id)));
			fileR.writeInt(numMats.get(numMats.indexOf(nummat)));
			fileR.writeUTF(nombres.get(nombres.indexOf(nombre)));
			fileR.writeUTF(apellidos.get(apellidos.indexOf(apellido)));
			fileR.writeUTF(ciclos.get(ciclos.indexOf(ciclo)));
			fileR.writeInt(cursos.get(cursos.indexOf(curso)));
			
			
			fileR.close();
		} catch (IOException | TransformerException | TransformerFactoryConfigurationError | SAXException | ParserConfigurationException e) {
			e.printStackTrace();
		} finally {
			crearFich();
		}
	}

	public static int pedirNum(Scanner sc) {
		int num = -1;
		do {
			if(sc.hasNextInt()) {
				num = sc.nextInt();
				sc.nextLine();
			} else {
				sc.nextLine();
				num = -1;
			}
		} while (num < 0);
		return num;
	}

	private static void leerFichero() {
		
		try {
			DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
			DocumentBuilder build = factoria.newDocumentBuilder();
		
			Document documento = build.parse(fichXML);
			NodeList listaAlumn = documento.getElementsByTagName("Alumno");
			
			for (int i = 0; i < listaAlumn.getLength(); i++) {
				Node alumno = listaAlumn.item(i);
				if(alumno.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) alumno;
					System.out.println("ID: " + element.getAttribute("id"));
					System.out.println("Número de Matricula: " + valor("nummat", element));
					System.out.println("Apellidos: " + valor("apellidos", element));
					System.out.println("Nombre: " + valor("nombre", element));
					System.out.println("Ciclo: " + valor("ciclo", element));
					System.out.println("Curso: " + valor("curso", element));
					System.out.println("----------------------------------");
				}
				
			}
		} catch (ParserConfigurationException | SAXException | IOException e) {
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

	public static void leerConSAX() {
		try {
			SAXParserFactory factoria = SAXParserFactory.newInstance();
			SAXParser parser = factoria.newSAXParser();
			
			LeerSAX rs = new LeerSAX();
			
			parser.parse("alumnosXML.xml", rs);
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static File crearFich() {
		try {
			fichero = new File("Alumnos.dat");
			RandomAccessFile fileR = new RandomAccessFile(fichero, "rw");
			
			
			for (int i = 0; i < nombres.size(); i++) {
				fileR.writeInt(ids.get(i));
				fileR.writeInt(numMats.get(i));
				fileR.writeUTF(apellidos.get(i));
				fileR.writeUTF(nombres.get(i));
				fileR.writeUTF(ciclos.get(i));
				fileR.writeInt(cursos.get(i));
			}
			
			fileR.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fichero;
	}

	private static void cargarDatosDefecto() {
		ids.add(1);
		ids.add(2);
		ids.add(3);
		
		numMats.add(1);
		numMats.add(2);
		numMats.add(3);
		
		nombres.add("Pepe");
		nombres.add("Ana María");
		nombres.add("Carlos");

		apellidos.add("García Martín");
		apellidos.add("Matute Herrero");
		apellidos.add("Ruiz Zafón");

		ciclos.add("DAM");
		ciclos.add("DAM");
		ciclos.add("DAM");

		cursos.add(2);
		cursos.add(2);
		cursos.add(1);
	}
}
