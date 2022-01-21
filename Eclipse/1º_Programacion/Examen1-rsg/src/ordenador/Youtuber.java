package ordenador;

public class Youtuber {
	String nombreCanal, nombreYoutuber;
	int edad, numSuscriptores;
	boolean infantil;
	
	final static int PRECIO_BASE = 150;
	
	public Youtuber(String nombreCanal,String nombreYoutuber, int edad, int numSuscriptores, boolean infantil) {
		this.nombreCanal = nombreCanal;
		this.nombreYoutuber = nombreYoutuber;
		this.edad = edad;
		this.numSuscriptores = numSuscriptores;
		this.infantil = infantil;
	}
	
	
	//el calculo de el precio no me ha dado tiempo a corregirlo
	public String carcularPrecio() {
		double precio = PRECIO_BASE;
		String mensaje = "";
		
		if (((numSuscriptores < 4000) && (infantil)) || (edad < 18)) {
			mensaje = (String) "No se puede ofrecer precio";
		} else if ((numSuscriptores < 4000 && numSuscriptores > 9999) && !infantil) {
			precio -= precio * 0.20;
			
			mensaje = "PRECIO FINAL: " + precio;
		} else if (numSuscriptores >= 10000 && !infantil) {
			precio -= precio * 0.25;
			mensaje = "PRECIO FINAL: " + precio;
		}
		
		return mensaje;
	}
	
}
