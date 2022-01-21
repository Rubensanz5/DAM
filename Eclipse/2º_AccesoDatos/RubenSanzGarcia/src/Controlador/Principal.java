package Controlador;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import Modelo.Champion;
import Modelo.DAO.ChampionDAO;
import Modelo.DAO.HabilidadesDAO;
import Modelo.DAO.HechizosDAO;
import Vista.LogIn;

public class Principal {

	public static ArrayList<Champion> campeones; 
	
	public static void main(String[] args) {
		LogIn.ventana = new LogIn();
		LogIn.ventana.setVisible(true);
		
	}

	
	public static boolean crearCampeones(Champion ch){
		boolean echo = false;
		int id;
		try {
			id = ChampionDAO.añadirChamp(ch.getNombre(), Date.valueOf(ch.getFecha()), ch.getRol());
			if (id != -1) {
				HabilidadesDAO.añadirHabilid(id,ch.getH1(), ch.getH2(), ch.getH3(), ch.getH4(), ch.getH5());
				HechizosDAO.añadirHech(id, ch.getHe1(), ch.getHe2());
				ch.setIdChamp(id);
				campeones.add(ch);
				echo = true;
			}
		} catch (SQLException e) {
			echo = false;
			e.printStackTrace();
		}
		return echo;

	}
	
	public static boolean borrarCampeones(Champion ch) {
		boolean echo = false;
		try {
			Principal.campeones.remove(ch);
			int filas = ChampionDAO.borrarChamp(ch);
			if(filas == 1) {
				echo = true;
			}
		} catch (SQLException e) {
			echo = false;
			e.printStackTrace();
		}
		return echo;
	}
	
	public static boolean actualizarCampeones(Champion ch) {
		boolean echo = false;
		try {
			int filasC = ChampionDAO.actualizarChamp(ch);
			int filasH = HabilidadesDAO.actualizarHabilid(ch);
			int filasHe = HechizosDAO.actualizarHech(ch);
			
			if(filasC == 1 && filasH == 1 && filasHe == 1) {
				campeones.add(ch);
				echo = true;
			}
		} catch (SQLException e) {
			echo = false;
			e.printStackTrace();
		}
		return echo;
	}
	
	public static boolean comprobarCampos(String nombre, String h1, String h2, String h3, String h4, String h5) {
		boolean rellenos = false;
		
		if (!nombre.equals("")  & 
				!h1.equals("") & !h2.equals("") & !h3.equals("") & !h4.equals("") & !h5.equals("")) {
			rellenos = true;
		}
		
		return rellenos;
	}

	
}
