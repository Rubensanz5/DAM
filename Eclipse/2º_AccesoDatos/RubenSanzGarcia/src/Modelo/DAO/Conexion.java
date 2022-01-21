package Modelo.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexion {
	private static Connection con;

	public static Connection getCon() {
		return con;
	}


	public static boolean abrirConexion(String user, String pass){
		boolean comprobar = false;
		try {
			String connectionUrl = "jdbc:sqlserver://;database=New_Patch_LoL";
			con = DriverManager.getConnection(connectionUrl , user, pass);
			comprobar = true;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error, Usuario o Contraseña erroneos, compruebelos\n(Compruebe si esta activa la base de datos)", "Error!",JOptionPane.ERROR_MESSAGE);
		}
		
		return comprobar;
	}

	public static void cerrarConexion() throws SQLException{
		con.close();
	}
	
	

}
