package modelos.estados;

import java.io.Serializable;

import modelos.Ticket;
import modelos.Usuario;

public class Activo implements IEstado, Serializable {
	private Ticket ticket;

	public Activo(Ticket ticket) {
		super();
		this.ticket = ticket;
	}

	@Override
	public void setActivo() {
	}

	@Override
	public void setSuspendido() {
		this.ticket.setEstado(new Suspendido(ticket));
	}

	@Override
	public void setCancelado() {
		this.ticket.setEstado(new Cancelado(ticket));
	}

	@Override
	public void setFinalizado() {
		this.ticket.setEstado(new Finalizado(ticket));
	}

	@Override
	public Usuario getCreador() {
		return this.getCreador();
	}

	@Override
	public boolean esActivo() {
		return true;
	}

	@Override
	public String toString() {
		return "Activo";
	}

}
