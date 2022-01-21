package BaseDeDatosSQL.Ejemplos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Ejemplo4 {
	public static void main(String[] args) {
		String connectionUrl = "jdbc:sqlserver://;database=EMPRESA";
		
		try {
			Connection conn = DriverManager.getConnection(connectionUrl,"sa","1234");
			System.out.println("conectado");
			
			//String sql = "select * from departamentos";
			String sql = "update departamentos set nom_depto = UPPER(nom_depto)";
			
			Statement sentencia = conn.createStatement();
			boolean valor = sentencia.execute(sql);
			
			//como se trata de una consulta devuelve true
			
			if(valor) {
				//Recuperamos las filas devueltas
				ResultSet rs = sentencia.getResultSet();
				while(rs.next()) {
					System.out.println(rs.getInt(1) + " - " + rs.getString(2) + " - " + rs.getFloat(3) + " - " + rs.getInt(4));
				}
				rs.close();
			} else {
				//si no se trata de un select
				//mostramos el num de filas afectadas
				System.out.println("Filas afectadas " + sentencia.getUpdateCount());
			}
			
			
			sentencia.close();
			conn.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
