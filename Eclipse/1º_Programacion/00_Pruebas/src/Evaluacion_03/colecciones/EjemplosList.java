package Evaluacion_03.colecciones;

import java.util.ArrayList;
import java.util.ListIterator;

public class EjemplosList {
	public static void main(String[] args) {
		//arraylist
		
		ArrayList<String> listaNombres = new ArrayList<>();
		listaNombres.add("Jose Ignacio");
		listaNombres.add("Hector");
		listaNombres.add(null);
		listaNombres.add("Hector");
		listaNombres.add("Jose Ignacio");
		
		System.out.println("Primer elemento" + listaNombres.get(0));
		System.out.println("Primer elemento" + listaNombres.get(1));
		String profesor = listaNombres.set(1, "Maria Jesus");
		System.out.println("Elemento reemplazado" + profesor);

		
		for(String nom : listaNombres) {
			System.out.println(nom);
		}
		
		
		ArrayList<String> lista = new ArrayList<>();
		lista.add("A");
		lista.add("B");
		lista.add("C");
		lista.add("D");
		lista.add("E");
		
		ListIterator<String> it = lista.listIterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		System.out.println("Anterior posicion: " + it.previousIndex());
		System.out.println("Siguiente posicion: " + it.nextIndex());
		
		while(it.hasPrevious()) {
			System.out.println(it.previous());
		}
		
		it.remove();
		it.next();
		it.set("H");
		
		for(String letra : lista){
			System.out.println(letra);
		}
		
		//linked list(cola)
		Cola c = new Cola();
		System.out.println(c.frente());
		
		for (int i = 1; i <= 5; i++) {
			c.encolar(i);			
		}
		
		System.out.println("Frente: " + c.frente());
		c.desencolar();
		System.out.println("Frene :" + c.frente());

		//linked list(pila)
		Pila p = new Pila();
		System.out.println(p.cima());
		for (int i = 1; i <= 5; i++) {
			p.apilar(i);			
		}
		System.out.println("Cima" + p.cima());
		p.apilar(6);
		System.out.println("Cima" + p.cima());
		p.desapilar();
		System.out.println("Cima" + p.cima());
		
	}
	
}
