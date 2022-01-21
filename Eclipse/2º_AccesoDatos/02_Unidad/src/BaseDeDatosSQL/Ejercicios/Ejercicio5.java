package BaseDeDatosSQL.Ejercicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Ejercicio5 {
	
	static Connection conn;
	
	public static void main(String[] args) {
		String connectionUrl = "jdbc:sqlserver://;database=EMPRESA";
		
		try {
			conn = DriverManager.getConnection(connectionUrl,"sa","1234");
			
			int numDepto = Integer.parseInt(JOptionPane.showInputDialog("Introduce el numero de departamento"));
			
			while(!comprobarDepto(numDepto)){
				numDepto = Integer.parseInt(JOptionPane.showInputDialog("No existe ese departamento\nIntroduce el numero de departamento"));
			} 
			
			String sql = "select substring(e.nom_emple,0,CHARINDEX(',',e.nom_emple)) as 'Apellidos',e.salario, d.nom_depto as 'Departamento' "
					+ "from empleados e "
					+ "inner join departamentos d on e.num_depto = d.num_depto "
					+ "where e.num_depto = ?";
			
			String sql2 = "select count(*) as 'Numero Empleados', avg(salario) as 'Salario Medio' "
					+ "from empleados e "
					+ "where e.num_depto = ?";
			
			PreparedStatement sentencia = conn.prepareStatement(sql);
			PreparedStatement sentencia2 = conn.prepareStatement(sql2);
			
			sentencia.setInt(1, numDepto);
			sentencia2.setInt(1, numDepto);
			
			ResultSet valores = sentencia.executeQuery();
			ResultSet valores2 = sentencia2.executeQuery();
			
			JOptionPane.showMessageDialog(null,"Los apellidos, el salario y el nombre del departamento " + numDepto + " son:");
			while(valores.next()){
				JOptionPane.showMessageDialog(null, "Apellidos: " + valores.getString(1) + 
								   "\nSalario: " + valores.getDouble(2) + 
								   "\nNombre del departamento: " + valores.getString(3) + "\n");
			}
			
			JOptionPane.showMessageDialog(null,"El numero de empleados del departamento " + numDepto + " y su salario medio es: ");
			while (valores2.next()) {
				JOptionPane.showMessageDialog(null,"El numero de empleados es: " + valores2.getInt(1) + 
								   "\nEl salario medio es: " + valores2.getDouble(2));
				
			}
			
			conn.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static boolean comprobarDepto(int depto) throws SQLException {
		boolean existe = false;
		String sql = "select * from Departamentos where num_depto = ?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, depto);
		
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			existe = true;
		}
		
		return existe;
	}

}
