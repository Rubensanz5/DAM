package BaseDeDatosSQL.Ejercicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Ejercicio2 {
	public static void main(String[] args) {
		String connectionUrl = "jdbc:sqlserver://;database=EMPRESA";
		
		try {
			Connection conn = DriverManager.getConnection(connectionUrl,"sa","1234");
			//el nombre y salario de los empleados del departamento 110
			
			Statement sentencia = conn.createStatement();
//			ResultSet resultado = sentencia.executeQuery(
//					  "select top(1) e.nom_emple, e.salario, d.nom_depto "
//					+ "from empleados e "
//					+ "inner join departamentos d on d.num_depto = e.num_depto "
//					+ "order by e.salario desc");
					
			ResultSet resultado = sentencia.executeQuery(
					  "select e.nom_emple, e.salario, d.nom_depto "
					+ "from empleados e "
					+ "inner join departamentos d on d.num_depto = e.num_depto "
					+ "where e.salario = (select MAX(salario) from empleados)");
					
								
			resultado.next();
			System.out.println(resultado.getString(1) + " - " + resultado.getDouble(2) + " - " + resultado.getString(3));
			
			
			
			resultado.close();
			sentencia.close();
			conn.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
