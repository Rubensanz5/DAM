package Evaluacion_03;

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

	public PilotoKart() {
		
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
	
	@Override
	public int hashCode() {
		return piloto.hashCode() + caracteristicas[VELOCIDAD] + caracteristicas[ACELERACION] + 
				caracteristicas[PESO] + caracteristicas[MANEJO] + caracteristicas[AGARRE];
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof PilotoKart) {
			PilotoKart piloto2 = (PilotoKart) obj;
			if(this.piloto.equalsIgnoreCase(piloto2.piloto) && 
					this.caracteristicas[VELOCIDAD] == piloto2.caracteristicas[VELOCIDAD] && 
					this.caracteristicas[ACELERACION] == piloto2.caracteristicas[ACELERACION] && 
					this.caracteristicas[PESO] == piloto2.caracteristicas[PESO] && 
					this.caracteristicas[MANEJO] == piloto2.caracteristicas[MANEJO] && 
					this.caracteristicas[AGARRE] == piloto2.caracteristicas[AGARRE]) {
				return true; 
			} else {
				return false; 
			}
		} else {
			return false;
		}

	}
	
}
