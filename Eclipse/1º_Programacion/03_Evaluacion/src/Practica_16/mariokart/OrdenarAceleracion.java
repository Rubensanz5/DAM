package Practica_16.mariokart;
import java.util.Comparator;

public class OrdenarAceleracion implements Comparator<PilotoKart> {

	
	@Override
	public int compare(PilotoKart p1, PilotoKart p2) {
		
		if(p1.getCaracteristicas()[PilotoKart.ACELERACION] < p2.getCaracteristicas()[PilotoKart.ACELERACION]) {
			return -1;
		} else if(p1.getCaracteristicas()[PilotoKart.ACELERACION] == p2.getCaracteristicas()[PilotoKart.ACELERACION]) {
			return p2.getPiloto().compareTo(p1.getPiloto());
		} else {
			return 1;
		}
	}

}
