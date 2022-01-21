package Ejemplos;

import java.util.ArrayList;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;

public class AppJugadores {

	public static void main(String[] args) {
		Jugadores j1 = new Jugadores("Jaime", "Atletismo", "Burgos", 27, "España");
		Jugadores j2 = new Jugadores("Sara", "Boleiboll", "Burgos", 20, "Colombia");
		Jugadores j3 = new Jugadores("Javi", "PelotaMano", "Navarra", 23, "Rusia");
		Jugadores j4 = new Jugadores("Dani", "PelotaMano", "Burgos", 26, "España");
		Jugadores j5 = new Jugadores("Ruben", "Fronton", "Burgos", 23, "Japon");

		
		ODB odb = ODBFactory.open("equipos.db");
		
		ArrayList<Jugadores> jugadores = new ArrayList<Jugadores>();
		jugadores.add(j1);
		jugadores.add(j2);
		jugadores.add(j3);
		jugadores.add(j4);
		jugadores.add(j5);
		
		jugadores.forEach(odb::store);
		
		odb.close();
	}

}
