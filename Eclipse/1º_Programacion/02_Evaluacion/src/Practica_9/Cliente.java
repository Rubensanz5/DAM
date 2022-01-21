 package Practica_9;

 
 /**
  * @author Ruben Sanz
  *
  */
public class Cliente extends Persona {
	
	private String user;
	private String pin;
	
	public Cuenta cuenta1 = new Cuenta();
	public Cuenta cuenta2 = new Cuenta();
	public Cuenta cuenta3 = new Cuenta();
	
	public Deposito deposito1 = new Deposito();
	public Deposito deposito2 = new Deposito();
	
	/**
	 * Constructor.
	 * @param nombre de tipo String
	 * @param apellido de tipo String
	 * @param dni de tipo String
	 * @param fecha_nac de tipo String
	 * @param sexo de tipo boolean
	 * @param user de tipo String
	 * @param pin de tipo String
	 * @param cuenta1 de tipo Cuenta
	 * @param cuenta2 de tipo Cuenta
	 * @param cuenta3 de tipo Cuenta
	 * @param deposito1 de tipo Deposito
	 * @param deposito2 de tipo Deposito
	 * 
	 */
	
	public Cliente(String nombre, String apellido, String dni, String fecha_nac, boolean sexo, String user, String pin, Cuenta cuenta1, Cuenta cuenta2, Cuenta cuenta3, Deposito deposito1,Deposito deposito2) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.fecha_nac = fecha_nac;
		this.sexo = sexo;
		this.user = user;
		this.pin = pin;
		this.cuenta1 = cuenta1;
		this.cuenta2 = cuenta2;
		this.cuenta3 = cuenta3;
		this.deposito1 = deposito1;
		this.deposito2 = deposito2;
	}
	
	/**
	 * Metodo para devolver el usuario del cliente
	 * @return String usuario del cliente
	 */
	
	public String getUser() {
		return user;
	}
	
	/**
	 *Metodo para devolver el pin del cliente
	 * @return String pin del cliente
	 */
	
	public String getPin() {
		return pin;
	}
	
	/**
	 * Metodo para comprobar si puede retirar dinero
	 * @return boolean para comprobar que pueda retirar dinero
	 */
	
	public boolean retirarDinero() {
		boolean puede = false;
		 if(this.cuenta1.comprobarRetirada(10)
					|| (this.cuenta2 != null && this.cuenta2.comprobarRetirada(10)) 
					|| (this.cuenta3 != null && this.cuenta3.comprobarRetirada(10))){
			 puede = true;
			 
		 }
		return puede;
	}
	
	/**
	 * Metodo para comprobar si puede ingresar dinero
	 * @return boolean para comprobar que pueda ingresar dinero
	 */
	
	public  boolean ingresarDinero() {
		boolean puede = false;
		 if((this.getSaldoTotal() * 0.1) > 0){
			 puede = true;
			 
		 }
		return puede;
	}

	/**
	 * Metodo para comprobar si puede transferir dinero entre sus cuentas
	 * @return boolean para comprobar que pueda trasferir dinero entre sus cuentas
	 */
	
	public  boolean entreCuentas() {
		boolean puede = false;
		if(this.getSaldoTotal() > 0 && (this.cuenta2 != null || this.cuenta3 != null )) {
			 puede = true;
		 }
		return puede;
	}
	
	/**
	 * Metodo para comprobar si puede transferir dinero a otras cuentas
	 * @return boolean para comprobar que pueda transferir dinero a otras cuentas
	 */
	
	public boolean otrasCuentas() {
		boolean puede = false;
		if(this.cuenta1.getSaldo() >= 3.95 
				|| (this.cuenta2 != null && this.cuenta2.getSaldo() >= 3.95) 
				|| (this.cuenta3 != null && this.cuenta3.getSaldo() >= 3.95)) {
			 puede = true;
		 }
		return puede;
	}
	
	/**
	 * Metodo para comprobar si puede abrir un deposito
	 * @return boolean para comprobar que pueda abrir un deposito
	 */
	
	public boolean crearDeposito() {
		boolean puede = false;
		if(this.cuenta1.getSaldo() >= 500 
				|| (this.cuenta2 != null && this.cuenta2.getSaldo() >= 500) 
				|| (this.cuenta3 != null && this.cuenta3.getSaldo() >= 500)) {
			 puede = true;
			 
		 }
		return puede;
	}
	
	/**
	 * Metodo para obtener el saldo total de la cuenta actual
	 * @return double con el total de las cuentas
	 */
	public double getSaldoTotal() {
		double total = 0;
		if(this.cuenta1 != null && this.cuenta2 != null && this.cuenta3 != null) {
			total = this.cuenta1.getSaldo() + this.cuenta2.getSaldo() + this.cuenta3.getSaldo();
		} else if(this.cuenta1 != null && this.cuenta2 != null && this.cuenta3 == null) {
			total = this.cuenta1.getSaldo() + this.cuenta2.getSaldo();
		} else if(this.cuenta1 != null && this.cuenta2 == null && this.cuenta3 == null) {
			total = this.cuenta1.getSaldo();
		} 
		
		return total;
	}
	
	/**
	 * Metodo para mostrar las cuentas y depositos
	 * @return String con todas las cuentas disponibles y depositos
	 */
	
	public String mostrarCuentas() {
		String mensaje = "Tus cuentas son las siguientes: \n" ;
		
		if (this.cuenta1 != null) {
			mensaje +=  "Cuenta 1: " + this.cuenta1.estadoDeLaCuenta() + "\n";
		} 
		if (this.cuenta2 != null) {
			mensaje += "Cuenta 2: " + this.cuenta2.estadoDeLaCuenta() + "\n";
		} 
		if (this.cuenta3 != null) {
			mensaje += "Cuenta 3: " + this.cuenta3.estadoDeLaCuenta() + "\n";
		} 
		if (this.deposito1 != null) {
			mensaje += "Deposito 1: " + this.deposito1.estadoDelDeposito() + "\n";
		} 
		if (this.deposito2 != null) {
			mensaje += "Deposito 2: " + this.deposito2.estadoDelDeposito() + "\n";
		}
		
		return mensaje;
	}
	
	/**
	 * Metodo para comprobar si puede hacer un ingreso en la cuenta
	 * @param cuenta0 de tipo cuenta 
	 * @param cantidad de tipo int
	 * @return boolean indicando true si puede y false si no puede
	 */
	
	public boolean comprobarIngreso(Cuenta cuenta0, double cantidad) {
		boolean puede = false;
		double porcentaje = 0.10 * getSaldoTotal();
		
		if (cuenta0.getSaldo() > 0 && cantidad <= porcentaje){
				puede = true;
			} else {
				puede = false;
		}
		return puede;
	}
}
