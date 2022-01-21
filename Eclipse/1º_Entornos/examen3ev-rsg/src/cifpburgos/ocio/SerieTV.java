package cifpburgos.ocio;

import java.util.Arrays;

import cifpburgos.Usuario;

public class SerieTV implements Coleccionable {
	private String nombre;
	private int temporadas;
	private int[] capitulos;
	private boolean[] visto;
	private Usuario prestatario;
	
	

	public SerieTV(String nombre, int temporadas, int[] capitulos, boolean[] visto, Usuario prestatario) {
		super();
		this.nombre = nombre;
		this.temporadas = temporadas;
		this.capitulos = capitulos;
		this.visto = visto;
		this.prestatario = prestatario;
	}

	public SerieTV(String nombre, int temporadas, Usuario prestatario) {
		this.nombre = nombre;
		this.temporadas = temporadas;
		this.capitulos = new int[temporadas];
		this.visto = new boolean[temporadas];
		Arrays.fill(visto, false);
		this.prestatario = prestatario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTemporadas() {
		return temporadas;
	}

	public void setTemporadas(int temporadas) {
		this.temporadas = temporadas;
	}

	public int[] getCapitulos() {
		return capitulos;
	}

	public void setCapitulos(int[] capitulos) {
		this.capitulos = capitulos;
	}

	public boolean[] getVisto() {
		return visto;
	}

	public void setVisto(boolean[] visto) {
		this.visto = visto;
	}

	public Usuario getPrestatario() {
		return prestatario;
	}

	public void setPrestatario(Usuario prestatario) {
		this.prestatario = prestatario;
	}

	@Override
	public boolean prestar(Usuario user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean devolver(Usuario user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void marcarFinalizado() {
		// TODO Auto-generated method stub
		
	}
	
	public void marcarVista(int temporada) {
		
	}

}
