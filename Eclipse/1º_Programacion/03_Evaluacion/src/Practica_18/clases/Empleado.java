package Practica_18.clases;
import java.math.BigDecimal;

public class Empleado {
	public static final String DNI = "[0-9]{8}[A-z]";
	
	private String dni;
	private String nomEmp;
	private String categoria;
	private BigDecimal sueldoBrutoAnual;
	private int idDepto;
	
	public Empleado(String dni, String nomEmp, int idDepto) {
		this.dni = dni;
		this.nomEmp = nomEmp;
		this.idDepto = idDepto;
	}

	public Empleado(String dni, String nomEmp, String categoria, BigDecimal sueldoBrutoAnual, int idDepto) {
		this.dni = dni;
		this.nomEmp = nomEmp;
		this.categoria = categoria;
		this.sueldoBrutoAnual = sueldoBrutoAnual;
		this.idDepto = idDepto;
	}

	public String getDni() {
		return dni;
	}
	
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	public String getNomEmp() {
		return nomEmp;
	}
	
	public void setNomEmp(String nom_emp) {
		this.nomEmp = nom_emp;
	}
	
	public String getCategoria() {
		return categoria;
	}
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public BigDecimal getSueldoBrutoAnual() {
		return sueldoBrutoAnual;
	}
	
	public void setSueldoBrutoAnual(BigDecimal sueldoBrutoAnual) {
		this.sueldoBrutoAnual = sueldoBrutoAnual;
	}

	public int getIdDepto() {
		return idDepto;
	}

	public void setIdDepto(int idDepto) {
		this.idDepto = idDepto;
	}
	
	@Override
	public String toString() {	
		return dni + " - " + nomEmp + " - " + categoria + " - " + sueldoBrutoAnual;
	}
	
	
}
