package cifpburgos.ocio;

import cifpburgos.Usuario;

public interface Coleccionable {
	//protected
	public final static String LIBRO = "Libro";
	public final static String SERIE = "Serie";
	public final static String VIDEOJUEGO = "Videojuego";
	
	public boolean prestar(Usuario user);
	public boolean devolver(Usuario user);
	public void marcarFinalizado();
	
	

}
