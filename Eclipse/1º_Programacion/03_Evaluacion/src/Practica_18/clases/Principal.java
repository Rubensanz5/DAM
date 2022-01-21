package Practica_18.clases;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Practica_18.clasesDAO.ConexionDAO;
import Practica_18.clasesDAO.DepartamentoDAO;
import Practica_18.clasesDAO.EmpleadoDAO;
import Practica_18.clasesDAO.ProyectoDAO;
import Practica_18.clasesDAO.ProyectoSedeDAO;
import Practica_18.clasesDAO.SedeDAO;



public class Principal {
	
	public final static String SEDE = "Gestionar sedes";
	public final static String DEPARTAMENTO = "Gestionar departamentos";
	public final static String EMPLEADO = "Gestionar empleados";
	public final static String PROYECTO = "Gestionar proyectos";
	public final static String SALIR = "Salir";
	
	public static void main(String[] args) {
		try {
			Statement stmt = ConexionDAO.abrirConexion();
			ConexionDAO.crearBD(stmt);
			ConexionDAO.crearTablas(stmt);

			menuInicial(stmt);
	
			ConexionDAO.cerrarConexion(stmt);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public static void menuInicial(Statement stmt) throws SQLException{
		String[] opciones = {SEDE, DEPARTAMENTO, EMPLEADO, PROYECTO, SALIR};
		String opcion0 = null;
		do {
			opcion0 = (String) JOptionPane.showInputDialog(null, "¿Que quieres hacer?", "Bienvenid@", JOptionPane.QUESTION_MESSAGE , null, opciones, null);

			if(opcion0 == null) {
				opcion0 = SALIR;
			}
			
			switch (opcion0) {
				case SEDE:
					String[] opcionesSede = {"Crear sede","Modificar sede", "Eliminar sede", "Volver"};
					opcionesSede(stmt, opcionesSede);
					break;
					
				case DEPARTAMENTO:
					String[] opcionesDepto = {"Crear departamento","Modificar el nombre del departamento", "Modificar la sede del departamento", "Eliminar departamento", "Volver"};
					if(SedeDAO.obtenerSede(stmt).size() != 0) {
						opcionesDepto(stmt, opcionesDepto);
					} else {
						JOptionPane.showMessageDialog(null, "Debe haber al menos alguna sede para crear un departamento", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
					break;
					
				case EMPLEADO:
					String[] opcionesEmp = {"Crear empleado","Modificar el nombre del empleado", "Modificar el departamento del empleado", "Modificar la categoria del empleado", "Modificar el sueldo del empleado", "Eliminar empleado", "Volver"};
					if(DepartamentoDAO.obtenerDepto(stmt).size() != 0) {
						opcionesEmp(stmt, opcionesEmp);
					} else {
						JOptionPane.showMessageDialog(null, "Debe haber al menos algun departamento para crear un empleado", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
					break;
					
				case PROYECTO:
					String[] opcionesProyect = {"Crear proyecto","Modificar nombre del proyecto","Poner fecha de finalizacion al proyecto", "Asignar un proyecto a una sede", "Poner fecha de finalizacion a un proyecto de una sede","Ver proyectos asignados a sedes", "Eliminar proyecto", "Volver"};
					opcionesProyecto(stmt, opcionesProyect);
					
					break;
				case SALIR:
					break;
				default:
					opcion0 = SALIR;
					break;
			}
		} while(opcion0 != SALIR);
	}

	
	private static void opcionesProyecto(Statement stmt, String[] opcionesProyect) throws SQLException {
		String opcion;
		do {
			opcion = (String) JOptionPane.showInputDialog(null, "¿Que quieres hacer?", "Opciones Empleado: ", JOptionPane.QUESTION_MESSAGE , null, opcionesProyect, null);
			
			if(opcion == null) {
				opcion = "Volver";
			}
			
			switch(opcion) {
				case "Crear proyecto":
					ProyectoDAO.crearProy(stmt, pedirNom(), Date.valueOf(LocalDate.now()));
					JOptionPane.showMessageDialog(null, "La fecha de inicio del proyecto sera la actual");
					break;
				case "Modificar nombre del proyecto":
					ProyectoDAO.actualizarNomProy(stmt, mostrarListaProy(stmt), pedirNom());
					break;
				case "Poner fecha de finalizacion al proyecto":	
					JOptionPane.showMessageDialog(null, "La fecha de final del proyecto sera la actual");
					ProyectoDAO.actualizarFechaProy(stmt, mostrarListaProy(stmt), Date.valueOf(LocalDate.now()));
					break;
				case "Asignar un proyecto a una sede":
					Proyecto proyectoAsignar = mostrarListaProy(stmt);
					ArrayList<Sede> sedeSinAsignar = SedeDAO.obtenerSedesSinAsignar(stmt, proyectoAsignar);
					if(sedeSinAsignar.size() != 0) {
						ProyectoSedeDAO.asignarProy(stmt, proyectoAsignar, mostrarListaSedeSinProy(sedeSinAsignar), Date.valueOf(LocalDate.now()));
					}
					break;
				case "Poner fecha de finalizacion a un proyecto de una sede":
					JOptionPane.showMessageDialog(null, "La fecha de finalizacion del proyecto sera la actual"
							+ "\nSi se pone un proyecto con una fecha de finalizacion ya establecida se actualizará");
					ProyectoSedeDAO.ponerFechaFin(stmt, mostrarListaProySede(stmt), Date.valueOf(LocalDate.now()));
					break;
				case "Ver proyectos asignados a sedes":
					for (ProyectoSede proyectSede : ProyectoSedeDAO.obtenerProySede(stmt)) {
						JOptionPane.showMessageDialog(null, "Id del Proyecto: " + proyectSede.getIdProy() + "\nId de la sede: " + proyectSede.getIdSede() 
								+ "\nFecha inicio: " + proyectSede.getfInicio() + (proyectSede.getFechFin() == null ? "" : "\nFecha de finalizacion: " + proyectSede.getFechFin()));
					}
					break;
				case "Eliminar proyecto":
					int confir = JOptionPane.showConfirmDialog(null, "¿Quieres eliminar el proyecto?", "Confirmacion", JOptionPane.WARNING_MESSAGE);
					
					if(confir == JOptionPane.OK_OPTION) {
						ProyectoDAO.eliminarProy(stmt, mostrarListaProy(stmt));
					}
					break;
				case "Volver": 
					break;
				default:
					opcion = "Volver";
					break;
			}
		} while (!opcion.equals("Volver"));
	}

	private static void opcionesEmp(Statement stmt, String[] opcionesEmp) throws SQLException {
		String opcion1;

		do {
			opcion1 = (String) JOptionPane.showInputDialog(null, "¿Que quieres hacer?", "Opciones Empleado: ", JOptionPane.QUESTION_MESSAGE , null, opcionesEmp, null);
			
			if(opcion1 == null) {
				opcion1 = "Volver";
			}
			
			switch(opcion1) {
				case "Crear empleado":
					EmpleadoDAO.crearEmp(stmt, mostrarListaDepto(stmt), pedirNom(), pedirDni(), pedirSueldo(), pedirCategoria());
					break;
				case "Modificar el nombre del empleado":
					EmpleadoDAO.actualizarEmpleadoNom(stmt, mostrarListaEmpl(stmt), pedirNom());
					break;
				case "Modificar el departamento del empleado":
					EmpleadoDAO.actualizarEmpleadoDepartamento(stmt, mostrarListaEmpl(stmt), mostrarListaDepto(stmt));
					break;
				case "Modificar la categoria del empleado":
					EmpleadoDAO.actualizarEmpleadoCategoria(stmt, mostrarListaEmpl(stmt), pedirCategoria());
					break;
				case "Modificar el sueldo del empleado":
					EmpleadoDAO.actualizarEmpleadoSueldo(stmt, mostrarListaEmpl(stmt), pedirSueldo());
					break;
				case "Eliminar empleado":
					int confir = JOptionPane.showConfirmDialog(null, "¿Quieres eliminar el empleado?", "Confirmacion", JOptionPane.WARNING_MESSAGE);
					
					if(confir == JOptionPane.OK_OPTION) {
						EmpleadoDAO.eliminarDepto(stmt, mostrarListaEmpl(stmt));
					}
					break;
				case "Volver": 
					break;
				default:
					opcion1 = "Volver";
					break;
			}
		} while (!opcion1.equals("Volver"));
	}

	private static void opcionesDepto(Statement stmt, String[] opcionesDepto) throws SQLException {
		int opcion;
		do {
			opcion = JOptionPane.showOptionDialog(null,"¿Que quieres hacer?",
					"Opciones departamento: ", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcionesDepto, "Crear departamento");
			switch(opcion) {
				case 0:
					DepartamentoDAO.crearDepto(stmt, mostrarListaSedes(stmt), pedirNom());					
					break;
				case 1:
					DepartamentoDAO.actualizarDepartamentoNom(stmt, mostrarListaDepto(stmt), pedirNom());
					break;
				case 2:
					DepartamentoDAO.actualizarDeptoSede(stmt, mostrarListaDepto(stmt), mostrarListaSedes(stmt));
					break;
				case 3:
					int confir = JOptionPane.showConfirmDialog(null, "Si eliminas el departamento se eliminaran los empleados que esten en el\n ¿Quieres continuar?", "Confirmacion", JOptionPane.WARNING_MESSAGE);
					
					if(confir == JOptionPane.OK_OPTION) {
						DepartamentoDAO.eliminarDepto(stmt, mostrarListaDepto(stmt));
					}
					break;
				case 4:
					opcion = -1;
			}
		} while (opcion != -1);
	}

	private static void opcionesSede(Statement stmt, String[] opcionesSede) throws SQLException {
		int opcion = -1;
			do {
				opcion = JOptionPane.showOptionDialog(null, "¿Que quieres hacer?", "Opciones sede: ", JOptionPane.DEFAULT_OPTION,
						JOptionPane.INFORMATION_MESSAGE, null, opcionesSede, "Crear Sede");
				switch (opcion) {
					case 0:
						SedeDAO.crearSede(stmt, pedirNom());
						break;
					case 1:
						SedeDAO.actualizarSede(stmt, mostrarListaSedes(stmt), pedirNom());
						break;
					case 2:
						int confir = JOptionPane.showConfirmDialog(null, "Si eliminas la sede se eliminaran los departamentos asociados y los empleados de los departamentos\n ¿Quieres continuar?", "Confirmacion", JOptionPane.WARNING_MESSAGE);
						
						if(confir == JOptionPane.OK_OPTION) {
							SedeDAO.eliminarSede(stmt, mostrarListaSedes(stmt));
						}
						break;
					case 3:
						opcion = -1;
						break;
				}
			} while (opcion != -1);
	}
	public static String pedirCategoria() {
		String mensaje;
		do {
			mensaje = JOptionPane.showInputDialog(null, "¿Que categoria quieres poner?(Max 2 caracteres)");
		} while(mensaje.length() > 2);
		
		return mensaje;
	}
	
	public static BigDecimal pedirSueldo() {
		BigDecimal sueldo = null;
		do {
			try {
				String sueldoB = JOptionPane.showInputDialog(null, "¿Que sueldo tendra el empleado?");
				sueldo = new BigDecimal(sueldoB);
			} catch (NumberFormatException e) {
				sueldo = null;
			}
		}while(sueldo == null);
		return sueldo;
	}
	
	public static String pedirNom() {
		String mensaje = JOptionPane.showInputDialog(null, "¿Que nombre quieres poner?");
		return mensaje;
	}

	public static String pedirDni() {
		String dni = null;
		do {
			dni = JOptionPane.showInputDialog(null, "¿Introcuce el DNI?(8 numeros y 1 letra)");
			if (!dni.matches(Empleado.DNI)) {
				JOptionPane.showMessageDialog(null, "DNI erroneo introducelo correctamente");
				dni = null;
			}
			
		} while (dni == null);
		return dni;
	}
	
	
	public static Sede mostrarListaSedes(Statement stmt) throws SQLException {
		ArrayList<Sede> lista = SedeDAO.obtenerSede(stmt);
		
		Sede opcion0 = null;
		do {
			opcion0 = (Sede) JOptionPane.showInputDialog(null, "Selecciona la sede", "Ver sedes", JOptionPane.QUESTION_MESSAGE , null, lista.toArray(), null);
		} while(opcion0 == null);
		return opcion0;
	}
	
	public static Departamento mostrarListaDepto(Statement stmt) throws SQLException {
		ArrayList<Departamento> lista = DepartamentoDAO.obtenerDepto(stmt);
		
		Departamento opcion0 = null;
		do {
			opcion0 = (Departamento) JOptionPane.showInputDialog(null, "Selecciona el departamento", "Ver departamentos", JOptionPane.QUESTION_MESSAGE , null, lista.toArray(), null);
		} while(opcion0 == null);
		return opcion0;
	}
	
	public static Empleado mostrarListaEmpl(Statement stmt) throws SQLException {
		ArrayList<Empleado> lista = EmpleadoDAO.obtenerEmp(stmt);
		
		Empleado opcion0 = null;
		do {
			opcion0 = (Empleado) JOptionPane.showInputDialog(null, "Selecciona el empleado", "Ver empleados", JOptionPane.QUESTION_MESSAGE , null, lista.toArray(), null);
		} while(opcion0 == null);
		return opcion0;
	}
	
	public static Proyecto mostrarListaProy(Statement stmt) throws SQLException {
		ArrayList<Proyecto> lista = ProyectoDAO.obtenerProy(stmt);
		
		Proyecto opcion0 = null;
		do {
			opcion0 = (Proyecto) JOptionPane.showInputDialog(null, "Selecciona el proyecto", "Ver proyecto", JOptionPane.QUESTION_MESSAGE , null, lista.toArray(), null);
		} while(opcion0 == null);
		return opcion0;
	}
	
	public static ProyectoSede mostrarListaProySede(Statement stmt) throws SQLException {
		ArrayList<ProyectoSede> lista = ProyectoSedeDAO.obtenerProySede(stmt);
		
		ProyectoSede opcion0 = null;
		do {
			opcion0 = (ProyectoSede) JOptionPane.showInputDialog(null, "Selecciona el proyecto", "Ver proyecto", JOptionPane.QUESTION_MESSAGE , null, lista.toArray(), null);
		} while(opcion0 == null);
		return opcion0;
	}
	
	public static Sede mostrarListaSedeSinProy(ArrayList<Sede> lista) throws SQLException {
		Sede opcion0 = null;
		do {
			opcion0 = (Sede) JOptionPane.showInputDialog(null, "Selecciona la sede", "Ver sedes", JOptionPane.QUESTION_MESSAGE , null, lista.toArray(), null);
		} while(opcion0 == null);
		return opcion0;
	}

}
