package Evaluacion_03.BasesDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EjemplosConexionBD {
	public static void main(String[] args) {
		try {
			//conexion bd
			String url = "jdbc:mariadb://localhost:3306/mariokart";
			Connection con = DriverManager.getConnection(url , "root", "");
			Statement stmt = con.createStatement();
			//creacion de tabla en bd existente
			stmt.execute("DROP TABLE CLIENTES");
			stmt.execute("CREATE TABLE CLIENTES (DNI CHAR(9) NOT NULL, APELLIDOS VARCHAR(32) NOT NULL, CP CHAR(5), PRIMARY KEY(DNI))");
			
			// introducion de datos en la tabla
			int nFilCli = stmt.executeUpdate(
					"INSERT INTO CLIENTES (DNI,APELLIDOS,CP) VALUES "
					+ "('45687531G','NADALES','44126'),"
					+ "('48754158H','HOJAS', null),"
					+ "('45213654S','SAMPER','29730'),"
					+ "('45876321F','LAMIQUIZ', null);");
			
			System.out.println(nFilCli + " Filas insertadas.");
			int nFilPiloto = stmt.executeUpdate(
					"INSERT INTO piloto (Nombre, Imagen, Velocidad, Aceleracion, Peso, Manejo, Agarre, Seleccionado) VALUES"
					+ "('Mario','url',5,4,3,2,1,'0'),"
					+ "('Luigi', 'url',1,2,3,4,5,'0'),"
					+ "('Huesitos', 'url',5,5,5,5,5,'0'),"
					+ "('Peach', 'url',3,2,3,2,1,'0');");
			
			System.out.println(nFilPiloto + " Filas insertadas.");
			
			stmt.close();
			con.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}
