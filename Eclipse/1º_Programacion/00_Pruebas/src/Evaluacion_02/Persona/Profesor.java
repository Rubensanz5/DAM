package Evaluacion_02.Persona;

public class Profesor extends Persona {

	private String idProfesor;
	
	public Profesor(String nombre, String apellidos, int edad) {
		super(nombre, apellidos, edad);
		this.idProfesor = "Desconocido";
	}
	
	public Profesor(String nombre, String apellidos, int edad,String idProfesor) {
		super(nombre, apellidos, edad);
		this.idProfesor = idProfesor;
	}
	
	public String getIdProfesor() {
		return idProfesor;
	}

	public void setIdProfesor(String idProfesor) {
		this.idProfesor = idProfesor;
	}
	
	// Métodos específicos de Id subclase 
	public void mostrarNombreApellidosYCarnet() { 
	 
		System.out.println("Profesor de nombre: " + getNombre() + " " + getApellidos() + " con Id de profesor: " + getIdProfesor()); 
	}

	

}
