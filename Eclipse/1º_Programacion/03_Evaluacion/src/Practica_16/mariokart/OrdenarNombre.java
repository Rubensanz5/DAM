package Practica_16.mariokart;
import java.util.Comparator;

public class OrdenarNombre implements Comparator<PilotoKart> {

	@Override
	public int compare(PilotoKart p1, PilotoKart p2) {
		return p1.getPiloto().compareTo(p2.getPiloto());
	}

}
