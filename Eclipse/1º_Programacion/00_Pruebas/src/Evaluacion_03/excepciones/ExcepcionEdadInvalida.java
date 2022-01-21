package Evaluacion_03.excepciones;

@SuppressWarnings("serial")
public class ExcepcionEdadInvalida extends IllegalArgumentException {
	public ExcepcionEdadInvalida(String mensaje) {
		super(mensaje);
	}

}
