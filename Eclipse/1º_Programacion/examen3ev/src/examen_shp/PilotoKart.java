package examen_shp;

import java.util.Arrays;

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
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(caracteristicas);
		long temp;
		temp = Double.doubleToLongBits(ganancias);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((piloto == null) ? 0 : piloto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PilotoKart other = (PilotoKart) obj;
		if (!Arrays.equals(caracteristicas, other.caracteristicas))
			return false;
		if (Double.doubleToLongBits(ganancias) != Double.doubleToLongBits(other.ganancias))
			return false;
		if (piloto == null) {
			if (other.piloto != null)
				return false;
		} else if (!piloto.equals(other.piloto))
			return false;
		return true;
	}

}
