package Practica_11;

import javax.swing.JOptionPane;

import cajeroAutomatico.Cuenta;
import cajeroAutomatico.Deposito;
import cajeroAutomatico.Movimientos;
import cajeroAutomatico.Cliente;

public class Cajero_RSG {
	public final static ClienteNuevo CLIENTE1 = new ClienteNuevo("Jeff", "Preston Bezos", "72343698G", "12/01/1964", true, "amazon", "0666", (new CuentaNuevo("ES01 1465 0100 72 2030876293",350000, false, false)),(new CuentaNuevo ("ES11 1005 3105 46 2030899228",1000000, true, false)),(new CuentaNuevo("ES21 5364 1030 55 0305646565", 375000, true, true)), (new DepositoNuevo(375000,Deposito.MAX)),null,null);
	public final static ClienteNuevo CLIENTE2 = new ClienteNuevo("Ana Patricia", "Botín Sanz", "08269547N", "04/10/1960", true, "santander", "1234", (new CuentaNuevo("ES02 5464 1111 09 1685416389",15000, true, true)), (new CuentaNuevo("ES12 4985 8974 79 4658756285",182000, true, true)),null, (new DepositoNuevo(56754,Deposito.SENIOR)),null,null);
	public final static ClienteNuevo CLIENTE3 = new ClienteNuevo("Mark", "Lenders", "94827645W", "07/07/2007", true, "toho", "9999", (new CuentaNuevo("ES03 8775 1354 95 5457986510",0, true, true)),null,null,null,null,null);

	public final static String RETIRAR = "1. Retirar Dinero";
	public final static String INGRESAR = "2. Ingresar Dinero";
	public final static String MISMAS_CUENTAS = "3. Transferir dinero entre cuentas del usuario";
	public final static String DISTINTAS_CUENTAS = "4. Transferir dinero a otras cuentas externas";
	public final static String DEPOSITOS = "5. Contratar un depósito bancario";
	public final static String SALIR = "0. Salir";
	public final static String MOSTRAR_CUENTAS = "6. Mostrar cuentas";
	
	
	public static void main(String[] args) {
		ClienteNuevo cliente0 = logIn();
		
		JOptionPane.showMessageDialog(null, cliente0.mostarCuentas());
		
		mostrarMenu(cliente0);	
		
		
	}
	
	public static void mostrarMenu(Cliente cliente0) {
		String operacion;
		Cuenta cuentaElegida = null;
		Movimientos movimientos = null;
		do {
			
			String[] opcion = opcionesDesplegable( ((ClienteNuevo) cliente0).retirarDinero(), ((ClienteNuevo) cliente0).ingresarDinero(),((ClienteNuevo) cliente0).entreCuentas(),((ClienteNuevo) cliente0).otrasCuentas(),((ClienteNuevo) cliente0).crearDeposito());
			operacion = String.valueOf( JOptionPane.showInputDialog(null, "Elige una opcion:", "Opciones", JOptionPane.QUESTION_MESSAGE, null, opcion, null));
			
			
			switch (operacion) {
				case SALIR:
					break;
				case RETIRAR:
					cuentaElegida = elegirCuenta(cliente0);
					int dineroRetirar;
					
					do {
						dineroRetirar = Integer.parseInt(JOptionPane.showInputDialog("¿Cuanto dinero quieres sacar?(Solo multiplos de 10)"));
					} while(!(dineroRetirar % 10 == 0));
					
					JOptionPane.showMessageDialog(null,((CuentaNuevo) cuentaElegida).retirarDinero(dineroRetirar));
					break; 
				case INGRESAR:
					cuentaElegida = elegirCuenta(cliente0);
					movimientos = new MovimientosNuevo (cuentaElegida, cliente0);
					movimientos.ingresarDinero();
					break; 
				case MISMAS_CUENTAS:
					JOptionPane.showMessageDialog(null, ((ClienteNuevo) cliente0).mostarCuentas());
					trasferenciaEntreCuentas(cliente0);
					break;
				case DISTINTAS_CUENTAS:
					cuentaElegida = elegirCuenta(cliente0);
					movimientos = new MovimientosNuevo (cuentaElegida, cliente0);
					movimientos.trasferirCuentasExternas();
					break;
				case DEPOSITOS:
					cuentaElegida = elegirCuenta(cliente0);
					movimientos = new MovimientosNuevo (cuentaElegida, cliente0);
					movimientos.crearDepositos();
					break;
				case MOSTRAR_CUENTAS:
					JOptionPane.showMessageDialog(null, ((ClienteNuevo) cliente0).mostarCuentas());
					break;
			}	
		} while (!operacion.equalsIgnoreCase(SALIR));   
	}
	
	public static ClienteNuevo logIn() {
		ClienteNuevo cliente0 = null;
		String usuario;
		String pin;
		
		do {
			usuario = JOptionPane.showInputDialog("Introduce tu usuario: ");
			
			pin = JOptionPane.showInputDialog("Introduce tu pin");
			
			if(usuario.equalsIgnoreCase("amazon")) {
				if (pin.equalsIgnoreCase(CLIENTE1.getPin())) {
					JOptionPane.showMessageDialog(null,"Bienvenido " + CLIENTE1.getNombre());
					cliente0 = CLIENTE1;
				} else {
					JOptionPane.showMessageDialog(null, "Has introducido un pin erroneo");
				}
			} else if(usuario.equalsIgnoreCase("santander")) {
				if (pin.equalsIgnoreCase(CLIENTE2.getPin())) {
					JOptionPane.showMessageDialog(null,"Bienvenida " + CLIENTE2.getNombre());
					cliente0 = CLIENTE2;
				} else {
					JOptionPane.showMessageDialog(null, "Has introducido un pin erroneo");
				}
			} else if(usuario.equalsIgnoreCase("toho")) {
				if (pin.equalsIgnoreCase(CLIENTE3.getPin())) {
					JOptionPane.showMessageDialog(null,"Bienvenido " + CLIENTE3.getNombre());
					cliente0 = CLIENTE3;	
				} else {
					JOptionPane.showMessageDialog(null, "Has introducido un pin erroneo");
				}
			} else {
				JOptionPane.showMessageDialog(null,"Has introducido un usuario que no existe");
			}
		} while (cliente0 == null);
		
		return cliente0;
	}
	
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
	
	public static CuentaNuevo elegirCuenta(Cliente cliente0) {
		CuentaNuevo cuenta0 = null;
		int opcion = 0;
		
		if(cliente0.getNombre().equalsIgnoreCase("jeff")) {
			String[] opciones = {"Cuenta 1", "Cuenta 2", "Cuenta 3"};
		
			 opcion = JOptionPane.showOptionDialog(null, CuentaNuevo.mostarCuentas(cliente0), 
										  "Tus cuentas " + cliente0.getNombre(), JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null , opciones, "Cuenta 1");
			if (opcion == 0) {
				cuenta0 = (CuentaNuevo) CLIENTE1.cuenta1;	
			} else if (opcion == 1) {
				cuenta0 = (CuentaNuevo) CLIENTE1.cuenta2;
			} else if (opcion == 2){
				cuenta0 = (CuentaNuevo) CLIENTE1.cuenta3;
			}
			
		} else if(cliente0.getNombre().equalsIgnoreCase("Ana Patricia")) {
			String[] opciones = {"Cuenta 1", "Cuenta 2"};
			 opcion = JOptionPane.showOptionDialog(null,  CuentaNuevo.mostarCuentas(cliente0), 
										"Tus cuentas " + cliente0.getNombre(), JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null , opciones, "Cuenta 1");
			
			if (opcion == 0) {
				cuenta0 = (CuentaNuevo) CLIENTE2.cuenta1;	
			} else if (opcion == 1) {
				cuenta0 = (CuentaNuevo) CLIENTE2.cuenta2;
			}
		} else {
			String[] opciones = {"Cuenta 1"};
			 opcion = JOptionPane.showOptionDialog(null,  CuentaNuevo.mostarCuentas(cliente0), 
										"Tus cuentas " + cliente0.getNombre(), JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null , opciones, "Cuenta 1");
			if (opcion == 0) {
				cuenta0 = (CuentaNuevo) CLIENTE3.cuenta1;	
			}
		}
		return cuenta0;
	}
	
	public static Cuenta elegirCuentaDestino(Cliente cliente0, Cuenta cuenta0) {
		CuentaNuevo cuenta00 = null;
		int opcion = 0;
		
		if(cliente0.getNombre().equalsIgnoreCase("jeff")) {
			if(cuenta0 == CLIENTE1.cuenta1) {
				String[] opciones = {"Cuenta 2", "Cuenta 3"};
				opcion = JOptionPane.showOptionDialog(null,"¿A que cuenta quieres hacer el traspaso?", "Trasferir entre cuentas", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,null,opciones, "Cuenta 1");
				if (opcion == 0) {
					cuenta00 = (CuentaNuevo) CLIENTE1.cuenta2;	
				} else if (opcion == 1) {
					cuenta00 = (CuentaNuevo) CLIENTE1.cuenta3;
				} 
				
			} else if(cuenta0 == CLIENTE1.cuenta2) {
				String[] opciones = {"Cuenta 1", "Cuenta 3"};
				opcion = JOptionPane.showOptionDialog(null,"¿A que cuenta quieres hacer el traspaso?", "Trasferir entre cuentas", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,null,opciones, "Cuenta 1");
				if (opcion == 0) {
					cuenta00 = (CuentaNuevo) CLIENTE1.cuenta1;	
				} else if (opcion == 1) {
					cuenta00 = (CuentaNuevo) CLIENTE1.cuenta3;
				} 
				
			}  else if(cuenta0 == CLIENTE1.cuenta3) {
				String[] opciones = {"Cuenta 1", "Cuenta 2"};
				opcion = JOptionPane.showOptionDialog(null,"¿A que cuenta quieres hacer el traspaso?", "Trasferir entre cuentas", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,null,opciones, "Cuenta 1");
				if (opcion == 0) {
					cuenta00 = (CuentaNuevo) CLIENTE1.cuenta1;	
				} else if (opcion == 1) {
					cuenta00 = (CuentaNuevo) CLIENTE1.cuenta2;
				} 	
			}
		} else if(cliente0.getNombre().equalsIgnoreCase("Ana Patricia")) {
			if(cuenta0 == CLIENTE2.cuenta1) {
				cuenta00 = (CuentaNuevo) CLIENTE2.cuenta2;
			} else {
				cuenta00 = (CuentaNuevo) CLIENTE2.cuenta1;
			}
		} else {
			JOptionPane.showMessageDialog(null,"No tienes ninguna cuenta a la que hacer una trasferencia");
		}
		return cuenta00;
	}
	
	public static void trasferenciaEntreCuentas(Cliente cliente0) {
		CuentaNuevo cuenta00 = null;
		double cantidad;
		
		JOptionPane.showMessageDialog(null,"¿Desde que cuenta quieres hacer la trasferencia?");
		Cuenta cuenta0 = elegirCuenta(cliente0);
		cuenta00 = (CuentaNuevo) elegirCuentaDestino(cliente0,cuenta0);

		do {
			cantidad = Double.parseDouble(JOptionPane.showInputDialog("¿Cuanto dinero quieres transferir?"));
		} while(cantidad < 0);
		
		JOptionPane.showMessageDialog(null, ((CuentaNuevo) cuenta0).traspasoMismoCliente(cuenta00, cantidad));
		JOptionPane.showMessageDialog(null, ((ClienteNuevo) cliente0).mostarCuentas());
	
	}
}
