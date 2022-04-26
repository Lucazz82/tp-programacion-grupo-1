package excepciones;

public class ContrasenaIncorrectaException extends Exception {
	private static final long serialVersionUID = 1L;

	public ContrasenaIncorrectaException(String mensaje) {
		super(mensaje);
	}

}
