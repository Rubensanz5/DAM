package cifpburgos;

import java.util.ArrayList;

import cifpburgos.ocio.Coleccionable;

public class Biblioteca {
	private Usuario propietario;
	private ArrayList<Coleccionable> lista = new ArrayList<>();
	
	
	public Biblioteca(Usuario propietario, ArrayList<Coleccionable> lista) {
		this.propietario = propietario;
		this.lista = lista;
	}
	public Usuario getPropietario() {
		return propietario;
	}
	public void setPropietario(Usuario propietario) {
		this.propietario = propietario;
	}
	public ArrayList<Coleccionable> getLista() {
		return lista;
	}
	public void setLista(ArrayList<Coleccionable> lista) {
		this.lista = lista;
	}
	
	
}
