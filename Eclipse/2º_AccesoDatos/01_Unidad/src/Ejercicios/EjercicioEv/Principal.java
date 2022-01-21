package Ejercicios.EjercicioEv;

import java.awt.HeadlessException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.swing.JOptionPane;

public class Principal {
	//Se deberia de hacer una clase de empleados que de hecho te la envio como se deberia de hacer aunque no haga falta por que no es de acceso aleatorio
	// y al no ser de acceso aleatorio para esta practica no se usará
	public static final String[] DEPARTAMENTOS = {"Marketing", "Informatica", "Ventas", "Comercial"};
	
	public static void main(String[] args) {
		menu();
	}
	
	public static void menu() {		
		int opcion;
		do {
			String[] opciones = {"Visualizar todos los empleados", "Visualizar un empleado", "Añadir un nuevo empleado al final","Añadir un nuevo empleado", "Modificar salario de un empleado", "Salir"};
			opcion = JOptionPane.showOptionDialog(null, "Selecciona una opción:", "Opciones", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, "Crear nuevo piloto");

			switch(opcion) {
				case 0:
					visualizarEmp();
					break;
				case 1:
					int id = Integer.parseInt(JOptionPane.showInputDialog("Inserte el Identificador (ID) del empleado a visualizar"));
					verInfoEmpl(id);
					break;
				case 2:
					añadirEmpFinal();
					break;
				case 3:
					añdirNuevoEmp();
					break;
				case 4: 
					modificarSalario();
					break;
				case 5 : 
					break;
				default:
					opcion = 5;
					break;
			}
		} while (opcion != 5);
		
	}
	
	

	public static void visualizarEmp() {
		try {
			File fichero = new File("Empleados.txt");
			RandomAccessFile fileR = new RandomAccessFile(fichero, "r");
			
			int id; 
			double salario;
			char[] departamento = new char[15];
			char[] apellido = new char[15];
			
			int posicion = 0;
			
			while (fileR.getFilePointer() != fichero.length()) {
				//posicionamiento del puntero
				fileR.seek(posicion);
				
				//leer id
				id = fileR.readInt();
				
				//leer apellido
				for (int i = 0; i < apellido.length; i++) { 
					apellido[i] = fileR.readChar();
				}
				//convertir el array de char a String
				String apellidos = new String(apellido);
				
				//leer departamento
				for (int i = 0; i < departamento.length; i++) { 
					departamento[i] = fileR.readChar();
				}
				//convertir el array de char a String
				String depto = new String(departamento);
				
				//leer salario
				salario = fileR.readDouble();
				
				JOptionPane.showMessageDialog(null,"ID: " + id + "\nApellido: " + apellidos + "\nDepartamento: " + depto +"\nSalario: " + salario + "\n");

				posicion = posicion + 72;
			}
			
			fileR.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void verInfoEmpl(int id) {
		try {
			File fichero = new File("Empleados.txt");
			RandomAccessFile fileR = new RandomAccessFile(fichero, "r");
			
			double salario;
			char[] departamento = new char[15];
			char[] apellido = new char[15];
						
			int posicion = calcularPosicion(id);
			
			if(posicion >= fileR.length()) {
				System.err.println("No existe el empleado a buscar");
			} else {
				fileR.seek(posicion);
				
				//leer id
				id = fileR.readInt();
				
				//leer apellido
				for (int i = 0; i < apellido.length; i++) { 
					apellido[i] = fileR.readChar();
				}
				//convertir el array de char a String
				String apellidos = new String(apellido);
				
				//leer departamento
				for (int i = 0; i < departamento.length; i++) { 
					departamento[i] = fileR.readChar();
				}
				//convertir el array de char a String
				String depto = new String(departamento);
				
				//leer salario
				salario = fileR.readDouble();
				
				JOptionPane.showMessageDialog(null,"ID: " + id + "\nApellido: " + apellidos + "\nDepartamento: " + depto +"\nSalario: " + salario + "\n");

			}
			
			fileR.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void añadirEmpFinal() {
		
		try {
			File fichero = new File("Empleados.txt");
			RandomAccessFile fileR = new RandomAccessFile(fichero, "rw");
			
			int posicion = (int) (fileR.length() - 72);
			
			fileR.seek(posicion);
			
			int id = fileR.readInt();
			id += 1;
			
			//Control para que no deje en blanco o cierre la ventana
			String apellido = null;
			do {
				apellido = JOptionPane.showInputDialog("Introduce el apellido del empleado a insertar: ");				
				if(apellido == null) {
					JOptionPane.showMessageDialog(null, "Tienes que terminar la creacion del Empleado", "Error", JOptionPane.ERROR_MESSAGE);
				} else if (apellido.isEmpty()){
					JOptionPane.showMessageDialog(null, "No puedes dejar en blanco el apellido del Empleado", "Error", JOptionPane.ERROR_MESSAGE);
				}
			} while(apellido == null); 
			
			String depto = null;
			do {
				depto = (String) JOptionPane.showInputDialog(null, "Introduce el departamento del empleado a insertar: ", "Deptos", JOptionPane.INFORMATION_MESSAGE, null, Principal.DEPARTAMENTOS, null);
				if(depto == null) {
					JOptionPane.showMessageDialog(null, "Tienes que terminar la creacion del Empleado", "Error", JOptionPane.ERROR_MESSAGE);
				}
			} while(depto == null); 
			
			double salario = 0.0;
			do {
				salario = Double.parseDouble(JOptionPane.showInputDialog("Introduce el salario del empleado a insertar: "));				
				if(salario == 0.0) {
					JOptionPane.showMessageDialog(null, "Tienes que terminar la creacion del Empleado", "Error", JOptionPane.ERROR_MESSAGE);
				}
			} while(salario == 0.0); 
			
			
			fileR.seek(fileR.length());
			//ID del alumno
			fileR.writeInt(id);
			
			//apellido
			//buffer xa almacenar el apellido
			StringBuffer buffer_a = new StringBuffer(apellido);
			//nº de caracteres xa apellido
			buffer_a.setLength(15);
			//Insertamos el apellido
			fileR.writeChars(buffer_a.toString());
			
			//apellido
			//buffer xa almacenar el depto
			StringBuffer buffer_d = new StringBuffer(depto);
			//nº de caracteres xa depto
			buffer_d.setLength(15);
			//Insertamos el depto
			fileR.writeChars(buffer_d.toString());
			
			//Salario
			fileR.writeDouble(salario);
			JOptionPane.showMessageDialog(null, "Se ha creado correctamente el empleado");
			
			fileR.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void añdirNuevoEmp() {
		try {
			File fichero = new File("Empleados.txt");
			RandomAccessFile fileR = new RandomAccessFile(fichero, "rw");
			int id = Integer.parseInt(JOptionPane.showInputDialog("Inserte el Identificador (ID) del empleado a insertar: "));
			
			int posicion = calcularPosicion(id);
		
			if(posicion >= fileR.length()) {
				
				//Control para que no deje en blanco o cierre la ventana
				String apellido = null;
				do {
					apellido = JOptionPane.showInputDialog("Introduce el apellido del empleado a insertar: ");				
					if(apellido == null) {
						JOptionPane.showMessageDialog(null, "Tienes que terminar la creacion del Empleado", "Error", JOptionPane.ERROR_MESSAGE);
					} else if (apellido.isEmpty()){
						JOptionPane.showMessageDialog(null, "No puedes dejar en blanco el apellido del Empleado", "Error", JOptionPane.ERROR_MESSAGE);
					}
				} while(apellido == null); 
				
				String depto = null;
				do {
					depto = (String) JOptionPane.showInputDialog(null, "Introduce el departamento del empleado a insertar: ", "Deptos", JOptionPane.INFORMATION_MESSAGE, null, Principal.DEPARTAMENTOS, null);
					if(depto == null) {
						JOptionPane.showMessageDialog(null, "Tienes que terminar la creacion del Empleado", "Error", JOptionPane.ERROR_MESSAGE);
					}
				} while(depto == null); 
				
				double salario = 0;
				do {
					salario = Double.parseDouble(JOptionPane.showInputDialog("Introduce el salario del empleado a insertar: "));				
					if(salario == 0) {
						JOptionPane.showMessageDialog(null, "Tienes que terminar la creacion del Empleado", "Error", JOptionPane.ERROR_MESSAGE);
					}
				} while(salario == 0); 
				
				fileR.seek(posicion);
				//ID del alumno
				fileR.writeInt(id);
				
				//apellido
				//buffer xa almacenar el apellido
				StringBuffer buffer_a = new StringBuffer(apellido);
				//nº de caracteres xa apellido
				buffer_a.setLength(15);
				//Insertamos el apellido
				fileR.writeChars(buffer_a.toString());
				
				//apellido
				//buffer xa almacenar el depto
				StringBuffer buffer_d = new StringBuffer(depto);
				//nº de caracteres xa depto
				buffer_d.setLength(15);
				//Insertamos el depto
				fileR.writeChars(buffer_d.toString());
				
				//Salario
				fileR.writeDouble(salario);
				
				fileR.close();
				
				JOptionPane.showMessageDialog(null, "Se ha creado correctamente el empleado");
			} else {
				JOptionPane.showMessageDialog(null, "Ya existe ese empleado");
				verInfoEmpl(id);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static void modificarSalario() {
		
		try {
			File fichero = new File("Empleados.txt");
			RandomAccessFile fileR = new RandomAccessFile(fichero, "rw");
		
		
			int id = Integer.parseInt(JOptionPane.showInputDialog("Inserte el Identificador (ID) del empleado \nque quieres modificar el salario: "));
			int posicion = calcularPosicion(id);
		
			if(posicion >= fileR.length()) {
				JOptionPane.showMessageDialog(null, "No existe ese empleado");
			} else {
				//Nos posicionamos para obtener el 1er salario
				fileR.seek(posicion + 64);
				double salarioN = Double.parseDouble(JOptionPane.showInputDialog("Inserte el salario del empleado que quieres modificar\nEl salario que se ponga se sumará al actual: "));
				double salarioTotal = fileR.readDouble();
				salarioTotal += salarioN;
				//Una vez obtenido la suma de los salarios nos volvemos a posicionar para escribilo ya que se mueve el puntero al leer
				fileR.seek(posicion + 64);
				fileR.writeDouble(salarioTotal);
				verInfoEmpl(id);
			}
			
			fileR.close();
			
		} catch (IOException | NumberFormatException | HeadlessException e) {
			e.printStackTrace();
		}
	}
	
	public static int calcularPosicion (int id) {
		return (id - 1 ) * 72;
	}
}
