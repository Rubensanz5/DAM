package Modelo.DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import Modelo.Champion;

public class ChampionDAO {
	public static int añadirChamp(String nombre, Date fecha, String rol) throws SQLException {
		String insert = "INSERT INTO campeones VALUES (?, ?, ?)";
		int clave = -1;
		
		PreparedStatement ps = Conexion.getCon().prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, nombre);
		ps.setString(2, rol);
		ps.setDate(3, fecha);
		ps.executeUpdate();
		
		ResultSet keys = ps.getGeneratedKeys();
		while (keys.next()) {
		       clave = keys.getInt(1);
		}
		ps.close();
		return clave;
	}
	
	public static int actualizarChamp(Champion champ) throws SQLException {
		
		String update = "UPDATE campeones SET nombre = ?, rol = ?, fecha = ? WHERE id = ?";

		PreparedStatement ps = Conexion.getCon().prepareStatement(update);
		ps.setString(1, champ.getNombre());
		ps.setString(2, champ.getRol());
		ps.setDate(3, Date.valueOf(champ.getFecha()));
		ps.setInt(4, champ.getIdChamp());
		int filas = ps.executeUpdate();	
		
		ps.close();
		return filas;	
		
		
	}
	
	public static int borrarChamp(Champion cham) throws SQLException {
		int filas = -1;
		String delete = "DELETE FROM campeones WHERE id = ?";
		PreparedStatement ps = Conexion.getCon().prepareStatement(delete);
		ps.setInt(1, cham.getIdChamp());
		filas = ps.executeUpdate();
		return filas;
	}
	
	public static ArrayList<Champion> listaChamp() throws SQLException {
		 ArrayList<Champion> champs = new ArrayList<Champion>();
			ResultSet rs = Conexion.getCon().createStatement().executeQuery("select c.id, c.nombre, c.rol, c.fecha, "
					+ "h.habilidad1, h.habilidad2, h.habilidad3, h.habilidad4, h.habilidad5, "
					+ "s.summoner1, s.summoner2 "
					+ "from campeones c "
					+ "inner join habilidades h on c.id = h.id "
					+ "inner join summoners s on c.id = s.id");
			while(rs.next()) {
				int idCha = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String rol = rs.getString("rol");
				Date fecha = rs.getDate("fecha");
				
				String h1 = rs.getString("habilidad1");
				String h2 = rs.getString("habilidad2");
				String h3 = rs.getString("habilidad3");
				String h4 = rs.getString("habilidad4");
				String h5 = rs.getString("habilidad5");

				String he1 = rs.getString("summoner1");
				String he2 = rs.getString("summoner2");

				
				Champion champ = new Champion(nombre, rol, fecha.toLocalDate(), h1, h2, h3, h4, h5, he1, he2);
				champ.setIdChamp(idCha);
				champs.add(champ);
				}
			return champs;
		}

}
