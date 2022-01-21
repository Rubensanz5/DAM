package Practica_Navidad.juego_senet;

public class Senet {

	public static void main(String[] args) {
		System.out.println(tablero());
	}
	
	private static String tablero() {
		String tablero = "";
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 20; j++) {
				if(i == 1 && j == 10) {
					tablero += "{ ";
				}else if(i == 1 && j == 11) {
					tablero += "}";
				}else if(i == 2 && j == 12) {
					tablero += "{ ";
				}else if(i == 2 && j == 13) {
					tablero += "}";
				}else if(i == 2 && j >= 10) {
					if((j % 2) == 0) {
						tablero += "( ";
					}else {
						tablero += ")";
					}
				}else if((j % 2) == 0) {
					tablero += "[ ";
				}else {
					tablero += "]";
				}
			}
			tablero += "\n";
		}
		return tablero;
		/*StringBuilder tablero = new StringBuilder();
		
		return tablero.toString();*/
	}
	
}
