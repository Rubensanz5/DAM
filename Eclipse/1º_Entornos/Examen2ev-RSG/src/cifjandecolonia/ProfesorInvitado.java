package cifjandecolonia;

import cifpjuandecolonia.Profesor;

public class ProfesorInvitado extends Profesor {

	private String empresa;
	
	public ProfesorInvitado(String nombre, String apellidos, int edad,String empresa) {
		super(nombre, apellidos, edad);
		this.empresa = empresa;
	}
	
	
	public String getEmpresa() {
		return empresa;
	}



	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}



	@Override
	public void mostrarNombreApellidosYCarnet() {
		System.out.println("Profesor Invitado: " + getNombre() + " " + getApellidos() + 
				" de la empresa " + empresa);
	}

}
