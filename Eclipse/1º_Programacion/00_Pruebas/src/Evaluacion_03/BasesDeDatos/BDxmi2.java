package Evaluacion_03.BasesDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

public class BDxmi2 {
	public static void main(String[] args) {
		HashSet<String> lista = new HashSet<String>();
		String url = "jdbc:mariabd://localhost:3306/hola";
		try {
			Connection con = DriverManager.getConnection(url, "root", "");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM sede");
			while(rs.next()) {
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void menu() {
		
	}
}
