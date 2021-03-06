package modelos.estados;

import java.io.Serializable;

import modelos.Ticket;
import modelos.Usuario;

public class Finalizado implements IEstado, Serializable {
	private Ticket ticket;

	public Finalizado(Ticket ticket) {
		super();
		this.ticket = ticket;
		this.ticket.getCreador().finalizarTicket();
	}

	@Override
	public void setActivo() {
	}

	@Override
	public void setSuspendido() {
	}

	@Override
	public void setCancelado() {
	}

	@Override
	public void setFinalizado() {
	}

	@Override
	public Usuario getCreador() {
		return null;
	}

	@Override
	public boolean esActivo() {
		return false;
	}

	@Override
	public String toString() {
		return "Finalizado";
	}
}
