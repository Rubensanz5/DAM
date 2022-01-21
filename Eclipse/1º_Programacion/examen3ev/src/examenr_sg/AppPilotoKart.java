package examenr_sg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

import javax.swing.JOptionPane;

public class AppPilotoKart {
	public static HashSet<PilotoKart> listaPilotos = new HashSet<PilotoKart>();
	
	public static void main(String[] args) {
		try {
			Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/examen3ev", "root", "");
		//	PreparedStatement yt = con.prepareStatement(null);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM pilotos");
			while(rs.next()) {
				String nom = rs.getString("nombre");
				int[] caract = {rs.getInt("velocidad"),rs.getInt("peso"), rs.getInt("aceleracion"), rs.getInt("manejo"), rs.getInt("agarre")};
				double ganancias = rs.getDouble("ganancias");
				PilotoKart piloto = new PilotoKart(nom, caract);
				piloto.setGanancias(ganancias);
				listaPilotos.add(piloto);
			}
			
			menu(stmt);
			
			stmt.close();
			con.close();
			
		}catch (SQLException ex) {
			ex.printStackTrace();
		}
	
	}
	
	public static void menu(Statement stmt) throws SQLException{
		String[] opciones = {"Crear Piloto", "Listar Pilotos", "Eliminar Piloto", "Guardar en BD", "Salir"};
		boolean salir = false;
		do {
			int opcion = JOptionPane.showOptionDialog(null, "Que quieres hacer", "Opciones", JOptionPane.PLAIN_MESSAGE,
					JOptionPane.INFORMATION_MESSAGE, null, opciones, "Listar Pilotos");
			switch (opcion) {
			case 0:
				crear();
				break;
			case 1:
				listar();
				break;
			case 2:
				eliminar();
				break;
			case 3:
				guardarBD(stmt);
				break;
			case 4:
				salir = true;
				break;
			}
		} while (!salir);
	}
	
	
	public static void crear() {
		String nombre = JOptionPane.showInputDialog("Que nombre quieres poner al piloto");
		int velocidad = Integer.parseInt(JOptionPane.showInputDialog("Que velocidad quieres poner al piloto\n(1 - Muy baja, 2 - baja, 3 - media, 4 - alta, 5 - muy alta)"));
		int aceleraccion = Integer.parseInt(JOptionPane.showInputDialog("Que aceleraccion quieres poner al piloto\n(1 - Muy baja, 2 - baja, 3 - media, 4 - alta, 5 - muy alta)"));
		int peso = Integer.parseInt(JOptionPane.showInputDialog("Que peso quieres poner al piloto\n(1 - Muy baja, 2 - baja, 3 - media, 4 - alta, 5 - muy alta)"));
		int manejo = Integer.parseInt(JOptionPane.showInputDialog("Que manejo quieres poner al piloto\n(1 - Muy baja, 2 - baja, 3 - media, 4 - alta, 5 - muy alta)"));
		int agarre = Integer.parseInt(JOptionPane.showInputDialog("Que agarre quieres poner al piloto\n(1 - Muy baja, 2 - baja, 3 - media, 4 - alta, 5 - muy alta)"));
		double ganancias = Double.parseDouble(JOptionPane.showInputDialog("Que ganancias quieres poner al piloto (en dolares)"));
		int[] caract = {velocidad, aceleraccion,peso,manejo,agarre};
		PilotoKart piloto = new PilotoKart(nombre, caract);
		piloto.setGanancias(ganancias);
		listaPilotos.add(piloto);
		
	}
	
	public static void listar() {
		JOptionPane.showMessageDialog(null,listaPilotos);
	}
	
	public static void eliminar() {
		PilotoKart[] pilotos = new PilotoKart[listaPilotos.size()];
		pilotos = (PilotoKart[]) listaPilotos.toArray();
		
		listar();
		String nombre = JOptionPane.showInputDialog("Que piloto quieres eliminar?");
		for (PilotoKart piloto : pilotos) {
			if(nombre.equals(piloto.getPiloto())){
				listaPilotos.remove(piloto);
			}
		}
		
		
	}
	
	public static void guardarBD(Statement stmt) throws SQLException{
		stmt.executeUpdate("DELETE FROM pilotos");
		for (PilotoKart p : listaPilotos) {
			stmt.executeUpdate("INSERT INTO pilotos (nombre, velocidad, peso, aceleracion, manejo, agarre, ganancias) VALUES ('" + p.getPiloto() +"', '" + p.getCaracteristicas()[PilotoKart.VELOCIDAD] +"','" + p.getCaracteristicas()[PilotoKart.ACELERACION] +"','" +  p.getCaracteristicas()[PilotoKart.PESO] +"','" +  p.getCaracteristicas()[PilotoKart.MANEJO] +"', '" +  p.getCaracteristicas()[PilotoKart.AGARRE] +"', '" + p.getGanancias() +"');");
		}
	}

}
