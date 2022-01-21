package BaseDeDatosSQL.Ejemplos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conexion {

	public static void main(String[] args) {
		String connectionUrl = "jdbc:sqlserver://;database=EMPRESA";
		
		try {
			Connection conn = DriverManager.getConnection(connectionUrl,"sa","1234");
			System.out.println("conectado");
			
			Statement sentencia = conn.createStatement();
			ResultSet resultado = sentencia.executeQuery("select * from departamentos");
			
			while(resultado.next()) {
				System.out.println(resultado.getInt(1) + " - " +
								   resultado.getString(2) + " - " +
								   resultado.getFloat(3) + " - " +
								   resultado.getInt(4));
			}
			
			
			//el nombre y salario de los empleados del departamento 10
			
			
			
			
			
			
			resultado.close();
			sentencia.close();
			conn.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
