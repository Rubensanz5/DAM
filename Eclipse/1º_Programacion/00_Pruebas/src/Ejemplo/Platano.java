package Ejemplo;

public class Platano implements Fruta2 {

	private String tipo;
	
	public Platano( String tipo) {

		this.tipo = tipo;
	}
	
	@Override
	public String mostrarNombreYtipo() {
		return NOMBRE + tipo;
	}
	
	@Override
	public String mostrarColor() {
		return COLOR;
	}
	
}
