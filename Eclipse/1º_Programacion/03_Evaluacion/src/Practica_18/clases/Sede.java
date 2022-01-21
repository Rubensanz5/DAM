package Practica_18.clases;


public class Sede {
	private int idSede;
	private String nomSede;
	
	public Sede(int idSede, String nomSede) {
		this.idSede = idSede;
		this.nomSede = nomSede;
	}
	
	public int getIdSede() {
		return idSede;
	}
	
	public void setIdSede(int idSede) {
		this.idSede = idSede;
	}
	
	public String getNomSede() {
		return nomSede;
	}
	public void setNomSede(String nomSede) {
		this.nomSede = nomSede;
	}

	@Override
	public String toString() {	
		return idSede + " - " + nomSede;
	}
}
