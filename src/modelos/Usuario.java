package modelos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import excepciones.ContrasenaIncorrectaException;

public abstract class Usuario extends Observable implements Logueable, Serializable, Observer {
	private String nombreUsuario;
	private String contrasena;
	protected int puntaje;
	
	protected ArrayList<Observable> observables = new ArrayList<Observable>();

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
	public void update(Observable o, Object arg) {
		if(this.observables.contains(o)) {
			System.out.println("Hola ->" + (String) arg);
			this.setChanged();
			this.notifyObservers(arg);
		}
	}
	
	public void agregarObservador(Observer o) {
		this.addObserver(o);
	}

	@Override
	public String toString() {
		return "Nombre de Usuario: " + nombreUsuario + " Puntaje: " + puntaje;
	}
}
