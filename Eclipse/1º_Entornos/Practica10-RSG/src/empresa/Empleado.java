package empresa;

public class Empleado extends Persona {
	private double sueldoBruto;
	
	public Empleado(String nombre, int edad, double sueldoBruto) {
		super(nombre, edad);
		this.sueldoBruto = sueldoBruto;
	}
	
	public double getSueldoBruto() {
		return sueldoBruto;
	}
	
	public void setSueldoBruto(double sueldoBruto) {
		this.sueldoBruto = sueldoBruto;
	}
	
	@Override
	public void mostrar() {
		
	}
	
	public double calcular_salario_neto() {
		return sueldoBruto;
	}
	
}
