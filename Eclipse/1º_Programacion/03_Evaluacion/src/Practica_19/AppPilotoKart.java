package Practica_19;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import javax.swing.JOptionPane;

import  Practica_19.Interface.MarioKartGUI;

public class AppPilotoKart {
	
	public static HashSet<PilotoKart> competicionPilotos = new HashSet<>();
	
	
	public static void main(String[] args) {
		escribirEnLog("Se ha iniciado la AppPilotoKart");
 
		MarioKartGUI.ventana = new MarioKartGUI();
		MarioKartGUI.ventana.setVisible(true);
		
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
		
		JOptionPane.showMessageDialog(MarioKartGUI.ventana, "Se han cargado los pilotos");
		
	}
	
	public static void escribirEnLog(String mensaje) {
		final DateTimeFormatter FORMAT_FECHA = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

		try (BufferedWriter writer = new BufferedWriter(new FileWriter("practica19.log", true))) {
			writer.write(LocalDateTime.now().format(FORMAT_FECHA) + " - " + mensaje);
			writer.newLine();
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}	
}
