package BaseDeDatosSQL.Ejemplos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejemplo5 {

	public static void main(String[] args) throws Exception {
		String connectionUrl = "jdbc:sqlserver://;database=prueba";
		
		//Establecemos la conexion con la BD
		Connection conn;
		
			try {
				conn = DriverManager.getConnection(connectionUrl,"sa","1234");
				
				//Fichero que queremos ejecutar
				File script = new File("ficheros/CrearbdEjemplo5.txt");
				System.out.println("Fichero a ejecutar: " + script.getName());
				
				FileReader fr = new FileReader(script);
				BufferedReader br = new BufferedReader(fr);
				
				String linea;
				StringBuilder sb = new StringBuilder();
				String saltoLinea = System.getProperty("line.separator");
				
				while((linea = br.readLine()) != null) {
					sb.append(linea);
					sb.append(saltoLinea);
				}
				String consulta = sb.toString();
				System.out.println(consulta);
				
				Statement st = conn.createStatement();
				int resultado = st.executeUpdate(consulta);
				System.out.println(resultado);
				
				br.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

	}

}
