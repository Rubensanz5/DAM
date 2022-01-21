package Practica_Navidad.monopoly;

import java.util.Random;

import javax.swing.JOptionPane;

public class Tablero  { // el objeto tablero esta compuesto por objetos calles
	
	static CasillasEspeciales salida;
	static Calles marron1;
	static CasillasEspeciales suerte;
	static Calles marron2 ;
	static CasillasEspeciales cajaFuerte;
	static Calles Estacion1;
	static Calles azulClaro1;
	static CasillasEspeciales impuestos;
	static Calles azulClaro2;
	static Calles azulClaro3;
	static CasillasEspeciales cajaFuerte2;
	static Calles rosa1;
	static Calles Estacion2;
	static Calles rosa2;
	static Calles rosa3;
	static CasillasEspeciales suerte2;
	static Calles naranja1;
	static CasillasEspeciales impuestos1; 
	static Calles naranja2;
	static Calles naranja3;
	static Calles Estacion3;
	
	public Tablero () {
	
		// se da valor a los objetos calles( nombre, precio, posicion, alquiler, comprado, dueño)
		 salida = new CasillasEspeciales ("Salida", 0, 200);
		 marron1 = new Calles ("Ronda De Valencia", 60, 1, 2, false ,null);
		 suerte = new CasillasEspeciales ("Suerte", 2, 0);
		 marron2 = new Calles ("Plaza Lavapies", 60, 3, 4, false, null);
		 cajaFuerte = new CasillasEspeciales ("Caja de ahorros", 4, 0);
		 Estacion1 = new Calles("Estacion De Mediodia",100,5,25,false,null);
		 azulClaro1 = new Calles ("Glorieta Cuatro Caminos", 100, 6, 6, false, null);
		 impuestos = new CasillasEspeciales ("Impuestos", 7, -200);
		 azulClaro2 = new Calles ("Avenida Reina Victoria", 100, 8, 6, false, null);
		 azulClaro3 = new Calles ("Calle Bravo Murillo", 120, 9, 8, false, null);
		 cajaFuerte2 = new CasillasEspeciales ("Caja de ahorros", 10,0);
		 rosa1 = new Calles ("Glorieta De Bilbao", 140, 11, 10, false, null);
		 Estacion2 = new Calles("Estacion Del Norte",100,12,25,false,null);
		 rosa2 = new Calles ("Calle Alberto Aguilera", 140, 13, 10, false, null);
		 rosa3 = new Calles ("Calle Fuencarral", 160, 14, 12, false, null);
		 suerte2 = new CasillasEspeciales ("Suerte", 15);
		 naranja1 = new Calles ("Glorieta De Bilbao", 180, 16, 14, false, null);
		 naranja2 = new Calles ("Calle Alberto Aguilera", 180, 17, 14, false, null);
		 impuestos1 = new CasillasEspeciales ("Impuestos", 8, -200);
		 naranja3 = new Calles ("Calle Fuencarral", 200, 19, 16, false, null);
		 Estacion3 = new Calles("Estacion Del Sur",100,20,25,false, null);
	}
	
	public static void  casillas (int dado, int turno, Jugador jugador1, Jugador jugador2, Jugador jugador3) {
		
		String mensaje = "";
		switch (dado){ // el tablero esta compuesto por calles, cada caso se corresponde a una casilla distinta
		case 0:
			mensaje = "\n Has pasado por la salida, recibes 200M";
			CasillaDinero (Tablero.salida.pagar, turno, jugador1, jugador2, jugador3, mensaje);
			break;
		case 1:
			Comprarcalle (Tablero.marron1, turno, jugador1, jugador2, jugador3 );
			break;
		case 2:
			CartaSuerte (turno, jugador1, jugador2, jugador3 );
			break;
		case 3:
			Comprarcalle (Tablero.marron2, turno, jugador1, jugador2, jugador3 );
			break;
		case 4:
			CartaCajaFuerte(turno, jugador1, jugador2, jugador3 );
			break;
		case 5:
			Comprarcalle (Tablero.Estacion1, turno, jugador1, jugador2, jugador3 );
			break;
		case 6:
			Comprarcalle (Tablero.azulClaro1, turno, jugador1, jugador2, jugador3 );
			break;
		case 7:
			mensaje = "\n Impuesto de lujo, pagas 200M" ;
			CasillaDinero (Tablero.impuestos.pagar, turno, jugador1, jugador2, jugador3, mensaje);
			break;
		case 8:
			Comprarcalle (Tablero.azulClaro2, turno, jugador1, jugador2, jugador3 );
			break;
		case 9:
			Comprarcalle (Tablero.azulClaro3, turno, jugador1, jugador2, jugador3 );
			break;
		case 10:
			CartaCajaFuerte(turno, jugador1, jugador2, jugador3 );
			break;
		case 11:
			Comprarcalle (Tablero.rosa1, turno, jugador1, jugador2, jugador3 );
			break;
		case 12:
			Comprarcalle (Tablero.Estacion2, turno, jugador1, jugador2, jugador3 );
			break;
		case 13:
			Comprarcalle (Tablero.rosa2, turno, jugador1, jugador2, jugador3 );
			break;
		case 14:
			Comprarcalle (Tablero.rosa3, turno, jugador1, jugador2, jugador3 );
			break;
		case 15:
			CartaSuerte (turno, jugador1, jugador2, jugador3 );
			break;
		case 16:
			Comprarcalle (Tablero.naranja1, turno, jugador1, jugador2, jugador3 );
			break;
		case 17:
			Comprarcalle (Tablero.naranja2, turno, jugador1, jugador2, jugador3 );
			break;
		case 18:
			mensaje = "\n Impuesto de contribucion, pagas 200M" ;
			CasillaDinero (Tablero.impuestos1.pagar, turno, jugador1, jugador2, jugador3, mensaje);
			break;
		case 19:
			Comprarcalle (Tablero.naranja3, turno, jugador1, jugador2, jugador3 );
			break;
		case 20:
			Comprarcalle (Tablero.Estacion3, turno, jugador1, jugador2, jugador3 );
			break;
		}
	}
	
	// comprar calles (coprobar que no este comprada o que tenga dinero suficiente, si esta comprada comprueba de quien es y se le paga el alquiler)
		public static void Comprarcalle (Calles CalleComprar, int turno, Jugador jugador1,Jugador jugador2, Jugador jugador3 ) {
		
		
		if (CalleComprar.comprado == false) { // si la calle no esta comprada
			int respuesta = JOptionPane.showConfirmDialog(null, "\n ¿ Quieres comprar la calle "+ CalleComprar.nombre + " por " + CalleComprar.precio + "M ?");
			if (respuesta == JOptionPane.OK_OPTION) { // si acepta comprar
				switch (turno){
				case 1:
					if (CalleComprar.precio <=  jugador1.dinero) { //comprobamos que tenga dinero suficiente el jugador 1
						CalleComprar.dueño = jugador1; // anadimos valor a la variable dueño
						CalleComprar.comprado = true; // cambiamos a valor true la compra
						jugador1.dinero = jugador1.dinero - CalleComprar.precio; // restamos el dinero de la calle comprada
					} else if (CalleComprar.precio >  jugador1.dinero) { // si no tiene dinero suficiente
						JOptionPane.showMessageDialog(null, " No puedes comprar la calle " + CalleComprar.nombre + " ya que no tienes suficiente dinero.", "INFORMACION DE " + jugador1.nombre.toUpperCase(), JOptionPane.INFORMATION_MESSAGE ); 
						}
					break;
					
				case 2: 
					if (CalleComprar.precio <=  jugador2.dinero) {  //comprobamos que tenga dinero suficiente el jugador 2
						CalleComprar.dueño = jugador2; // anadimos valor a la variable dueño
						CalleComprar.comprado = true; // cambiamos a valor true la compra
						jugador2.dinero = jugador2.dinero - CalleComprar.precio; // restamos el dinero de la calle comprada
					} else if (CalleComprar.precio >  jugador2.dinero) { // si no tiene dinero suficiente
						JOptionPane.showMessageDialog(null, " No puedes comprar la calle " + CalleComprar.nombre + " ya que no tienes suficiente dinero.", "INFORMACION DE " + jugador2.nombre.toUpperCase(), JOptionPane.INFORMATION_MESSAGE );
					}
					break;
					
				case 3 :
					if (CalleComprar.precio <=  jugador3.dinero) { //comprobamos que tenga dinero suficiente el jugador 2
						CalleComprar.dueño = jugador3; // anadimos valor a la variable dueño
						CalleComprar.comprado = true; // cambiamos a valor true la compra
						jugador3.dinero = jugador3.dinero - CalleComprar.precio; // restamos el dinero de la calle comprada
					} else if (CalleComprar.precio >  jugador3.dinero) { // si no tiene dinero suficiente
						JOptionPane.showMessageDialog(null, " No puedes comprar la calle " + CalleComprar.nombre + " ya que no tienes suficiente dinero.", "INFORMACION DE " + jugador3.nombre.toUpperCase(), JOptionPane.INFORMATION_MESSAGE );
					}
					break;	
				}
				
			} else if (respuesta == JOptionPane.NO_OPTION) { // si no quiere comprar, fin del turno
	
			}else if (respuesta == JOptionPane.CLOSED_OPTION) { // si da a cancelar o cierra la pestaña, fin del turno
				
			}
			
		} else if ( CalleComprar.comprado == true) { // si la calle ya esta comprada 
			JOptionPane.showMessageDialog(null,  "La calle "+ CalleComprar.nombre + " ya tiene dueño, tiene que pagar a "  + CalleComprar.dueño.nombre + " " + CalleComprar.alquiler + "M", "INFORMACION de la calle " + CalleComprar.nombre, JOptionPane.INFORMATION_MESSAGE );
			
			if (CalleComprar.dueño == jugador1) { // comprueba si la calle es del jugador 1
				jugador1.dinero = jugador1.dinero + CalleComprar.alquiler; // se suma el dinero del alquiler a su dueño
			}else if (CalleComprar.dueño == jugador2) { // comprueba si la calle es del jugador 2
				jugador2.dinero = jugador2.dinero + CalleComprar.alquiler; // se suma el dinero del alquiler a su dueño
			}else if (CalleComprar.dueño == jugador3) { // comprueba si la calle es del jugador 3
				jugador3.dinero = jugador3.dinero + CalleComprar.alquiler; // se suma el dinero del alquiler a su dueño
			}
			switch (turno) { // comprueba de quien era el turno para saber quien ha caido en esa posicion y por tanto quien debe pagar
			case 1:
				jugador1.dinero = jugador1.dinero - CalleComprar.alquiler ; // se resta el dinero del alquiler
				break;
			case 2:
				jugador2.dinero = jugador2.dinero - CalleComprar.alquiler;  // se resta el dinero del alquiler
				break;
			case 3:
				jugador3.dinero = jugador3.dinero  - CalleComprar.alquiler;  // se resta el dinero del alquiler
				break;
			}
			
			
		}
		
	}
	
		// funciones de las cartas de suerte (con un numero random, se eligue aleatoriamente la carta de suerte a usar)
		public static void CartaSuerte (int turno, Jugador jugador1, Jugador jugador2, Jugador  jugador3) {
			int funcion, dinero = 0;
			String mensaje =" ";
			Random aleatorio = new Random();
			funcion = aleatorio.nextInt(8)+1; 
			switch (funcion){
			case 1:
				mensaje = "\n La banca te paga 50M de intereses";
				dinero = 50;
				break;
			case 2:
				mensaje = "\n Pagas 150M por material escolar";
				dinero = -150;
				break;
			case 3:
				mensaje = "\n Recibes rescate por el seguro de tus edificios cobra 150M";
				dinero = 150;
				break;
			case 4:
				mensaje = "\n Es tu cumpleaños recibes 10M";
				dinero = 10;
				break;
			case 5:
				mensaje = "\n Has ganado un concurso de crucigamas. Cobras 100M";
				dinero = 100;
				break;
			case 6:
				mensaje = "\n Multa por exceso de velocidad. 50M";
				dinero = -50;
				break;
			case 7:
				mensaje = "\n Por gastos de hospital, pagas 100M";
				dinero = -100;
				break;
			case 8:
				mensaje = "\n Decides invitar a tus amigos a una cena, pagas 50";
				dinero = -50;
				break;
			}
			switch (turno) { // Se comprueba de quien es el turno para saber a quien aplicar la carta
			case 1:
				JOptionPane.showMessageDialog(null,  "Has caido en la casilla Suerte, coges una carta de suerte \n CARTA DE SUERTE:" + mensaje, "INFORMACION DE " + jugador1.nombre.toUpperCase(), JOptionPane.INFORMATION_MESSAGE  );
				jugador1.dinero = jugador1.dinero + dinero;
				break;
			case 2:
				JOptionPane.showMessageDialog(null,  "Has caido en la casilla Suerte, coges una carta de suerte \n CARTA DE SUERTE:" + mensaje, "INFORMACION DE " + jugador2.nombre.toUpperCase(), JOptionPane.INFORMATION_MESSAGE  );
				jugador2.dinero = jugador2.dinero + dinero;
				break;
			case 3:
				JOptionPane.showMessageDialog(null,  "Has caido en la casilla Suerte, coges una carta de suerte \n CARTA DE SUERTE:" + mensaje, "INFORMACION DE " + jugador3.nombre.toUpperCase(), JOptionPane.INFORMATION_MESSAGE  );
				jugador3.dinero = jugador3.dinero + dinero;
				break;
			}
			
		}
		
	// funciones de las cartas caja fuerte (con un numero random, se eligue aleatoriamente la carta de caja fuerte a usar)
		public static void CartaCajaFuerte (int turno, Jugador jugador1, Jugador jugador2, Jugador  jugador3) {
			int funcion, dinero = 0;
			String mensaje =" ";
			Random aleatorio = new Random();
			funcion = aleatorio.nextInt(8)+1; 
			switch (funcion){
			case 1:
				mensaje = "\n La venta de tus acciones te producen 50M";
				dinero = 50;
				break;
			case 2:
				mensaje = "\n Paga tu poliza de seguro 150M" ;
				dinero = -150;
				break;
			case 3:
				mensaje = "\n Paga una multa de 10M o bien saca una carta de suerte";
				dinero = -10;
				break;
			case 4:
				mensaje = "\n recibes 50M por cuidar a tus sobrinos" ;
				dinero = 10;
				break;
			case 5:
				mensaje = "\n cobras una herencia 100M";
				dinero = 100;
				break;
			case 6:
				mensaje = "\n Vas a la peluqueria, pagas 50M";
				dinero = -50;
				break;
			case 7:
				mensaje = "\n planeas un viaje, pagas 100M";
				dinero = -100;
				break;
			case 8:
				mensaje = "\n Decides comprarte un coche, pagas 50M";
				dinero = -50;
				break;
			}
			switch (turno) { // Se comprueba de quien es el turno para saber a quien aplicar la carta
			case 1:
				JOptionPane.showMessageDialog(null,  "Has caido en la casilla Suerte, coges una carta de caja fuerte \n CARTA DE CAJA FUERTE:" + mensaje, "INFORMACION DE " + jugador1.nombre.toUpperCase(),JOptionPane.INFORMATION_MESSAGE  );
				jugador1.dinero = jugador1.dinero + dinero;
				break;
			case 2:
				JOptionPane.showMessageDialog(null,  "Has caido en la casilla Suerte, coges una carta de caja fuerte \n CARTA DE CAJA FUERTE:" + mensaje, "INFORMACION DE " + jugador2.nombre.toUpperCase(), JOptionPane.INFORMATION_MESSAGE  );
				jugador2.dinero = jugador2.dinero + dinero;
				break;
			case 3:
				JOptionPane.showMessageDialog(null,  "Has caido en la casilla Suerte, coges una carta de caja fuerte \n CARTA DE CAJA FUERTE:" + mensaje, "INFORMACION DE " + jugador3.nombre.toUpperCase(), JOptionPane.INFORMATION_MESSAGE  );
				jugador3.dinero = jugador3.dinero + dinero;
				break;
			}
		}
	
	// funciones de la casilla de salida o las dos de impuestos
		public static void CasillaDinero (int pagar, int turno, Jugador jugador1, Jugador jugador2, Jugador jugador3, String mensaje) {
			
			switch (turno) { // Se comprueba de quien es el turno para saber a quien aplicar la casilla
			case 1:
				JOptionPane.showMessageDialog(null,   mensaje, "INFORMACION DE " + jugador1.nombre.toUpperCase(), JOptionPane.INFORMATION_MESSAGE );
				jugador1.dinero = jugador1.dinero + pagar;
				break;
			case 2:
				JOptionPane.showMessageDialog(null,  mensaje, "INFORMACION DE " + jugador2.nombre.toUpperCase(), JOptionPane.INFORMATION_MESSAGE  );
				jugador2.dinero = jugador2.dinero + pagar;
				break;
			case 3:
				JOptionPane.showMessageDialog(null, mensaje, "INFORMACION DE" + jugador3.nombre.toUpperCase(), JOptionPane.INFORMATION_MESSAGE  );
				jugador3.dinero = jugador3.dinero + pagar;
				break;
			}
		}

}
