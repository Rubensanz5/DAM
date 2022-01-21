package Practica_18.clasesDAO;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import Practica_18.clases.Proyecto;


public class ProyectoDAO {
	//INSERT INTO `proyecto` (`id_proy`, `nom_proy`, `f_inicio`, `f_fin`) VALUES (NULL, 'ddffd', '2021-05-11', NULL);
	public static void crearProy(Statement stmt, String nomProy, Date fIni) throws SQLException {
		stmt.executeUpdate(
				"INSERT INTO proyecto (nom_proy, f_inicio) VALUES "
				+ "('" + nomProy + "','" + fIni + "');");
	}
	
	public static void eliminarProy(Statement stmt, Proyecto proyAEliminar) throws SQLException {
		stmt.executeUpdate(
				"DELETE FROM proyecto WHERE id_proy = '" + proyAEliminar.getIdProy() + "'");
	}
	
	public static void actualizarNomProy(Statement stmt, Proyecto proyActualizar, String nomNuevo) throws SQLException {
		stmt.executeUpdate(
				"UPDATE proyecto SET nom_proy = '" + nomNuevo + "' WHERE id_proy = " + proyActualizar.getIdProy());
	}
	
	public static void actualizarFechaProy(Statement stmt, Proyecto proyActualizar, Date fechFin) throws SQLException {
		stmt.executeUpdate(
				"UPDATE proyecto SET f_fin = '" + fechFin + "' WHERE id_proy = " + proyActualizar.getIdProy());
	}
	
	
	public static ArrayList<Proyecto> obtenerProy(Statement stmt) throws SQLException {
	 ArrayList<Proyecto> proyects = new ArrayList<Proyecto>();
		ResultSet rs = stmt.executeQuery("SELECT * FROM proyecto");
		while(rs.next()) {
			int id = rs.getInt("id_proy");
			String nombre = rs.getString("nom_proy");
			LocalDate fIni = rs.getDate("f_inicio").toLocalDate();
			Date fFin = rs.getDate("f_fin");
			LocalDate fechFin = null;
			
			if(fFin != null) {
				fechFin = fFin.toLocalDate();
			}
			
			Proyecto proy0 = new Proyecto(id,nombre, fIni, fechFin);
			proyects.add(proy0);
		}
		return proyects;
	}
	
}
