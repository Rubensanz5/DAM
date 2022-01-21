/**
 * 
 */
package Practica_11.cajeroAutomaticoSara;

/**
 * @author saral
 *
 */
public class Cuenta {
	String iban;
	int dinero = 0;
	boolean euros; // true euros
	boolean corriente; //corriente true
	
	/***
	 * constructor del objeto cuenta
	 * @param iban objeto String, guarda el iban de la cuenta
	 * @param dinero variable int, con el saldo de la cuenta
	 * @param euros variable boolean con el tipo de moneda de la cuenta (€ o $) de la cuenta
	 * @param corriente variable boolean con el tipo de cuenta (corriente o nomina) que es la cuenta
	 */
	public Cuenta(String iban, int dinero, boolean euros, boolean corriente) {
		this.iban = iban;
		this.dinero = dinero;
		this.euros = euros;
		this.corriente = corriente;
	}

	
	public String getIban() {
		return iban;
	}


	public void setIban(String iban) {
		this.iban = iban;
	}


	public int getDinero() {
		return dinero;
	}


	public void setDinero(int dinero) {
		this.dinero = dinero;
	}


	public boolean isEuros() {
		return euros;
	}


	public void setEuros(boolean euros) {
		this.euros = euros;
	}


	public boolean isCorriente() {
		return corriente;
	}


	public void setCorriente(boolean corriente) {
		this.corriente = corriente;
	}


	/***
	 * metodo para mostrar por pantalla el valor al que corresponde el boleano de euros y de corriente
	 * @return el objeto String creado al comprobar los valores de corriente y euros
	 */
	public String estadoCuenta () {
		String estadoCuenta;
		estadoCuenta = "Cuenta " + (corriente ? "Corriente" : "Nómina") + ":" + dinero + ( euros ? "€" : "$" ) + "\n";	
		return estadoCuenta;
		}
	/***
	 * metodo para mostrar el estado de las cuentas y loss depositos del cliente
	 * @param clienteActual objeto cliente, sobre el que se quiere saber el estado de sus cuentas
	 * @return objeto String donde se alamacena la informacion de todas las cuentas y depsositos que no esten con valor nulo
	 */
	public static String mostarCuentas (Cliente clienteActual) {
		String mensaje;
		mensaje =  " Estas son las diferentes cuentas que tienes\n" ;
		if (clienteActual.cuenta1 != null) {
			mensaje += "cuenta1 " +clienteActual.cuenta1.estadoCuenta() + "\n";
		}
		if (clienteActual.cuenta2 != null) {
			mensaje +=  "cuenta2 " + clienteActual.cuenta2.estadoCuenta() + "\n";
		}
		if (clienteActual.cuenta3 != null) {
			mensaje += "cuenta3 " + clienteActual.cuenta3.estadoCuenta() + "\n";
		}
		if (clienteActual.deposito1 != null) {
			mensaje +=  "deposito1 " + clienteActual.deposito1.estadoDeposito() + "\n";
		}
		if (clienteActual.deposito2 != null) {
			mensaje += "deposito2 " + clienteActual.deposito2.estadoDeposito() + "\n";
		}
		
		return mensaje;
	}
	

}
