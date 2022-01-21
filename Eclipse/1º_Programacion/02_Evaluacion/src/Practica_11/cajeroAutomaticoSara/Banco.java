/**
 * 
 */
package Practica_11.cajeroAutomaticoSara;

import javax.swing.JOptionPane;

/**
 * Clase Main, que utiliza otras clases como Cliente, cuenta, deposito y movimientos.
 * @author saral
 *
 */
public class Banco {
	//crear cliente 1
	 final static Cliente CLIENTE1= new Cliente ("Jeff", "Preston Bezos", "723436968G", "12/01/1964", true,  "amazon", 666, new Cuenta ("ES111111111111111111111111", 350000, true, false ), new Cuenta ("ES111111111111111111111112", 1000000, false, true), new Cuenta ("ES111111111111111111111113", 565000, true, true), new Deposito (375000, Deposito.MAX), null, 4, 1);
	 //crear cliente2
	 final static Cliente CLIENTE2= new Cliente ("Ana Patricia", "Botín Sanz", "08269547N" , "04/10/1960 " , false, "santander", 1234, new Cuenta ("ES111111111111111111111114", 15000, true, true), new Cuenta ("ES111111111111111111111115",182000, true, true), null, new Deposito (56754, Deposito.SENIOR), null, 3, 1);
	 //crear cliente3
	 final static Cliente CLIENTE3= new Cliente ("Mark", "Lenders", "94827645W", "07/07/2007", true , "toho", 9999, new Cuenta ("ES111111111111111111111116", 0, true, true), null, null, null, null, 1, 0);
	 
	 /**
		 * clase Main, desde la cual, creo los diferentes objetos clientes, y llama a los metodos acceso, opciones, eleguir cuenta y al objeto movimientos, donde dentro tiene creadas diferentes metodos los cueles son llamados tbn (sacarDinero, ingresarDinero, transferirCuentas, transfeririCuentasExternas, crearDepositos)
		 * @param args
		 */
	 public static void main(String[] args) {
			Cliente clienteActual = acceso();
			JOptionPane.showMessageDialog(null, (clienteActual.isHombre() ? "Bienvenido " : "Bienvenida ") + clienteActual.getNombre() + Cuenta.mostarCuentas(clienteActual) + "\n\n");
			int opcion;
			do {
				opcion = opciones(clienteActual);
				Cuenta cuentaElegida = elegirCuenta(clienteActual);
				Movimientos movimientos = new Movimientos (cuentaElegida, clienteActual);
				switch (opcion){
				case 0:
					JOptionPane.showMessageDialog(null,"Fin del programa");
					break;
				case 1:
					movimientos.sacarDinero();
					break;
				case 2:
					movimientos.ingresarDinero();
					break;
				case 3:
					movimientos.transferirCuentas();
					break;
				case 4:
					movimientos.trasferirCuentasExternas();
					break;
				case 5:
					movimientos.crearDepositos();
					break;
				}
			}while (opcion != 0);
		}
				
		
		
		/***
		 * Metodo para saber si un usuario existe, introduciendo su usuario y contraseña
		 * @param cliente, objeto tipo cliente
		 * @param cliente, objeto tipo cliente
		 * @param cliente, objeto tipo cliente
		 * @return el objeto cliente que exista
		 * 
		 */
		public static Cliente acceso () {
			int contrasena;
			String usuario;
			boolean acceso = false;
			do {
				usuario = JOptionPane.showInputDialog(null, "Introduce tu usuario");
				contrasena = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce tu contraseña"));
				if (CLIENTE1.getUsuario().equalsIgnoreCase(usuario) && CLIENTE1.getContrasena() == contrasena ) {
					acceso = true;
					return CLIENTE1;		
				} else if (CLIENTE2.getUsuario().equalsIgnoreCase(usuario) && CLIENTE2.getContrasena() == contrasena) {
					acceso = true;
					return CLIENTE2;
				}else if (CLIENTE3.getUsuario().equalsIgnoreCase(usuario) && CLIENTE3.getContrasena() == contrasena) {
					acceso = true;
					return CLIENTE3;
				}
			}while (acceso == false);
			
			return null;
		}
		
		
		/***
		 * Metodo para eleguir las funciones que el cliente puede utilizar, algunas de ellas se ven afectadas por el metodo dineroTotal
		 * @param clienteActual, cliente el cual va eleguir las operaciones
		 * @return el numero de la opcion señalada
		 */
		public static int opciones (Cliente clienteActual) {
			String mensaje = "Elige una de las siguientes opciones\n";
			int i = 0;
			int opcion;
			 if (clienteActual.dineroTotal() != 0) {
				 mensaje = mensaje + i + ". Salir de la aplicacion\n";
				 i++;
				 mensaje = mensaje + i + ". Retirar dinero\n";
				 i++;
				 mensaje = mensaje + i + ". Ingresar dinero\n";
				 i++;
				 if (clienteActual.numCuentas > 1) {
					 mensaje = mensaje + i + ". Transferir dinero a otras cuentas\n";
					 i++;
				 }
					 mensaje = mensaje + i + ". Transferir dinero a otros usuarios\n";
				 	 i++;
				 if (clienteActual.numDepositos < 3 ) {
					 mensaje = mensaje + i + ". Crear un deposito\n";
				 }
				 do {
					 opcion = Integer.parseInt(JOptionPane.showInputDialog(null,  mensaje));
				 }while (opcion < 1 ||  opcion > i);
				 
			 } else {
				 
				 do {
					 opcion = Integer.parseInt(JOptionPane.showInputDialog(null,  "No puedes hacer ninguna operacion, no tienes dinero\n Pon 0 para salir"));
				 }while (opcion != 0);
			 }
			  return opcion;
			  
		}
		
		/***
		 * metodo para eleguir la cuenta del cliente indicado por parametros, que se va usar
		 * @param clienteActual, objeto cliente, para saber de quien es la cuenta usada
		 * @param error, objeto String, donde muestra un mensaje de error si la cuenta no coincide
		 * @return la cuenta eleguida y sabiendo que esta existe
		 */
		public static Cuenta elegirCuenta (Cliente clienteActual) {
			Cuenta cuentaElegida = null;
			String mensaje = Cuenta.mostarCuentas(clienteActual);
			String seleccion;
			do {
				do {
					seleccion =JOptionPane.showInputDialog(null,  mensaje);
				}while (!(seleccion.equalsIgnoreCase("cuenta1") || seleccion.equalsIgnoreCase("cuenta2") || seleccion.equalsIgnoreCase("cuenta3")));
				
				if (seleccion.equalsIgnoreCase("cuenta1") && clienteActual.cuenta1 != null) {
					cuentaElegida = clienteActual.cuenta1;
				} else if (seleccion.equalsIgnoreCase("cuenta2") && clienteActual.cuenta2 != null) {
					cuentaElegida = clienteActual.cuenta2;
				}else {
					cuentaElegida = clienteActual.cuenta3;
				}
			}while (cuentaElegida == null);
			return cuentaElegida;
		}
		

}