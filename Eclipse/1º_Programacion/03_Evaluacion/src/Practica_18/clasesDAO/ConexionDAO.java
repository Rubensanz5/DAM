package Practica_18.clasesDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionDAO {
	
	private static Connection con;
	private static Statement stmt;

	public static Statement abrirConexion() throws SQLException{
		//conexion bd
		String url = "jdbc:mariadb://localhost:3306/";
		con = DriverManager.getConnection(url , "root", "");
		stmt = con.createStatement();
		return stmt;
	}
	
	public static void crearBD(Statement stmt) throws SQLException{
		//creacion de tabla en bd existente
		stmt.execute("CREATE DATABASE IF NOT EXISTS practica18");
		stmt.execute("USE practica18");
	}
	
	public static void crearTablas(Statement stmt)  throws SQLException{
		//creacion de tabla en bd existente
		stmt.execute("CREATE TABLE IF NOT EXISTS SEDE (id_sede INT(11) NOT NULL AUTO_INCREMENT,nom_sede VARCHAR(20), PRIMARY KEY(id_sede));");
		stmt.execute("CREATE TABLE IF NOT EXISTS DEPARTAMENTO (id_depto INT(11) NOT NULL AUTO_INCREMENT, nom_depto VARCHAR(32),id_sede INT(11) NOT NULL ,PRIMARY KEY(id_depto), FOREIGN KEY (id_sede) REFERENCES sede (id_sede) ON DELETE CASCADE);");
		stmt.execute("CREATE TABLE IF NOT EXISTS EMPLEADO (dni VARCHAR(9) NOT NULL, nom_emp VARCHAR(40), id_depto INT(11) NOT NULL, PRIMARY KEY(dni),FOREIGN KEY(id_depto) REFERENCES departamento (id_depto) ON DELETE CASCADE);");
		stmt.execute("CREATE TABLE IF NOT EXISTS EMPLEADO_DATOS_PROF (dni VARCHAR(9) NOT NULL, categoria VARCHAR(2) NOT NULL, sueldo_bruto_anual DECIMAL(8,2), PRIMARY KEY(dni),FOREIGN KEY(dni) REFERENCES empleado (dni) ON DELETE CASCADE ON UPDATE CASCADE);");
		stmt.execute("CREATE TABLE IF NOT EXISTS PROYECTO (id_proy INT(11) NOT NULL AUTO_INCREMENT,nom_proy VARCHAR(20),f_inicio DATE, f_fin DATE ,PRIMARY KEY(id_proy));");
		stmt.execute("CREATE TABLE IF NOT EXISTS PROYECTO_SEDE (id_proy INT(11) NOT NULL, id_sede INT(11) NOT NULL, f_inicio DATE, f_fin DATE ,PRIMARY KEY(id_proy,id_sede), FOREIGN KEY(id_proy) REFERENCES proyecto (id_proy) ON DELETE CASCADE ON UPDATE CASCADE, FOREIGN KEY(id_sede) REFERENCES sede (id_sede) ON DELETE CASCADE ON UPDATE CASCADE);");
	}
	public static void cerrarConexion(Statement stmt) throws SQLException{
		stmt.close();
		con.close();
	}
	
	
	
}
