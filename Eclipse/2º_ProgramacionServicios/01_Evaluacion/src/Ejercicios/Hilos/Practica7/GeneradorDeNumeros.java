package Ejercicios.Hilos.Practica7;

public class GeneradorDeNumeros {
	private int numeroGenerado;
	private boolean numGen;

	public int getNumeroGenerado() {
		numGen = false;
		return numeroGenerado;
	}

	public void setNumeroGenerado(int numeroGenerado) {
		this.numeroGenerado = numeroGenerado;
		numGen = true;
	}

	public boolean isNumGen() {
		return numGen;
	}

	public void setNumGen(boolean numGen) {
		this.numGen = numGen;
	}
	
}
