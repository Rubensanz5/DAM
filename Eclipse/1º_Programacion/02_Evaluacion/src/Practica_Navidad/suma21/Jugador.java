package Practica_Navidad.suma21;

public class Jugador {
	public int carta1; 
	public int carta2; 
	public int total;
	
	Jugador(){
		carta1 = cartaNueva(); 
		carta2 = cartaNueva();
		total = carta1 + carta2;
	}
	
	public int cartaNueva () {
		int carta = (int) (1 + Math.random() * 12);
		return carta;
	}
}
