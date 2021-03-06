package modelos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import excepciones.ContrasenaIncorrectaException;

public abstract class Usuario implements Logueable, Serializable, Observer {
	private String nombreUsuario;
	private String contrasena;
	protected int puntaje;

	protected Observable observables = null;
	protected String mensaje = null;

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

	public String getMensaje() {
		return (mensaje == null) ? "No tiene mensajes" : mensaje;
	}

	public void vaciarMensajes() {
		this.mensaje = null;
	}

	@Override
	public void update(Observable o, Object arg) {
		if (this.observables == o) {
			this.mensaje = (String) arg;
		}
	}

	@Override
	public String toString() {
		return "Nombre de Usuario: " + nombreUsuario + " Puntaje: " + puntaje;
	}
}
