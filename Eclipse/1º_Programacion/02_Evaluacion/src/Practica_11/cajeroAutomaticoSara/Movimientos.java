package Practica_11.cajeroAutomaticoSara;

import javax.swing.JOptionPane;
/***
 * 
 * @author saral
 *
 */

public class Movimientos {
	private Cuenta cuentaElegida;
	private  Cliente clienteActual ;
	int cantidadDinero;
	/***
	 * constructor del objeto movimientos 
	 * @param cuentaEleguida objeto cuenta donde se indica la cuenta que se va a usar
	 * @param clienteActual objeto cliente 
	 */
	public Movimientos(Cuenta cuentaEleguida, Cliente clienteActual) {
		this.cuentaElegida = cuentaEleguida;
		this.clienteActual = clienteActual;
	}
	
	
	public Cuenta getCuentaElegida() {
		return cuentaElegida;
	}


	public void setCuentaElegida(Cuenta cuentaElegida) {
		this.cuentaElegida = cuentaElegida;
	}


	public Cliente getClienteActual() {
		return clienteActual;
	}


	public void setClienteActual(Cliente clienteActual) {
		this.clienteActual = clienteActual;
	}


	public int getCantidadDinero() {
		return cantidadDinero;
	}


	public void setCantidadDinero(int cantidadDinero) {
		this.cantidadDinero = cantidadDinero;
	}


	/***
	 * metodo que comprueba si tiene el valor minimo introducido y si no lo tiene se llama al meotod de la clase banco.eleguirCuenta y se eligue otra cuenta
	 * @param dineroMinimo variable int donde se indica el valor minimo de dinero que tiene que tener la cuenta
	 * @return objeto cuenta elegida y que tenga mas del dineroMinimo
	 */
	public Cuenta comprobarSaldo (int dineroMinimo) {
		while (cuentaElegida.dinero <= dineroMinimo) {
			cuentaElegida =  Banco.elegirCuenta( clienteActual);
		}
		return cuentaElegida;
	}
	/*** 
	 * metodo para quitar el dinero introducido por el usuario, de la cuenta elegida. este metodo utiliza otros metos como el de comprobarSaldo
	 */
	public void sacarDinero() {
		cuentaElegida = comprobarSaldo(0);
		int max = cuentaElegida.corriente  ?  500 : 300  ;
			do {
				cantidadDinero = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce la cantidad que quieres retirar\n Como maximo " + max + (cuentaElegida.euros ? "€" : "$")));
			}while (cantidadDinero > max && cantidadDinero < 0 && (cantidadDinero > (cuentaElegida.dinero * 0.25)));
		cuentaElegida.dinero -= cantidadDinero;
		JOptionPane.showMessageDialog(null, "Recibiras " + cantidadDinero + "en los siguientes biletes\n\t" + sacarBilletes ());
	}
	/***
	 * metodo privado usado para dividir la cantidad a retirar en billetes, en este caso de 10, 20,50 y 100
	 * @return objeto string con la cantidad de billetes y los billetes usados
	 */
	public String sacarBilletes () {
		String billetesTotales = "";
		int tiposDeBilletes = 0;
		int valorBillete;
		do {
			tiposDeBilletes++;
			switch (tiposDeBilletes) {
			case 1:
				if (cuentaElegida.euros) {
					valorBillete = 100;
					billetesTotales += "\n" + billetes (valorBillete);
				}
				break;
			case 2:
				valorBillete = 50;
				billetesTotales += "\n" + billetes (valorBillete);
				break;
			case 3:
				valorBillete = 20;
				billetesTotales += "\n" + billetes (valorBillete);
				break;
			case 4:
				valorBillete = 10;
				billetesTotales += "\n" + billetes (valorBillete);
				break;
				
			}
		} while (tiposDeBilletes < 4);
		return billetesTotales;
	}
	/***
	 * metodo complementario al metodo sacarbilletes, donde se indica cuantas veces ha de sacarse ese valor de billete
	 * @return objeto String donde se indica la cantidad de billetes de ese valor usado 
	 */
	private String billetes (int valorBillete) {
		 int contador = 0;
			while (cantidadDinero >= valorBillete) {
				cantidadDinero -= valorBillete;
				contador++;
			}
			String mensaje = contador + " billetes de " + valorBillete + ( cuentaElegida.euros ? "€" : "$" );
		 return mensaje;
	 }
	/***
	 * metodo para introducir dinero a una cuenta, siempre que sea menos del 10% del dinero de la cuenta
	 */
	public void ingresarDinero() {
		do {
		cantidadDinero = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce la cantidad que vas a ingresar"));
		}while (cantidadDinero < 0 && cantidadDinero > (cuentaElegida.dinero * 0.10));
		cuentaElegida.dinero += cantidadDinero;
	}
	/***
	 * metodo para transferir dinero de una cuenta entre otra de un mismo cliente, se usa el metodo banco.elegirCuenta y el metodo comprobarSaldo
	 */
	public void transferirCuentas () {
		Cuenta donante  = cuentaElegida;
		Cuenta receptor;
		
		do {
			donante = comprobarSaldo(0);
			receptor = Banco.elegirCuenta(clienteActual);
		} while (donante == receptor);
		
		do {
			cantidadDinero = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce la cantidad que quieres transpasar:"));
		} while (cantidadDinero > cuentaElegida.dinero && cantidadDinero < 0);
		if (donante.corriente == receptor.corriente) {
			receptor.dinero += cantidadDinero;
			donante.dinero -= cantidadDinero;
		}else if (donante.corriente = true) {
			receptor.dinero += (cantidadDinero * 1.25);
			donante.dinero -= cantidadDinero;
		} else {
			receptor.dinero += (cantidadDinero / 1.25);
			donante.dinero -= cantidadDinero;
		}
		
	}
	/***
	 * metodo para transferir dinero de una cuenta entre otra cuenta, introducida a traves del iban, se comprueba que el iban esta bn introducida y se usa el metodo comprobarSaldo
	 */
	public void trasferirCuentasExternas () {
		cuentaElegida = comprobarSaldo(0);
		do {
		cantidadDinero = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce cuanta cantidad quieres transpasar"));
		} while (cantidadDinero > cuentaElegida.dinero && cantidadDinero < 0);
		boolean numero = true;
		do {
			String iban;
			do {
				iban = JOptionPane.showInputDialog(null,"Introduce el iban de la cuenta a la que quiers ingresar el dinero\n EJEMPLO: ES0000000000000000000000");
			}while (iban.length() != 24); 
			 String numerosIban = iban.substring(2);
			 for (int contador = 0 ; numero == true && contador < 22  ; contador++) {
				 char comprobar = numerosIban.charAt(contador);
				 if (Character.isDigit(comprobar)) {
					 numero = true;
				 }else {
					 numero = false;
				 }
			 }	
		} while (numero == false);
		cuentaElegida.dinero -= cantidadDinero;
	}
	
	
	/***
	 * metodo para crear depositos, se comprueba la cantida de depositos que tiene un cliente usando el metodo Deposito.cantidaDepositos, y se usa el metodo  elegirdeposito, para eleguir que deposito quiere crear y el metodo carcateristicasDepositos para establecer las carcateristicas del deposito eleguido
	 */
	public void crearDepositos () {
		int tipoDeposito;
		
		switch (Deposito.cantidadDepositos(clienteActual)) {
		case 0:
			JOptionPane.showMessageDialog(null,"Puedes crear un maximo de dos depositos");
			tipoDeposito = eleguirDeposito();
			caracteristicasDepositos(tipoDeposito);
			clienteActual.deposito1 = new Deposito (cantidadDinero, tipoDeposito);			
			break;
		case 1:
			JOptionPane.showMessageDialog(null,"Puedes crear un solo depositos");
			tipoDeposito = eleguirDeposito();
			caracteristicasDepositos(tipoDeposito);
			if (clienteActual.deposito1 == null) {
				clienteActual.deposito1 = new Deposito (cantidadDinero, tipoDeposito);
			} else {
				clienteActual.deposito2 = new Deposito (cantidadDinero, tipoDeposito);
			}
			break;
		case 2:
			JOptionPane.showMessageDialog(null,"Ya tienes dos depositos no puedes crear mas");
			break;
		}
	
		
		}
	/***
	 * metodo privado, usado en el metodo crearDeposito, metodo para elegir el deposito que se quiere crear y se comprueba que cumple las condiciones
	 * @return variable de tipo int con el tipo de deposito eleguido para crearlo
	 */
	public int eleguirDeposito() {
		int tipo, dineroMinimo;
		boolean depositoCreado = false;
		final int DIA_ACTUAL = 07, MES_ACTUAL = 02, ANO_ACTUAL = 2021;
		String tipoDepositos = "Elige el tipo de deposito que quieres\n1. Deposisto Junior\n2. Deposito Senior\n3. Deposito MAX ";
		do {
			do {
				tipo = Integer.parseInt(JOptionPane.showInputDialog(null, tipoDepositos));
				}while (tipo < 1 && tipo > 3);
			cuentaElegida = Banco.elegirCuenta(clienteActual);
			switch (tipo) {
			case 1:
				dineroMinimo = 500;
				cuentaElegida = comprobarSaldo(dineroMinimo);
				depositoCreado = true;
				break;
			case 2:
				dineroMinimo = 5000;
				cuentaElegida = comprobarSaldo(dineroMinimo);
				depositoCreado = clienteActual.mayoriaEdad(DIA_ACTUAL, MES_ACTUAL, ANO_ACTUAL);
				break;
			case 3:
				dineroMinimo = 20000;
				cuentaElegida = comprobarSaldo(dineroMinimo);
				depositoCreado = clienteActual.mayoriaEdad(DIA_ACTUAL, MES_ACTUAL, ANO_ACTUAL);
				break;
			}
			if (depositoCreado == false) {
				JOptionPane.showMessageDialog(null, "Eres menor de edad, solo puedes crear el deposito juvenil");
			}
		}while (depositoCreado == false);
		
		return tipo;
		}
	/***
	 * metodo privado, complementario del metodo eleguirDepositos y crearDepositos, en este metodo se establecen las condiciones minimas del deposito eleguido
	 * @param tipoDeposito variable int del tipo de deposito elegido
	 */
	public void caracteristicasDepositos (int tipoDeposito) {
		int dineroMinimo = 0, meses = 0;
		double tAE = 0, intereses;
		final double IMPUESTO = 0.21;
		switch (tipoDeposito) {
		case 1:
			dineroMinimo = 500;
			meses = 18;
			tAE = 0.5;
			break;
		case 2:
			dineroMinimo = 5000;
			meses = 25;
			tAE = 0.65;
			break;
		case 3:
			dineroMinimo = 2000;
			meses = 36;
			tAE = 0.8;
			break;
		}
		do {
			cantidadDinero = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce la cantidad de dinero con la que quieres crear el deposito"));
		}while (cantidadDinero < dineroMinimo && cantidadDinero > cuentaElegida.dinero);
		cuentaElegida.dinero -= cantidadDinero;
		intereses = ((cantidadDinero * meses) * tAE) * IMPUESTO;
		JOptionPane.showMessageDialog(null, "Tu deposito " + Deposito.nombrarDeposito(tipoDeposito) + "generara en " + meses + " meses y con un TAE " 
				+ tAE + ", " + intereses + " con el impuesto de " + IMPUESTO + " ya descontado");
		
	}
	

}
