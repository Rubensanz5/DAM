package Practica_11;

public class CuentaNuevo extends cajeroAutomatico.Cuenta {

	private double saldo;
	
	public CuentaNuevo(String iban,  double saldo, boolean euros, boolean corriente) {
		super(iban, 0, euros, corriente);
		
		this.saldo = saldo;
		
	}
	
	
	public double getSaldo() {
		return saldo;
	}



	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}



	public static String cambioEuro(boolean euros) {
		String tipoCuenta;
		
		if (euros) {
			tipoCuenta = "€";
		} else {
			tipoCuenta = "$";
		}
		
		return tipoCuenta;
	}
	
	public String cambioTipo(boolean corriente) {
		String tipoCuenta;
		
		if (corriente) {
			tipoCuenta = "Cuenta corriente";
		} else {
			tipoCuenta = "Cuenta nómina";
		}
		
		return tipoCuenta;
	}
	
	public double cambioDivisa(double cantidad) {
		double cambio = 0;
		
		if (isEuros()) {
			cambio = cantidad * 1.22;
		} else {
			cambio = cantidad / 1.22;
		}
		
		return cambio;
	}
	
	@Override
	public String estadoCuenta () {
		String estado;
		
		estado = (cambioTipo(isCorriente())) + " : " + getIban() + " : " +  saldo + (cambioEuro(isEuros()));
		return estado;
	}
	
	public boolean comprobarRetirada(int cantidad) {
		boolean puede = false;
		double porcentaje = 0.25 * getSaldo();
		
		if (getSaldo() > 0 && cantidad <= porcentaje){
			if (isCorriente()) {
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
	
	public String retirarDinero(int cantidad) {
		String cambio = "";
		int valorBillete = 0;
		int billetes = 0;
		
		
		if (comprobarRetirada(cantidad)){
			setSaldo(getSaldo()  - cantidad);	
			 
			for (int i = isEuros() ? 1 : 2; i < 5; i++) {
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
						cambio += " euros\n";
					} else {
						cambio += " dolares \n";
					}
				}
			}
		} else {
			cambio = "No puedes hacer esa operacion, la cantidad a retirar es mayor que el 25% del saldo de tu cuenta que es: " + (getSaldo() * 0.25)  + " " + cambioEuro(isEuros());
		}
		
		cambio = cambio + ("\nTu saldo disponible es de: " + getSaldo() + " " + cambioEuro(isEuros()));
		setSaldo(getSaldo());
		
		return cambio;
	}
	
	public String traspasoMismoCliente(CuentaNuevo cuenta00, double cantidad) {
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
}

