package Evaluacion_02.knightsapp;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class KnightsApp {

	public static void main(String[] args) {
		
		final int VIDA_INICIAL_PROTAGONISTA = 25;
		final int VIDA_INICIAL_ADVERSARIO = 25;
		final int RONDAS_COMBATE = 10;
		
		Caballero protagonista = new Caballero("Héctor", VIDA_INICIAL_PROTAGONISTA);
		Caballero adversario = new Caballero("Némesis de Héctor", VIDA_INICIAL_ADVERSARIO);
		
		Combate combate = new Combate(protagonista, adversario, RONDAS_COMBATE);
		
		JOptionPane.showMessageDialog(null, "Te batirás en duelo contra " + combate.getSegundoCaballero().getNombre(), "Combate", JOptionPane.WARNING_MESSAGE);
		JOptionPane.showMessageDialog(null, "¡Comienza el combate!", "Combate", JOptionPane.WARNING_MESSAGE);
		
		int finalCombate = combate.iniciar();

		if (finalCombate == Combate.GANADOR_COMBATE_PRIMER_CABALLERO) {
			JOptionPane.showMessageDialog(null, "¡¡Felicidades!!\n ¡Has ganado el combate!", "Combate", JOptionPane.PLAIN_MESSAGE, new ImageIcon("img/trompetas.jpg"));
			protagonista.setVida(VIDA_INICIAL_PROTAGONISTA);
			Caballero nuevoAdversario = new Caballero("Jefe final de Mazmorra", VIDA_INICIAL_ADVERSARIO);
			Combate combate2 = new Combate(protagonista, nuevoAdversario, 5);
			combate2.iniciar();
		} else if (finalCombate == Combate.GANADOR_COMBATE_SEGUNDO_CABALLERO) {
			JOptionPane.showMessageDialog(null, "¡¡Perdiste!!\n Has sido derrotado en combate", "Combate", JOptionPane.PLAIN_MESSAGE, new ImageIcon("img/lapida.jpg"));
		} else if (finalCombate == Combate.GANADOR_COMBATE_EMPATE) {
			JOptionPane.showMessageDialog(null, "¡¡Empate!!\n Ambos caballeros seguís en pie", "Combate", JOptionPane.PLAIN_MESSAGE, null);
		}
	}

}
