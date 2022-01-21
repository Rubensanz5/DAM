package Practica_11;

import javax.swing.JOptionPane;

import cajeroAutomatico.Cliente;
import cajeroAutomatico.Deposito;

public class DepositoNuevo extends cajeroAutomatico.Deposito {
	public final static int PREMIUM = 4;
	
	public DepositoNuevo(int dinero, int tipo) {
		super(dinero, tipo);
	}
	
	public static String nombrarDeposito(int tipo) {
		switch (tipo) {
		case Deposito.JUNIOR:
			return  "Junior";
		case Deposito.SENIOR:
			return "Senior";
		case Deposito.MAX:
			return "MAX";
		case PREMIUM:
			return "Premium";
		}
		return null;
	}
	
	@Override
	public String estadoDeposito() {
		String estadoDeposito = "Deposito";
		
		switch (getTipo()) {
		case Deposito.JUNIOR:
			estadoDeposito += " Junior";
			break;
		case Deposito.SENIOR:
			estadoDeposito += " Senior";
			break;
		case Deposito.MAX:
			estadoDeposito += " MAX";
			break;
		case PREMIUM:
			estadoDeposito += " Premium";	
			break;
		}
		
		estadoDeposito += ":" + getDinero() + "€";	
		
		return estadoDeposito;
	}
	
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

	