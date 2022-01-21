
import java.util.Arrays;

public class ExamenRSG {

	public static void main(String[] args) {
		String propietario = "Ruben";
		
		Colecionable libro1 = new Libro("Java: The Complete Referene", "Herbert Schildt", "McGraw-Hill Education", 1312);
		libro1.prestar();
		
		int[] capitulos = {13,12,12,13,10};
		Colecionable serie1 = new SerieTV("The Wire", 5, capitulos); 
		
		Colecionable juego1 = new Videojuego("Civilization VI", Videojuego.PC);
	
		
		Colecionable[] elementos = {libro1,serie1,juego1};
		Biblioteca biblio = new Biblioteca(propietario, elementos);
		
		mostrarBiblioteca(biblio);
		

	}
	
	public static void mostrarBiblioteca(Biblioteca biblio) {
		System.out.println("Biblioteca de " + biblio.getPropietario().toUpperCase());
		System.out.println("------------------------------------------------------- \n\n");
		
		
		System.out.println("Libro\n" + ((Libro) biblio.getElementos()[0]).getTitulo() + "\n" + ((Libro) biblio.getElementos()[0]).getAutor() + "\n" +
				((Libro) biblio.getElementos()[0]).getEditorial() + "\n" + ((Libro) biblio.getElementos()[0]).getNumPags() + " páginas\n");
		
		System.out.println("Serie de TV\n" + ((SerieTV) biblio.getElementos()[1]).getNombre() + "\n" + ((SerieTV) biblio.getElementos()[1]).getNumTemporadas() + " temporadas\n" +
				Arrays.toString(((SerieTV) biblio.getElementos()[1]).getCapTemporada()) + " capitulos\n" );
		
		
		String plataforma = "";
		if(((Videojuego) biblio.getElementos()[2]).getPlataforma() == Videojuego.PC) {
			plataforma = "PC";
		} else if(((Videojuego) biblio.getElementos()[2]).getPlataforma() == Videojuego.MOVILE) {
			plataforma = "MOVILE";
		} else if(((Videojuego) biblio.getElementos()[2]).getPlataforma() == Videojuego.PLAYSTATION) {
			plataforma = "PLAYSTATION";
		} else if(((Videojuego) biblio.getElementos()[2]).getPlataforma() == Videojuego.XBOX) {
			plataforma = "XBOX";
		} else if(((Videojuego) biblio.getElementos()[2]).getPlataforma() == Videojuego.SWITCH) {
			plataforma = "SWITCH";
		} else {
			plataforma = "Other";
		}
		
		System.out.println("Videojuego \n" + ((Videojuego) biblio.getElementos()[2]).getNombre() + "\n" + plataforma + "\n");
		
	}

}
