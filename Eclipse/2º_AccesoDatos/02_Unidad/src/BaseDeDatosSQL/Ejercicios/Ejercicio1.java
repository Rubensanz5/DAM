package BaseDeDatosSQL.Ejercicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Ejercicio1 {
	public static void main(String[] args) {
		String connectionUrl = "jdbc:sqlserver://;database=EMPRESA";
		
		try {
			Connection conn = DriverManager.getConnection(connectionUrl,"sa","1234");
			//el nombre y salario de los empleados del departamento 110
			
			Statement sentencia = conn.createStatement();
			ResultSet resultado = sentencia.executeQuery("select nom_emple, salario from empleados where num_depto = 110");
			
			while(resultado.next()) {
				System.out.println(resultado.getString(1) + " - " +
								   resultado.getInt(2));
			}
			
			
			resultado.close();
			sentencia.close();
			conn.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
