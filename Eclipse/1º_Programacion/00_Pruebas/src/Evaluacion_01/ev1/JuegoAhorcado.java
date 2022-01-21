package Evaluacion_01.ev1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class JuegoAhorcado {
	
	static boolean pista = true;
	static boolean letra = false;
	static int nivel_dificultad = 0;
	
	static Scanner scn = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Juego del ahrcado, desarrollado de A.David Temiño\n\n\n");
		try {
			int opcion = -1;
			
			while(true) {
				System.out.println("Bienvenido al juego del ahorcado, elige una opcion:"
						+ "\nOpcion [1]: Elegir dificultad (por defecto esta en facil)"
						+ "\nOpcion [2]: Empezar partida"
						+ "\nOpcion [3]: Tutorial"
						+ "\nOpcion [0]: Salir");
				
				do {
					opcion = scn.nextInt();
				}while(opcion < 0 || opcion > 3);
				
				switch(opcion) {
				case 0:
					System.out.println("\n\n\n Gracias por jugar, hasta pronto!");
					System.exit(0);
					break;
				case 1:
					elegirDificultad();
					break;
				case 2:
					jugar();
					break;
				case 3:
					tutorial();
					break;
				}
			}
		}catch(InputMismatchException e) {
			System.out.println("Fatal ERROR 404, seguramente introdujo una"
					+ "\nletra en vez de un numero, el programa se cerrara");
		}
		
	}
	
	private static void elegirDificultad() {
		String entrada;
		
		System.out.println("\n\nSeleccione el nivel de dificultad:\n0 = facil" 
				+ "\n1 = normal\n2 = dificil\n3 = muy dificil");
		do {
			nivel_dificultad = scn.nextInt();
		}while(nivel_dificultad < 0 || nivel_dificultad >3);
		
		System.out.println("\n\nHabilitar pistas:\nIntroduzca \"si\" o \"no\"");
		do {
			entrada = scn.nextLine();
		}while(!entrada.equalsIgnoreCase("si") && !entrada.equalsIgnoreCase("no"));
		if(entrada.equalsIgnoreCase("si")) {
			pista = true;
		}else if(entrada.equalsIgnoreCase("no")) {
			pista = false;
		}
		
		System.out.println("\n\nHabilitar letras prefijadas:\nIntroduzca \"si\" o \"no\"");
		do {
			entrada = scn.nextLine();
		}while(!entrada.equalsIgnoreCase("si") && !entrada.equalsIgnoreCase("no"));
		if(entrada.equalsIgnoreCase("si")) {
			letra = true;
		}else if(entrada.equalsIgnoreCase("no")) {
			letra = false;
		}
		
		System.out.println("\n\n");
	}
	
	private static void jugar() {
		String palabra = listaPalabras(nivel_dificultad);
		String entrada = "";
		StringBuilder hueco_modificable = new StringBuilder("");
		int contador = 5;
		int turno = 0;
		boolean suma = true;
		
		for (int i = 0; i < palabra.length(); i++) {
			hueco_modificable.append("_");
		}
		
		if(letra == true) {
			hueco_modificable = rellenarLetras(palabra, hueco_modificable);
		}
		
		while(!palabra.equalsIgnoreCase(hueco_modificable.toString()) && contador > -0) {
			turno++;
			suma = false;
			if(pista == true) {
				System.out.println(listaPistas(palabra));
				System.out.println(dibujo(contador));
				System.out.println(hueco_modificable + "\nTurno: [" + turno + "], intentos restantes: [" + contador + "]");
				System.out.println("Introduce un caracter:");
				if(turno == 1)
					entrada = scn.nextLine();
				entrada = scn.nextLine();
				
				if(entrada.equalsIgnoreCase("troll face")) {
					System.out.println("QQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQ\r\n" + 
							"QQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQ\r\n" + 
							"QQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQ\r\n" + 
							"QQQQQQQQQQQQQQQQQQQWQQQQQWWWBBBHHHHHHHHHBWWWQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQ\r\n" + 
							"QQQQQQQQQQQQQQQD!`__ssaaaaaaaaaass_ass_s____.  -~\"\"??9VWQQQQQQQQQQQQQQQQQQQ\r\n" + 
							"QQQQQQQQQQQQQP'_wmQQQWWBWV?GwwwmmWQmwwwwwgmZUVVHAqwaaaac,\"?9$QQQQQQQQQQQQQQ\r\n" + 
							"QQQQQQQQQQQW! aQWQQQQW?qw#TTSgwawwggywawwpY?T?TYTYTXmwwgZ$ma/-?4QQQQQQQQQQQ\r\n" + 
							"QQQQQQQQQQW' jQQQQWTqwDYauT9mmwwawww?WWWWQQQQQ@TT?TVTT9HQQQQQQw,-4QQQQQQQQQ\r\n" + 
							"QQQQQQQQQQ[ jQQQQQyWVw2$wWWQQQWWQWWWW7WQQQQQQQQPWWQQQWQQw7WQQQWWc)WWQQQQQQQ\r\n" + 
							"QQQQQQQQQf jQQQQQWWmWmmQWU???????9WWQmWQQQQQQQWjWQQQQQQQWQmQQQQWL 4QQQQQQQQ\r\n" + 
							"QQQQQQQP'.yQQQQQQQQQQQP\"       <wa,.!4WQQQQQQQWdWP??!\"??4WWQQQWQQc ?QWQQQQQ\r\n" + 
							"QQQQQP'_a.<aamQQQW!<yF \"!` ..  \"??$Qa \"WQQQWTVP'    \"??' =QQmWWV?46/ ?QQQQQ\r\n" + 
							"QQQP'sdyWQP?!`.-\"?46mQQQQQQT!mQQgaa. <wWQQWQaa _aawmWWQQQQQQQQQWP4a7g -WWQQ\r\n" + 
							"QQ[ j@mQP'adQQP4ga, -????\" <jQQQQQWQQQQQQQQQWW;)WQWWWW9QQP?\"`  -?QzQ7L ]QQQ\r\n" + 
							"QW jQkQ@ jWQQD'-?$QQQQQQQQQQQQQQQQQWWQWQQQWQQQc \"4QQQQa   .QP4QQQQfWkl jQQQ\r\n" + 
							"QE ]QkQk $D?`  waa \"?9WWQQQP??T?47`_aamQQQQQQWWQw,-?QWWQQQQQ`\"QQQD\\Qf(.QWQQ\r\n" + 
							"QQ,-Qm4Q/-QmQ6 \"WWQma/  \"??QQQQQQL 4W\"- -?$QQQQWP`s,awT$QQQ@  \"QW@?$:.yQQQQ\r\n" + 
							"QQm/-4wTQgQWQQ,  ?4WWk 4waac -???$waQQQQQQQQF??'<mWWWWWQW?^  ` ]6QQ' yQQQQQ\r\n" + 
							"QQQQw,-?QmWQQQQw  a,    ?QWWQQQw _.  \"????9VWaamQWV???\"  a j/  ]QQf jQQQQQQ\r\n" + 
							"QQQQQQw,\"4QQQQQQm,-$Qa     ???4F jQQQQQwc <aaas _aaaaa 4QW ]E  )WQ`=QQQQQQQ\r\n" + 
							"QQQQQQWQ/ $QQQQQQQa ?H ]Wwa,     ???9WWWh dQWWW,=QWWU?  ?!     )WQ ]QQQQQQQ\r\n" + 
							"QQQQQQQQQc-QWQQQQQW6,  QWQWQQQk <c                             jWQ ]QQQQQQQ\r\n" + 
							"QQQQQQQQQQ,\"$WQQWQQQQg,.\"?QQQQ'.mQQQmaa,.,                . .; QWQ.]QQQQQQQ\r\n" + 
							"QQQQQQQQQWQa ?$WQQWQQQQQa,.\"?( mQQQQQQW[:QQQQm[ ammF jy! j( } jQQQ(:QQQQQQQ\r\n" + 
							"QQQQQQQQQQWWma \"9gw?9gdB?QQwa, -??T$WQQ;:QQQWQ ]WWD _Qf +?! _jQQQWf QQQQQQQ\r\n" + 
							"QQQQQQQQQQQQQQQws \"Tqau?9maZ?WQmaas,,    --~-- ---  . _ssawmQQQQQQk 3QQQQWQ\r\n" + 
							"QQQQQQQQQQQQQQQQWQga,-?9mwad?1wdT9WQQQQQWVVTTYY?YTVWQQQQWWD5mQQPQQQ ]QQQQQQ\r\n" + 
							"QQQQQQQWQQQQQQQQQQQWQQwa,-??$QwadV}<wBHHVHWWBHHUWWBVTTTV5awBQQD6QQQ ]QQQQQQ\r\n" + 
							"QQQQQQQQQQQQQQQQQQQQQQWWQQga,-\"9$WQQmmwwmBUUHTTVWBWQQQQWVT?96aQWQQQ ]QQQQQQ\r\n" + 
							"QQQQQQQQQQWQQQQWQQQQQQQQQQQWQQma,-?9$QQWWQQQQQQQWmQmmmmmQWQQQQWQQW(.yQQQQQW\r\n" + 
							"QQQQQQQQQQQQQWQQQQQQWQQQQQQQQQQQQQga%,.  -??9$QQQQQQQQQQQWQQWQQV? sWQQQQQQQ\r\n" + 
							"QQQQQQQQQWQQQQQQQQQQQQQQWQQQQQQQQQQQWQQQQmywaa,;~^\"!???????!^`_saQWWQQQQQQQ\r\n" + 
							"QQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQWWWWQQQQQmwywwwwwwmQQWQQQQQQQQQQQ\r\n" + 
							"QQQQQQQWQQQWQQQQQQWQQQWQQQQQWQQQQQQQQQQQQQQQQWQQQQQWQQQWWWQQQQQQQQQQQQQQQWQ");
					entrada = scn.nextLine();
				}
				
				for (int i = 0; i < palabra.length(); i++) {
					if(entrada.equalsIgnoreCase(Character.toString(palabra.charAt(i)))) {
						hueco_modificable.replace(i, (i + 1), entrada);
						suma = true;
					}
				}
				
			}else {
				System.out.println(dibujo(contador));
				System.out.println(hueco_modificable + "\nTurno: [" + turno + "], intentos restantes: [" + contador + "]");
				System.out.println("Introduce un caracter:");
				if(turno == 1)
					entrada = scn.nextLine();
				entrada = scn.nextLine();
				
				for (int i = 0; i < palabra.length(); i++) {
					if(entrada.equalsIgnoreCase(Character.toString(palabra.charAt(i)))) {
						hueco_modificable.replace(i, (i + 1), entrada);
						suma = true;
					}
				}
			}
			
			if(!suma) {
				contador--;
			}
		}
		
		if(contador == 0) {
			System.out.println(dibujo(contador));
			System.out.println("Perdiste\n\n");
		}else {
			System.out.println("Felicidades, Ganaste en " + turno + " turnos\n\n");
		}
	}
	
	private static String dibujo(int intento) {
		String ahorcado = "";
		if(intento == 5) {
			ahorcado = " ______" + "\n |    |" + "\n |" + "\n |" + "\n |" + "\n_|_";
		}else if(intento == 4) {
			ahorcado = " ______" + "\n |    |" + "\n |    Õ" + "\n |    |" + "\n |    |" + "\n_|_";
		}else if(intento == 3) {
			ahorcado = " ______" + "\n |    |" + "\n |    Õ" + "\n |   \\|" + "\n |    |" + "\n_|_";
		}else if(intento == 2) {
			ahorcado = " ______" + "\n |    |" + "\n |    Õ" + "\n |   \\|/" + "\n |    |" + "\n_|_";
		}else if(intento == 1) {
			ahorcado = " ______" + "\n |    |" + "\n |    Õ" + "\n |   \\|/" + "\n |    |" + "\n_|_  /";
		}else if(intento == 0) {
			ahorcado = " ______" + "\n |    |" + "\n |    Õ" + "\n |   \\|/" + "\n |    |" + "\n_|_  / \\";
		}
		return ahorcado;
	}
	
	private static String listaPalabras(int dificultad) {
		String []lista = {"", "", "", "", ""};
		
		if(dificultad == 0) {
			lista[0] = "pez";
			lista[1] = "nuez";
			lista[2] = "sol";
			lista[3] = "casa";
			lista[4] = "lata";
		}else if(dificultad == 1) {
			lista[0] = "cama";
			lista[1] = "nogal";
			lista[2] = "taza";
			lista[3] = "zumo";
			lista[4] = "gorro";
		}else if(dificultad == 2) {
			lista[0] = "cafetera";
			lista[1] = "bosque";
			lista[2] = "falange";
			lista[3] = "alcohol";
			lista[4] = "papeleria";
		}else if(dificultad == 3) {
			lista[0] = "desbrozadora";
			lista[1] = "pilum";
			lista[2] = "esternocleidomastoideo";
			lista[3] = "inefable";
			lista[4] = "zangolotear";
		}
		
		return lista[(int) (Math.random()*5)];
	}
	
	private static StringBuilder rellenarLetras(String palabra, StringBuilder hueco) {
		hueco.delete(0, hueco.capacity());
		for (int i = 0; i < palabra.length(); i++) {
			if(palabra.charAt(i) == 'z' || palabra.charAt(i) == 'l' || palabra.charAt(i) == 'p' || palabra.charAt(i) == 'g' || palabra.charAt(i) == 'q') {
				hueco.append(palabra.charAt(i));
			}else {
				hueco.append("_");
			}
		}
		return hueco;
	}
	
	private static String listaPistas(String palabra) {
		String pista = "\n\n";
		
		if(palabra.equalsIgnoreCase("pez")) {
			pista += "animal acuatico";
		}else if(palabra.equalsIgnoreCase("nuez")) {
			pista += "fruto seco";
		}else if(palabra.equalsIgnoreCase("sol")) {
			pista += "astro de nuestro sistema solar";
		}else if(palabra.equalsIgnoreCase("casa")) {
			pista += "vivienda u hogar";
		}else if(palabra.equalsIgnoreCase("lata")) {
			pista += "envase metalico para conservas";
		}else if(palabra.equalsIgnoreCase("cama")) {
			pista += "lecho o catre";
		}else if(palabra.equalsIgnoreCase("nogal")) {
			pista += "arbol frutal de la familia juglandaceae";
		}else if(palabra.equalsIgnoreCase("taza")) {
			pista += "recipiente usado comunmente para el desayuno";
		}else if(palabra.equalsIgnoreCase("zumo")) {
			pista += "liquido de las hierbas, flores, frutas u otras\ncosas semejantes, que se saca al exprimirlas";
		}else if(palabra.equalsIgnoreCase("gorro")) {
			pista += "pieza redonda, de tela o de punto, para cubrir y abrigar la cabeza";
		}else if(palabra.equalsIgnoreCase("cafetera")) {
			pista += "maquina con la que se preparan infusiones, principalmente de cafe";
		}else if(palabra.equalsIgnoreCase("bosque")) {
			pista += "cumulo de arboles";
		}else if(palabra.equalsIgnoreCase("falange")) {
			pista += "tipo de hueso hubicado en la mano";
		}else if(palabra.equalsIgnoreCase("alcohol")) {
			pista += "liquido incoloro, inflamable y soluble en agua,\nque se obtiene de la fermentación de productos\nnaturales ricos en hidratos de carbono";
		}else if(palabra.equalsIgnoreCase("papeleria")) {
			pista += "tienda donde se venden objetos de escritorio";
		}else if(palabra.equalsIgnoreCase("desbrozadora")) {
			pista += "maquina utilizada en jardineria para cortar hierbas,\nzarzas o palos de bajo grosor";
		}else if(palabra.equalsIgnoreCase("pilum")) {
			pista += "arma cortante usada entre los siglos I a.c. u III d.c";
		}else if(palabra.equalsIgnoreCase("esternocleidomastoideo")) {
			pista += "musculo con la funcion de girar e inclinar la cabeza";
		}else if(palabra.equalsIgnoreCase("inefable")) {
			pista += "que no puede ser dicho o pronunciado";
		}else if(palabra.equalsIgnoreCase("zangolotear")) {
			pista += "verbo referido a algo o alguien que esta en\nconstante movimiento sin proposito o fin alfuno";
		}
		
		return pista;
	}
	
	private static void tutorial() {
		System.out.println("\n\n[TUTORIAL]"
				+ "\n\nNiveles de dificultad:"
				+ "\nCada nivel de dificultad sirve para seleccionar"
				+ "\ncuantas letras tendra la palabra a adivinar, si"
				+ "\nhabra pistas sobre que palabra es y si habra letras"
				+ "\nya establecidas, todas las partidas tendran"
				+ "\nun maximo de 5 intentos; si se establece que haya"
				+ "\nletras ya establecidas solo apareceran las siguientes"
				+ "\nletras: ['Z', 'L', 'P', 'G', 'Q'] en el caso de que"
				+ "\nla palabra a adivinar las contenga"
				+ "\n\nEl juego:"
				+ "\nAparecera por pantalla el dibujo de un ahorcado,"
				+ "\ncada error ira redibujando al personaje hasta"
				+ "\ncompletar el dibujo, si el dibujo se completa"
				+ "\nhas perdido, cada turno deberas introducir solo"
				+ "\nun caracter, por cada caracter erroneo introducido"
				+ "\nse dibujara una nueva parte del estafermo ahorcado"
				+ "\n\n");
	}
	
}
