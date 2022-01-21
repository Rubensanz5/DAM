package Evaluacion_03.colecciones;

import java.util.LinkedList;

public class Cola {
	private LinkedList cola;
	
	public Cola() {
		this.cola = new LinkedList();
	}
	
	public void encolar(Object elemento) {
		cola.add(elemento);
	}
	
	public Object desencolar() {
		return cola.remove();
	}
	
	public Object frente() {
		return cola.peek();
	}
}
