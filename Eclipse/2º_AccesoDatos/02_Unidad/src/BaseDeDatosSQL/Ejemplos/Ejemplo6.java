package BaseDeDatosSQL.Ejemplos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Ejemplo6 {

	public static void main(String[] args) throws Exception {
		String connectionUrl = "jdbc:sqlserver://;database=prueba";
		
			try {
				Connection conn = DriverManager.getConnection(connectionUrl,"sa","1234");
				
				
				String nomApell = JOptionPane.showInputDialog("Introduce los apellidos y el nombre de los empleados");
				int salario = Integer.parseInt(JOptionPane.showInputDialog("Introduce el salario del empleado"));
				String fechAlta = JOptionPane.showInputDialog("Escribe la fecha de alta del empleado\nFormato aaaa/mm/dd");
				String fechNac = JOptionPane.showInputDialog("Escribe la fecha de nacimiento del empleado\nFormato aaaa/mm/dd");
				int depto = Integer.parseInt(JOptionPane.showInputDialog("Escribe el numero de departamento del empleado"));
				
				String sql = "Insert into empleados VALUES (?,?,?,?,?)";
				
				PreparedStatement sentencia = conn.prepareStatement(sql);
				sentencia.setString(1, nomApell);
				sentencia.setInt(2, salario);
				sentencia.setString(3, fechAlta);
				sentencia.setString(4, fechNac);
				sentencia.setInt(5, depto);

				int valores = sentencia.executeUpdate(sql);
				
				System.out.println("El numero de tablas afectadas son: " + valores);
				
				sentencia.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

	}

}
