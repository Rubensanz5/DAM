package BaseDeDatosSQL.Ejercicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Ejercicio3 {
	public static void main(String[] args) {
		String connectionUrl = "jdbc:sqlserver://;database=EMPRESA";
		
		try {
			Connection conn = DriverManager.getConnection(connectionUrl,"sa","1234");
			
			
			String nomApell = JOptionPane.showInputDialog("Introduce los apellidos y el nombre de los empleados");
			int salario = Integer.parseInt(JOptionPane.showInputDialog("Introduce el salario del empleado"));
			String fechAlta = JOptionPane.showInputDialog("Escribe la fecha de alta del empleado\nFormato aaaa/mm/dd");
			String fechNac = JOptionPane.showInputDialog("Escribe la fecha de nacimiento del empleado\nFormato aaaa/mm/dd");
			int depto = Integer.parseInt(JOptionPane.showInputDialog("Escribe el numero de departamento del empleado"));
			
			String sql = "Insert into empleados VALUES ('" + nomApell + "'," + salario +",'" + fechAlta +"','" + fechNac +"'," + depto +" )";
			Statement sentencia = conn.createStatement();
			
			int valores = sentencia.executeUpdate(sql);
			
			System.out.println("El numero de tablas afectadas son:" + valores);
			
			sentencia.close();
			conn.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
