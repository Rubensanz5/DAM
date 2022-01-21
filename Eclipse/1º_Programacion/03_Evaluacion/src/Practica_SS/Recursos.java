package Practica_SS;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


import javax.swing.JOptionPane;

public abstract class Recursos {
	private String nombre;
	private int udsTotales;
	private int udsUsandose;
	private String[] incidencias;
	private String[] prestamos ;
	private String[] users;
	private boolean prestado;
	private String imagen;
	
	public Recursos(String nombre,int udsTotales,String imagen) {
		this.nombre = nombre;
		this.udsTotales = udsTotales;
		this.udsUsandose = 0;
		prestamos = new String [this.udsTotales];
		users = new String [this.udsTotales];
		this.prestado = false;
		this.imagen = imagen; 
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getUnidadesTotales() {
		return udsTotales;
	}

	public void setUnidadesTotales(int unidadesTotales) {
		this.udsTotales = unidadesTotales;
	}

	public int getUnidadesUsandose() {
		return udsUsandose;
	}

	public void setUnidadesUsandose(int unidadesUsandose) {
		this.udsUsandose = unidadesUsandose;
	}

	public String[] getIncidencias() {
		return incidencias;
	}

	public void setIncidencias(String[] incidencias) {
		this.incidencias = incidencias;
	}

	public String[] getPrestamos() {
		return prestamos;
	}

	public void setPrestamos(String[] prestamos) {
		this.prestamos = prestamos;
	}

	public String[] getUsers() {
		return users;
	}

	public void setUsers(String[] users) {
		this.users = users;
	}

	public boolean isPrestado() {
		return prestado;
	}

	public void setPrestado(boolean prestado) {
		this.prestado = prestado;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public abstract String verIncidencias();
	public abstract String mostrarInformacion ();
	
	public boolean prestamos(Usuarios usuario0) {
		boolean prestado = false;
		
		if (!usuario0.isUsandoRecurso() && udsTotales >= udsUsandose) {
			prestado = true;
			
			JOptionPane.showMessageDialog(null, "Has adquirido el recurso " + this.getNombre());
			usuario0.setUsandoRecurso(true);;
			usuario0.setRecursoUsado(this);
			udsUsandose++;
			
			LocalDateTime hoy = LocalDateTime.now();
			DateTimeFormatter fecha = DateTimeFormatter.ofPattern("d '/' M '/' yyyy '-' kk ':' mm");
			String fechaPrestamo = hoy.format(fecha);
			
			int posicion = descubrirPosicion(this.users, null);
			this.users[posicion] = usuario0.getDni();
			
			if (this.prestamos[posicion] == null) {
				this.prestamos[posicion] = usuario0.getNombre().toUpperCase() + " " + usuario0.getApellido().toUpperCase() 
						+ "\nPrestamo: " + fechaPrestamo + " | " ;	
			}else {
				this.prestamos[posicion] += usuario0.getNombre().toUpperCase() + " " + usuario0.getApellido().toUpperCase() 
						+ "\nPrestamo: " + fechaPrestamo + " | " ;	
			}
			return prestado;
		} else {
			JOptionPane.showMessageDialog(null, "No puedes adquirir este recurso");
			return prestado;
	
		}

	}

	public boolean devolucion(Usuarios usuario0) {
		boolean devuelto = false;
		
		if(usuario0.isUsandoRecurso() && usuario0.getRecursoUsado().getNombre().equals(this.getNombre())) {
			devuelto = true;
			
			JOptionPane.showMessageDialog(null, "Has devuelto " + this.getNombre());
			usuario0.setUsandoRecurso(false);
			usuario0.setRecursoUsado(this);
			udsUsandose--;
			
			
			LocalDateTime hoy = LocalDateTime.now();
			DateTimeFormatter fecha = DateTimeFormatter.ofPattern("d '/' M '/' yyyy '-' kk ':' mm");
			String fechaDevolucion = hoy.format(fecha);
			
			int posicion = descubrirPosicion(this.users, usuario0.getDni());
			this.prestamos[posicion] += "Devolución: " + fechaDevolucion + "\n";
			this.users [posicion] = null;
			return devuelto;
			
		} else {
			JOptionPane.showMessageDialog(null, "No puedes devolver este recurso");
			return devuelto;
		}
	}
	
	public int descubrirPosicion(String[] array0, String comprobarValor) {
		int i = -1;
		for(String valor : array0) {
			i++;
			if (comprobarValor == valor ) {
				return i;
			}
		}
		return i;
		
	}
	public void ponerIncidencia(Usuarios usuario0) {
		int posicion = descubrirPosicion(this.users, usuario0.getDni());
		String mensaje = JOptionPane.showInputDialog("Escribe tu incidencia: \n");
		this.incidencias[posicion] += mensaje + "\n";
		
	}

	public String verPrestamos() {
		String info = "";
		int posicion = 0;
		for (String mensaje : this.prestamos) {
			posicion ++;
			info += "Prestamo del " + this.nombre + " " + posicion + "\n" ;
			info += (mensaje == null) ? "\nNo se ha prestado todavia" : mensaje;
			info += (this.prestamos.length > posicion) ? "\n***************************************\n" : "";
			
		}
		return info;
	}

	
	
	
	
}
