package BaseDeDatosSQL.Ejercicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Ejercicio4 {
	public static void main(String[] args) {
		String connectionUrl = "jdbc:sqlserver://;database=EMPRESA";
		
		try {
			Connection conn = DriverManager.getConnection(connectionUrl,"sa","1234");
			
			String depto = JOptionPane.showInputDialog("Introduce el departamento del que se quiere modificar el sueldo");
			int salario = Integer.parseInt(JOptionPane.showInputDialog("Introduce el departamento del que se quiere modificar el sueldo"));
			
			String sql = "Update empleados set salario = salario + " + salario + " where num_depto = " + depto + ";";
			
			Statement st = conn.createStatement();
			
			int valor = st.executeUpdate(sql);
			
			System.out.println("Las filas afectadas son: " + valor);
			
			st.close();
			conn.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
