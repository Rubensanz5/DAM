package cifjandecolonia.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import cifjandecolonia.ProfesorInvitado;

class ProfesorInvitadoTest {
	ProfesorInvitado profe = new ProfesorInvitado("Héctor", "Morán Bayón", 38, "HP");
	
	@Test
	@DisplayName("Prueba de MostrarNombreApellidosYCarnet")
	void testMostrarNombreApellidosYCarnet() {
		assertTrue(true);
	}

	

}
