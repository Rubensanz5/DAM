package Ejemplos.PracticarEx;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.sql.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
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

public class Practica1 {
	static String [] nombres = {"Juan", "Pedro", "Maria"};
	static String [] apellidos = {"Sanchez", "fernandez", "Garcia"};
	static int [] edad = {23, 43, 16};
	static int [] nMatricula = {56465465,4564654,546465};
	static Alumno alumno1 = new Alumno("ruben", "sanz", 23, 5421);
	static Alumno alumno2 = new Alumno("ruben", "sanz", 23, 5421);
	static Alumno alumno3 = new Alumno("ruben", "sanz", 23, 5421);
	
	public static void main(String[] args) {
		try {
			File fichero = new File("Fichero.txt");
			operacionesConFile(fichero);
			
			escribirBuffererWriter(fichero);
			
			leerCarecter(fichero);
			
			File fichAlum = new File("fichAlum.dat");
			escribirBinario(fichAlum);
			
			leerBinario(fichAlum);
			
			File fichAlum1 = new File("fichAlum1.dat");
			leerEscribirObjetos(fichAlum1);
			
			escribirRandomFile();
			
			leerRandomFile();
			
			File fichXML = new File("fichXML");
			
			escribirXML(fichAlum, fichXML);
			
			leerXML(fichXML);
			
			
		} catch (IOException | ClassNotFoundException | ParserConfigurationException | TransformerException | TransformerFactoryConfigurationError | SAXException e) {
			e.printStackTrace();
		}
	}


	private static void leerXML(File fichXML) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factoria.newDocumentBuilder();
		
		Document doc = builder.parse(fichXML);

		System.out.println("Elemeto raiz: " + doc.getDocumentElement().getNodeName());
		
		//A partir del nodo se crea una lista de empleados
		NodeList listaAlumn = doc.getElementsByTagName("Alumno");
		
		for (int i = 0; i < listaAlumn.getLength(); i++) {
			//Obtengo un nodo
			Node alumno = listaAlumn.item(i);
			if(alumno.getNodeType() == Node.ELEMENT_NODE) {
				Element elemento = (Element) alumno;
				System.out.println("ID: " + elemento.getAttribute("id"));
				System.out.println("Nombre: " + valor("nombre", elemento));
				System.out.println("Apellido: " + valor("apellido", elemento));
				System.out.println("Edad: " + valor("edad", elemento));
				System.out.println("Num Matricula: " + valor("numMat", elemento));
			}
		}
	}


	public static String valor(String etiqueta, Element elemento) {
		NodeList nList = elemento.getElementsByTagName(etiqueta).item(0).getChildNodes();
		Node nValor = nList.item(0);
		return nValor.getNodeValue();
	}


	private static void escribirXML(File fichAlum, File fichXML)
			throws FileNotFoundException, ParserConfigurationException, IOException, TransformerConfigurationException,
			TransformerFactoryConfigurationError, TransformerException {
		
		FileInputStream fi = new FileInputStream(fichAlum);
		DataInputStream dataI = new DataInputStream(fi);
		
		DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
		DocumentBuilder build = factoria.newDocumentBuilder();
		
		DOMImplementation implementacion = build.getDOMImplementation();
		Document document = implementacion.createDocument(null, "Alumnos", null);
		document.setXmlVersion("1.0");
		
		
		while(dataI.available() != 0) {
			Element raiz = document.createElement("Alumno");
			document.getDocumentElement().appendChild(raiz);
			
			int id = dataI.readInt();
			raiz.setAttribute("id", String.valueOf(id));
	
			String nombre = dataI.readUTF();
			String apellido = dataI.readUTF();
			int edad = dataI.readInt();
			int numMat = dataI.readInt();
			
			crearElement("nombre", nombre.trim(), raiz, document);
			crearElement("apellido", apellido.trim(), raiz, document);
			crearElement("edad", Integer.toString(edad), raiz, document);
			crearElement("numMat", Integer.toString(numMat), raiz, document);
		}
		
		
		Source origen = new DOMSource(document);
		Result destino = new StreamResult(fichXML);
		
		Transformer transformacion = TransformerFactory.newInstance().newTransformer();
		transformacion.transform(origen, destino);
		
		dataI.close();
	}


	public static void crearElement (String etiqueta, String valor, Element raiz, Document document) {
//		Element etiq = document.createElement(etiqueta);
//		etiq.setTextContent(valor);
//		raiz.appendChild(etiq);
		
		Element etiq = document.createElement(etiqueta);
		Text valorEtiq = document.createTextNode(valor);
		
		raiz.appendChild(etiq);
		etiq.appendChild(valorEtiq);
	}

	private static void leerRandomFile() throws FileNotFoundException, IOException {
//		char[] nombre = new char[10];
		String nombre = "";
		String apellido = "";	
//		char[] apellido = new char[10];
		
		int [] ids = new int[3];
		String [] nombres = new String[3];
		String [] apellidos = new String[3];
		int [] edades = new int[3];
		int [] nMatriculas = new int[3];
		
		//calcular posicion formula -> (id - 1) * 52 num de bytes totales 
		
		File fAlumnos = new File("alumnos.txt");
		RandomAccessFile ra = new RandomAccessFile(fAlumnos, "r");
		
		//while (fileR.getFilePointer() != fichero.length())
		for (int i = 0; i < nombres.length; i++) {
			ids[i] = ra.readInt();
			
			for (int j = 0; j < 10; j++) {
				nombre += ra.readChar();
			}
			//String nombre0 = new String(nombre);
			nombres[i] = nombre;
			
			for (int j = 0; j < 10; j++) {
				apellido += ra.readChar();
			}	
//			String apellido0 = new String(apellido);
			apellidos[i] = apellido;

			edades[i] = ra.readInt();
			nMatriculas[i] = ra.readInt();
			
			System.out.println("ID " + ids[i] + " Nombre: " + nombre + ", Apellido: " + apellidos[i].toString() + " Edad " + edades[i] +", Nº matricula: " + nMatriculas[i] + "\n");
		}
		
		ra.close();
	}

	
	
	private static void escribirRandomFile() throws FileNotFoundException, IOException {
		
		File fAlumnos = new File("alumnos.txt");
		RandomAccessFile ra = new RandomAccessFile(fAlumnos, "rw");
		
		for (int i = 0; i < nombres.length; i++) {
			ra.writeInt(i + 1);
			
			StringBuffer sbN = new StringBuffer(nombres[i]);
			sbN.setLength(10);
			ra.writeChars(sbN.toString());
			
			StringBuffer sbA = new StringBuffer(apellidos[i]);
			sbA.setLength(10);
			ra.writeChars(sbA.toString());
			
			ra.writeInt(edad[i]);
			
			ra.writeInt(nMatricula[i]);
		}
		
		ra.close();
	}

	private static void operacionesConFile(File fichero) throws IOException {
		if(!fichero.exists()) {
			fichero.createNewFile();
		}
		
		System.out.println(new Date(fichero.lastModified()));
		System.out.println(fichero.getAbsolutePath());
		System.out.println(fichero.getPath());
		System.out.println(new File(fichero.getAbsolutePath()).getParent());
		System.out.println(fichero.getTotalSpace());
		
		fichero.renameTo(new File("fich.txt"));
		System.out.println(fichero.getName());
		
		File fich = new File(".");
		File[] listafich = fich.listFiles();
		for (File file : listafich) {
			if(file.isFile()) {
				System.out.println(file.getName());
			} else {
				System.out.println(file.getName());
			}
		}
	}

	private static void leerEscribirObjetos(File fichAlum) throws FileNotFoundException, IOException, ClassNotFoundException {	
		
		FileOutputStream fo = new FileOutputStream(fichAlum);
		ObjectOutputStream os = new ObjectOutputStream(fo);
		
		os.writeObject(alumno1);
		os.writeObject(alumno2);
		os.writeObject(alumno3);
		
		os.close();
		
		FileInputStream fi = new FileInputStream(fichAlum);
		ObjectInputStream oi = new ObjectInputStream(fi);
		
		Alumno alum1 = (Alumno) oi.readObject();
		Alumno alum2 = (Alumno) oi.readObject();
		Alumno alum3 = (Alumno) oi.readObject();
		System.out.println(alum1.toString());
		System.out.println(alum2.toString());
		System.out.println(alum3.toString());
		
		oi.close();
	}

	private static void leerBinario(File fichBinario) throws FileNotFoundException, IOException {
		FileInputStream fi = new FileInputStream(fichBinario);
		DataInputStream is = new DataInputStream(fi);
		for (int i = 0; i < nombres.length; i++) {
			String texto = "";
			texto += is.readInt() + " ";
			texto += is.readUTF() + " ";
			texto += is.readUTF() + " ";
			texto += is.readInt() + " ";
			texto += is.readInt() + " ";
			System.out.println(texto);
		}
		
		is.close();
	}

	private static void escribirBinario(File fichBinario) throws FileNotFoundException, IOException {
		FileOutputStream fo = new FileOutputStream(fichBinario);
		OutputStreamWriter os = new OutputStreamWriter(fo);
		DataOutputStream dataO = new DataOutputStream(fo);

		System.out.println(os.getEncoding());
		
		for (int i = 0; i < nombres.length; i++) {
			dataO.writeInt(i + 1);
			dataO.writeUTF(nombres[i]);
			dataO.writeUTF(apellidos[i]);
			dataO.writeInt(edad[i]);
			dataO.writeInt(nMatricula[i]);
			
		}
		
		dataO.close();
		os.close();
	}

	private static void escribirBuffererWriter(File fichero) throws IOException {
		FileWriter fw = new FileWriter(fichero);
		BufferedWriter bw = new BufferedWriter(fw);
		
		bw.write("Hola buenas");
		bw.flush();
		bw.close();
	}

	private static void leerCarecter(File fichero) throws FileNotFoundException, IOException {
		FileReader fr = new FileReader(fichero);
		BufferedReader br = new BufferedReader(fr);
		
		int caract = 0;
		String texto = "";
		
		while(caract != -1) {
			caract = br.read();
			texto += (char)caract;
			System.out.println((char)caract);
		}
		System.out.println(texto);
		br.close();
	}

}
