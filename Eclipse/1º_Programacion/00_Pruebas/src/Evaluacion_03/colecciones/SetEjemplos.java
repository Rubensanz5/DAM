package Evaluacion_03.colecciones;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

import Evaluacion_02.Persona.*;



public class SetEjemplos {

	public static void main(String[] args) {
		//hashset
		
		HashSet<String> conjuntoNombres = new HashSet<>();
		
		conjuntoNombres.add("Maria Jesus");
		conjuntoNombres.add("Hector");
		conjuntoNombres.add(null);
		conjuntoNombres.add("Hector");
		conjuntoNombres.add("Jose Ignacio");
		
		System.out.println(conjuntoNombres);

		System.out.println(conjuntoNombres.contains("Jose Ignacio"));
		conjuntoNombres.remove("Jose Ignacio");
		System.out.println(conjuntoNombres.contains("Jose Ignacio"));
		System.out.println("El HashSet tiene " + conjuntoNombres.size() + " elementos");

		
		HashSet<Persona> conjuntoPersonas = new HashSet<>();
		
		Persona persona1 = new Persona("Hector", "Moran", 38);
		Persona persona2 = new Persona("Antonio", "Valle", 42);
		Persona persona3 = new Persona("Hector", "Moran", 45);
		Persona persona4 = new Persona("Hector", "Moran", 38);
		Persona persona5 = persona2;
		
		conjuntoPersonas.add(persona1);
		conjuntoPersonas.add(persona2);
		conjuntoPersonas.add(persona3);
		conjuntoPersonas.add(persona4);
		conjuntoPersonas.add(persona5);

		System.out.println(conjuntoPersonas);
		
		//recorrer coleccionables (for each)
		
		for(Persona p : conjuntoPersonas) {
			System.out.println(p.getNombre());
		}
		
		//recorrer con un iterador
		
		Iterator<Persona> iterador = conjuntoPersonas.iterator();
		
		while(iterador.hasNext()) {
			Persona p = (Persona) iterador.next();
			System.out.println(p.getNombre());
		}
		
		//linkedHashSet
		
		LinkedHashSet<Persona> linkedPersonas = new LinkedHashSet<>();
		
		Persona persona01 = new Persona("Hector", "Moran", 38);
		Persona persona02 = new Persona("Antonio", "Valle", 42);
		Persona persona03 = new Persona("Hector", "Moran", 45);
		Persona persona04 = new Persona("Hector", "Moran", 38);
		Persona persona05 = persona02;
		
		linkedPersonas.add(persona01);
		linkedPersonas.add(persona02);
		linkedPersonas.add(persona03);
		linkedPersonas.add(persona04);
		linkedPersonas.add(persona05);

		System.out.println(linkedPersonas);
		
		//treeSet
		
		TreeSet<Integer> setNumeros = new TreeSet<>();
		setNumeros.add(3);
		setNumeros.add(1);
		setNumeros.add(2);
		setNumeros.add(4);
		setNumeros.add(1);
		setNumeros.add(-2);
		
		//aparecen ordenados si los recorres
		Iterator<Integer> iteradorNumeros = setNumeros.descendingIterator();
		
		while(iteradorNumeros.hasNext()) {
			System.out.println(iteradorNumeros.next());
		}
		
		//tree set con objetos
		
		TreeSet<Persona> arbolPersonas = new TreeSet<>();
		// el metodo creado en persona se llama con el add
		arbolPersonas.add(new Persona("Hector", "Moran", 38));
		arbolPersonas.add(new Persona("Maria", "Valle", 45));
		arbolPersonas.add(new Persona("Borja", "Perez", 24));
		arbolPersonas.add(new Persona("Veronica", "Rodriguez", 52));
		arbolPersonas.add(new Persona("Luis", "Reguera", 36));
		
		Iterator<Persona> iteradorArbol = arbolPersonas.iterator();
		
		while(iteradorArbol.hasNext()) {
			System.out.println(iteradorArbol.next().getNombre());
		}
		//se puede añadir el codigo entero de la clase OrdenarPersonaPorApellidos en los parentesis
		TreeSet<Persona> arbolPersonas1 = new TreeSet<>(new OrdenarPersonaPorApellidos());


		arbolPersonas1.add(new Persona("Hector", "Moran", 38));
		arbolPersonas1.add(new Persona("Maria", "Valle", 45));
		arbolPersonas1.add(new Persona("Borja", "Perez", 24));
		arbolPersonas1.add(new Persona("Veronica", "Rodriguez", 52));
		arbolPersonas1.add(new Persona("Luis", "Reguera", 36));
		
		for(Persona p : arbolPersonas1) {
			System.out.println(p.getNombre());
		}
		
	}

}
