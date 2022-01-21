package Practica_16.mariokart;
import java.util.Comparator;

public class OrdenarCaracteristicas implements Comparator<PilotoKart> {

	@Override
	public int compare(PilotoKart p1, PilotoKart p2) {
		int p1Carac = 0;
		int p2Carac = 0;
		for (int p : p1.getCaracteristicas()) {
			p1Carac += p;
		}
		for (int p : p2.getCaracteristicas()) {
			p2Carac += p;
		}
//		for (int i = 0; i <= p1.getCaracteristicas().length; i++) {
//			p1Carac += p1.getCaracteristicas()[i];
//		}
		
//		for (int i = 0; i <=p2.getCaracteristicas().length; i++) {
//			p2Carac += p2.getCaracteristicas()[i];
//		}
		
		if(p1Carac < p2Carac) {
			return -1;
		} else {
			return 1;
		}
	}
}
