package Evaluacion_02.Persona;

import java.text.DateFormat;
import java.util.Calendar;

public class ProfesorInterino extends Profesor {

	private Calendar fechaComienzoInterinidad;
	
	public ProfesorInterino(String nombre, String apellidos, int edad, Calendar fechaComienzoInterinidad) {
		super(nombre, apellidos, edad);
		this.fechaComienzoInterinidad = fechaComienzoInterinidad;
	}
	

	public Calendar getFechaComienzoInterinidad() {
		return fechaComienzoInterinidad;
		
	}
	
	@Override
	public void mostrarNombreApellidosYCarnet() { 
		 
		System.out.println("Profesor ITERINO: " + getNombre() + " " + getApellidos() + " con feha: " + DateFormat.getDateTimeInstance().format(fechaComienzoInterinidad.getTime())); 
	}
	
}
