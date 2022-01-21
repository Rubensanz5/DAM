package Ejercicios.EjercicioEv;

public class Empleado {
	public static final String[] DEPARTAMENTOS = {"Marketing", "Informatica", "Ventas", "Recursos Humanos", "Comercial"};
	
	private static int id = 0; //4 bytes
	private String apellido; //30 bytes(15 caract)
	private String depto; //30 bytes(15 caract)
	private double salario; // 8 bytes
	
	
	
	public Empleado(String apellido, String depto, double salario) {
		id = id + 1;
		this.apellido = apellido;
		this.depto = depto;
		this.salario = salario;
	}
	public int getId() {
		return id;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDepto() {
		return depto;
	}
	public void setDepto(String depto) {
		this.depto = depto;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	
}
