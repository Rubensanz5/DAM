package BaseDeDatosSQL.Ejercicios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



public class Ejercicio6 {
	static Scanner sc = new Scanner(System.in);
	static Connection conn;
	static File script;
	
	public static void main(String[] args) {
		String connectionUrl = "jdbc:sqlserver://;database=pruebas";
		
		try {
			conn = DriverManager.getConnection(connectionUrl,"sa","1234");
			
			script = new File("ficheros/crearTablas.sql");
			insertarDatos(script);
			
			script = new File("ficheros/valores.sql");
			insertarDatos(script);
			
			empleMaxSalario();
			
			insertarNuevoEmple(); 
			
			modificarEmple();
			
			conn.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


	private static void modificarEmple() throws SQLException {
		System.out.println("Introduce el numero de empleado del empleado a modificar:");
		int numEmple = pedirNum(sc);
		
		while(!comprobarEmple(numEmple)){
			System.out.println("No existe ese empleado, introduce otro:");
			numEmple = pedirNum(sc);
		}
		
		double salario;
		do {
			System.out.println("Introduce el salario del empleado a insetar (Debe ser mayor que 0):");
			salario = pedirNum(sc);
		} while(salario > 0);
		
		String sql = "update empleados set salario = ? where emp_no = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setDouble(1, salario);
		ps.setInt(2, numEmple);
		
		int filas = ps.executeUpdate();
		
		System.out.println("Las filas afectadas son:" + filas);
	}


	private static void insertarNuevoEmple() throws SQLException {
		System.out.println("Introduce el Apellido del empleado a insetar:");
		String apellido = sc.nextLine();
		
		System.out.println("Introduce el oficio del empleado a insetar:");
		String oficio = sc.nextLine();
		
		System.out.println("Introduce el numero de director del empleado a insetar:");
		int director = pedirNum(sc);
		
		System.out.println("Introduce la fecha de alta del empleado a insetar:\nFormato dd/mm/aaaa");
		String fechaAlta = sc.nextLine();
		
		double salario;
		do {
			System.out.println("Introduce el salario del empleado a insetar (Debe ser mayor que 0):");
			salario = pedirNum(sc);
		} while(salario > 0);
			
		System.out.println("Introduce la comision del empleado a insetar:");
		int comision = pedirNum(sc);
		
		System.out.println("Introduce el numero de departamento al que pertenece de empleado a insetar:");
		int numDepto = pedirNum(sc);
		
		while(!comprobarDepto(numDepto)){
			System.out.println("No existe ese departamento, introduce otro:");
			numDepto = pedirNum(sc);
		}
		
		String sql = "insert into empleados values (?,?,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, apellido);
		ps.setString(2, oficio);
		ps.setInt(3, director);
		ps.setString(4, fechaAlta);
		ps.setDouble(5, salario);
		ps.setInt(6, comision);
		ps.setInt(7, numDepto);
		
		int filas = ps.executeUpdate();
		System.out.println("Las filas afectadas son: " + filas);
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
	
	public static boolean comprobarEmple(int numEmple) throws SQLException {
		boolean existe = false;
		String sql = "select * from empleados where num_depto = ?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, numEmple);
		
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			existe = true;
		}
		
		return existe;
	}
	
	private static void empleMaxSalario() throws SQLException {
		String sql = "select salario, apellido from empleados where salario = (select max(salario) from empleados)";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			System.out.println("Salario: " + rs.getFloat(1) + "\nApellido: " + rs.getString(2));
		}
	}
	

	public static void insertarDatos(File scriptFile) throws IOException, SQLException {
		
		BufferedReader br = new BufferedReader(new FileReader(scriptFile));
		
		String linea;
		StringBuilder sb = new StringBuilder();
		String saltoLinea = System.getProperty("line.separator");
		
		while((linea = br.readLine()) != null) {
			sb.append(linea);
			sb.append(saltoLinea);
		}
		String consulta = sb.toString();
		
		Statement st = conn.createStatement();
		st.executeUpdate(consulta);
		
		br.close();
	}
	
	public static int pedirNum(Scanner sc) {
		int num = -1;
		do {
			if(sc.hasNextInt()) {
				num = sc.nextInt();
				sc.nextLine();
			} else {
				sc.nextLine();
				num = -1;
			}
		} while (num < 0);
		return num;
	}

}
