package Ejemplos.HTML;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class ConvertidorHTML {

	public static void main(String[] args) {
		
		try {
			String hojaEstilo = ".\\ficheros\\xml\\plantilla-alumnos.xsl";
			String datosAlumno = ".\\ficheros\\xml\\alumnos37.xml";
	
			//creamos el fich html
			File pagHTML = new File(".\\ficheros\\xml\\alumnos.html");
			FileOutputStream salida = new FileOutputStream(pagHTML);
			//Tomamos la fuente de estilos
			Source estilos = new StreamSource(hojaEstilo);
			//Tomamos la fuente de datos
			Source datos = new StreamSource(datosAlumno);
			
			Result resultado = new StreamResult(salida);
			
			Transformer trans = TransformerFactory.newInstance().newTransformer(estilos);
			trans.transform(datos, resultado);
			
		} catch (FileNotFoundException | TransformerException | TransformerFactoryConfigurationError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
