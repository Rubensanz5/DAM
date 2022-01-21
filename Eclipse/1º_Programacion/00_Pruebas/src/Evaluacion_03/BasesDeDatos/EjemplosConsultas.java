package Evaluacion_03.BasesDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

import Evaluacion_03.PilotoKart;

public class EjemplosConsultas {
	public static HashSet<PilotoKart> pilotos = new HashSet<PilotoKart>();
	public static void main(String[] args) {
		String url = "jdbc:mariadb://localhost:3306/mariokart";
		try(
			Connection con = DriverManager.getConnection(url , "root", "");
			Statement stmt = con.createStatement(); 
			ResultSet rs = stmt.executeQuery("SELECT * FROM CLIENTES"); 
			ResultSet rs1 = stmt.executeQuery("SELECT * FROM piloto")) {
			int i = 1;
			while(rs.next()) {
				System.out.println("[" + (i++) + "]");
				System.out.println("DNI " + rs.getString("DNI"));
				System.out.println("Apellidos " + rs.getString("APELLIDOS"));
				System.out.println("CP " + rs.getString("CP"));
			}
			
			
			int j = 1;
			while(rs1.next()) {
				int[] carac = {rs1.getInt("Velocidad"), rs1.getInt("Aceleracion"), rs1.getInt("Peso"), rs1.getInt("Manejo"), rs1.getInt("Agarre")};			
				String nombre = rs1.getString("Nombre");
				String imagen = rs1.getString("Imagen");
				PilotoKart piloto0 = new PilotoKart(nombre,imagen,carac);
				pilotos.add(piloto0);
				
				System.out.println("[" + (j++) + "]");
				System.out.println("Nombre " + piloto0.getPiloto());
				System.out.println("Imagen " + piloto0.getImagen());
				System.out.println("Velocidad " + piloto0.getCaracteristicas()[PilotoKart.VELOCIDAD]);
				System.out.println("Aceleracion " + piloto0.getCaracteristicas()[PilotoKart.ACELERACION]);
				System.out.println("Peso " + piloto0.getCaracteristicas()[PilotoKart.PESO]);
				System.out.println("Manejo " + piloto0.getCaracteristicas()[PilotoKart.MANEJO]);
				System.out.println("Agarre " + piloto0.getCaracteristicas()[PilotoKart.AGARRE]);
				System.out.println("Seleccionado " + piloto0.isSeleccionado());
		
			}
	
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

}
