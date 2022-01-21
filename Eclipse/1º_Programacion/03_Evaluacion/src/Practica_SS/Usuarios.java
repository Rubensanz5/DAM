package Practica_SS;

public class Usuarios {
	private String nombre;
	private String apellido;
	private String dni;
	private Recursos recursoUsado;
	private boolean hombre;
	private boolean usandoRecurso;
	private boolean usandoMesa;
	
	public Usuarios(String nombre, String apellido, String dni,boolean hombre) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.hombre = hombre;
		this.recursoUsado = null;
		this.usandoRecurso = false;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Recursos getRecursoUsado() {
		return recursoUsado;
	}

	public void setRecursoUsado(Recursos recursoUsado) {
		this.recursoUsado = recursoUsado;
	}

	public boolean isUsandoRecurso() {
		return usandoRecurso;
	}

	public void setUsandoRecurso(boolean usandoRecurso) {
		this.usandoRecurso = usandoRecurso;
	}

	public boolean isHombre() {
		return hombre;
	}

	public void setHombre(boolean hombre) {
		this.hombre = hombre;
	}

	public boolean isUsandoMesa() {
		return usandoMesa;
	}

	public void setUsandoMesa(boolean usandoMesa) {
		this.usandoMesa = usandoMesa;
	}
	
}
