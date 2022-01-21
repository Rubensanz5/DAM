/**
 * 
 */
package Practica_9;

import javax.swing.JOptionPane;

/**
 * @author Ruben Sanz
 *
 */
public class CajeroRSG {
	public final static Cliente CLIENTE1 = new Cliente("Jeff", "Preston Bezos", "72343698G", "12/01/1964", true, "amazon", "0666", Cuenta.crearCuenta(350000, false, false, "ES01 1465 0100 72 2030876293"),Cuenta.crearCuenta(1000000, true, false, "ES11 1005 3105 46 2030899228"),Cuenta.crearCuenta(375000, true, true, "ES21 5364 1030 55 0305646565"),  Deposito.crearDepsito(Deposito.MAX,375000),null);
	public final static Cliente CLIENTE2 = new Cliente("Ana Patricia", "Botín Sanz", "08269547N", "04/10/1960", true, "santander", "1234", Cuenta.crearCuenta(15000, true, true, "ES02 5464 1111 09 1685416389"),Cuenta.crearCuenta(182000, true, true, "ES12 4985 8974 79 4658756285"),null, Deposito.crearDepsito(Deposito.SENIOR,56754), null);
	public final static Cliente CLIENTE3 = new Cliente("Mark", "Lenders", "94827645W", "07/07/2007", true, "toho", "9999", Cuenta.crearCuenta(0, true, true, "ES03 8775 1354 95 5457986510"),null,null,null,null);

	public final static String RETIRAR = "1. Retirar Dinero";
	public final static String INGRESAR = "2. Ingresar Dinero";
	public final static String MISMAS_CUENTAS = "3. Transferir dinero entre cuentas del usuario";
	public final static String DISTINTAS_CUENTAS = "4. Transferir dinero a otras cuentas externas";
	public final static String DEPOSITOS = "5. Contratar un depósito bancario";
	public final static String SALIR = "0. Salir";
	public final static String MOSTRAR_CUENTAS = "6. Mostrar cuentas";
	public static Cliente cliente0;
	/**
	 * Metodo main para llamar a otras metodos
	 * @param args , argumentos de la aplicacion
	 */
	public static void main(String[] args) {
		cliente0 = logIn();
		
		JOptionPane.showMessageDialog(null, cliente0.mostrarCuentas());
		
		mostrarMenu(cliente0);	
		
	}
	
	/**
	 * Metodo que llama a la mayoria de los metodos con el menu del cliente y las distintas funciones que puede realizar
	 * llamando a cada metodo respectivamente
	 * @param cliente0 de tipo cliente es el cliente que se logea y con el que se trabaja
	 */

	public static void mostrarMenu(Cliente cliente0) {
		String operacion;
		Cuenta cuenta0 = null;
		do {
			
			String[] opcion = opcionesDesplegable( cliente0.retirarDinero(), cliente0.ingresarDinero(),cliente0.entreCuentas(),cliente0.otrasCuentas(),cliente0.crearDeposito());
			operacion = String.valueOf( JOptionPane.showInputDialog(null, "Elige una opcion:", "Opciones", JOptionPane.QUESTION_MESSAGE, null, opcion, null));

			switch (operacion) {
				case SALIR:
					break;
				case RETIRAR:
					cuenta0 = mostrarOpciones(cliente0);
					int dineroRetirar;
					
					do {
						dineroRetirar = Integer.parseInt(JOptionPane.showInputDialog("¿Cuanto dinero quieres sacar?(Solo multiplos de 10)"));
					} while(!(dineroRetirar % 10 == 0));
					
					JOptionPane.showMessageDialog(null,cuenta0.retirarDinero(dineroRetirar));
					
					break; 
				case INGRESAR:
					cuenta0 = mostrarOpciones(cliente0);
					double dineroIngresar;
					
					do {
						dineroIngresar = Double.parseDouble(JOptionPane.showInputDialog("¿Cuanto dinero quieres ingresar?"));
					} while(dineroIngresar <= 0);
					
					JOptionPane.showMessageDialog(null,cuenta0.ingresarDinero(cliente0,cuenta0, dineroIngresar));
					
					break; 
				case MISMAS_CUENTAS:
					trasferenciaEntreCuentas(cliente0);
					break;
				case DISTINTAS_CUENTAS:
					cuenta0 = mostrarOpciones(cliente0);
					double cantidad;
					
					do {
						cantidad = Double.parseDouble(JOptionPane.showInputDialog("¿Cuanto dinero quieres transferir?"));
					} while(cantidad <= 0);
					
					JOptionPane.showMessageDialog(null,cuenta0.tranferenciaCuentasExternas(cantidad));
					JOptionPane.showMessageDialog(null, cliente0.mostrarCuentas());
					
					break;
				case DEPOSITOS:
					int tipo;
					int saldo = 0;
					double dineroTotalCuenta;
					double interesTotal = 0, conImpuestos = 0, total;
					
					Deposito.comprobarDeposito(cliente0);
					
					
					if (Deposito.depositosCreados(cliente0)) {
						while(cliente0.deposito1 == null || cliente0.deposito2 == null) {
							if(cliente0.comprobarEdad(JOptionPane.showInputDialog(null,"¿Que fecha es hoy?(dd/mm/aaaa)"))) {
								String[] opciones1 = {"Deposito Junior(18 meses al 0.5% TAE)", "Deposito Senior (25 meses al 0.65% TAE)", "Deposito MAX (36 meses al 0.8% TAE)"};
								 tipo = JOptionPane.showOptionDialog(null,"¿Que tipo de deposito quieres contratar?", "Contratar deposito", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,null,opciones1, "Deposito Senior (25 meses al 0.65% TAE)");
							 	if(tipo == 0) {
									 saldo = Integer.parseInt(JOptionPane.showInputDialog("¿Cuanto quiere ingresar en este deposito Junior? (Minimo 500 €)"));
									 interesTotal = saldo * (0.5 / 100) /12 * 18;
									 
								 } else if(tipo == 1) {
									 saldo = Integer.parseInt(JOptionPane.showInputDialog("¿Cuanto quiere ingresar en este deposito Senior? (Minimo 5000 €)"));
									 interesTotal = saldo * (0.65 / 100) / 12 * 25;
									 
								 } else if(tipo == 2) {
									 saldo = Integer.parseInt(JOptionPane.showInputDialog("¿Cuanto quiere ingresar en este deposito MAX? (Minimo 20000 €)"));
									 interesTotal = saldo * (0.8 / 100) / 12 * 36;
								 }
							} else {
								String[] opciones1 = {"Deposito Junior(18 meses al 0.5% TAE)"};
								 tipo = JOptionPane.showOptionDialog(null,"Solo puedes contratar este deposito", "Contratar deposito", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,null,opciones1, "Deposito Senior (25 meses al 0.65% TAE)");
							 	if(tipo == 0) {
									 saldo = Integer.parseInt(JOptionPane.showInputDialog("¿Cuanto quiere ingresar en este deposito Junior? (Minimo 500 €)"));
									 interesTotal = saldo * (0.5 / 100) /12 * 18;
								 }
							}
							conImpuestos = interesTotal * (21.0 / 100); 
							total = interesTotal - conImpuestos;
							
							JOptionPane.showMessageDialog(null,"Los intereses van a ser: " + interesTotal + "\n Lo que vas a generar es: " + (saldo + total));
							 
							cuenta0 = mostrarOpciones(cliente0);
							
							dineroTotalCuenta = cuenta0.getSaldo() - saldo; 
							cuenta0.setSaldo(dineroTotalCuenta); 
							 
							 if (cliente0.deposito1 == null) {
								 cliente0.deposito1 = Deposito.crearDepsito(tipo, saldo);
							 } else {
								 cliente0.deposito2 = Deposito.crearDepsito(tipo, saldo);
							 }
						}
					} 
					break;
				case MOSTRAR_CUENTAS:
					JOptionPane.showMessageDialog(null, cliente0.mostrarCuentas());
					break;
			}	
		} while (!operacion.equalsIgnoreCase(SALIR));
	}
	
	/**
	 * Metodo que comprueba los usuarios y sus respectivos pin para acceder a sus cuentas 
	 * @return retorna un objeto de tipo cliente con el cliente logeado
	 */
	
	public static Cliente logIn() {
		Cliente cliente0 = null;
		String usuario;
		String pin;
		
		do {
			usuario = JOptionPane.showInputDialog("Introduce tu usuario: ");
			
			pin = JOptionPane.showInputDialog("Introduce tu pin");
			//A
			if(usuario.equalsIgnoreCase("amazon")) {
				//B
				if (pin.equalsIgnoreCase(CLIENTE1.getPin())) {
					JOptionPane.showMessageDialog(null,"Bienvenido " + CLIENTE1.getNombre());
					cliente0 = CLIENTE1;
				} else {
					JOptionPane.showMessageDialog(null, "Has introducido un pin erroneo");
				}
			//C
			} else if(usuario.equalsIgnoreCase("santander")) {
				//D
				if (pin.equalsIgnoreCase(CLIENTE2.getPin())) {
					JOptionPane.showMessageDialog(null,"Bienvenida " + CLIENTE2.getNombre());
					cliente0 = CLIENTE2;
				} else {
					JOptionPane.showMessageDialog(null, "Has introducido un pin erroneo");
				}
			//E
			} else if(usuario.equalsIgnoreCase("toho")) {
				//F
				if (pin.equalsIgnoreCase(CLIENTE3.getPin())) {
					JOptionPane.showMessageDialog(null,"Bienvenido " + CLIENTE3.getNombre());
					cliente0 = CLIENTE3;	
				} else {
					JOptionPane.showMessageDialog(null, "Has introducido un pin erroneo");
				}
			} else {
				JOptionPane.showMessageDialog(null,"Has introducido un usuario que no existe");
			}
		//G
		} while (cliente0 == null);
		
		return cliente0;
	}
	
	/**
	 * Metodo que asigna unos Strings con las opciones disponibles para el usuario a un array
	 * @param puedeRetirar boolean indicando si puede retirar (llamando al metodo de la clase Cliente de retirar dinero)
	 * @param puedeIngresar boolean indicando si puede ingresar (llamando al metodo de la clase Cliente de ingresar dinero)
	 * @param puedeEntreCuentas boolean indicando si puede transferir entre cuentas (llamando al metodo de la clase Cliente de entreCuentas )
	 * @param puedeOtrasCuentas boolean indicando si puede transferir a otras cuentas externas (llamando al metodo de la clase Cliente de otrasCuentas )
	 * @param puedeDepositos boolean indicando si puede o no crear un deposito (llamando al metodo de la clase Cliente crearDeposito)
	 * @return retorna un Array con las opciones disponibles del usuario
	 */
	
	public static String[] opcionesDesplegable(boolean puedeRetirar, boolean puedeIngresar, boolean puedeEntreCuentas, boolean puedeOtrasCuentas, boolean puedeDepositos) {
		String retirar, ingresar,entreCuentas,otrasCuentas,depositos;
		
		if(puedeRetirar) {
			retirar = RETIRAR;
		} else {
			retirar = "1. Opcion no disponible";
		}
		
		if(puedeIngresar) {
			ingresar = INGRESAR;
		} else {
			ingresar = "2. Opcion no disponible";
		}
		
		if(puedeEntreCuentas) {
			entreCuentas = MISMAS_CUENTAS;
		} else {
			entreCuentas = "3. Opcion no disponible";
		}
		
		if(puedeOtrasCuentas) {
			otrasCuentas = DISTINTAS_CUENTAS;
		} else {
			otrasCuentas = "4. Opcion no disponible";
		}
		
		if(puedeDepositos) {
			depositos = DEPOSITOS;
		} else {
			depositos = "5. Opcion no disponible";
		}
		
		String[] opciones = {retirar, ingresar, entreCuentas, otrasCuentas,depositos,MOSTRAR_CUENTAS, SALIR};
		return opciones;
	}
	
	/**
	 * Metodo para mostrar las cuentas con botones del cliente actual
	 * @param cliente0 de tipo Cliente y es el cliente actual
	 * @return retorna un objeto de tipo cuenta que contiene la cuenta que selecciona del cliente actual
	 */
	
	public static Cuenta mostrarOpciones(Cliente cliente0) {
		Cuenta cuenta0 = null;
		int opcion = 0;
		
		if(cliente0.getNombre().equalsIgnoreCase("jeff")) {
			String[] opciones = {"Cuenta 1", "Cuenta 2", "Cuenta 3"};
		
			 opcion = JOptionPane.showOptionDialog(null, cliente0.mostrarCuentas(), 
										  "Tus cuentas " + cliente0.getNombre(), JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null , opciones, "Cuenta 1");
			if (opcion == 0) {
				cuenta0 = CLIENTE1.cuenta1;	
			} else if (opcion == 1) {
				cuenta0 = CLIENTE1.cuenta2;
			} else if (opcion == 2){
				cuenta0 = CLIENTE1.cuenta3;
			}
			
		} else if(cliente0.getNombre().equalsIgnoreCase("Ana Patricia")) {
			String[] opciones = {"Cuenta 1", "Cuenta 2"};
			 opcion = JOptionPane.showOptionDialog(null, cliente0.mostrarCuentas(), 
										"Tus cuentas " + cliente0.getNombre(), JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null , opciones, "Cuenta 1");
			
			if (opcion == 0) {
				cuenta0 = CLIENTE2.cuenta1;	
			} else if (opcion == 1) {
				cuenta0 = CLIENTE2.cuenta2;
			}
		} else {
			String[] opciones = {"Cuenta 1"};
			 opcion = JOptionPane.showOptionDialog(null, cliente0.mostrarCuentas(), 
										"Tus cuentas " + cliente0.getNombre(), JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null , opciones, "Cuenta 1");
			if (opcion == 0) {
				cuenta0 = CLIENTE3.cuenta1;	
			}
		}
		return cuenta0;
	}
	
	/**
	 * Metodo el cual se usa para elegir una segunda cuenta para hacer la transferencia entre cuentas
	 * @param cliente0 cliente actual que se usa para operar
	 * @param cuenta0 cuenta origen desde la que va a transferir el dinero
	 * @return retorna un objeto de tipo Cuenta con la cuenta seleccionada del cliente actual
	 */
	
	public static Cuenta elegirCuentaDestino(Persona cliente0, Cuenta cuenta0) {
		Cuenta cuenta00 = null;
		int opcion = 0;
		
		if(cliente0.getNombre().equalsIgnoreCase("jeff")) {
			if(cuenta0 == CLIENTE1.cuenta1) {
				String[] opciones = {"Cuenta 2", "Cuenta 3"};
				opcion = JOptionPane.showOptionDialog(null,"¿A que cuenta quieres hacer el traspaso?", "Trasferir entre cuentas", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,null,opciones, "Cuenta 1");
				if (opcion == 0) {
					cuenta00 = CLIENTE1.cuenta2;	
				} else if (opcion == 1) {
					cuenta00 = CLIENTE1.cuenta3;
				} 
				
			} else if(cuenta0 == CLIENTE1.cuenta2) {
				String[] opciones = {"Cuenta 1", "Cuenta 3"};
				opcion = JOptionPane.showOptionDialog(null,"¿A que cuenta quieres hacer el traspaso?", "Trasferir entre cuentas", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,null,opciones, "Cuenta 1");
				if (opcion == 0) {
					cuenta00 = CLIENTE1.cuenta1;	
				} else if (opcion == 1) {
					cuenta00 = CLIENTE1.cuenta3;
				} 
				
			}  else if(cuenta0 == CLIENTE1.cuenta3) {
				String[] opciones = {"Cuenta 1", "Cuenta 2"};
				opcion = JOptionPane.showOptionDialog(null,"¿A que cuenta quieres hacer el traspaso?", "Trasferir entre cuentas", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,null,opciones, "Cuenta 1");
				if (opcion == 0) {
					cuenta00 = CLIENTE1.cuenta1;	
				} else if (opcion == 1) {
					cuenta00 = CLIENTE1.cuenta2;
				} 	
			}
		} else if(cliente0.getNombre().equalsIgnoreCase("Ana Patricia")) {
			if(cuenta0 == CLIENTE2.cuenta1) {
				cuenta00 = CLIENTE2.cuenta2;
			} else {
				cuenta00 = CLIENTE2.cuenta1;
			}
		} else {
			JOptionPane.showMessageDialog(null,"No tienes ninguna cuenta a la que hacer una trasferencia");
		}
		return cuenta00;
	}
	
	/**
	 * Metodo que hace la transferencia entre cuentas 
	 * @param cliente0 de tipo Cliente que es el cliente actual
	 */
	
	public static void trasferenciaEntreCuentas(Cliente cliente0) {
		Cuenta cuenta00 = null;
		double cantidad;
		
		JOptionPane.showMessageDialog(null,"¿Desde que cuenta quieres hacer la trasferencia?");
		Cuenta cuenta0 = mostrarOpciones(cliente0);
		cuenta00 = elegirCuentaDestino(cliente0,cuenta0);

		do {
			cantidad = Double.parseDouble(JOptionPane.showInputDialog("¿Cuanto dinero quieres transferir?"));
		} while(cantidad < 0);
		JOptionPane.showMessageDialog(null, cuenta0.traspasoMismoCliente(cuenta00, cantidad));
		JOptionPane.showMessageDialog(null, cliente0.mostrarCuentas());
	
	}

}
