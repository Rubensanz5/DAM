package Evaluacion_03.excepciones;

import java.util.Calendar;

import Evaluacion_02.Persona.Persona;
import Evaluacion_02.Persona.Profesor;
import Evaluacion_02.Persona.ProfesorInterino;


public class PruebasPersonaTryCatch {
	public static void main(String[] args) {
		Persona[] personas = new Persona[4];
		
		personas[0] = new Persona("Jeff","Preson",57);
		personas[1] = new Profesor("Ana Patricia","Botin",60,"anapatri.botin");
		personas[2] = new ProfesorInterino("Mark","Lenders",23,Calendar.getInstance());
		
		Profesor profe = new Profesor("Hector", "Moran", 38, "hector.morbay");
		
		try {
			Persona persona = new Persona("Luis","Gonzalez",46);
			persona.setEdad(-47);
			System.out.println("Edad camiada con exito");
		} catch (ExcepcionEdadInvalida ex) {
			System.out.println(ex.getMessage());
		}
		
		try {
			addPersona(personas, profe, 5);
		} catch (ArrayIndexOutOfBoundsException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public static void addPersona(Persona[] listado, Persona persona, int posicion) {
		Persona[] nuevoArrayListado = new Persona[listado.length + 1];
		System.arraycopy(listado, 0, nuevoArrayListado, 0, posicion);
		nuevoArrayListado[posicion] = persona;
		System.arraycopy(listado, posicion, nuevoArrayListado, posicion + 1, listado.length - posicion);
		listado = nuevoArrayListado;
	}
}
