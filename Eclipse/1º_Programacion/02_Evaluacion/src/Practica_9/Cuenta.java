package Practica_9;

/**
 *  @author Ruben Sanz
 */

import javax.swing.JOptionPane;

public class Cuenta {

	/**
	 * Atributos de la clase 
	 * double saldo
	 * boolean tipo true cuenta corriente y false cuenta nomina
	 * boolean euros
	 * String iban
	 */
	
	private double saldo;
	private boolean corriente;// true cuenta corriente y false cuenta nomina
	private boolean euros;
	private String iban;
	
	/**
	 * Constructor 
	 * @param saldo de tipo double
	 * @param corriente de tipo boolean, true si es cuenta corriente y false si es cuenta nomina
	 * @param euros de tipo boolean, true si son euros y false si son dolares
	 * @param iban de tipo String 
	 */

	public Cuenta(double saldo,boolean corriente ,boolean euros, String iban) {
		this.saldo = saldo;
		this.corriente = corriente;
		this.euros = euros;
		this.iban = iban;
	}	
	
	/**
	 * Constructor por defecto para crear cuentas vacias 
	 */
	public Cuenta() {
		
	}

	/**
	 * Metodo para establecer el saldo de la cuenta por el que se le pase por parametros
	 * @param saldo de tipo double
	 */
	
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	/**
	 * Metodo para obtener el saldo 
	 * @return saldo de tipo double 
	 */
	
	public double getSaldo() {
		return saldo;
	}
	
	/**
	 * Metodo para obtener el tipo de cuenta que es 
	 * @return corriente boolean
	 */
	
	public boolean isTipo() {
		return corriente;
	}
	
	/**
	 * Metodo para obtener si son euros o dolares
	 * @return euros boolean, retorna true si son euros y false si son dolares
	 */
	
	public boolean isEuros() {
		return euros;
	}
	
	/**
	 * Metodo para obtener el iban
	 * @return iban de tipo String
	 */
	
	public String getIban() {
		return iban;
	}
	
	/**
	 * Metodo para obtener un String con el tipo de cuenta (nomina o corriente)
	 * @param corriente boolean
	 * @return String con el tipo de la cuenta
	 */
	public String cambioTipo(boolean corriente) {
		String tipoCuenta;
		
		if (corriente) {
			tipoCuenta = "Cuenta corriente";
		} else {
			tipoCuenta = "Cuenta nómina";
		}
		
		return tipoCuenta;
	}
	
	/**
	 * Metodo para hacer el cambio de divisa de euros a dolares y viceversa
	 * @param cantidad de tipo double
	 * @return double con la cantidad transformada de euros a dolares u viceversa
	 */
	
	public double cambioDivisa(double cantidad) {
		double cambio = 0;
		
		if (isEuros()) {
			cambio = cantidad * 1.22;
		} else {
			cambio = cantidad / 1.22;
		}
		
		return cambio;
	}
	
	/**
	 * Metodo para poner el simbolo de € o $ dependiendo del tipo
	 * @param euros de tipo boolean
	 * @return String con el simbolo
	 */
	
	public static String cambioEuro(boolean euros) {
		String tipoCuenta;
		
		if (euros) {
			tipoCuenta = "€";
		} else {
			tipoCuenta = "$";
		}
		
		return tipoCuenta;
	}
	
	/**
	 * Metodo para mostrar el estado de la cuenta actual 
	 * String con el tipo de cuenta que es, el IBAN, el saldo y el simbolo de € o $
	 * @return String 
	 */
	
	public String estadoDeLaCuenta() {
		String estado;
		
		estado = (cambioTipo(corriente)) + " : " + iban + " : " +  saldo + (cambioEuro(euros));
		
		return estado;
	}
	
	/**
	 * Metodo para crear cuentas automaticamente pasando los parametros 
	 * @param saldo de tipo double
	 * @param corriente de tipo boolean
	 * @param euros de tipo boolean
	 * @param iban de tipo String
	 * @return retorna un objeto de tipo Cuenta con los parametros que se le han pasado 
	 */
	
	public static Cuenta crearCuenta(double saldo,boolean corriente ,boolean euros, String iban) {
		Cuenta cuenta = new Cuenta();
		cuenta.saldo = saldo;
		cuenta.corriente = corriente;
		cuenta.euros = euros;
		cuenta.iban = iban;
		return cuenta;
	}
	
	/**
	 * Metodo para comprobar si puede retirar dinero 
	 * @param cantidad de tipo double 
	 * @return boolean con si puede retirar dinero o no atendiendo al 25% porciento del saldo y si tiene mas de 0 de saldo 
	 */
	
	public boolean comprobarRetirada(double cantidad) {
		boolean puede = false;
		double porcentaje = 0.25 * saldo;
		
		if (saldo > 0 && cantidad <= porcentaje){
			if (corriente) {
				if (cantidad < 300) {
					puede = true;
				} else {
					puede = false;
				}
			} else {
				if (cantidad < 500) {
					puede = true;
				} else {
					puede = false;
				}
			}
		}
		return puede;
	}
	
	/**
	 * Metodo que devuelve el numero de billetes de cada tipo y la cantidad de saldo despues de la retirada  
	 * @param cantidad de tipo int ya que solo se puede retirar dinero que sean multiplos de 10
	 * @return String con todos los billetes y el saldo
	 */
	
	public String retirarDinero(int cantidad) {
		String cambio = "";
		int valorBillete = 0;
		int billetes = 0;
		
		
		if (comprobarRetirada(cantidad)){
			saldo = saldo  - cantidad;	
			 
			for (int i = euros ? 1 : 2; i < 5; i++) {
				billetes = 0;
				switch(i) {
					case 1: 
						valorBillete = 100;
						break;
					case 2:
						valorBillete = 50;
						break;
					case 3:
						valorBillete = 20;
						break;
					case 4:
						valorBillete = 10;
						break;
				}
				while (cantidad >= valorBillete) {
					billetes = billetes + 1;
					cantidad = cantidad - valorBillete;
				}
				if (billetes > 0) {
					cambio = cambio + (billetes + " billetes de " + valorBillete);
					if (isEuros()) {
						cambio += " euros";
					} else {
						cambio += " dolares";
					}
				}
			}
		} else {
			cambio = "No puedes hacer esa operacion, la cantidad a retirar es mayor que el 25% del saldo de tu cuenta que es: " + (saldo * 0.25)  + " " + cambioEuro(euros);
		}
		
		cambio = cambio + ("\nTu saldo disponible es de: " + saldo + " " + cambioEuro(euros));
		setSaldo(saldo);
		
		return cambio;
	}
	
	/**
	 * Metodo que llama al metodo de la clase cliente de 'comprobarIngreso' para ver si puede
	 * meter dinero y si puede se le suma el saldo a la cuenta 
	 * @param cliente0 de tipo Cliente es el cliente actual
	 * @param cuenta0 de tipo Cuenta es la cuenta actual
	 * @param cantidad de tipo int la cantidad que se quiere retirar
	 * @return String con la cantidad total despues del ingreso y si no se puede mensaje de que no se puede
	 */
	
	public String ingresarDinero(Cliente cliente0,Cuenta cuenta0, double cantidad) {
		String total;
		double suma;
		if (cliente0.comprobarIngreso(cuenta0, cantidad)) {
			suma = cantidad + saldo;
			total = suma + " " + cambioEuro(euros) + " Este es tu saldo total";
			setSaldo(suma);
		} else {
			total = "No puedes hacer esa operacion, el limite es el 10% del saldo de tus cuentas totales que es: " + cliente0.getSaldoTotal() + " " + cambioEuro(euros);
		}
		
		return total;
	}
	
	/**
	 * Metodo que transfiere el dinero entre la cuenta actial que este usando el cliente y la que se pase por parametro
	 * comprueba si las dos son en euros par no hacer el cambio de divisa y si son distintas lo realiza
	 * @param cuenta00 de tipo cuenta y se refiere a la cuenta a la que se va a traspasar y la actual es de la que se traspasa
	 * @param cantidad de tipo double indicando la cantidad que se quiere transferir
	 * @return retorna un String diciendo si se ha hecho la operacion o no
	 */
	
	public String traspasoMismoCliente(Cuenta cuenta00, double cantidad) {
		String mensaje = "Tu operacion no se ha podido realizar";
		double total;
		double total1;
		double cambio;
		
		if (this.isEuros() == cuenta00.isEuros()){
			total = this.getSaldo() - cantidad ;
			this.setSaldo(total);
			total1 = cantidad + cuenta00.getSaldo();
			cuenta00.setSaldo(total1);
			mensaje = "Tu operacion se ha realizado correctamente";
			
		} else {
			cambio = this.cambioDivisa(cantidad);
			total = this.getSaldo() - cambio ;
			this.setSaldo(total);
			total1 = cambio + cuenta00.getSaldo();
			cuenta00.setSaldo(total1);
			mensaje = "Tu operacion se ha realizado correctamente";
		} 
		return mensaje;
	}
	
	/**
	 * Metodo que transfiere dinero a cuentas externas preguntando el iban, titular, concepto,
	 * para ver si es urgente muestra un cuadro de dialogo con (si,no y cancelar) restando la comision en cada caso
	 * para ver si quiere justificante el cuadro de dialogo es igual que para el justificante y en caso de que diese a si
	 * se le muestra el justificante con el iban al que va realizado, el titular, concepto, si es urgente o no
	 * la cantidad y el saldo despues de la operacion incluidas las comisiones
	 * @param cantidad de tipo double que indiaca la cantidad de dinero que se quiere transferir
	 * @return mensaje con si se ha realizado la operacion correctamente
	 */
	
	public String tranferenciaCuentasExternas(double cantidad) {
		String mensaje = "Tu operacion no se ha podido realizar";
		String iban, titular, concepto;
		int urgente;
		double total, porcentaje = cantidad * 0.3 / 100;
	
		iban = JOptionPane.showInputDialog("Ingresa el IBAN de la cuenta a la que va a ingresar la transferencia");
		titular = JOptionPane.showInputDialog("Ingresa el titular de la cuenta a la que va a ingresar la transferencia");
		concepto = JOptionPane.showInputDialog("Ingresa el concepto de la transferencia");
		urgente = JOptionPane.showConfirmDialog(null,"¿La transferencia es urgente?");
		
		total = getSaldo() - cantidad;
		setSaldo(total);
		
		if(urgente == JOptionPane.OK_OPTION) {
			total = getSaldo() - 20;
			setSaldo(total);
			mensaje = "Urgente";
		} else if(urgente == JOptionPane.NO_OPTION) {
			if(porcentaje <= 3.95) {
				total = getSaldo() - 3.95;
				setSaldo(total);
			} else {
				total = getSaldo() - porcentaje;
				setSaldo(total);
			}
			mensaje = "No urgente";
		} else if(urgente == JOptionPane.CLOSED_OPTION) {
			
		}
		
		justificante(cantidad, mensaje, iban, titular, concepto);
		
		mensaje = "Tu transferencia se ha realizado correctamente";

		return mensaje;
	}

	private void justificante(double cantidad, String mensaje, String iban, String titular, String concepto) {
		int justificante;
		double total;
		justificante = JOptionPane.showConfirmDialog(null,"¿Quieres justificante?");

		if(justificante == JOptionPane.OK_OPTION) {
			if (this.isEuros()) {
				total = getSaldo() - 3;
				setSaldo(total);
			} else {
				total = getSaldo() - cambioDivisa(3);
				setSaldo(total);
			}
			JOptionPane.showMessageDialog(null,"Transferencia realizada con exito: \nAl IBAN: " + iban + "\nCon titular: " + titular 
											+"\nCon el concepto de: " + concepto +"\nCon motivo: " + mensaje + "\nUn total de: " + cantidad
											+ "\nCTu saldo es de: " + getSaldo());
		} else if(justificante == JOptionPane.NO_OPTION) {
			
		} else if(justificante == JOptionPane.CLOSED_OPTION) {
			
		}
	}
			
}
