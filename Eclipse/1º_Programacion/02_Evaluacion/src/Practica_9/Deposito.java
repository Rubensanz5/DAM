package Practica_9;

import javax.swing.JOptionPane;
/**
 *  @author Ruben Sanz
 */
public class Deposito {
	/**
	 * Atributos de la clase 
	 * int tipo 
	 * int saldo
	 */
	public int tipo;
	public int saldo;
	
	/**
	 * Constantes con el tipo de deposito
	 * 1 - Junior
	 * 2 - Senior
	 * 3 - MAX
	 */

	final static int JUNIOR = 1;
	final static int SENIOR = 2;
	final static int MAX = 3;
	
	/**
	 * Constantes con el minimo de dinero a ingresar
	 * Junior - 500€
	 * Senior - 5000€
	 * MAX - 20000€
	 */
	
	final static int MINIMO_JUNIOR = 500;
	final static int MINIMO_SENIOR = 5000;
	final static int MINIMO_MAX = 20000;
	
	/**
	 * Constructor por defecto para crear un deposito vacio
	 */
	public Deposito() {
		
	}
	
	/**
	 * Constructor con los dos atributos
	 * @param tipo int indicando cual de los tres tipos es
	 * @param saldo con el dinero que tiene
	 */
	
	public Deposito(int tipo, int saldo) {
		this.tipo = tipo;
		this.saldo = saldo;

	}
	
	/**
	 * Metodo para crear depositos pasando el tipo y el saldo
	 * @param tipo int cualquiera de los tres de las constantes
	 * @param saldo el saldo que introduzca
	 * @return objeto de tipo deposito
	 */
	
	public static Deposito crearDepsito(int tipo ,int saldo) {
		Deposito deposito = new Deposito();
		deposito.tipo = tipo;
		deposito.saldo = saldo;
		
		return deposito;
	}
	
	/**
	 * Metodo que cambia el tipo de int a String 
	 * @return devuelve el tipo de deposito que es en un String 
	 */
	
	public String estadoDelDeposito() {
		String estado = "Deposito ";
		
		if (tipo == JUNIOR) {
			estado += "Junior";
		} else if (tipo == SENIOR) {
			estado += "Senior";
		} else if (tipo == MAX) {
			estado += "MAX";
		}
		estado += " : " + saldo + " €" ;
		
		return estado;
	}
	
	/**
	 * Metodo que comprueba cuantos depositpos hay creados
	 * @param cliente0 de tipo Cliente
	 * @return retorna un boolean con true si puede crear algun deposito mas o false si tiene los dos que puede tener
	 */
	
	public static boolean depositosCreados(Cliente cliente0) {
		boolean puede = false;
		
		if (cliente0.deposito1 == null && cliente0.deposito2 == null) {
			puede = true;
		} else if (cliente0.deposito1 != null && cliente0.deposito2 == null) {
			puede = true;
		} else if (cliente0.deposito1 != null && cliente0.deposito2 != null) {
			puede = false;
		}
		
		return puede;
	}
	/**
	 * Metodo que te muestra por pantalla cuantas cuentas puede crear 
	 * @param cliente0 de tipo Cliente que es elñ cliente actual
	 * @return retona el numero (int) de cuentas que se pueden crear
	 */
	
	public static int comprobarDeposito(Cliente cliente0) {
		int numero = 0;
		String mensaje = "";
		
		if (depositosCreados(cliente0)) {
			if(cliente0.deposito1 == null && cliente0.deposito2 == null) {
				numero = 2;
				mensaje = "Puedes contratar dos depositos aun";
			} else if (cliente0.deposito1 != null && cliente0.deposito2 == null) {
				numero = 1;
				mensaje = "Puedes contratar un deposito aun";			
			}
		} else {
			numero = 0;
			mensaje = "No puedes contratar mas depositos";
			
		} 
		
		JOptionPane.showMessageDialog(null,mensaje);
		
		return numero;
		
	}
}
