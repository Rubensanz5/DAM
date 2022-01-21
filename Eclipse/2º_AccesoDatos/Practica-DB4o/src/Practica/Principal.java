package Practica;

import java.io.File;
import java.util.List;
import java.util.Scanner;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class Principal {
	static Scanner sc = new Scanner(System.in);
	static ObjectContainer db;
	static String nombreArchivo = "personas.db4o";
	static File archivo = new File(nombreArchivo);

	public static void main(String[] args) {
		
		if(!archivo.exists()) {
			db = Db4oEmbedded.openFile(nombreArchivo);
		}
		
		int opcion;
		do {
			System.out.println("MENU:\n1. Insertamos los registros por defecto en la bbdd\n2. Buscamos los datos de las personas que tienen 30 años\n3. Borramos a Alfredo\n4. "
					+ "Actualizamos la edad de Roberto a 50\n5. Salir");
			opcion = pedirNum(sc);
			switch (opcion) {
				case 1:
					//Insertamos los registros por defecto en la bbdd
					ejemploInsert(db);
					mostrarBDD(db);
					break;
				case 2:
					//Buscamos los datos de las personas que tienen 30 años
					selectPersona(new Persona(null, 30, 0, 0), db);
					break;
				case 3:
					//
					borrarPersona(new Persona("Alfredo", 20, 1.9, 90), db);
					mostrarBDD(db);
					db = abrirCerrar(db);
					break;
				case 4:
					updateRoberto(new Persona("Roberto", 35, 1.70, 70), db);
					mostrarBDD(db);
					db = abrirCerrar(db);
					break;
					
				default:
					// Borrar archivo para que no halla duplicados
					
					archivo.delete();	
					//Cerramos la base de datos
					db.close();
					break;
			}
		} while (opcion <= 5);

	
		sc.close();
	}

	public static ObjectContainer abrirCerrar(ObjectContainer nombre) {
		nombre.close();
		ObjectContainer db = Db4oEmbedded.openFile(nombreArchivo);
		return db;
	}
	
	public static void ejemploInsert(ObjectContainer db) {
		// Creamos los objetos
		Persona p1 = new Persona("Fernando", 30, 1.73, 73);
		Persona p2 = new Persona("Pepe", 30, 1.75, 80);
		Persona p3 = new Persona("Alfredo", 20, 1.9, 90);
		Persona p4 = new Persona("Roberto", 35, 1.70, 70);
		Persona p5 = new Persona("Domingo", 30, 1.73, 80);

		// Guardamos los objetos en la base de datos
		db.store(p1);
		db.store(p2);
		db.store(p3);
		db.store(p4);
		db.store(p5);
	}
	
	public static void borrarPersona(Persona p, ObjectContainer db) {
		ObjectSet<Persona> result = db.queryByExample(p);

		if (result.hasNext()) {
			Persona pDel = result.next();
			db.delete(pDel);
		} else {
			System.out.println("No existe el objeto");
		}
	}
	
	public static void updateRoberto(Persona p, ObjectContainer db) {
		ObjectSet<Persona> result2 = db.queryByExample(p);

		// Si existe el objeto
		if (result2.hasNext()) {
			// Obtengo el objeto persona
			Persona pAct = result2.next();

			// Actualizo el objeto
			pAct.setEdad(50);

			// Guardamos el objeto de nuevo, actualizandolo
			db.store(pAct);
		}
	}
	
	public static void mostrarBDD(ObjectContainer db) {
		@SuppressWarnings("rawtypes")
		ObjectSet resultado = db.queryByExample(Persona.class);
		mostrarListaResultado(resultado);
	}
	
	public static void mostrarListaResultado(List<?> resultado){
		System.out.println();
		System.out.println("-------------------------------------------------------------------------------------");
		for (Object o : resultado) {
			System.out.println(o);
		}
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println();
	}

	public static void selectPersona(Persona p, ObjectContainer db) {
		ObjectSet<Persona> resultado = db.queryByExample(p);
		mostrarListaResultado(resultado);
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
	
	
}
