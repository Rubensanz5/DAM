package Ejercicios.Hilos.Practica6;

public class Cuenta {
	private double saldo = 50;
	private String persona;
	

	public synchronized void retirarSaldo(double retirada) throws InterruptedException {
		if(saldo <= 0) {
			System.out.println(persona + " no puede retirar dinero, NO HAY SALDO("+ saldo +"€)");
		} else {
			System.out.println(persona + " va a retirar dinero (Saldo actual es " + saldo + "€)");
			Thread.sleep(500);
			saldo = saldo - retirada;
			System.out.println(persona + " retira => " + retirada + "(ACTUAL " + saldo + ")");
		}
	}

	public double getSaldo() {
		return saldo;
	}	
	
	public String getPersona() {
		return persona;
	}

	public void setPersona(String persona) {
		this.persona = persona;
	}
}
