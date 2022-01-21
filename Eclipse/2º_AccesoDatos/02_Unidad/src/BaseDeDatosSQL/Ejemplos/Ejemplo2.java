package BaseDeDatosSQL.Ejemplos;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Ejemplo2 {

	public static void main(String[] args) {
		String connectionUrl = "jdbc:sqlserver://;database=EMPRESA";
		try {
			//Establecemos la conexion con la BD
			Connection conn = DriverManager.getConnection(connectionUrl,"sa","1234");
			
			//Creamos el objeto
			DatabaseMetaData dbmd = conn.getMetaData();
			
			//Obtener info sobre la BD
			String nombre = dbmd.getDatabaseProductName();
			String driver = dbmd.getDriverName();
			String url = dbmd.getURL();
			String usuario = dbmd.getUserName();
			
			System.out.println("Info sobre la BD");
			System.out.println("-----------------");
			System.out.println("Nombre: " + nombre);
			System.out.println("Driver: " + driver);
			System.out.println("Url: " + url);
			System.out.println("Usuario: " + usuario);
			
			//Obtener info sobre las tablas y vistas de la BD
			System.out.println("\nInfo sobre las Tablas");
			System.out.println("-----------------");
			
			ResultSet tablas = dbmd.getTables("EMPRESA", "dbo", null, null);
			
			while(tablas.next()) {
				String catalogo = tablas.getString("TABLE_CAT");
				String esquema = tablas.getString("TABLE_SCHEM");
				String nb = tablas.getString("TABLE_NAME");
				String tipo = tablas.getString("TABLE_TYPE");
				
				System.out.println("Catalogo: " + catalogo);
				System.out.println("Esquema: " + esquema);
				System.out.println("Nombre Tabla: " + nb);
				System.out.println("Tipo: " + tipo);
				System.out.println("------------------------------------\n");

			}
			
			System.out.println("\nInfo sobre la Tabla Departamenos");
			System.out.println("-----------------");
			
			ResultSet columnas = dbmd.getColumns("EMPRESA", "dbo", "Departamentos", null);
			
			while(columnas.next()) {
				String nombreC = columnas.getString("COLUMN_NAME");
				String tipoDato = columnas.getString("TYPE_NAME");
				String longColum = columnas.getString("COLUMN_SIZE");
				String nulleable = columnas.getString("IS_NULLABLE");
				
				System.out.println("Nombre de la columna: " + nombreC);
				System.out.println("Tipo de dato: " + tipoDato);
				System.out.println("Longitud de la Columna: " + longColum);
				System.out.println("Es nulo: " + nulleable);
				System.out.println("------------------------------------\n");
			}
			
			
			System.out.println("\nClave primaria de Tabla Departamenos");
			System.out.println("-----------------");
			
			ResultSet pk = dbmd.getPrimaryKeys("EMPRESA", "dbo", "Departamentos");
			
			while(pk.next()) {
				String clave = pk.getString("COLUMN_NAME");
				System.out.println("Clave Primaria: " + clave);
			}
						
			System.out.println("\nClaves ajenas donde se hace referencia a la clave primaria de Tabla Departamenos");
			System.out.println("-----------------");
			
			ResultSet fk = dbmd.getExportedKeys("EMPRESA", "dbo", "Departamentos");
			
			while(fk.next()) {
				String nombreFk = fk.getString("FKCOLUMN_NAME");
				String nombrePk = fk.getString("PKCOLUMN_NAME");
				String tablaPk = fk.getString("PKTABLE_NAME");
				String tablaFk = fk.getString("FKTABLE_NAME");
				
				
				
				System.out.println("Tabla con PRIMARY KEY " + tablaPk + " \nNombre clave primaria " + nombrePk);
				System.out.println("Tabla con FOREING KEY " + tablaFk + " \nNombre clave ajena " + nombreFk);
			}
			
			System.out.println("\nClaves ajenas de la Tabla Departamenos");
			System.out.println("-----------------");
			
			ResultSet fk2 = dbmd.getImportedKeys("EMPRESA", "dbo", "Departamentos");
			while(fk2.next()) {
				String clave = fk2.getString("FKCOLUMN_NAME");
				System.out.println("Claves Ajenas: " + clave);
			}
			
			System.out.println("\nProcedimientos almacenados");
			System.out.println("-----------------");
			
			ResultSet procedure = dbmd.getProcedures("EMPRESA", "dbo", null);
			
			while(procedure.next()) {
				String nombreProc = procedure.getString("PROCEDURE_NAME");
				String tipoProc = procedure.getString("PROCEDURE_TYPE");	
				
				System.out.println("Nombre del procedimiento: " + nombreProc);
				System.out.println("Tipo del procedimiento: " + tipoProc);
			}
			
			conn.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
