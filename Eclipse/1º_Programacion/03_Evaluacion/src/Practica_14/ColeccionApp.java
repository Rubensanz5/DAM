package Practica_14;


import javax.swing.JOptionPane;

public class ColeccionApp {
	public static Colecionable libro =  new Libro("El hombre de Tiza", "C. J. TUDOR", "PLAZA & JANES EDITORES", 352);
	public static Colecionable serie =  new SerieTV("Vikingos", 6, new int[] {9,10,10,20,20,20});
	public static Colecionable videojuego =  new Videojuego("League of Legends", Videojuego.PC);

	public static Colecionable[] coleccion =  {libro,serie,videojuego};
	
	public static Biblioteca biblioteca1 = new Biblioteca("Ruben", coleccion);
	
	public static Biblioteca[] bibliotecas = {biblioteca1};
	
	public static void main(String[] args) {
		menuEntrada();
	}
	
	public static void menuEntrada() {
		int opcion;
		do {
			String[] opciones = {"Dar de alta una nueva biblioteca", "Ver una biblioteca","Salir"};
			opcion = JOptionPane.showOptionDialog(null, "\nBienvenido a la Biblioteca\n\n\nElija una opcion:", "Bienvenido", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null , opciones, "Dar de alta una nueva biblioteca");
			switch (opcion) {
				case 0:
					altaBiblioteca();
					break;
				case 1:
					String[] propietarios = new String[bibliotecas.length];
					for (int i = 0; i < bibliotecas.length; i++) {
						propietarios [i] = bibliotecas[i].getPropietario();
					}	
					String nombre = String.valueOf(JOptionPane.showInputDialog(null, "Elige la biblioteca de un propietario:", "Plataformas", JOptionPane.DEFAULT_OPTION, null , propietarios, "PC"));

					try {
						verBiblioteca(nombre);
					} catch (ArrayIndexOutOfBoundsException ex) {
						
					}
						
					break;
				case 2:
				
					break;
				default:
					opcion = 2;
					break;
			
			}
		} while(opcion != 2);
	}
	
	public static void altaBiblioteca() {
		String propietario;
		boolean existente = false;
		
		do {
			propietario = JOptionPane.showInputDialog("Introduce el propietario de la biblioteca\n(Si coincide el nombre con otra no se creara): ");
			try {
				for (Biblioteca bibli : bibliotecas) {
					if(propietario.equalsIgnoreCase(bibli.getPropietario())){
						existente = true;
					}
				}
			} catch (NullPointerException ex) {
				JOptionPane.showMessageDialog(null, "No has introducido ningun nombre \n" + ex.getMessage());
			}
		} while(propietario == null);
			
		if(!existente) {
			Biblioteca[] bibliotecas0 = new Biblioteca[bibliotecas.length + 1];
			Colecionable[] recursos = recursos();
			Biblioteca biblio = new Biblioteca(propietario,recursos);
			for(int i = 0; i < bibliotecas.length; i++){
				bibliotecas0[i] = bibliotecas[i];
	        }
			bibliotecas0[bibliotecas.length] = biblio;
			bibliotecas = bibliotecas0;
		}
	}
	
	public static Colecionable[] recursos() {
		Colecionable[] coleccion = new Colecionable[0];
		int opcion;
		do {
			String[] opciones = {"Añadir un libro", "Añadir una serie", "Añadir un videojuego", "Volver"};
			opcion = JOptionPane.showOptionDialog(null, "Que quieres dar de alta\n\n\nElija una opcion:", "Dar altas", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null , opciones, "Añadir un libro");
			
			switch (opcion) {
				case 0:
					Colecionable[] coleccion0 = new Colecionable[coleccion.length + 1];
					String titulo = JOptionPane.showInputDialog("Introduce el titulo del libro");
					String autor = JOptionPane.showInputDialog("Introduce el autor del libro");
					String editorial = JOptionPane.showInputDialog("Introduce la editorial del libro");
					int numPags = 0;
					boolean fallo = false;
					do { 
						try {
							numPags = Integer.parseInt(JOptionPane.showInputDialog("Introduce el numero de páginas del libro"));
							fallo = false;
						} catch (NumberFormatException ex) {
							fallo = true;
							JOptionPane.showMessageDialog(null,"Tienes que introducir un numero\n" + ex.getMessage());
						}
					} while(fallo);
					
					Colecionable libro = new Libro(titulo, autor, editorial, numPags);
					for(int i = 0; i < coleccion.length; i++){
						coleccion0[i] = coleccion[i];
			        }
					coleccion0[coleccion.length] = libro;
					coleccion = coleccion0;
					break;
			case 1:
				Colecionable[] coleccion1 = new Colecionable[coleccion.length + 1];
				String nombre = JOptionPane.showInputDialog("Introduce el nombre de la serie");
				int numTemp = 0;
				boolean fallo1 = false;
				do { 
					try {
						numTemp = Integer.parseInt(JOptionPane.showInputDialog("Introduce el numero de temporadas de la serie"));
						fallo1 = false;
					} catch (NumberFormatException ex) {
						fallo1 = true;
						JOptionPane.showMessageDialog(null,"Tienes que introducir un numero\n" + ex.getMessage());
					}
				} while(fallo1);
				
				int numCap = 0;
				int[] capTemporada = new int[numTemp];
				boolean fallo2 = false;
				
				for (int i = 0; i <= capTemporada.length - 1; i++) {
					do { 
						try {
							numCap = Integer.parseInt(JOptionPane.showInputDialog("Introduce el numero de capitulos de la temporada " + (i + 1) ));
							fallo2 = false;
							capTemporada[i] = numCap;
						} catch (NumberFormatException ex) {
							fallo2 = true;
							JOptionPane.showMessageDialog(null,"Tienes que introducir un numero\n" + ex.getMessage());
						} catch (ArrayIndexOutOfBoundsException exc) {
							
						} 
					} while(fallo2);
				}
				
				Colecionable serie = new SerieTV(nombre, numTemp, capTemporada);
				for(int i = 0; i < coleccion.length; i++){
					coleccion1[i] = coleccion[i];
		        }
				coleccion1[coleccion.length] = serie;
				coleccion = coleccion1;

				break;
			case 2:
				Colecionable[] coleccion2 = new Colecionable[coleccion.length + 1];
				String juego = JOptionPane.showInputDialog("Introduce el nombre del Videojuego");
				String[] videojuego = Videojuego.videojue;
				String plataforma = String.valueOf( JOptionPane.showInputDialog(null, "Elige una la plataforma del juego:", "Plataformas", JOptionPane.DEFAULT_OPTION, null , videojuego, "PC"));

				Colecionable videojueg = new Videojuego(juego, plataforma);
			
				coleccion2[coleccion.length] = videojueg;
				coleccion = coleccion2;
				break;
				
			case 3:
				break;
				
			default:
				opcion = 3;
				break;
			}
		} while(opcion != 3);
		return coleccion;
		
	}
	
	public static void verBiblioteca(String nombre) throws ArrayIndexOutOfBoundsException {
		for (int i = 0; i <= bibliotecas.length; i++) {
			if(nombre.equalsIgnoreCase(bibliotecas[i].getPropietario())) {
				for (int j = 0; j < bibliotecas[i].getElementos().length; j++) {
					JOptionPane.showMessageDialog(null,	bibliotecas[i].getElementos()[j].mostrar());
				}
			}
		}
	}
	
}
