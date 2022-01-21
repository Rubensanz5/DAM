package Practica_9;

public class Persona {

	/**
	 * Atributos de la clase 
	 * String nombre
	 * String apellido
	 * String dni
	 * String fecha_nac
	 * boolean sexo
	 * String user
	 * String pin
	 * Cuenta cuenta1 = new Cuenta()
	 * Cuenta cuenta2 = new Cuenta()
	 * Cuenta cuenta3 = new Cuenta()
	
	 * Deposito deposito1 = new Deposito()
	 * Deposito deposito2 = new Deposito()
	 * 
	 */
	protected String nombre;
	protected String apellido;
	protected String dni;
	protected String fecha_nac;
	protected boolean sexo;

	public Persona() {
		super();
	}

	/**
	 * Metodo para devolver el nombre del cliente
	 * @return String nombre del cliente
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodo para devolver el apellido del cliente
	 * @return String apellido del cliente
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * Metodo para devolver el DNI del cliente
	 * @return String DNI cliente
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * Metodo para obtener la fecha de nacimiento del cliente
	 * @return String fecha nacimiento del cliente
	 */
	public String getFecha_nac() {
		return fecha_nac;
	}

	/**
	 * Metodo para devolver el sexo del cliente
	 * @return boolean sexo del cliente
	 */
	public boolean isSexo() {
		return sexo;
	}

	/**
	 * Metodo para comprobar si es mayor de edad o no
	 * @param fechaActual String con la fecha actual formato dd/mm/aaaa
	 * @return retorna un boolean con true si es mayor de edad y false si no
	 */
	public boolean comprobarEdad(String fechaActual) {
		boolean puede = false;
		int anio = fechaActual.lastIndexOf('/');
		int dia =  fechaActual.indexOf('/');
		
		int diaActual = Integer.parseInt(fechaActual.substring(0,dia));
		int anioActual = Integer.parseInt(fechaActual.substring(anio + 1));
		int mesActual = Integer.parseInt(fechaActual.substring(dia + 1, anio));
		
		int diaNac = Integer.parseInt(this.fecha_nac.substring(0,dia));
		int anioNac = Integer.parseInt(this.fecha_nac.substring(anio + 1));
		int mesNac = Integer.parseInt(this.fecha_nac.substring(dia + 1, anio));
		
		if (anioActual > anioNac + 18){
			puede = true;
		} else if (anioActual == anioNac +18) {
			if(mesActual > mesNac) {
				puede = true;
			} else if(mesActual == mesNac) {
				if(diaActual >= diaNac) {
					puede = true;
				}
			}
		}
		
		
		return puede;
	}

}