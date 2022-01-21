package Practica_18.clases;
import java.time.LocalDate;

public class Proyecto {
	private int idProy;
	private String nomProy;
	private LocalDate fInicio;
	private LocalDate fechFin;
	
	public Proyecto(int idProy, String nomProy, LocalDate fInicio, LocalDate fechFin) {
		this.idProy = idProy;
		this.nomProy = nomProy;
		this.fInicio = fInicio;
		this.fechFin = fechFin;
	}

	public int getIdProy() {
		return idProy;
	}
	
	public void setIdProy(int idProy) {
		this.idProy = idProy;
	}
	
	public String getNomProy() {
		return nomProy;
	}
	
	public void setNomProy(String nomProy) {
		this.nomProy = nomProy;
	}
	
	public LocalDate getfInicio() {
		return fInicio;
	}
	
	public void setfInicio(LocalDate fInicio) {
		this.fInicio = fInicio;
	}
	
	public LocalDate getFechFin() {
		return fechFin;
	}
	
	public void setFechFin(LocalDate fechFin) {
		this.fechFin = fechFin;
	}
	
	@Override
	public String toString() {	
		
		return idProy + " - " + nomProy + " - Fecha Inicio " + fInicio + (fechFin == null ? "" : " Fecha Fin " + fechFin);
	}
	
}
