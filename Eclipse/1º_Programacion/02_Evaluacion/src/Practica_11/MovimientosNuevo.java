package Practica_11;

import javax.swing.JOptionPane;

import cajeroAutomatico.Cliente;
import cajeroAutomatico.Cuenta;
import cajeroAutomatico.Deposito;

public class MovimientosNuevo extends cajeroAutomatico.Movimientos {
	public MovimientosNuevo(Cuenta cuentaEleguida, Cliente clienteActual) {
		super(cuentaEleguida, clienteActual);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void crearDepositos() {
		@SuppressWarnings("unused")
		int dineroMinimo = 0, meses = 0;
		double dinero = 0;
		double tae = 0, intereses;
		final double IMPUESTO = 0.21;
		int tipo;
		int saldo = 0;
		
		DepositoNuevo.comprobarDeposito(getClienteActual());
		
		if (DepositoNuevo.depositosCreados(getClienteActual())) {
			while(getClienteActual().deposito1 == null || getClienteActual().deposito2 == null) {
			
				String fechaActual = JOptionPane.showInputDialog(null,"¿Que fecha es hoy?(dd/mm/aaaa)");
		
				if(((ClienteNuevo) getClienteActual()).comprobarEdad(fechaActual)) {
					
					if(Cajero_RSG.CLIENTE1.cuenta1.isCorriente()) {
						String[] opciones = {"Deposito Junior(18 meses al 0.5% TAE)", "Deposito Senior (25 meses al 0.65% TAE)", "Deposito MAX (36 meses al 0.8% TAE)"};
						tipo = JOptionPane.showOptionDialog(null,"¿Que tipo de deposito quieres contratar?", "Contratar deposito", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,null, opciones, "Deposito Senior (25 meses al 0.65% TAE)");
					} else {
						String[] opciones = {"Deposito Junior(18 meses al 0.5% TAE)", "Deposito Senior (25 meses al 0.65% TAE)", "Deposito MAX (36 meses al 0.8% TAE)", "Deposito Premium (12 meses al 1.0% TAE)"};	
						tipo = JOptionPane.showOptionDialog(null,"¿Que tipo de deposito quieres contratar?", "Contratar deposito", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,null, opciones, "Deposito Senior (25 meses al 0.65% TAE)");
					}
					switch (tipo) {
						case 0:
							dineroMinimo = 500;
							meses = 18;
							tae = 0.5;
							 do {
								 saldo = Integer.parseInt(JOptionPane.showInputDialog("¿Cuanto quiere ingresar en este deposito Junior? (Minimo 500 €)"));
							 } while (saldo < 500);
							 break;
						case 1:
							dineroMinimo = 5000;
							meses = 25;
							tae = 0.65;
							 do {
								saldo = Integer.parseInt(JOptionPane.showInputDialog("¿Cuanto quiere ingresar en este deposito Senior? (Minimo 5000 €)")); 
							} while (saldo < 5000);
							break;
						case 2:
							dineroMinimo = 2000;
							meses = 36;
							tae = 0.8;
							 do {
							 	saldo = Integer.parseInt(JOptionPane.showInputDialog("¿Cuanto quiere ingresar en este deposito MAX? (Minimo 20000 €)")); 
						 	} while (saldo < 2000);
							break;
						case 3:
							dineroMinimo = 0;
							meses = 12;
							tae = 1.0;
							 do {
							 	saldo = Integer.parseInt(JOptionPane.showInputDialog("¿Cuanto quiere ingresar en este deposito Premium? (Sin Minimo)")); 
						 	} while (saldo < 0);
							break;
					 }
				} else {
					String[] opciones1 = {"Deposito Junior(18 meses al 0.5% TAE)"};
					tipo = JOptionPane.showOptionDialog(null,"Solo puedes contratar este deposito", "Contratar deposito", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,null,opciones1, "Deposito Senior (25 meses al 0.65% TAE)");
				 	if(tipo == 0) {
				 		saldo = Integer.parseInt(JOptionPane.showInputDialog("¿Cuanto quiere ingresar en este deposito Junior? (Minimo 500 €)"));	 
					 }
				}
				
				
				
				dinero = ((CuentaNuevo) getCuentaElegida()).getSaldo() - saldo; 
				((CuentaNuevo) getCuentaElegida()).setSaldo(dinero); 
				 
				if (getClienteActual().deposito1 == null) {
					getClienteActual().deposito1 = new Deposito (saldo, tipo);
				} else {
					getClienteActual().deposito2 = new Deposito (saldo, tipo);
				}
			
				
				intereses = ((saldo * meses) * tae) * IMPUESTO;
				JOptionPane.showMessageDialog(null, "Tu deposito " + DepositoNuevo.nombrarDeposito(tipo + 1) +  " generara en " + meses + " meses y con un TAE " 
						+ tae + ", " + intereses + " con el impuesto de " + IMPUESTO + " ya descontado");
				
			}
		}
	}
	
	@Override
	public void trasferirCuentasExternas() {
		String mensaje = "Tu operacion no se ha podido realizar";
		String iban, titular, concepto;
		int urgente, justificante;
		double total;
		double cantidad;
		
		do {
			cantidad = Double.parseDouble(JOptionPane.showInputDialog("¿Cuanto dinero quieres transferir?"));
		} while(cantidad <= 0);
		
		double porcentaje = cantidad * 0.3 / 100;
		
		iban = JOptionPane.showInputDialog("Ingresa el IBAN de la cuenta a la que va a ingresar la transferencia");
		titular = JOptionPane.showInputDialog("Ingresa el titular de la cuenta a la que va a ingresar la transferencia");
		concepto = JOptionPane.showInputDialog("Ingresa el concepto de la transferencia");
		urgente = JOptionPane.showConfirmDialog(null,"¿La transferencia es urgente?");
		
		total = ((CuentaNuevo) getCuentaElegida()).getSaldo() - cantidad;
		((CuentaNuevo) getCuentaElegida()).setSaldo(total);
		
		if(urgente == JOptionPane.OK_OPTION) {
			total = ((CuentaNuevo) getCuentaElegida()).getSaldo() - 20;
			((CuentaNuevo) getCuentaElegida()).setSaldo(total);
			mensaje = "Urgente";
		} else if(urgente == JOptionPane.NO_OPTION) {
			if(porcentaje <= 3.95) {
				total = ((CuentaNuevo) getCuentaElegida()).getSaldo() - 3.95;
				((CuentaNuevo) getCuentaElegida()).setSaldo(total);
			} else {
				total = ((CuentaNuevo) getCuentaElegida()).getSaldo() - porcentaje;
				((CuentaNuevo) getCuentaElegida()).setSaldo(total);
			}
			mensaje = "No urgente";
		} else if(urgente == JOptionPane.CLOSED_OPTION) {
			
		}
		
		justificante = JOptionPane.showConfirmDialog(null,"¿Quieres justificante?");

		if(justificante == JOptionPane.OK_OPTION) {
			if (((CuentaNuevo) getCuentaElegida()).isEuros()) {
				total = ((CuentaNuevo) getCuentaElegida()).getSaldo() - 3;
				((CuentaNuevo) getCuentaElegida()).setSaldo(total);
			} else {
				total = ((CuentaNuevo) getCuentaElegida()).getSaldo() - ((CuentaNuevo) getCuentaElegida()).cambioDivisa(3);
				((CuentaNuevo) getCuentaElegida()).setSaldo(total);
			}
			JOptionPane.showMessageDialog(null,"Transferencia realizada con exito: \nAl IBAN: " + iban + "\nCon titular: " + titular 
											+"\nCon el concepto de: " + concepto +"\nCon motivo: " + mensaje + "\nUn total de: " + cantidad
											+ "\nCTu saldo es de: " + ((CuentaNuevo) getCuentaElegida()).getSaldo());
		} else if(justificante == JOptionPane.NO_OPTION) {
			
		} else if(justificante == JOptionPane.CLOSED_OPTION) {
			
		}
		
		mensaje = "Tu transferencia se ha realizado correctamente";

		JOptionPane.showMessageDialog(null, mensaje);
	}

}
