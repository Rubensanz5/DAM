package Evaluacion_02.Persona;

import java.util.Calendar;

public class Principal {

	public static void main(String[] args) {
		Calendar fecha = Calendar.getInstance(); 
		fecha.set(2021, 01, 17); 
		// Profesor 
		Profesor profesor1 = new Profesor ("Héctor", "Morán Bayón", 38); 
		profesor1.setIdProfesor("hector.morbay"); 
		profesor1.mostrarNombreApellidosYCarnet(); 

		// Profesorinterino 
		ProfesorInterino interino1 = new ProfesorInterino("José Antonio", "Rodríguez Pérez", 57, fecha); 
		System.out.println("El profesor interino " + interino1.getNombre() + " " + interino1.getApellidos() + " se incorporó en la fecha: " + fecha.getTime().toString() ); 
		
		// Casting hacia arriba - Profesorinterino en Profesor 
		Profesor profesor2 = new ProfesorInterino("Natalia", "Valle Centeno", 25, fecha); 
		profesor2.mostrarNombreApellidosYCarnet(); // No puede acceder a métodos específicos de Profesorinterino 
		
		profesor1 = interino1; 
		profesor1.mostrarNombreApellidosYCarnet(); // No puede acceder a métodos específicos de Profesorinterino
		
		// Casting hacia abajo - Profesor a Profesorinterino 
		ProfesorInterino interino2 = (ProfesorInterino) profesor2; 
		interino2.getFechaComienzoInterinidad(); // Puedes acceder a métodos específicos de Profesorinterino 
		System.out.println("Fecha: " + ((ProfesorInterino) profesor1).getFechaComienzoInterinidad().getTime().toString()); 

		
		//Uso de instanceof
		if(profesor1 instanceof ProfesorInterino){
			System.out.println("Profesor1 es un objeto de tipo ProfesorInterino");
			ProfesorInterino nuevoProfesor = (ProfesorInterino) profesor1;
			nuevoProfesor.getFechaComienzoInterinidad();
		}
		
		if (interino1 instanceof Profesor) {
			System.out.println("interino1 es un objeto de tipo Profesor");
		} else {
			System.out.println("interino1 no apunta a un objeto de tipo Profesor");
		}
		
		Profesor profesor3 = new Profesor("Hector", "Moran", 38);
		
		if (profesor3 instanceof ProfesorInterino) {
			System.out.println("Profesor3 es un objeto de tipo ProfesorInterino");
		} else {
			System.out.println("Profesor3 no es un objeto de tipo ProfesorInterino");
		}
	
	
		Profesor polimorfo1 = new Profesor("Jose Antonio", "Rodriguez Perez", 57);
		Profesor polimorfo2 = new ProfesorInterino("Natalia", "Valle", 25, fecha);
		
		System.out.println(viewCompleteName(polimorfo1));
		System.out.println(viewCompleteName(polimorfo2));
		System.out.println(viewCompleteName(new Persona("Antonio" ,"Macias", 65)));
		
		
		Profesor polimorfo3 = new Profesor("Jose Antonio", "Rodriguez Perez", 57);
		Profesor polimorfo4 = new ProfesorInterino("Natalia", "Valle", 25, fecha);
		
		polimorfo3.mostrarNombreApellidosYCarnet();
		polimorfo4.mostrarNombreApellidosYCarnet();	
	}

	public static String viewCompleteName(Persona persona) {
		return persona.getNombre() + " " + persona.getApellidos();
	}
}
