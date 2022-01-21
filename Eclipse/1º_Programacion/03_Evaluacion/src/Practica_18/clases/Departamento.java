package Practica_18.clases;
public class Departamento {
	private int idDepto;
	private String nomDepto;
	private int idSede;
	
	public Departamento(int idDepto, String nomDepto, int idSede) {
		this.idDepto = idDepto;
		this.nomDepto = nomDepto;
		this.idSede = idSede;
	}

	public int getIdDepto() {
		return idDepto;
	}

	public void setIdDepto(int idDepto) {
		this.idDepto = idDepto;
	}

	public String getNomDepto() {
		return nomDepto;
	}

	public void setNomDepto(String nomDepto) {
		this.nomDepto = nomDepto;
	}

	public int getIdSede() {
		return idSede;
	}

	public void setIdSede(int idSede) {
		this.idSede = idSede;
	}
	
	@Override
	public String toString() {	
		return idDepto + " - " + nomDepto + " Sede: " + idSede;
	}
	
}
