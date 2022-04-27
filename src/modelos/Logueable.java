package modelos;

import excepciones.ContrasenaIncorrectaException;

public interface Logueable {

	public void login(String contrasena) throws ContrasenaIncorrectaException;

}