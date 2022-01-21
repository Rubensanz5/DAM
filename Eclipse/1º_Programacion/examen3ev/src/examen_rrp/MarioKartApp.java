package examen_rrp;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

import javax.swing.JOptionPane;

public class MarioKartApp {
	
	private static HashSet<PilotoKart> pilotos;
	private static Connection con;
	
	public static void main(String[] args) {
		
		try {
			pilotos = new HashSet<PilotoKart>();
			con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/examen3ev", "root", "");
			
			cargarPilotos();
			
			int opcion;
			
			do {
				opcion = JOptionPane.showOptionDialog(null, "Elige una opción", "Examen 3ev",
						JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
						new String[] {"Crear piloto", "Listar pilotos", "Eliminar pilotos", "Guardar BBDD"}, null);
				
				switch (opcion) {
					case 0:
						crearPiloto();
						break;
					case 1:
						listarPilotos();
						break;
					case 2:
						eliminarPiloto();
						break;
					case 3:
						guardarBBDD();
						break;
				}
			} while (opcion != JOptionPane.CLOSED_OPTION);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JOptionPane.showMessageDialog(null, "Fin de la aplicación",
					"Examen 3ev", JOptionPane.PLAIN_MESSAGE);
		}
		
	}
	
	public static void crearPiloto() {
		
		String nombre;
		int[] caracteristicas = new int[5];
		double ganancias = 0;
		
		do {
			nombre = JOptionPane.showInputDialog(null, "Introduce el nombre del piloto", "Examen 3ev",
					JOptionPane.PLAIN_MESSAGE);
			
			if (nombre == null) {
				JOptionPane.showMessageDialog(null, "Debes introducir un nombre",
						"Examen 3ev", JOptionPane.ERROR_MESSAGE);
			}
		} while (nombre == null);
		
		for (int i = 0; i < caracteristicas.length; i++) {
			caracteristicas[i] = pedirCaracteristica(i);
		}
		
		boolean valido;
		do {
			try {
				ganancias = Double.parseDouble(JOptionPane.showInputDialog(null, "Introduce las ganancias en competiciones del piloto",
						"Examen 3ev", JOptionPane.PLAIN_MESSAGE));
				valido = true;
			} catch (NumberFormatException | NullPointerException e) {
				JOptionPane.showMessageDialog(null, "Debes introducir un número real",
						"Examen 3ev", JOptionPane.ERROR_MESSAGE);
				valido = false;
			}
		} while(!valido);
		
		PilotoKart nuevoPiloto = new PilotoKart(nombre, caracteristicas);
		nuevoPiloto.setGanancias(ganancias);
		
		if (pilotos.add(nuevoPiloto)) {
			JOptionPane.showMessageDialog(null, "Se ha creado el piloto", "Examen 3ev", JOptionPane.INFORMATION_MESSAGE);
		}
		
	}
	
	public static int pedirCaracteristica(int stat) {
		
		String caracteristica = null;
		
		switch (stat) {
			case PilotoKart.VELOCIDAD:
				caracteristica = "velocidad";
				break;
			case PilotoKart.ACELERACION:
				caracteristica = "aceleracion";
				break;
			case PilotoKart.PESO:
				caracteristica = "peso";
				break;
			case PilotoKart.AGARRE:
				caracteristica = "agarre";
				break;
			case PilotoKart.MANEJO:
				caracteristica = "manejo";
				break;
		}
		
		int valor = 0;
		
		do {
			valor = JOptionPane.showOptionDialog(null, "Selecciona el/la " + caracteristica,
					"Examen 3ev", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
					new String[] {"1 Muy Baja", "2 Baja", "3 Media", "4 Alta", "5 Muy Alta"}, null) + 1;
			
			if (valor > 5 || valor < 1) {
				JOptionPane.showMessageDialog(null, "Debes elegir una opción",
						"Examen 3ev", JOptionPane.ERROR_MESSAGE);
			}
		} while (valor > 5 || valor < 1);
		
		return valor;
		
	}
	
	public static void listarPilotos() {
		
		for (PilotoKart pilotoKart : pilotos) {
			System.out.println(pilotoKart);
		}
		
	}
	
	public static void eliminarPiloto() {
		
		PilotoKart pilotoEliminar = (PilotoKart) JOptionPane.showInputDialog(null, "Elige el piloto a eliminar",
				"Examen 3ev", JOptionPane.PLAIN_MESSAGE, null, pilotos.toArray(), null);
		
		if (pilotos.remove(pilotoEliminar)) {
			JOptionPane.showMessageDialog(null, "Se ha eliminado el piloto", "Examen 3ev", JOptionPane.INFORMATION_MESSAGE);
		}
		
	}
	
	public static void guardarBBDD() throws SQLException {
		
		PreparedStatement stmt = con.prepareStatement("INSERT INTO pilotos "
				+ "(nombre, velocidad, peso, aceleracion, manejo, agarre, ganancias) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)");
		
		stmt.executeUpdate("DELETE FROM pilotos");
		
		for (PilotoKart pilotoKart : pilotos) {
			stmt.setString(1, pilotoKart.getPiloto());
			stmt.setInt(2, pilotoKart.getCaracteristicas()[PilotoKart.VELOCIDAD]);
			stmt.setInt(3, pilotoKart.getCaracteristicas()[PilotoKart.ACELERACION]);
			stmt.setInt(4, pilotoKart.getCaracteristicas()[PilotoKart.PESO]);
			stmt.setInt(5, pilotoKart.getCaracteristicas()[PilotoKart.MANEJO]);
			stmt.setInt(6, pilotoKart.getCaracteristicas()[PilotoKart.AGARRE]);
			stmt.setDouble(7, pilotoKart.getGanancias());
			
			stmt.executeUpdate();
		}
		
		JOptionPane.showMessageDialog(null, "Se han guardado los pilotos en la base de datos",
				"Examen 3ev", JOptionPane.INFORMATION_MESSAGE);
		
	}
	
	public static void cargarPilotos() throws SQLException {
		
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM pilotos");
		
		while (rs.next()) {
			PilotoKart piloto = new PilotoKart(rs.getString("nombre"),
					new int[] {
							rs.getInt("velocidad"),
							rs.getInt("aceleracion"),
							rs.getInt("peso"),
							rs.getInt("manejo"),
							rs.getInt("agarre"),
					});
			piloto.setGanancias(rs.getDouble("ganancias"));
			
			pilotos.add(piloto);
		}
		
		rs.close();
		stmt.close();
		
	}
	
}