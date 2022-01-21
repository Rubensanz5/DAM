package Evaluacion_03.BasesDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

import javax.swing.JOptionPane;

public class BDxmi {
	public static HashSet<String> lista = new HashSet<>();
	
	public static void main(String[] args) {
		String url = "jdbc:mariadb://localhost:3306/hola";
		try( Connection con = DriverManager.getConnection(url, "root", "");
			Statement stmt = con.createStatement()) {
			ResultSet rs = stmt.executeQuery("SELECT * FROM sede");
			while(rs.next()) {
				String nom = rs.getString("nom");
				lista.add(nom);
			}
			
			System.out.println(lista);
			
			añadirALista();
			
			System.out.println(lista);
			
			borrarBD(stmt);
			
			JOptionPane.showMessageDialog(null, "");
			for(String lis : lista) {
				ponerEnBD(stmt, lis);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		System.out.println(lista);

	}
	
	public static void añadirALista() {
		//int id = Integer.parseInt(JOptionPane.showInputDialog("nom"));
		String nom = JOptionPane.showInputDialog("nom");
		lista.add(nom);
	}
	
	public static void ponerEnBD(Statement stmt,String nombre) throws SQLException{
		stmt.executeUpdate("INSERT INTO sede (nom) VALUES ('" + nombre + "');");
		
	}
	public static void borrarBD(Statement stmt) throws SQLException{
		stmt.executeUpdate("DELETE FROM sede");
		
	}
	
}
