package Practica_12y13.marioKart;

public class PilotoKart {
	
	public static final int VELOCIDAD = 0;
	public static final int ACELERACION = 1;
	public static final int PESO = 2;
	public static final int MANEJO = 3;
	public static final int AGARRE = 4;
	
	private String piloto;
	private String imagen;
	private int[] caracteristicas;
	private boolean seleccionado;

	public PilotoKart(String piloto, String imagen, int[] caracteristicas) {
		this.piloto = piloto;
		this.imagen = imagen;
		this.caracteristicas = caracteristicas;
	}

	public String getPiloto() {
		return piloto;
	}

	public void setPiloto(String piloto) {
		this.piloto = piloto;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public int[] getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(int[] caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	public boolean isSeleccionado() {
		return seleccionado;
	}

	public void setSeleccionado(boolean seleccionado) {
		this.seleccionado = seleccionado;
	}

	
}
