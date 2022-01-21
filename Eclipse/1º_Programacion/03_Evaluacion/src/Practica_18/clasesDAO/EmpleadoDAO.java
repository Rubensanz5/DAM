package Practica_18.clasesDAO;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Practica_18.clases.Departamento;
import Practica_18.clases.Empleado;



public class EmpleadoDAO {

	public static void crearEmp(Statement stmt, Departamento deptoAsociado, String nomEmp, String dni, BigDecimal sueldo, String categoria) throws SQLException{
		stmt.executeUpdate(
			"INSERT INTO empleado (dni,nom_emp,id_depto) VALUES "
			+ "('" + dni + "','" + nomEmp + "', '" + deptoAsociado.getIdDepto() + "');");
		crearEmpDatosProf(stmt, sueldo, categoria, dni);
	}
	
	private static void crearEmpDatosProf(Statement stmt, BigDecimal sueldo, String categoria, String dni) throws SQLException{
		stmt.executeUpdate(
				"INSERT INTO empleado_datos_prof (dni,categoria,sueldo_bruto_anual) VALUES "
				+ "('" + dni + "','" + categoria + "', '" + sueldo + "');");
	}
	
	public static void eliminarDepto(Statement stmt,Empleado empEliminar) throws SQLException {
		stmt.executeUpdate(
				"DELETE FROM empleado WHERE dni = '" + empEliminar.getDni() + "'");
	}
	
	public static void actualizarEmpleadoNom(Statement stmt, Empleado empActualizar, String nomNuevo) throws SQLException {
		stmt.executeUpdate(
				"UPDATE empleado SET nom_emp = '" + nomNuevo + "' WHERE dni = '" + empActualizar.getDni() + "'");
	}
	
	public static void actualizarEmpleadoDepartamento(Statement stmt, Empleado empActualizar, Departamento deptoNuevo) throws SQLException {
		stmt.executeUpdate(
				"UPDATE empleado SET id_depto = '" + deptoNuevo.getIdDepto() + "' WHERE dni = '" + empActualizar.getDni() + "'");
	}
	
	public static void actualizarEmpleadoCategoria(Statement stmt, Empleado empActualizar, String categoria) throws SQLException {
		stmt.executeUpdate(
				"UPDATE empleado_datos_prof SET categoria = '" + categoria + "' WHERE dni = '" + empActualizar.getDni() + "'");
	}
	
	public static void actualizarEmpleadoSueldo(Statement stmt, Empleado empActualizar, BigDecimal sueldo) throws SQLException {
		stmt.executeUpdate(
				"UPDATE empleado_datos_prof SET sueldo_bruto_anual = '" + sueldo + "' WHERE dni = '" + empActualizar.getDni() + "'");
	}
	
	public static ArrayList<Empleado> obtenerEmp(Statement stmt) throws SQLException {
		 ArrayList<Empleado> emps = new ArrayList<Empleado>();
			ResultSet rs = stmt.executeQuery("SELECT * FROM empleado");
			ResultSet rs1 = stmt.executeQuery("SELECT * FROM empleado_datos_prof");
			while(rs.next() && rs1.next()) {
				String dni = rs.getString("dni");
				String nombre = rs.getString("nom_emp");
				String categoria = rs1.getString("categoria");
				BigDecimal sueldo = rs1.getBigDecimal("sueldo_bruto_anual");
				int depto = rs.getInt("id_depto");
				Empleado empl0 = new Empleado(dni,nombre,categoria,sueldo,depto);
				emps.add(empl0);
				}
			return emps;
		}
}
