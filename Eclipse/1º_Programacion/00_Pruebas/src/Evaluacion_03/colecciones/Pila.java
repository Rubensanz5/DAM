package Evaluacion_03.colecciones;

import java.util.LinkedList;

public class Pila {
	private LinkedList pila;
	
	public Pila() {
		this.pila = new LinkedList();
	}
	
	public void apilar(Object elemento) {
		pila.push(elemento);
	}
	
	public Object desapilar() {
		return pila.pop();
	}
	
	public Object cima() {
		return pila.peek();
	}


}
