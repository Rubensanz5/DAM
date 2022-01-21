package Ejemplos.XString;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.thoughtworks.xstream.XStream;

public class EscribirPesona {

	public static void main(String[] args) {
		XStream xs = new XStream();
			
		xs.alias("persona", Persona.class);
		
		Tlfon tel = new Tlfon(123, 123456);
		Tlfon fax = new Tlfon(123, 999999);
		
		Persona p = new Persona("Ruben", "Sanz", tel, fax);
		
		String xml = xs.toXML(p);
		try {
			xs.toXML(p,new FileOutputStream("ficheros\\xml\\personas2.xml"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(xml);

	}

}
