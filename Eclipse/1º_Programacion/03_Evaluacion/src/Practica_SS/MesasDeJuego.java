package Practica_SS;

public class MesasDeJuego {
	
	private boolean reservar;
	private int numSillas;
	

	public MesasDeJuego(boolean reservar, int numSillas) {
		this.reservar = reservar;
		this.numSillas = numSillas;
	}

	public boolean isReservar() {
		return reservar;
	}

	public void setReservar(boolean reservar) {
		this.reservar = reservar;
	}

	public int getNumSillas() {
		return numSillas;
	}

	public void setNumSillas(int numSillas) {
		this.numSillas = numSillas;
	}
	
	public String reservarMesa(Usuarios usuarioActual) {
		String mensaje = "";
		if(!reservar) {
			reservar = true;
			usuarioActual.setUsandoMesa(true);
			mensaje = "Tu reserva se ha realizado";
		} else {
			mensaje = "No has podido reservar la mesa";
		}
		return mensaje;
	}
	
	public String irseDeMesa(Usuarios usuarioActual) {
		String mensaje = "";
		if(reservar) {
			usuarioActual.setUsandoMesa(false);
			reservar = false;
			mensaje = "Se ha liberado la mesa correctamente";
		} else {
			mensaje = "ya estas en esta mesa";
		}
		return mensaje;
	}

	
	
	
}
