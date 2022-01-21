package Evaluacion_02;


public class Numeros {
	
	private int numero1;
	private int numero2;

	public Numeros(int a, int b) {
		if (a < 0) {
			numero1 = -a;
		} else {
			numero1 = a;
		}
		if (b < 0) {
			numero2 = -b;
		} else {
			numero2 = b;
		}
	}
	
	public int compara() {
		int mayor;
		if (numero1 > numero2) {
			mayor = numero1;
		} else {
			mayor = numero2;
		}
		return mayor;
	}
	
	public void setNumero1(int numero1) {
		this.numero1 = numero1;
	}
	
	public void setNumero2(int numero2) {
		this.numero2 = numero2;
	}

}
