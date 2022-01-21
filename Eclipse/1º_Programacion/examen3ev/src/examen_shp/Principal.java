package examen_shp;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Iterator;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		String url="jdbc:mariadb://localhost:3306/examen3ev";

		HashSet<PilotoKart> lista = new HashSet<PilotoKart>();
		try {
			Connection con = DriverManager.getConnection(url,"root","");
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("select * from piloto");
			while(rs.next()) {
				lista.add(null);
			}
			
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if ( JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null, "¿Quieres crear un piloto?","MENU", JOptionPane.YES_NO_OPTION)) {
			lista.add(crearPiloto());
		}
		
		if ( JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null, "¿Quieres eliminar un piloto?","MENU", JOptionPane.YES_NO_OPTION)) {
			eliminarPiloto();
		}
		
		if ( JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null, "¿Quieres ver la lista de pilotos?","MENU", JOptionPane.YES_NO_OPTION)) {
			listar(lista);
		}
		
		for (PilotoKart pilotoKart : lista) {
			Connection con;
			try {
				con = DriverManager.getConnection(url,"root","");
				Statement stmt = con.createStatement();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
		}

	}

	private static void eliminarPiloto() {
		// TODO Esbozo de método generado automáticamente
		
	}

	private static void listar(HashSet<PilotoKart> lista) {
		for (Iterator iterator = lista.iterator(); iterator.hasNext();) {
			PilotoKart pilotoKart = (PilotoKart) iterator.next();
			System.out.println(pilotoKart.getPiloto() + " con ganancias " + pilotoKart.getGanancias() + "dolares");
			
		}
		
	}

	private static PilotoKart crearPiloto() {
		
		String nombre = JOptionPane.showInputDialog("Dime el nombre del piloto");
		int velocidad = Integer.parseInt(JOptionPane.showInputDialog("Dime la velocidad"));
		int aceleracion = Integer.parseInt(JOptionPane.showInputDialog("Dime la aceleración"));
		int peso = Integer.parseInt(JOptionPane.showInputDialog("Dime el peso"));
		int manejo = Integer.parseInt(JOptionPane.showInputDialog("Dime el manejo"));
		int agarre = Integer.parseInt(JOptionPane.showInputDialog("Dime el agarre"));
		double ganancias = Integer.parseInt(JOptionPane.showInputDialog("Dime las ganancias"));
		
		int[] caracteristicas = {velocidad,aceleracion,peso, manejo, agarre};
		
		PilotoKart piloto = new PilotoKart(nombre, caracteristicas);
		piloto.setGanancias(ganancias);
		
		return piloto;
	}
}
