package Ejercicios.Ejercicio1.Ejercicio1_37;

import java.util.ArrayList;

import Ejercicios.Ejercicio1.Ejercicio1_26.Alumno;

public class ListaAlumnos {
	private ArrayList<Alumno> lista = new ArrayList<>();
	
	public void add(Alumno al) {
		lista.add(al);
	}

	public ArrayList<Alumno> getLista() {
		return lista;
	}
	
	
}
