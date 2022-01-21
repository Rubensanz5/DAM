package Modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

public class Champion implements Comparable<Champion>{
	public static final String TOP = "Top";
	public static final String ADC = "Botton";
	public static final String SUP = "Support";
	public static final String JUNGLE = "Jungle";
	public static final String MID = "Mid";
	
	public static final String FANTASMAL = "Fantasmal";
	public static final String CURACION = "Curacion";
	public static final String BARRERA = "Barrera";
	public static final String EXTENUACION = "Extenuación";
	public static final String CLARIDAD = "Claridad";
	public static final String DESTESLLO = "Destello";
	public static final String TP = "Teleportar";
	public static final String SMITE = "Aplastar";
	public static final String QUEMAR = "Quemar";
	public static final String PURIF = "Purificación";
	
	
	private int idChamp;
	private String nombre;
	private String rol;
	private LocalDate fecha;
	
	private String h1;
	private String h2;
	private String h3;
	private String h4;
	private String h5;
	
	private String he1;
	private String he2;
	
	


	public Champion(String nombre, String rol, LocalDate fecha, String h1, String h2, String h3, String h4, String h5, String he1, String he2) {
		this.nombre = nombre;
		this.rol = rol;
		this.fecha = fecha;
		this.h1 = h1;
		this.h2 = h2;
		this.h3 = h3;
		this.h4 = h4;
		this.h5 = h5;
		this.he1 = he1;
		this.he2 = he2;
	}

	
	public int getIdChamp() {
		return idChamp;
	}


	public void setIdChamp(int idChamp) {
		this.idChamp = idChamp;
	}


	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getH1() {
		return h1;
	}

	public void setH1(String h1) {
		this.h1 = h1;
	}

	public String getH2() {
		return h2;
	}

	public void setH2(String h2) {
		this.h2 = h2;
	}

	public String getH3() {
		return h3;
	}

	public void setH3(String h3) {
		this.h3 = h3;
	}

	public String getH4() {
		return h4;
	}

	public void setH4(String h4) {
		this.h4 = h4;
	}

	public String getH5() {
		return h5;
	}

	public void setH5(String h5) {
		this.h5 = h5;
	}

	public String getHe1() {
		return he1;
	}

	public void setHe1(String he1) {
		this.he1 = he1;
	}

	public String getHe2() {
		return he2;
	}

	public void setHe2(String he2) {
		this.he2 = he2;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	@Override
	public int compareTo(Champion o) {
		int invertir = (this.fecha.compareTo(o.fecha)) * -1;
		if (invertir == 0) {
			Integer id = this.idChamp;
			invertir = id.compareTo(o.idChamp);
		}
		
		return invertir;
	}
	
	public static Comparator<Champion> ordenarNombre (){
		return new Comparator<Champion>() {

			@Override
			public int compare(Champion o1, Champion o2) {
				int resul = o1.nombre.compareTo(o2.nombre);
				if (resul == 0) {
					Integer id = o1.idChamp;
					resul = id.compareTo(o2.idChamp);
				}
				return resul;
			}
		
	};}
	
	public static ArrayList<String> getHechizos(){
		ArrayList<String> hechizos = new ArrayList<String>();
		hechizos.add(BARRERA);
		hechizos.add(CLARIDAD);
		hechizos.add(CURACION);
		hechizos.add(DESTESLLO);
		hechizos.add(EXTENUACION);
		hechizos.add(FANTASMAL);
		hechizos.add(PURIF);
		hechizos.add(QUEMAR);
		hechizos.add(SMITE);
		hechizos.add(TP);
		return hechizos;
	}
	
}


