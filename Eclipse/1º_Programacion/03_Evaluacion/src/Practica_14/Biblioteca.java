package Practica_14;

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
	
	public int[] numRecursos() {
		int[] numero = new int[] {0,0,0};
		
		for (Colecionable colecc : elementos) {
			if (colecc != null) {
				if(colecc instanceof Libro) {
					numero[0] += 1;
				} else if (colecc instanceof SerieTV) {
					numero[1] += 1;
				} else if (colecc instanceof Videojuego) {
					numero[2] += 1;
				}
			}
		}
		return numero;
	}
	
}
