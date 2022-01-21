package Evaluacion_03.BasesDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConexionSQLite {
	public static void main(String[] args) {
		String url = "jdbc:sqlite:R:\\1ºDAM\\Software\\SQLite\\bdRuben.db";
		
		try {
			Connection con = DriverManager.getConnection(url);
			
			PreparedStatement stat = con.prepareStatement("SELECT * FROM sede");
			ResultSet rs = stat.executeQuery();
			
			while(rs.next()) {
				int id_sede = rs.getInt(1);
				String nom_sede = rs.getString(2);
				System.out.println(id_sede + " " + nom_sede);
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
}
