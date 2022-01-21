package Practica_18.clasesDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Practica_18.clases.Proyecto;
import Practica_18.clases.Sede;



public class SedeDAO {

	public static void crearSede(Statement stmt, String nomSede) throws SQLException {
		stmt.executeUpdate("INSERT INTO sede (nom_sede) VALUES "
							+ "('" + nomSede + "');");
	}
	
	public static void eliminarSede(Statement stmt, Sede sedeAEliminar) throws SQLException {
		stmt.executeUpdate(
			"DELETE FROM sede WHERE id_sede = '" + sedeAEliminar.getIdSede() + "'");
	}
	
	
	public static void actualizarSede(Statement stmt, Sede sedeActualizar, String nomNuevo) throws SQLException {
		stmt.executeUpdate(
				"UPDATE sede SET nom_sede = '" + nomNuevo + "' WHERE id_sede = " + sedeActualizar.getIdSede());
	}
	
	public static ArrayList<Sede> obtenerSede(Statement stmt) throws SQLException {
		 ArrayList<Sede> sedes = new ArrayList<Sede>();

			ResultSet rs = stmt.executeQuery("SELECT * FROM sede");
			while(rs.next()) {
				int id = rs.getInt("id_sede");
				String nombre = rs.getString("nom_sede");
				Sede sede0 = new Sede(id,nombre);
				sedes.add(sede0);
				}
			return sedes;
		}
	
	public static ArrayList<Sede> obtenerSedesSinAsignar(Statement stmt, Proyecto proyect) throws SQLException {
		 ArrayList<Sede> sedes = new ArrayList<Sede>();
			ResultSet rs = stmt.executeQuery("SELECT * FROM sede WHERE id_sede NOT IN (SELECT id_sede FROM proyecto_sede WHERE id_proy = '" + proyect.getIdProy() + "')");
			while(rs.next()) {
				int id = rs.getInt("id_sede");
				String nombre = rs.getString("nom_sede");
				Sede sede0 = new Sede(id,nombre);
				sedes.add(sede0);
			}
			return sedes;
		}
}
