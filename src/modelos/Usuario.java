package modelos;

import java.util.ArrayList;
import java.util.Iterator;

import excepciones.ContrasenaIncorrectaException;

public abstract class Usuario {
	private String nombreUsuario;
	private String contrasena;
	private int puntaje;
	private ArrayList<Ticket> tickets = new ArrayList<Ticket>();
	

	public Usuario(String nombreUsuario, String contrasena) {
		this.nombreUsuario = nombreUsuario;
		this.contrasena = contrasena;
		this.puntaje = 0;
	}
	
	public void login(String contrasena) throws ContrasenaIncorrectaException {
		if(!this.contrasena.equals(contrasena)) {
			throw new ContrasenaIncorrectaException("Contrasena incorrecta");
		}
	}
	
	public void agregarTicket(Ticket ticket) {
		this.tickets.add(ticket);
	}
	
	public String getnombreUsuario() {
		return nombreUsuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public int getPuntaje() {
		return puntaje;
	}

	public Iterator<Ticket> getTickets() {
		return tickets.iterator();
	}
	
	@Override
	public String toString() {
		return "nombreUsuario=" + nombreUsuario + ", contrasena=" + contrasena + ", puntaje=" + puntaje;
	}
}
