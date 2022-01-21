package examen_rrp;


public class PilotoKart {

	public static final int VELOCIDAD = 0;
	public static final int ACELERACION = 1;
	public static final int PESO = 2;
	public static final int MANEJO = 3;
	public static final int AGARRE = 4;
	
	private String piloto;
	private int[] caracteristicas;
	private double ganancias;

	public PilotoKart(String piloto, int[] caracteristicas) {
		this.piloto = piloto;
		this.caracteristicas = caracteristicas;
	}

	public String getPiloto() {
		return piloto;
	}

	public void setPiloto(String piloto) {
		this.piloto = piloto;
	}

	public int[] getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(int[] caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	public double getGanancias() {
		return ganancias;
	}

	public void setGanancias(double ganancias) {
		this.ganancias = ganancias;
	}

	@Override
	public int hashCode() {
		return piloto.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof PilotoKart)) {
			return false;
		} else {
			return this.piloto.equals(((PilotoKart) obj).piloto);
		}
	}

	@Override
	public String toString() {
		return piloto + " - Ganancias: " + ganancias;
	}

}
