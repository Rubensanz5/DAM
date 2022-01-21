package Modelo.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import Modelo.Champion;

public class HabilidadesDAO {
	public static void añadirHabilid(int id, String h1, String h2, String h3, String h4, String h5) throws SQLException {
		String insert = "INSERT INTO habilidades VALUES (?, ?, ?, ?, ?, ?)";
		PreparedStatement ps;

		ps = Conexion.getCon().prepareStatement(insert);
		ps.setInt(1, id);
		ps.setString(2, h1);
		ps.setString(3, h2);
		ps.setString(4, h3);
		ps.setString(5, h4);
		ps.setString(6, h5);
		ps.executeUpdate();
		ps.close();
	}

	public static int actualizarHabilid(Champion champ) throws SQLException {
		String update = "UPDATE habilidades SET habilidad1 = ?, habilidad2 = ?, habilidad3 = ?, habilidad4 = ?, habilidad5 = ? WHERE id = ?";
		int filas = -1;
		
		PreparedStatement ps = Conexion.getCon().prepareStatement(update);
		ps.setString(1, champ.getH1());
		ps.setString(2, champ.getH2());
		ps.setString(3, champ.getH3());
		ps.setString(4, champ.getH4());
		ps.setString(5, champ.getH5());
		ps.setInt(6, champ.getIdChamp());
		filas = ps.executeUpdate();
		ps.close();
		
		return filas;
	}

}
