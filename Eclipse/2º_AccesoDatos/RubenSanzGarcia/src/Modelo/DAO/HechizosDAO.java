package Modelo.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import Modelo.Champion;

public class HechizosDAO {
	public static void añadirHech(int id, String h1, String h2) throws SQLException {
		String insert = "INSERT INTO summoners VALUES (?, ?, ?)";
		PreparedStatement ps;

		ps = Conexion.getCon().prepareStatement(insert);
		ps.setInt(1, id);
		ps.setString(2, h1);
		ps.setString(3, h2);
		ps.executeUpdate();
		ps.close();
	}

	public static int actualizarHech(Champion champ) throws SQLException {
		String update = "UPDATE summoners SET summoner1 = ?, summoner2 = ? WHERE id = ?";
		int filas = -1;
		
		PreparedStatement ps = Conexion.getCon().prepareStatement(update);
		ps.setString(1, champ.getHe1());
		ps.setString(2, champ.getHe2());
		ps.setInt(3, champ.getIdChamp());
		filas = ps.executeUpdate();
		return filas;

	}

}
