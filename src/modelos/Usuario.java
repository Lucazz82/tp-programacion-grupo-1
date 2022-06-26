package modelos;

import java.io.Serializable;

import excepciones.ContrasenaIncorrectaException;

public abstract class Usuario implements Logueable, Serializable {
	private String nombreUsuario;
	private String contrasena;
	protected int puntaje;

	public Usuario(String nombreUsuario, String contrasena) {
		this.nombreUsuario = nombreUsuario;
		this.contrasena = contrasena;
		this.puntaje = 0;
	}

	/**
	 * Valida si la contrasena del usuario es la recibida por parametro.
	 * 
	 * @param contrasena contrasena a validar
	 * @throws ContrasenaIncorrectaException si la contrasena no corresponde a este
	 *                                       usuario.
	 */
	@Override
	public void login(String contrasena) throws ContrasenaIncorrectaException {
		if (!this.contrasena.equals(contrasena)) {
			throw new ContrasenaIncorrectaException("Contrasena incorrecta");
		}
	}

	public abstract void finalizarTicket();

	public abstract void cancelarTicket();

	public String getnombreUsuario() {
		return nombreUsuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public int getPuntaje() {
		return puntaje;
	}

	@Override
	public String toString() {
		return "Nombre de Usuario: " + nombreUsuario + " Puntaje: " + puntaje;
	}
}
