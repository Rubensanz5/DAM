package BaseDeDatosSQL.Ejemplos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class Ejemplo8 {

	public static void main(String[] args) {
		String connectionUrl = "jdbc:sqlserver://;database=EMPRESA";
		
			try {
				Connection conn = DriverManager.getConnection(connectionUrl,"sa","1234");
				
				
				String sql = "{call InsertarDeptos(?,?,?)}";
				CallableStatement cs = conn.prepareCall(sql);
				
				cs.setString(1, "Infor");
				cs.setFloat(2, 1000);
				cs.setInt(3, 10);
				
				//Ejecutamos el procedemiento alamacenado
				cs.execute();
				System.out.println("Se ha insertado el nuevo depto");
				
				cs.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

	}

}
