package empresa.clientes;

import empresa.Persona;

public class Cliente extends Persona {
	private int telefono_de_contacto;
	
	public Cliente(String nombre, int edad, int telefono_de_contacto) {
		super(nombre, edad);
		this.telefono_de_contacto = telefono_de_contacto;
	}

	public int getTelefono_de_contacto() {
		return telefono_de_contacto;
	}

	public void setTelefono_de_contacto(int telefono_de_contacto) {
		this.telefono_de_contacto = telefono_de_contacto;
	}


	@Override
	public void mostrar() {
		
	}

	
}
