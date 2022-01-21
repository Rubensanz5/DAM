package Practica_SS;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;



public class CentroCivico {
	static Recursos monopoly = new JuegosDeMesa("Monopoly", "Hasbro", 2, 3, 8, "img/monopoly.jpg");
	static Recursos avalon = new JuegosDeMesa("Avalon", "Devir", 1, 4, 10, "img/avalon.png");
	static Recursos tabu = new JuegosDeMesa("Tabu", "Hasbro Gaming", 3, 3, 6, "img/tabu.png");
	static Recursos bang = new JuegosDeMesa("Bang", "Edge Entertainment", 2, 3, 6, "img/bang.png");
	static Recursos[] juegosDeMesa = new Recursos[] {monopoly, avalon, tabu, bang};

	
	static Recursos solitario = new JuegosDeCartas("Solitario", 3, 50, "img/solitario.jfif");
	static Recursos continental = new JuegosDeCartas("Continental", 2, 120, "img/conti.png");
	static Recursos poker = new JuegosDeCartas("Poker", 2, 52, "img/poker.png");
	static Recursos uno = new JuegosDeCartas("uno", 1, 112, "img/uno.png");
	static Recursos[] juegosDeCartas = new Recursos[] {solitario, continental, poker, uno};

	
	static Recursos gtaV = new Videojuegos("GTA V", "RockStar", "PlayStation", 3, "img/GTAV.jpg");
	static Recursos isaac = new Videojuegos ("The Binding of Isaac Repentance", "Nicalis", "Nintendo Switch", 2, "img/isaac.png");
	static Recursos lol = new Videojuegos ("League of Legends", "PC", "Riot Games", 4, "img/LOL.png");
	static Recursos fortnite = new Videojuegos ("Fortnite", "XBOX", "Epic Games", 5, "img/fortnite.jpg");
	static Recursos[] videojuegos = new Recursos[] {gtaV, isaac, lol, fortnite};

	
	static Recursos dondeEstaWally = new Libros("Donde esta Wally", "MARTIN HANDFORD", "B DE BLOK", 32, 2, "img/wally.jpg");
	static Recursos harrypotter = new Libros ("Harry Potter y la piedra filosofal", "J.K Rowling", "SALAMANDRA", 368, 3, "img/harry.png");
	static Recursos hombreTiza = new Libros ("El hombre de Tiza", "C. J. TUDOR", "PLAZA & JANES EDITORES", 352, 4, "img/hombretiza.png");
	static Recursos historiasMiedo = new Libros ("Historias de Miedo Para no Dormir", "Alvin Schwartz", "OCEANO", 440, 2, "img/historias.jpg");
	static Recursos[] libros = new Recursos[] {dondeEstaWally, harrypotter, hombreTiza, historiasMiedo};
	
	static MesasDeJuego mesa1 = new MesasDeJuego(false, 4);
	static MesasDeJuego mesa2 = new MesasDeJuego(false, 5);
	static MesasDeJuego mesa3 = new MesasDeJuego(false, 6);
	static MesasDeJuego mesa4 = new MesasDeJuego(false, 7);
	static MesasDeJuego mesas[] = new MesasDeJuego[] {mesa1, mesa2, mesa3, mesa4};
	
	static Usuarios juan = new Usuarios("Juan","Perez","49588535F", true);
	static Usuarios maria = new Usuarios("Maria","Alvarez","95874520G", false);
	static Usuarios raul = new Usuarios("Raul","Fernandez","36658967Y", true);
	static Usuarios[] usuarios = new Usuarios[] {juan, maria, raul};
	
	
	
	public static void main(String[] args) {
		añadir();
		menuEntrada();
		
	}
	
	public static void añadir() {
		JuegosDeCartas poker1 = (JuegosDeCartas) poker;
		poker1.setComplementos(new String[] {"Necesita un tapete y fichas de poker\n", "Necesita un tapete y fichas de poker\n"});
		
		
		monopoly.setIncidencias(new String[] {"Juego 1:\nLe faltan 5 billetes de 10\n", "Juego 2:\nLe falta una ficha de jugador\n"});
		avalon.setIncidencias(new String[] {"Juego 1:\n"});
		bang.setIncidencias(new String[] {"Juego 1:\nLe faltan 2 balas\n", "Juego 2:\n", "Juego 3:\n"});
		tabu.setIncidencias(new String[] {"Juego 1:\n", "Juego 2:\nLe falta una ficha de jugador\n"});
		
		solitario.setIncidencias(new String[] {"Juego 1:\n", "Juego 2:\n", "Juego 3:\n"});
		continental.setIncidencias(new String[] {"Juego 1:\nFalta un comodin\n", "Juego 2:\n"});
		poker1.setIncidencias(new String[] {"Juego 1:\nFaltan tres fichas de 50\n", "Juego 2:\n"});
		uno.setIncidencias(new String[] {"Falta un + 4\n"});
		
		gtaV.setIncidencias(new String[] {"Videouego 1:\n", "Videouego 2:\nFalta la caratula\n", "Videouego 3:\n"});
		isaac.setIncidencias(new String[] {"Videouego 1:\n", "Videouego 2:\n"});
		lol.setIncidencias(new String[] {"Videouego 1:\n", "Videouego 2:\nEl disco esta rayado\n", "Videouego 3:\n", "Videouego 4:\n"});
		fortnite.setIncidencias(new String[] {"Videouego 1:\n", "Videouego 2:\n", "Videouego 3:\nInicia lento\n", "Videouego 4:\n", "Videouego 5:\nHay veces que se sale\n"});
		
		dondeEstaWally.setIncidencias(new String[] {"Libro 1: \n", "Libro 2: \nEsta pintado en la pag 21\n"});
		harrypotter.setIncidencias(new String[] {"Libro 1: \nLa caratula esta en mal estado\n", "Libro 2: \n", "Libro 3: \n"});
		hombreTiza.setIncidencias(new String[] {"Libro 1: \n", "Libro 2: \n", "Libro 3: \n", "Libro 4: \nHay paginas arrugadas\n"});
		historiasMiedo.setIncidencias(new String[] {"Libro 1: \n", "Libro 2: \n"});

		poker = poker1;

	}
	
	public static void menuEntrada() {
		int opcion;
		do {
			String[] opciones = {"Entrar", "Registrarte", "Dar de alta un recurso","Salir"};
			opcion = JOptionPane.showOptionDialog(null, "\nBienvenido a la sala de juegos\n\n\nElija una opcion:", "Bienvenido", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, new ImageIcon("img/sala.jpg") , opciones, "Entrar");
			switch (opcion) {
				case 0:
					Usuarios usuarioActual;
					do {
						usuarioActual = login();
					} while (usuarioActual == null);
					mostrarOpciones(usuarioActual);
				break;
			case 1:
				usuarioActual = nuevoUsuario();
				mostrarOpciones(usuarioActual);
				
				break;
			case 2:
				darAltas();
				break;
				
			case 3:
				break;
			}
		} while(opcion != 3);
	}
	
	public static void darAltas() {
		int opcion0;
		do {
			String[] opciones0 = {"Dar de alta un juego de mesa", "Dar de alta un juego de cartas", "Dar de alta un videojuego", "Dar de alta un libro", "Salir"};
			opcion0 = JOptionPane.showOptionDialog(null, "¿Que recurso quieres dar de alta?:", "Dar altas", 0, JOptionPane.QUESTION_MESSAGE, null, opciones0, null);
			switch (opcion0) {
				case 0:
					String nombre = JOptionPane.showInputDialog("Introduce el titulo del juego de mesa\n(Si pones un nombre ya existente se sumara una unidad a ese recurso): ");
					
					if(comprobarRecurso(juegosDeMesa, nombre)) {
						Recursos[] juegosDeMesa0 = new Recursos[juegosDeMesa.length + 1];
						
						String editorial = JOptionPane.showInputDialog("Introduce la editorial: ");
						int unidades = Integer.parseInt(JOptionPane.showInputDialog("Introduce el numero de unidades: "));
						int minJugadores = Integer.parseInt(JOptionPane.showInputDialog("Introduce el numero de unidades: "));
						int maxJugadores = Integer.parseInt(JOptionPane.showInputDialog("Introduce el numero de unidades: "));
						Recursos juegoDeMesaX = new JuegosDeMesa(nombre, editorial, unidades, minJugadores, maxJugadores, "img/nojuegom.png");
						for(int i = 0; i < juegosDeMesa.length; i++){
							juegosDeMesa0[i] = juegosDeMesa[i];
				        }
						juegosDeMesa0[juegosDeMesa.length] = juegoDeMesaX;
						juegosDeMesa = juegosDeMesa0;
						
					}
					break;
				case 1:
					String nombre0 = JOptionPane.showInputDialog("Introduce el titulo del juego de cartas\n(Si pones un nombre ya existente se sumara una unidad a ese recurso): ");
					
					if(comprobarRecurso(juegosDeCartas, nombre0)) {
						Recursos[] juegosDeCartas0 = new Recursos[juegosDeCartas.length + 1];
						int unidades = Integer.parseInt(JOptionPane.showInputDialog("Introduce el numero de unidades: "));
						int numCartas = Integer.parseInt(JOptionPane.showInputDialog("Introduce el numero de numero de cartas: "));
						Recursos juegoDeCartasX = new JuegosDeCartas(nombre0, unidades, numCartas, "img/nojuec.png");
						for(int i = 0; i < juegosDeCartas.length; i++){
							juegosDeCartas0[i] = juegosDeCartas[i];
				        }
						juegosDeCartas0[juegosDeCartas.length] = juegoDeCartasX;
						juegosDeCartas = juegosDeCartas0;
					}
					
					break;
				case 2:
					String nombre1 = JOptionPane.showInputDialog("Introduce el titulo del videojuego \n(Si pones un nombre ya existente se sumara una unidad a ese recurso): ");
					
					if(comprobarRecurso(videojuegos, nombre1)) {
						Recursos[] videojuegos0 = new Recursos[videojuegos.length + 1];
						String compañia = JOptionPane.showInputDialog("Introduce la compañia del videojuego: ");
						String[] opcion = Videojuegos.PLATAFORMAS;
						String plataforma = String.valueOf( JOptionPane.showInputDialog(null, "Elige una la plataforma del juego:", "Plataformas", JOptionPane.DEFAULT_OPTION, new ImageIcon("img/videojuegos.jpg") , opcion, "PC"));
						int unidades = Integer.parseInt(JOptionPane.showInputDialog("Introduce el numero de unidades: "));
						Recursos videojuegosX = new Videojuegos(nombre1, compañia, plataforma, unidades, "img/novideojue.png");
						for(int i = 0; i < videojuegos.length; i++){
							videojuegos0[i] = videojuegos[i];
				        }
						videojuegos0[videojuegos.length] = videojuegosX;
						videojuegos = videojuegos0;
					}
					break;
				case 3:
					String nombre2 = JOptionPane.showInputDialog("Introduce el titulo del juego de mesa\n(Si pones un nombre ya existente se sumara una unidad a ese recurso): ");
					
					if(comprobarRecurso(libros, nombre2)) {
						Recursos[] libros0 = new Recursos[libros.length + 1];
						
						String autor = JOptionPane.showInputDialog("Introduce el autor: ");
						String editorial = JOptionPane.showInputDialog("Introduce la editorial: ");
						int numPaginas = Integer.parseInt(JOptionPane.showInputDialog("Introduce el numero de paginas: "));
						int unidades = Integer.parseInt(JOptionPane.showInputDialog("Introduce el numero de unidades: "));
						Recursos librosX = new Libros(nombre2, autor, editorial, numPaginas ,unidades, "img/nolib.png");
						for(int i = 0; i < libros.length; i++){
							libros0[i] = libros[i];
				        }
						libros0[libros.length] = librosX;
						libros = libros0;
					}
					break;
				case 4:
					
					break;
				
			}
		} while (opcion0 != 4);
	}
	
	public static boolean comprobarRecurso(Recursos[] recurso0, String nombre) {
		boolean existente = false;
		for (int i = 0 ; i < recurso0.length || existente == true; i++) {
			if (recurso0[i].getNombre().equalsIgnoreCase(nombre)) {
				recurso0[i].setUnidadesTotales(recurso0[i].getUnidadesTotales() + 1);
				JOptionPane.showMessageDialog(null, "Has añadido una unidad de " + recurso0[i].getNombre() + " ahora hay un total de: " + recurso0[i].getUnidadesTotales());
				existente = true;
				return false;
			}
		}
		return true;
	}

	public static void opcionesRecursos(Recursos[] array, Usuarios usuarioActual) {
	int n = 0;
	String[] opciones = {"Anterior", "Prestamo", "Devolucion", "Ver Incidencias", "Poner Incidencias", "Ver Prestamos", "Siguiente", "Salir"};
	String recurso = "";
	String mensaje = "";
	boolean seleccion = false;
	do {
		if(array[n] instanceof JuegosDeMesa) {
			JuegosDeMesa jue = (JuegosDeMesa) array[n];
			recurso = "Juego de Mesa";
			mensaje = jue.mostrarInformacion() ;
		} else if (array[n] instanceof JuegosDeCartas) {
			JuegosDeCartas jueCartas = (JuegosDeCartas) array[n];
			recurso = "Juego de Cartas";
			mensaje = jueCartas.mostrarInformacion() ;
		} else if (array[n] instanceof Libros) {
			Libros libro = (Libros) array[n];
			recurso = "Libro";
			mensaje = libro.mostrarInformacion() ;
		} else if (array[n] instanceof Videojuegos) {
			Videojuegos VideoJue = (Videojuegos) array[n];
			recurso = "Videojuego";
			mensaje = VideoJue.mostrarInformacion() ;
		}
	

		int opcion = JOptionPane.showOptionDialog(null, mensaje,
			 	  recurso + "--->" + array[n].getNombre() ,
				  JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, new ImageIcon(array[n].getImagen()), opciones, "Siguiente");
		
		
	 	switch (opcion) {
		 	case 0:
		 		if(n <= 0) {
		 			
		 		} else {
		 			n--;
		 		}
		 		break;
		 	case 1:
				array[n].prestamos(usuarioActual);
		 		break;
		 	case 2:
		 		array[n].devolucion(usuarioActual);
		 		break;
		 	case 3:
		 		JOptionPane.showMessageDialog(null,array[n].verIncidencias());
		 		break;
		 	case 4:
		 		array[n].ponerIncidencia(usuarioActual);
		 		break;
		 	case 5:
		 		JOptionPane.showMessageDialog(null, array[n].verPrestamos());
		 		break;
		 	case 6:
				if(n >= array.length - 1) {
		 			
		 		} else {
		 			n++;
		 		}
				break;
		 	case 7:
		 		seleccion = true;
		 		break;
			default:
				seleccion = true;
				break;
		 	}
		} while (seleccion == false);
	}

	public static void mostrarOpciones(Usuarios usuarioActual) {
		final int MESA = 0; 
		final int JUEGODEMESA = 1; 
		final int JUEGODECARTAS= 2; 
		final int VIDEOJUEGO = 3; 
		final int LIBRO = 4; 
		final int SALIRMESA = 5; 
		final int SALIR = 6; 
		int opcion0;
		
		do {
			String[] opciones0 = {"Reservar/Usar una mesa", "Usar un juego de mesa", "Usar un juego de cartas", "Usar un videojuego", "Usar un libro", "Levantarse de la mesa", "Salir"};
			opcion0 = JOptionPane.showOptionDialog(null, "¿Que quieres hacer?\n\nElige una opcion:", "Bienvenido", 0, JOptionPane.QUESTION_MESSAGE, null, opciones0, null);
			switch (opcion0) {
				case MESA:
					mesasJuego(usuarioActual);
					break;
				case JUEGODEMESA:
					opcionesRecursos(juegosDeMesa,usuarioActual);
					break;
				case JUEGODECARTAS:
					opcionesRecursos(juegosDeCartas,usuarioActual);
					break;
				case VIDEOJUEGO:
					opcionesRecursos(videojuegos,usuarioActual);
					break;
				case LIBRO:
					opcionesRecursos(libros,usuarioActual);
					break;
				case SALIRMESA:
					irseMesasJuego(usuarioActual);
					break;
				case SALIR:
					break;
			}
		} while(opcion0 != SALIR);
	}
	
	public static void mesasJuego(Usuarios usuarioActual) {
		String[] opciones = {"Mesa de 4 sillas", "Mesa de 5 sillas", "Mesa de 5 sillas", "Mesa de 6 sillas", "Mesa de 7 sillas", "Salir"};
		int opcion = JOptionPane.showOptionDialog(null, "¿Que quieres hacer?\n\nElige una opcion:", "Bienvenido", 0, JOptionPane.QUESTION_MESSAGE, null, opciones, null);
		switch (opcion) {
		case 0 :
			if(!mesa1.isReservar()) {
				if(!usuarioActual.isUsandoMesa()) {
					JOptionPane.showMessageDialog(null, mesa1.reservarMesa(usuarioActual));
				} else {
					JOptionPane.showMessageDialog(null, "Ya estas en una mesa, NO puedes reservar estar en otra");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Esta mesa ya se ha reservado");
			}
			break;
		case 1 :
			if(!mesa2.isReservar()) {
				if(!usuarioActual.isUsandoMesa()) {
					JOptionPane.showMessageDialog(null, mesa2.reservarMesa(usuarioActual));
				} else {
					JOptionPane.showMessageDialog(null, "Ya estas en una mesa, NO puedes reservar estar en otra");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Esta mesa ya se ha reservado");
			}
			break;
		case 2 :
			if(!mesa3.isReservar()) {
				if(!usuarioActual.isUsandoMesa()) {
					JOptionPane.showMessageDialog(null, mesa3.reservarMesa(usuarioActual));
				} else {
					JOptionPane.showMessageDialog(null, "Ya estas en una mesa, NO puedes reservar estar en otra");
				}			} else {
				JOptionPane.showMessageDialog(null, "Esta mesa ya se ha reservado");
			}
			break;
		case 3 :
			if(!mesa4.isReservar()) {
				if(!usuarioActual.isUsandoMesa()) {
					JOptionPane.showMessageDialog(null, mesa4.reservarMesa(usuarioActual));
				} else {
					JOptionPane.showMessageDialog(null, "Ya estas en una mesa, NO puedes reservar estar en otra");
				}			} else {
				JOptionPane.showMessageDialog(null, "Esta mesa ya se ha reservado");
			}
			break;
		case 4 :
			break;
		}
	}
	
	public static void irseMesasJuego(Usuarios usuarioActual) {
		String[] opciones = {"Mesa de 4 sillas", "Mesa de 5 sillas", "Mesa de 5 sillas", "Mesa de 6 sillas", "Mesa de 7 sillas", "Salir"};
		int opcion = JOptionPane.showOptionDialog(null, "¿Que quieres hacer?\n\nElige una opcion:", "Bienvenido", 0, JOptionPane.QUESTION_MESSAGE, null, opciones, null);
		switch (opcion) {
		case 0 :
			if(mesa1.isReservar()) {
				if(usuarioActual.isUsandoMesa()) {
					JOptionPane.showMessageDialog(null, mesa1.irseDeMesa(usuarioActual));
				} else {
					JOptionPane.showMessageDialog(null, "NO puedes dejar una mesa en la que no estas");
				}
			} else {
				JOptionPane.showMessageDialog(null, "No hay nadie en esta mesa");
			}
			break;
		case 1 :
			if(mesa2.isReservar()) {
				if(usuarioActual.isUsandoMesa()) {
					JOptionPane.showMessageDialog(null, mesa2.irseDeMesa(usuarioActual));
				} else {
					JOptionPane.showMessageDialog(null, "NO puedes dejar una mesa en la que no estas");
				}
			} else {
				JOptionPane.showMessageDialog(null, "No hay nadie en esta mesa");
			}
			break;
		case 2 :
			if(mesa3.isReservar()) {
				if(usuarioActual.isUsandoMesa()) {
					JOptionPane.showMessageDialog(null, mesa3.irseDeMesa(usuarioActual));
				} else {
					JOptionPane.showMessageDialog(null, "NO puedes dejar una mesa en la que no estas");
				}
			} else {
				JOptionPane.showMessageDialog(null, "No hay nadie en esta mesa");
			}
			break;
		case 3 :
			if(mesa4.isReservar()) {
				if(usuarioActual.isUsandoMesa()) {
					JOptionPane.showMessageDialog(null, mesa4.irseDeMesa(usuarioActual));
				} else {
					JOptionPane.showMessageDialog(null, "NO puedes dejar una mesa en la que no estas");
				}
			} else {
				JOptionPane.showMessageDialog(null, "No hay nadie en esta mesa");
			}
			break;
		case 4 :
			break;
		}
	}
	
	public static Usuarios login() {
		String nombre,dni;
		nombre = JOptionPane.showInputDialog("Introduce tu nombre de Usuario");
		dni = JOptionPane.showInputDialog("Introduce tu DNI para cooroborar tu identidad");
		for (Usuarios usuario : usuarios) {
			if (usuario.getNombre().equalsIgnoreCase(nombre)) {
				if (usuario.getDni().equalsIgnoreCase(dni)) {
					JOptionPane.showMessageDialog(null, (usuario.isHombre() ? "Bienvenido " : "Bienvenida ") + usuario.getNombre() + " " + usuario.getApellido());
					return usuario;
				}
			}
		}
		return null;
	}
	
	public static Usuarios nuevoUsuario() {
		String nombre, dni, apellido;
		boolean hombre;
		Usuarios usuarioNuevo = null;
		do {
			nombre = JOptionPane.showInputDialog("Introduce tu nombre para crear tu usuario");
			apellido = JOptionPane.showInputDialog("Introduce tu apellido para crear tu usuario");
			//si da a la X por defecto va a ser mujer
			String[] opciones0 = {"Hombre", "Mujer"};
			int opcion0 = JOptionPane.showOptionDialog(null, "Elije tu sexo:", "Sexo", 0, JOptionPane.QUESTION_MESSAGE, null, opciones0, null);
			hombre = (opcion0 == 0 ? true : false);
			do {
				dni = JOptionPane.showInputDialog("Introduce tu DNI para crear tu usuario \n(No puedes dejarlo en blanco)");
			} while(dni.equalsIgnoreCase(""));
			if (comprobarUsuario(dni)) {
				Usuarios[] users0 = new Usuarios[usuarios.length + 1];
				usuarioNuevo = new Usuarios (nombre, apellido, dni, hombre);
				for(int i = 0; i < usuarios.length; i++){
					users0[i] = usuarios[i];
		        }
				users0[usuarios.length] = usuarioNuevo;
				usuarios = users0;
			} else {
				usuarioNuevo = null;
				JOptionPane.showMessageDialog(null, "Ese DNI pertenece a un usuario ya registrado");
			}
		} while(usuarioNuevo == null);
		return usuarioNuevo;
	}
	
	public static boolean comprobarUsuario(String dni) {
		boolean existente = false;
		for (int i = 0 ; i < usuarios.length || existente == true; i++) {
			if (usuarios[i].getDni().equalsIgnoreCase(dni)) {
					existente = true;
					return false;
			}
		}
		return true;
	}

}
