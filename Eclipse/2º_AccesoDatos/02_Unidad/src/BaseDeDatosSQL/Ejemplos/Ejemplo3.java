package BaseDeDatosSQL.Ejemplos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class Ejemplo3 {
	public static void main(String[] args) {
		String connectionUrl = "jdbc:sqlserver://;database=EMPRESA";
		
		try {
			Connection conn = DriverManager.getConnection(connectionUrl,"sa","1234");
			
			Statement sentencia = conn.createStatement();
			ResultSet rs = sentencia.executeQuery("select * from Departamentos");
			
			ResultSetMetaData rsmd = rs.getMetaData();
			
			//Obtener el numero de columnas obtenidos por la consulta
			int numColum = rsmd.getColumnCount();
			System.out.println("Número de columnas recuperadas: " + numColum);
			
			//Info sobre las columnas recuperadas
			for (int i = 1; i <= numColum; i++) {
				System.out.println("Columna: " + i);
				System.out.println("Nombre: " + rsmd.getColumnName(i));
				System.out.println("Tipo: " + rsmd.getColumnTypeName(i));
				
				//Si puede tener nulos o no
				String nula;
				
				if(rsmd.isNullable(i) == 0) {
					nula = "NO";
				} else {
					nula = "SI";
				}
				
				System.out.println("Puede ser nula: " + nula);
				System.out.println("------------------------");
				
			}
			
			rs.close();
			sentencia.close();
			conn.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
