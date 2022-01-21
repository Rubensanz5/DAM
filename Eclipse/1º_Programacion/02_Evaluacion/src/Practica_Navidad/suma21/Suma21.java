package Practica_Navidad.suma21;

import javax.swing.JOptionPane;

public class Suma21 {
	static Jugador jugador1;
	static Jugador jugador2;
	static Jugador jugador3;
	static Jugador jugador4;
	
	public static void main(String[] args) {
		int opcion; 
		
		do {
			opcion = Integer.parseInt(JOptionPane.showInputDialog("¿Que haras? \n [0] Salir \n [1] Reglas(Como se juega)\n [2] Jugar"));
			
			switch (opcion) {
				case 0: 
					JOptionPane.showMessageDialog(null, "Estas saliendo del juego");
					break;
				case 1:
					JOptionPane.showMessageDialog(null, "Estas son las reglas: \n 1. El juego consiste en llegar a 21 sin pasarte.\n"
							+ "2. Las cartas tienen valor del 1 al 10 y de mano se reparten 2 cartas\n"
							+ "3. El valor de la mano es la suma de los puntos de las dos, o más, cartas que se reparten.\n"
							+ "4. Gana quien mas se acerque a 21 o quien llegue."
							+ "5. Si te pasas tu puntuacion sera la ultima antes de pasarte."
							+ "6. Si tus cartas iniciales son mayor de 21 tu puntuacion será 0");
					break;
				case 2:
					int jugadores;
					do {
						jugadores = Integer.parseInt(JOptionPane.showInputDialog("Cuantos jugadores van a jugar (1-4)"));
					} while (jugadores < 1 || jugadores > 4);
					
					switch (jugadores) {
						case 1:
							jugador1 = new Jugador();
							break;
						case 2:
							jugador1 = new Jugador();
							jugador2 = new Jugador();
							break;
						case 3:
							jugador1 = new Jugador();
							jugador2 = new Jugador();
							jugador3 = new Jugador();
							break;
						case 4:
							jugador1 = new Jugador();
							jugador2 = new Jugador();
							jugador3 = new Jugador();
							jugador4 = new Jugador();
							break;
						}
					
					for (int i = 1; i <= jugadores; i++) {
						JOptionPane.showMessageDialog(null,"Jugador" + i );
						Jugador jugador0 = new Jugador();
						String otraCarta = "y";
						int nuevaCarta = 0;
						boolean otra = true;
						// cartas iniciales
						JOptionPane.showMessageDialog(null,"Tus cartas: " + jugador0.carta1 + ", " + jugador0.carta2);
		
						// Total
						JOptionPane.showMessageDialog(null,"Total: " + jugador0.total);
						if (jugador0.total < 21) {
							do {
								do {
								otraCarta = JOptionPane.showInputDialog("Quieres otra carta? (intrroduce: y / n): ");
								} while (!(otraCarta.charAt(0) == 'n' || otraCarta.charAt(0) == 'y'));
								
								if (otraCarta.charAt(0) == 'n'){
									otra = false;
								} else if (otraCarta.charAt(0) == 'y'){
									otra = true;
									nuevaCarta = jugador0.cartaNueva();
									JOptionPane.showMessageDialog(null,"Carta: " + nuevaCarta);
									jugador0.total += nuevaCarta;
									JOptionPane.showMessageDialog(null,"Total: " + jugador0.total);
									
									if (jugador0.total < 21) {	
										JOptionPane.showMessageDialog(null,"Aun estas pordebajo de 21");
									} else if(jugador0.total == 21) {
										JOptionPane.showMessageDialog(null,"Has ganado !!!");
									
									} else if (jugador0.total > 21) {
										JOptionPane.showMessageDialog(null,"Te has pasado.");
									}
								}
							} while (otra && jugador0.total < 21);					
						} else if (jugador0.total > 21) {
							jugador0.total = 0;
						} else {
							JOptionPane.showMessageDialog(null,"Has ganado a la primera con tus cartas iniciales !!!");
						}
						
						if (jugador0.total < 22) {
							JOptionPane.showMessageDialog(null,"Tu puntuacion final es: " + jugador0.total);
						} else {
							JOptionPane.showMessageDialog(null,"Tu puntuacion final es: " + (jugador0.total - nuevaCarta));
						}
						
						switch (i) {
							case 1:
								if (jugador0.total <= 21) {
									jugador1.total = jugador0.total;
								} else {
									jugador0.total -= nuevaCarta;
									jugador1.total = jugador0.total;
								}
								break;
							case 2:
								if (jugador0.total <= 21) {
									jugador2.total = jugador0.total;
								} else {
									jugador0.total -= nuevaCarta;
									jugador2.total = jugador0.total;
								}
								break;
							case 3:
								if (jugador0.total <= 21) {
									jugador3.total = jugador0.total;
								} else {
									jugador0.total -= nuevaCarta;
									jugador3.total = jugador0.total;
								}
								break;
							case 4:
								if (jugador0.total <= 21) {
									jugador4.total = jugador0.total;
								} else {
									jugador0.total -= nuevaCarta;
									jugador4.total = jugador0.total;
								}
								break;
						}
					}
					saberGanador(jugadores);
				}	
		} while (opcion > 0 && opcion < 3);
		
		if (opcion >= 3) {
			JOptionPane.showMessageDialog(null,"Has elegido una opcion que no existe");
		}
	}
	
	
	public static void saberGanador(int numJugadores) {
		switch (numJugadores) {
			case 1:
				JOptionPane.showMessageDialog(null,"Tu puntuacion fianl es: " + jugador1.total);
			case 2:
				if (jugador1.total > jugador2.total) {
					JOptionPane.showMessageDialog(null,"Ha ganado jugador1 con la puntuacion fianl de: " + jugador1.total);
				} else if (jugador1.total < jugador2.total) {
					JOptionPane.showMessageDialog(null,"Ha ganado jugador2 con la puntuacion fianl de: " + jugador2.total);
				} else {
					JOptionPane.showMessageDialog(null,"Jugador1 y jugador2 han empatado con la puntuacion fianl de: " + jugador1.total);
				}
			case 3:
				if (jugador1.total > jugador2.total) {
					if (jugador1.total > jugador3.total) {
						JOptionPane.showMessageDialog(null,"Ha ganado jugador1 con la puntuacion fianl de: " + jugador1.total);
					} else if (jugador1.total < jugador3.total) {
						JOptionPane.showMessageDialog(null,"Ha ganado jugador3 con la puntuacion fianl de: " + jugador3.total);
					} else {
						JOptionPane.showMessageDialog(null,"Jugador1 y jugador3 han empatado con la puntuacion fianl de: " + jugador1.total);
					}
				} else if (jugador1.total < jugador2.total) {
					if (jugador2.total > jugador3.total) {
						JOptionPane.showMessageDialog(null,"Ha ganado jugador2 con la puntuacion fianl de: " + jugador2.total);
					} else if (jugador2.total < jugador3.total) {
						JOptionPane.showMessageDialog(null,"Ha ganado jugador3 con la puntuacion fianl de: " + jugador3.total);
					} else {
						JOptionPane.showMessageDialog(null,"Jugador2 y jugador3 han empatado con la puntuacion fianl de: " + jugador1.total);
					}
				} else {
					JOptionPane.showMessageDialog(null,"Jugador1 y jugador2 han empatado con la puntuacion fianl de: " + jugador1.total);
				}
				if (jugador1.total == jugador2.total && jugador1.total == jugador3.total) {
					JOptionPane.showMessageDialog(null,"Jugador1, jugador2 y jugador3 han empatado con la puntuacion fianl de: " + jugador1.total);
				}
				
			case 4:
				if (jugador1.total > jugador2.total) {
					if (jugador1.total > jugador3.total) {
						if (jugador1.total > jugador4.total) {
							JOptionPane.showMessageDialog(null,"Ha ganado jugador1 con la puntuacion fianl de: " + jugador1.total);
						} else if (jugador1.total < jugador4.total) {
							JOptionPane.showMessageDialog(null,"Ha ganado jugador4 con la puntuacion fianl de: " + jugador4.total);
						} else {
							JOptionPane.showMessageDialog(null,"Jugador1 y jugador4 han empatado con la puntuacion fianl de: " + jugador1.total);
						}
					} else if (jugador1.total < jugador3.total) {
						if (jugador3.total > jugador4.total) {
							JOptionPane.showMessageDialog(null,"Ha ganado jugador3 con la puntuacion fianl de: " + jugador3.total);
						} else if (jugador3.total < jugador4.total) {
							JOptionPane.showMessageDialog(null,"Ha ganado jugador4 con la puntuacion fianl de: " + jugador4.total);
						} else {
							JOptionPane.showMessageDialog(null,"Jugador3 y jugador4 han empatado con la puntuacion fianl de: " + jugador3.total);
					} 
				} else {
					JOptionPane.showMessageDialog(null,"Jugador1 y jugador3 han empatado con la puntuacion fianl de: " + jugador1.total);
				}
			} else if (jugador1.total < jugador2.total) {
				if (jugador2.total > jugador3.total) {
					if (jugador2.total > jugador4.total) {
						JOptionPane.showMessageDialog(null,"Ha ganado jugador2 con la puntuacion fianl de: " + jugador2.total);
					} else if (jugador2.total < jugador4.total) {
						JOptionPane.showMessageDialog(null,"Ha ganado jugador4 con la puntuacion fianl de: " + jugador4.total);
					} else {
						JOptionPane.showMessageDialog(null,"Jugador2 y jugador4 han empatado con la puntuacion fianl de: " + jugador2.total);
					}
				} else if (jugador2.total < jugador3.total) {
					if (jugador3.total > jugador4.total) {
						JOptionPane.showMessageDialog(null,"Ha ganado jugador3 con la puntuacion fianl de: " + jugador3.total);
					} else if (jugador3.total < jugador4.total) {
						JOptionPane.showMessageDialog(null,"Ha ganado jugador4 con la puntuacion fianl de: " + jugador4.total);
					} else {
						JOptionPane.showMessageDialog(null,"Jugador3 y jugador4 han empatado con la puntuacion fianl de: " + jugador3.total);
					} 
				} else {
					JOptionPane.showMessageDialog(null,"Jugador2 y jugador3 han empatado con la puntuacion fianl de: " + jugador2.total);
				}
			} else {
				JOptionPane.showMessageDialog(null,"Jugador1 y jugador2 han empatado con la puntuacion fianl de: " + jugador1.total);
			}
				
			if (jugador1.total == jugador2.total && jugador1.total == jugador3.total && jugador1.total == jugador4.total) {
				JOptionPane.showMessageDialog(null,"Jugador1, jugador2, jugador3 y jugador4 han empatado con la puntuacion fianl de: " + jugador1.total);
			} else if (jugador1.total == jugador2.total && jugador1.total == jugador3.total) {
				JOptionPane.showMessageDialog(null,"Jugador1, jugador2 y jugador3 han empatado con la puntuacion fianl de: " + jugador1.total);
			}
		}
	}
}
