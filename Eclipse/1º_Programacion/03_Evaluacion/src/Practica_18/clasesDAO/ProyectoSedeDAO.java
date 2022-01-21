package Practica_18.clasesDAO;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import Practica_18.clases.Proyecto;
import Practica_18.clases.ProyectoSede;
import Practica_18.clases.Sede;



public class ProyectoSedeDAO {
	public static void asignarProy(Statement stmt, Proyecto proyAsociado, Sede sedeAsociada ,Date fIni) throws SQLException {
		stmt.executeUpdate(
				"INSERT INTO proyecto_sede (id_proy,id_sede,f_inicio) VALUES "
				+ "('" + proyAsociado.getIdProy() + "', '" + sedeAsociada.getIdSede() + "','" + fIni + "');");
	}
	
	public static void ponerFechaFin(Statement stmt, ProyectoSede proyActualizar, Date fechFin) throws SQLException {
		stmt.executeUpdate(
				"UPDATE proyecto_sede SET f_fin = '" + fechFin + "' WHERE id_proy = " + proyActualizar.getIdProy());
	}
		
	public static ArrayList<ProyectoSede> obtenerProySede(Statement stmt) throws SQLException {
		 ArrayList<ProyectoSede> proySede = new ArrayList<ProyectoSede>();
			ResultSet rs = stmt.executeQuery("SELECT * FROM proyecto_sede");
			while(rs.next()) {
				int idP = rs.getInt("id_proy");
				int idS = rs.getInt("id_sede");
				LocalDate fIni = rs.getDate("f_inicio").toLocalDate();
				Date fFin = rs.getDate("f_fin");
				LocalDate fechFin = null;
				
				if(fFin != null) {
					fechFin = fFin.toLocalDate();
				}	
				ProyectoSede proy0 = new ProyectoSede(idP,idS, fIni, fechFin);
				proySede.add(proy0);
			}
			return proySede;
		}
	
}
