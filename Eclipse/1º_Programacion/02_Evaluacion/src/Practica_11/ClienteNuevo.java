package Practica_11;


import cajeroAutomatico.Cuenta;
import cajeroAutomatico.Deposito;

public class ClienteNuevo extends cajeroAutomatico.Cliente {
	
	private String pin;
	CuentaNuevo cuenta4;
	
	public ClienteNuevo(String nombre, String apellido, String DNI, String fechaNacimiento, boolean hombre, String usuario,
			String pin, Cuenta cuenta1, Cuenta cuenta2, Cuenta cuenta3, Deposito deposito1, Deposito deposito2,
			CuentaNuevo cuenta4 ) {
		super(nombre, apellido, DNI, fechaNacimiento, hombre, usuario, 1, cuenta1, cuenta2, cuenta3, deposito1,
				deposito2, 0, 0);
		this.pin = pin;
		this.cuenta4 = cuenta4;
		
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	
	public boolean retirarDinero() {
		boolean puede = false;
		 if(((CuentaNuevo) this.cuenta1).comprobarRetirada(10)
				|| (this.cuenta2 != null && ((CuentaNuevo) this.cuenta2).comprobarRetirada(10)) 
				|| (this.cuenta3 != null && ((CuentaNuevo) this.cuenta3).comprobarRetirada(10))
				|| (this.cuenta4 != null &&  this.cuenta4.comprobarRetirada(10))){
		 puede = true;
			 
		 }
		return puede;
	}

	public  boolean ingresarDinero() {
		boolean puede = false;
		 if((this.getSaldoTotal() * 0.1) > 0){
			 puede = true;
			 
		 }
		return puede;
	}
	
	public  boolean entreCuentas() {
		boolean puede = false;
		if(this.getSaldoTotal() > 0 && (this.cuenta2 != null || this.cuenta3 != null )) {
			 puede = true;
		 }
		return puede;
	}
	
	
	public boolean otrasCuentas() {
		boolean puede = false;
		if(((CuentaNuevo) super.cuenta1).getSaldo() >= 3.95 
				|| (this.cuenta2 != null && ((CuentaNuevo) this.cuenta2).getSaldo() >= 3.95) 
				|| (this.cuenta3 != null && ((CuentaNuevo) this.cuenta3).getSaldo() >= 3.95)) {
			 puede = true;
		 }
		return puede;
	}
	
	
	public boolean crearDeposito() {
		boolean puede = false;
		if(((CuentaNuevo) this.cuenta1).getSaldo() >= 500 
				|| (this.cuenta2 != null && ((CuentaNuevo) this.cuenta2).getSaldo() >= 500) 
				|| (this.cuenta3 != null && ((CuentaNuevo) this.cuenta3).getSaldo() >= 500)) {
			 puede = true;
			 
		 }
		return puede;
	}
	
	public double getSaldoTotal() {
		double total = 0;
		if(super.cuenta1 != null && this.cuenta2 != null && this.cuenta3 != null) {
			total = ((CuentaNuevo) this.cuenta1).getSaldo() + ((CuentaNuevo) this.cuenta2).getSaldo() + ((CuentaNuevo) this.cuenta3).getSaldo();
		} else if(this.cuenta1 != null && this.cuenta2 != null && this.cuenta3 == null) {
			total = ((CuentaNuevo) this.cuenta1).getSaldo() + ((CuentaNuevo) this.cuenta2).getSaldo();
		} else if(this.cuenta1 != null && this.cuenta2 == null && this.cuenta3 == null) {
			total = ((CuentaNuevo) this.cuenta1).getSaldo();
		} 
		
		return total;
	}

	public boolean comprobarEdad(String fechaActual) {
		boolean puede = false;
		int anio = fechaActual.lastIndexOf('/');
		int dia =  fechaActual.indexOf('/');
		
		int diaActual = Integer.parseInt(fechaActual.substring(0,dia));
		int anioActual = Integer.parseInt(fechaActual.substring(anio + 1));
		int mesActual = Integer.parseInt(fechaActual.substring(dia + 1, anio));
		
		int diaNac = Integer.parseInt(this.getFechaNacimiento().substring(0,dia));
		int anioNac = Integer.parseInt(this.getFechaNacimiento().substring(anio + 1));
		int mesNac = Integer.parseInt(this.getFechaNacimiento().substring(dia + 1, anio));
		
		if (anioActual > anioNac + 18){
			puede = true;
		} else if (anioActual == anioNac +18) {
			if(mesActual > mesNac) {
				puede = true;
			} else if(mesActual == mesNac) {
				if(diaActual >= diaNac) {
					puede = true;
				}
			}
		}

		return puede;
	}
	
	public String mostarCuentas() {
		String mensaje;
		mensaje =  " Estas son las diferentes cuentas que tienes \n" ;
		if (this.cuenta1 != null) {
			mensaje += "cuenta 1: " + ((CuentaNuevo)this.cuenta1).estadoCuenta() + "\n";
		}
		if (this.cuenta2 != null) {
			mensaje +=  "cuenta 2: " + ((CuentaNuevo)this.cuenta2).estadoCuenta() + "\n";
		}
		if (this.cuenta3 != null) {
			mensaje += "cuenta 3: " + ((CuentaNuevo)this.cuenta3).estadoCuenta() + "\n";
		}
		if (this.deposito1 != null) {
			mensaje +=  "deposito 1: " + ((DepositoNuevo)this.deposito1).estadoDeposito() + "\n";
		}
		if (this.deposito2 != null) {
			mensaje += "deposito 2: " + ((DepositoNuevo)this.deposito2).estadoDeposito() + "\n";
		}
		
		return mensaje;
	}
}
