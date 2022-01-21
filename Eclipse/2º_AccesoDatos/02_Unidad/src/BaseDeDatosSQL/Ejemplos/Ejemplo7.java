package BaseDeDatosSQL.Ejemplos;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Ejemplo7 {

	public static void main(String[] args) throws Exception {
		String connectionUrl = "jdbc:sqlserver://;database=EMPRESA";
		
			try {
				Connection conn = DriverManager.getConnection(connectionUrl,"sa","1234");
				
				int depto = Integer.parseInt(JOptionPane.showInputDialog("Introduce el numero departamento del que se quiere modificar el sueldo"));
				int salario = Integer.parseInt(JOptionPane.showInputDialog("Introduce salario a sumar"));
				
				String sql = "Update empleados set salario = salario + ? where num_depto = ?";
				
				PreparedStatement st = conn.prepareStatement(sql);
				st.setInt(1, salario);
				st.setInt(2, depto);
				
				int valor = st.executeUpdate();
				
				System.out.println("Las filas afectadas son: " + valor);
				
				st.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

	}

}
