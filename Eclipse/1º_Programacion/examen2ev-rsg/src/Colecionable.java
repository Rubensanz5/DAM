

public interface Colecionable {
	public static String LIBRO = "Libro";
	public static String SERIE_TV = "Serie de TV";
	public static String VIDEOJUEGO = "Videojuego";
	
	public boolean prestar();
	
	public boolean devolver();
	
	public boolean marcarFinalizado();
	
	
	
}
