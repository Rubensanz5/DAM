/**
 * 
 */
package Practica_11.cajeroAutomaticoSara;

/**
 * @author saral
 *
 */
public class Deposito {
	int dinero;
	int tipo;
	public static final int JUNIOR = 1;
	public static final int SENIOR = 2;
	public static final int MAX = 3;
	
	/***
	 * constructor de depositos 
	 * @param dinero variable int, donde se registra el saldo del deposito
	 * @param tipo variable int, donde se registra uno de los tipos del deposito
	 */
	public Deposito(int dinero, int tipo) {
		this.dinero = dinero;
		this.tipo = tipo;
	}
	
	
	
	public int getDinero() {
		return dinero;
	}



	public void setDinero(int dinero) {
		this.dinero = dinero;
	}



	public int getTipo() {
		return tipo;
	}



	public void setTipo(int tipo) {
		this.tipo = tipo;
	}



	/***
	 * metodo para dar un valor string donde indique el tipo de deposito indicado por un int
	 * @return una variable satring que devuelve el estado del deposito
	 */
	public String estadoDeposito () {
		String estadoDeposito = "deposito ";
		switch (tipo) {
		case 1:
			estadoDeposito += "Junior";
			break;
		case 2:
			estadoDeposito += "Senior";
			break;
		case 3:
			estadoDeposito += "MAX";
			break;
		}
		estadoDeposito += ":" + dinero + "€";	
		return estadoDeposito;
		}
	/***
	 * metodo para dar un valor string donde indique el tipo de deposito indicado por un int
	 * @return objeto string que devuelve el tipo de deposito
	 */
	public static String nombrarDeposito(int tipo) {
		switch (tipo) {
		case 1:
			return  "Junior";
		case 2:
			return "Senior";
		case 3:
			return "MAX";
		}
		return null;
	}
	
	/***
	 * metodo para contar cuantos depositos tiene un cliente
	 * @param clienteActual objeto Cliente del cual se desea saber los depositos que tiene
	 * @return variable int que indica la cantidad de depositos tiene el cliente
	 */
	public static int cantidadDepositos (Cliente clienteActual) {
		int cantidadDepositos = 0;
		if (clienteActual.deposito1 != null) {
			cantidadDepositos++ ;
		}
		if (clienteActual.deposito2 != null) {
			cantidadDepositos++ ;
		}
		return cantidadDepositos;
	}
}
