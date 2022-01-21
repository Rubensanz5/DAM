package Practica_12y13.marioKart;

import java.time.LocalTime;

public class Competicion {
	
	private String circuito;
	private String imagenMapa;
	private int cilindrada;
	private int vueltas;
	private LocalTime vueltaRapida;
	private PilotoKart[] participantes;

	public Competicion(String circuito, String imagenMapa, int cilindrada, int vueltas) {
		this.circuito = circuito;
		this.imagenMapa = imagenMapa;
		this.cilindrada = cilindrada;
		this.vueltas = vueltas;
		this.vueltaRapida = LocalTime.parse("00:00:00.000");
	}
	
	public String getCircuito() {
		return circuito;
	}

	public void setCircuito(String circuito) {
		this.circuito = circuito;
	}
	
	public String getImagenMapa() {
		return imagenMapa;
	}

	public void setImagenMapa(String imagenMapa) {
		this.imagenMapa = imagenMapa;
	}

	public int getCilindrada() {
		return cilindrada;
	}

	public void setCilindrada(int cilindrada) {
		this.cilindrada = cilindrada;
	}

	public int getVueltas() {
		return vueltas;
	}

	public void setVueltas(int vueltas) {
		this.vueltas = vueltas;
	}

	public LocalTime getVueltaRapida() {
		return vueltaRapida;
	}

	public void setVueltaRapida(LocalTime vueltaRapida) {
		this.vueltaRapida = vueltaRapida;
	}

	public PilotoKart[] getParticipantes() {
		return participantes;
	}

	public void setParticipantes(PilotoKart[] participantes) {
		this.participantes = participantes;
	}
	
	public boolean addKart(PilotoKart piloto0, int posicion) {
		
		boolean add = false;
		
		PilotoKart [] nuevosParticipantes = new PilotoKart[getParticipantes().length + 1];
		
		if(piloto0 != null && posicion > 0 && posicion <= nuevosParticipantes.length) {
			if ((posicion - 1) == 0) {
				nuevosParticipantes[0] = piloto0;
		        for(int i = 0; i < participantes.length; i++){
		        	nuevosParticipantes[i+1] = participantes[i];
		        }
		        add = true;
			} else if(posicion == nuevosParticipantes.length) {
		        for(int i = 0; i < participantes.length; i++){
		        	nuevosParticipantes[i] = participantes[i];
		        }
		        nuevosParticipantes[participantes.length] = piloto0;
				add = true; 
			} else {
				System.arraycopy(participantes, 0, nuevosParticipantes, 0, posicion);
				nuevosParticipantes[posicion - 1] = piloto0;
				System.arraycopy(participantes, posicion - 1 , nuevosParticipantes, posicion,participantes.length - (posicion - 1));
				add = true;
			}
			
			participantes = nuevosParticipantes;
			
		}
		return add;
	}
	
	public boolean removeKart(String nombre) {
		boolean remove = false;
		
		
		PilotoKart [] nuevosParticipantes = new PilotoKart[getParticipantes().length - 1];
		
		for (int i = 0; i < participantes.length; i++) {
				if (participantes[i].getPiloto().equalsIgnoreCase(nombre)){
					remove = true;
					if(i == 0) {
						System.arraycopy(participantes, 1, nuevosParticipantes, 0, nuevosParticipantes.length);
					} else if (i == participantes.length - 1){
						System.arraycopy(participantes, 0, nuevosParticipantes, 0, nuevosParticipantes.length);
					} else {
						System.arraycopy(participantes, 0, nuevosParticipantes, 0, i);
						System.arraycopy(participantes, i + 1, nuevosParticipantes, i, (participantes.length - i - 1));
					}
				} 
			}
		if(remove) {
			participantes = nuevosParticipantes;
		}
		return remove;
	}

}
