package Evaluacion_03.colecciones;
import java.util.Comparator;

import Evaluacion_02.Persona.*;

public class OrdenarPersonaPorApellidos implements Comparator<Persona> {

	@Override
	public int compare(Persona p1, Persona p2) {
		return p1.getApellidos().compareTo(p2.getApellidos());
	}

}
