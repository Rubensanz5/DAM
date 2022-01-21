package Practica_15.mariokart;

import java.io.File;
import java.util.HashSet;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class AppPilotoKart {
	
	public static HashSet<PilotoKart> competicionPilotos = new HashSet<>();
	
	
	public static void main(String[] args) {
		menuPrincipal();
	}
	
	public static void menuPrincipal() {
		int opcion;
		do {
			String[] opciones = {"Crear nuevo piloto", "Eliminar piloto", "Cargar pilotos por defecto", "Ver pilotos"};
			opcion = JOptionPane.showOptionDialog(null, "MARIO KART - Selecciona una opción:", "Mario Kart HashSet", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, new ImageIcon("img/mariokart.jpg"), opciones, "Crear nuevo piloto");

			switch(opcion) {
				case 0:
					crearPiloto();
					break;
				case 1:
					eliminarPiloto();
					break;
				case 2:
					cargarPilotos();
					break;
				case 3:
					mostrarPilotos();
					break;
				case 4: 
					break;
				default:
					opcion = 4;
					break;
			}
		} while (opcion != 4);
	}
	
	public static void crearPiloto() {

		String nombre = JOptionPane.showInputDialog("Introduce el nombre del nuevo piloto");
		String[] opciones = {"Si", "No"};
		
		int opcionImagen = JOptionPane.showOptionDialog(null, "Quieres añadir una imagen? \n(Si das a no se pondra una imagen por defecto)", "Imagen", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,null, opciones, "Si");
		
		String imagen = ponerImg(opcionImagen);
		
		int velocidad = pedirCaracteristicas("velocidad", nombre, imagen);
		int aceleracion = pedirCaracteristicas("aceleracion", nombre, imagen);
		int peso = pedirCaracteristicas("peso", nombre, imagen);
		int manejo = pedirCaracteristicas("manejo", nombre, imagen);
		int agarre = pedirCaracteristicas("agarre", nombre, imagen);

		PilotoKart piloto0 = new PilotoKart(nombre, imagen, new int[] {velocidad, aceleracion, peso, manejo, agarre});
		
		if (competicionPilotos.add(piloto0)){
			JOptionPane.showMessageDialog(null, "El piloto se ha creado correctamente");
		} else {
			JOptionPane.showMessageDialog(null, "Ese piloto ya existe");
		}
	}
	
	public static String ponerImg(int opcionAñadir) {
		String ruta;
		if(opcionAñadir == 0) {
			int opcion;
			JFileChooser selecionarImg = new JFileChooser();
			FileNameExtensionFilter filtro = new FileNameExtensionFilter("jpg y png", "jpg", "png");
			selecionarImg.setFileFilter(filtro);
			selecionarImg.setCurrentDirectory(new File("./img"));
			opcion = selecionarImg.showOpenDialog(selecionarImg);
			if(opcion == JFileChooser.CANCEL_OPTION) {
				ruta = "img/img-defecto.png";
			} else {
				ruta = selecionarImg.getSelectedFile().getAbsolutePath();
			}
		} else {
			ruta = "img/img-defecto.png";
		}
		return ruta;
	}
	
	public static int pedirCaracteristicas(String stat, String nombre, String imagen) {
		String[] caracteristicas = {"1 - Muy baja", "2 - Baja", "3 - Media", "4 - Alta", "5 - Muy Alta"};
		String caracteristica = null;
		do {
			caracteristica = (String) JOptionPane.showInputDialog(null, "Elige el/la " + stat + " del piloto " + nombre + " :", stat, JOptionPane.PLAIN_MESSAGE, new ImageIcon(imagen) , caracteristicas, null);
			if(caracteristica == null) {
				JOptionPane.showMessageDialog(null, "Tienes que terminar la creacion del personaje", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} while(caracteristica == null);
		
		caracteristica = caracteristica.substring(0,1);
		
		return Integer.parseInt(caracteristica);
	}
	
	public static void cargarPilotos() {
		PilotoKart mario = new PilotoKart("Mario", "img/mario.png", new int[] {3, 3, 3, 4, 3});
		PilotoKart luigi = new PilotoKart("Luigi", "img/luigi.png", new int[] {3, 3, 3, 4, 3});
		PilotoKart peach = new PilotoKart("Peach", "img/peach.png", new int[] {2, 4, 2, 4, 3});
		PilotoKart yoshi = new PilotoKart("Yoshi", "img/yoshi.png", new int[] {2, 3, 3, 3, 4});
		PilotoKart bowser = new PilotoKart("Bowser", "img/bowser.png", new int[] {5, 1, 5, 1, 3});
		PilotoKart donkeykong = new PilotoKart("Donkey Kong", "img/donkeykong.png", new int[] {4, 2, 4, 2, 2});
		PilotoKart toad = new PilotoKart("Toad", "img/toad.png", new int[] {1, 4, 1, 5, 4});
		PilotoKart koopa = new PilotoKart("Koopa", "img/koopa.png", new int[] {1, 5, 2, 4, 3});
		PilotoKart daisy = new PilotoKart("Daisy", "img/daisy.png", new int[] {2, 4, 2, 4, 3});
		PilotoKart wario = new PilotoKart("Wario", "img/wario.png", new int[] {5, 1, 5, 1, 2});
		PilotoKart shyguy = new PilotoKart("Shyguy", "img/shyguy.png", new int[] {4, 5, 1, 3, 2});
		
		competicionPilotos.add(mario);
		competicionPilotos.add(luigi);
		competicionPilotos.add(peach);
		competicionPilotos.add(yoshi);
		competicionPilotos.add(bowser);
		competicionPilotos.add(donkeykong);
		competicionPilotos.add(toad);
		competicionPilotos.add(koopa);
		competicionPilotos.add(daisy);
		competicionPilotos.add(wario);
		competicionPilotos.add(shyguy);
		
		JOptionPane.showMessageDialog(null, "Se han cargado los pilotos");
		
	}
	
	public static void eliminarPiloto() {
		if(competicionPilotos.size() != 0) {
			String[] pilotos = new String[competicionPilotos.size()];
			
			Iterator<PilotoKart> iterador = competicionPilotos.iterator();
			int i = 0;
			while(iterador.hasNext()) {
				PilotoKart p = (PilotoKart) iterador.next();
				pilotos[i] = p.getPiloto();
				i++;
			}	
			
			String nombre = (String) JOptionPane.showInputDialog(null, "Elige el nombre del piloto a eliminar:", "Eliminar piloto", JOptionPane.DEFAULT_OPTION, null , pilotos, null);
			
			PilotoKart piloto = null;
			
			for(PilotoKart p : competicionPilotos) {
				if(p.getPiloto().equals(nombre)) {
					piloto = p;
				}
			}
			
			competicionPilotos.remove(piloto);
		} else {
			JOptionPane.showMessageDialog(null, "No hay ningun piloto actualmente");
		}
	}
	
	public static void mostrarPilotos() {
		if (competicionPilotos.size() != 0) {
			boolean salir = false;
			int n = 0;
			String[] opciones = { "Anterior", "Seleccionar Piloto", "Siguiente", "Volver" };
			PilotoKart[] pilotos = new PilotoKart[competicionPilotos.size()];
			Iterator<PilotoKart> iterador = competicionPilotos.iterator();
			int i = 0;
			while (iterador.hasNext()) {
				PilotoKart p = (PilotoKart) iterador.next();
				pilotos[i] = p;
				i++;
			}
			do {
				int opcion = JOptionPane.showOptionDialog(null,
								  pilotos[n].getPiloto().toUpperCase() + "\n\n" + " Velocidad: "
								+ pilotos[n].getCaracteristicas()[PilotoKart.VELOCIDAD] + "\n Aceleracion: "
								+ pilotos[n].getCaracteristicas()[PilotoKart.ACELERACION] + "\n Peso: "
								+ pilotos[n].getCaracteristicas()[PilotoKart.PESO] + "\n Manejo: "
								+ pilotos[n].getCaracteristicas()[PilotoKart.MANEJO] + "\n Agarre: "
								+ pilotos[n].getCaracteristicas()[PilotoKart.AGARRE]
								+ (pilotos[n].isSeleccionado() ? "\n PILOTO SELECCIONADO" : "\n"),
								"Piloto: " + pilotos[n].getPiloto(), JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
								new ImageIcon(pilotos[n].getImagen()), opciones, "Seleccionar Piloto");

				if (opcion == 0) {
					if (n <= 0) {
					} else {
						n--;
					}
				} else if (opcion == 1) {
					if (!pilotos[n].isSeleccionado()) {
						pilotos[n].setSeleccionado(true);
					}
				} else if (opcion == 2) {
					if (n >= pilotos.length - 1) {

					} else {
						n++;
					}
				} else if (opcion == 3) {
					salir = true;
				} else {
					salir = true;
				}

			} while (salir == false);
		} else {
			JOptionPane.showMessageDialog(null, "No hay ningun piloto actualmente");
		}
	}
	
}
