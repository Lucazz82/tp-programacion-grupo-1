package modelos;

import excepciones.ContrasenaIncorrectaException;

public abstract class Usuario {
	private String nombreUsuario;
	private String contrasena;
	protected int puntaje;

	public Usuario(String nombreUsuario, String contrasena) {
		this.nombreUsuario = nombreUsuario;
		this.contrasena = contrasena;
		this.puntaje = 0;
	}

	public void login(String contrasena) throws ContrasenaIncorrectaException {
		if (!this.contrasena.equals(contrasena)) {
			throw new ContrasenaIncorrectaException("Contrasena incorrecta");
		}
	}

	public abstract void finalizarTicket();

	public abstract void cancelarTicket();

	public abstract double calcularComision(Ticket ticket);

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
		return "nombreUsuario=" + nombreUsuario + ", contrasena=" + contrasena + ", puntaje=" + puntaje;
	}
}
