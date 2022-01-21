package Practica_12y13.marioKart;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class MarioKartApp {

	public static void main(String[] args) {

		Competicion juanDeColoniaRace = new Competicion("Senda Arco Iris", "img/rainbowroad_map.png", 250, 3);
		
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
		
		PilotoKart[] pilotosJuanDeColoniaRace = { mario, luigi, peach, yoshi, bowser, donkeykong, toad, koopa, daisy, wario };
		
		juanDeColoniaRace.setParticipantes(pilotosJuanDeColoniaRace);
		
		
		juanDeColoniaRace.addKart(new PilotoKart("shyguy", "img/shyguy.png", new int[] {4, 5, 1, 3, 2}), 11);
		juanDeColoniaRace.removeKart("dfg");
		
		
		iniciarCompeticion(juanDeColoniaRace);
	}
	
	public static void iniciarCompeticion(Competicion competicion) {
		boolean seleccion = false;
			
		JOptionPane.showMessageDialog(null ,"COMPETICION SUPERMARIO KART \n" +
											"-----------------------------------------------  \n" + 
											competicion.getCircuito() + "\n" + 
											competicion.getCilindrada() + "cc - " + competicion.getVueltas() + " Vueltas\n" +
											competicion.getParticipantes().length + "pilotos \n" + 
											"Vuelta rapida " + competicion.getVueltaRapida(), 
											"SUPER MARIO KART: Senda Arcoiris", JOptionPane.PLAIN_MESSAGE ,new ImageIcon(competicion.getImagenMapa()));
		
		String[] opciones = {"Anterior", "Seleccionar Piloto", "Siguiente"};
		
		int n = 0;
		do {
			
			
			int opcion = JOptionPane.showOptionDialog(null, competicion.getParticipantes()[n].getPiloto().toUpperCase() + "\n\n" + 
					  " Velocidad: " + competicion.getParticipantes()[n].getCaracteristicas()[PilotoKart.VELOCIDAD] + 
					  "\n Aceleracion: " + competicion.getParticipantes()[n].getCaracteristicas()[PilotoKart.ACELERACION] +
					  "\n Peso: " + competicion.getParticipantes()[n].getCaracteristicas()[PilotoKart.PESO] +
					  "\n Manejo: " + competicion.getParticipantes()[n].getCaracteristicas()[PilotoKart.MANEJO] +
					  "\n Agarre: " + competicion.getParticipantes()[n].getCaracteristicas()[PilotoKart.AGARRE] +
					  (competicion.getParticipantes()[n].isSeleccionado() ? "\n PILOTO SELECCIONADO" : "\n"),
				 	  "Piloto: " + competicion.getParticipantes()[n].getPiloto() ,
					   JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, new ImageIcon(competicion.getParticipantes()[n].getImagen()), opciones, "Seleccionar Piloto");
			
			
		 	if (opcion == 0) {
		 		
		 		if(n <= 0) {
		 			
		 		} else {
		 			n--;
		 		}
			} else if (opcion == 1) {
				if(!competicion.getParticipantes()[n].isSeleccionado()) {
					competicion.getParticipantes()[n].setSeleccionado(true);
				}
				
			} else if (opcion == 2){
				if(n >= competicion.getParticipantes().length - 1) {
		 			
		 		} else {
		 			n++;
		 		}
			} else {
				seleccion = true;
			}
			
		} while (seleccion == false);
	}

}
