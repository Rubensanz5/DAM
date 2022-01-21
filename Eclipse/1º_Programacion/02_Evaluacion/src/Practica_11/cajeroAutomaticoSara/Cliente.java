/**
 * 
 */
package Practica_11.cajeroAutomaticoSara;

/**
 * @author saral
 *
 */
public class Cliente {

	private String nombre;
	private String apellido;
	private String DNI;
	private String fechaNacimiento;
	private boolean hombre;
	private String usuario;
	private int contrasena;
	public Cuenta cuenta1;
	public Cuenta cuenta2;
	public Cuenta cuenta3;
	public Deposito deposito1;
	public Deposito deposito2;
	public int numCuentas;
	public int numDepositos;
	/***
	 * constructor de la clase cliente
	 * @param nombre objeto String con el nombre del cliente
	 * @param apellido objeto String con el apellido del cliente
	 * @param DNI objeto String con el DNI del cliente
	 * @param fechaNacimiento objeto String con la fecha de nacimiento del cliente
	 * @param hombre variable boolean que indica si el cliente sera hombre o mujer
	 * @param usuario objeto String con el usuario del cliente
	 * @param contraseña objeto String con la contraseña del cliente
	 * @param cuenta1 objeto cuenta con la cuenta del cliente
	 * @param cuenta2 objeto cuenta con la cuenta del cliente
	 * @param cuenta3 objeto cuenta con la cuenta del cliente
	 * @param deposito1 objeto deposito con el deposito del cliente
	 * @param deposito2 objeto deposito con el deposito del cliente
	 * @param numCuentas variable int para saber cuantas cuentas tiene un cliente
	 * @param numDepositos variable int para saber cuantos depositos tiene un cliente
	 */
	public Cliente(String nombre, String apellido, String DNI, String fechaNacimiento, boolean hombre, String usuario,
			int contrasena, Cuenta cuenta1, Cuenta cuenta2,Cuenta cuenta3, Deposito deposito1 , Deposito deposito2, int numCuentas, int numDepositos) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.DNI = DNI;
		this.fechaNacimiento = fechaNacimiento;
		this.hombre = hombre;
		this.usuario = usuario;
		this.contrasena = contrasena;
		this.cuenta1 = cuenta1;
		this.cuenta2 = cuenta2;
		this.cuenta3 = cuenta3;
		this.deposito1 = deposito1;
		this.deposito2 = deposito2;
		this.numCuentas = numCuentas;
		this.numDepositos = numDepositos;
	}
	/***
	 * metodo para monstrar el nombre del cliente
	 * @return objeto String con el nombre del cliente
	 */
	public String getNombre() {
		return this.nombre;
	}
	/***
	 * metodo para monstrar el apellido del cliente
	 * @return objeto String con el apellido del cliente
	 */
	public String getApellido() {
		return this.apellido;
	}
	/***
	 * metodo para monstrar el DNI del cliente
	 * @return objeto String con el DNI del cliente
	 */
	public String getDNI() {
		return this.DNI;
	}
	/***
	 * metodo para monstrar la fecha de nacimiento del cliente
	 * @return objeto String con la fecha de nacimiento del cliente
	 */
	public String getFechaNacimiento() {
		return this.fechaNacimiento;
	}
	/***
	 * metodo para monstrar si un cliente es hombre (true) o mujer (false) del cliente
	 * @return una variable boolean que retorna true si es hombre y false si es mujer
	 */
	public boolean isHombre() {
		return this.hombre;
	}
	/***
	 * metodo para monstrar el usuario del cliente
	 * @return objeto String con el usuario del cliente
	 */
	public String getUsuario() {
		return usuario;
	}
	/***
	 * metodo para monstrar la contraseña del cliente
	 * @return objeto String con la contraseña del cliente
	 */
	public int getContrasena() {
		return contrasena;
	}
	
	/***
	 * metodo para saber si un cliente es mayor de edad o no
	 * @param añoActual variable int donde se pasa el valor del año que se quiere comprobar
	 * @param diaActual variable int donde se pasa el valor del dia que se quiere comprobar
	 * @param mesActual variable int donde se pasa el valor del mes que se quiere comprobar
	 * @return variable boolean que retrorna true si es mayor de dad y false si es menor
	 */
	public boolean mayoriaEdad(int anoActual, int diaActual, int mesActual) {
		int ano;
		int dia;
		int mes;
		boolean mayorEdad;
		dia = Integer.parseInt(this.getFechaNacimiento().substring(0,1));
		mes =  Integer.parseInt(this.getFechaNacimiento().substring(3,4));
		ano =  Integer.parseInt(this.getFechaNacimiento().substring(7));
		if (anoActual - ano == 18) {
			if (mesActual < mes) {
				mayorEdad = false;
			}else if(mesActual == mes) {
					if (diaActual < dia) {
						mayorEdad = false;
					} else {
						mayorEdad = true;
					}	
			}else {
				mayorEdad = true;
				}
			
			 
		 } else if (anoActual - ano > 18) {
			 mayorEdad = true;
			 
		 }else {
			 mayorEdad = false;
		 }
		return mayorEdad;
	}
	
	/***
	 * metodo para calcular la cantidad de dinero que tiene un cliente en total en todas sus cuentas
	 * @return variable int con la suma de esas cuentas
	 */
	public int dineroTotal() {
		int dineroTotal = 0;
		if (this.cuenta1 != null) {
			dineroTotal += this.cuenta1.dinero ;
			
		}if (this.cuenta2 != null) {
			dineroTotal += this.cuenta2.dinero ;
			
		}if (this.cuenta3 != null) {
			dineroTotal += this.cuenta3.dinero ;
		}
		return dineroTotal;
	}
	
	
	
}