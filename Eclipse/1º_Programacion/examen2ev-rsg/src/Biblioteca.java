

public class Biblioteca {
	private String propietario;
	private Colecionable[] elementos = new Colecionable[100];
	
	
	public Biblioteca(String propietario, Colecionable[] elementos) {
		this.propietario = propietario;
		this.elementos = elementos;
	}
	public String getPropietario() {
		return propietario;
	}
	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}
	public Colecionable[] getElementos() {
		return elementos;
	}
	public void setElementos(Colecionable[] elementos) {
		this.elementos = elementos;
	}
	
}
