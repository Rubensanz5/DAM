package Practica_18.clasesDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Practica_18.clases.Departamento;
import Practica_18.clases.Sede;



public class DepartamentoDAO {
	
	public static void crearDepto(Statement stmt, Sede sedeAsociada, String nomDepto) throws SQLException{
		stmt.executeUpdate(
				"INSERT INTO departamento (nom_depto,id_sede) VALUES "
				+ "('" + nomDepto + "', '" + sedeAsociada.getIdSede() + "');");
	}
	
	public static void eliminarDepto(Statement stmt,Departamento deptoEliminar) throws SQLException {
		stmt.executeUpdate(
				"DELETE FROM departamento WHERE id_depto = '" + deptoEliminar.getIdDepto() + "'");
	}
	
	public static void actualizarDepartamentoNom(Statement stmt, Departamento deptoActualizar, String nomNuevo) throws SQLException {
		stmt.executeUpdate(
				"UPDATE departamento SET nom_depto = '" + nomNuevo + "' WHERE id_depto = " + deptoActualizar.getIdDepto());		
	}
	
	public static void actualizarDeptoSede(Statement stmt, Departamento deptoActualizar, Sede sedeNueva) throws SQLException {
		stmt.executeUpdate(
				"UPDATE departamento SET id_sede = '" + sedeNueva.getIdSede() + "' WHERE id_depto = " + deptoActualizar.getIdDepto());		
	}
	
	public static ArrayList<Departamento> obtenerDepto(Statement stmt) throws SQLException {
		 ArrayList<Departamento> deptos = new ArrayList<Departamento>();
			ResultSet rs = stmt.executeQuery("SELECT * FROM departamento");
			while(rs.next()) {
				int id = rs.getInt("id_depto");
				String nombre = rs.getString("nom_depto");
				int sede = rs.getInt("id_sede");
				Departamento depto0 = new Departamento(id,nombre,sede);
				deptos.add(depto0);
				}
			return deptos;
		}	
}
