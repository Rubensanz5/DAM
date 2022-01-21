package Practica_18.clases;
import java.time.LocalDate;

public class ProyectoSede {
	private int idProy;
	private int idSede;
	private LocalDate fInicio;
	private LocalDate fechFin;
	
	public ProyectoSede(int idProy, int idSede, LocalDate fInicio, LocalDate fechFin) {
		this.idProy = idProy;
		this.idSede = idSede;
		this.fInicio = fInicio;
		this.fechFin = fechFin;
	}
	
	public int getIdProy() {
		return idProy;
	}
	
	public void setIdProy(int idProy) {
		this.idProy = idProy;
	}
	
	public int getIdSede() {
		return idSede;
	}
	
	public void setIdSede(int idSede) {
		this.idSede = idSede;
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
	
	public String toString() {	
		return "Id_Proyecto: " + idProy + " - Asignado a la sede: " + idSede + " - Fecha Inicio " + fInicio + (fechFin == null ? "" : " - Fecha Fin " + fechFin);
	}
	
	
}
