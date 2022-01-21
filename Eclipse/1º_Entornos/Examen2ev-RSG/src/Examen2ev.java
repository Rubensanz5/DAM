import cifjandecolonia.ProfesorInvitado;
import cifpponferrada.Profesor;

public class Examen2ev {

	public static void main(String[] args) {
		Profesor profe1 = new Profesor("Rubén", "Sanz", 22, "ruben.sangar.4");
		
		ProfesorInvitado profe2 = new ProfesorInvitado("Héctor", "Morán Bayón", 38, "HP");
		
		profe1.mostrarNombreApellidosYCarnet();
		profe2.mostrarNombreApellidosYCarnet();
	}

}
