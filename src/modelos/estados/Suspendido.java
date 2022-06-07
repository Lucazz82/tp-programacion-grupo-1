package modelos.estados;

import java.io.Serializable;

import modelos.Ticket;
import modelos.Usuario;

public class Suspendido implements IEstado, Serializable {
	private Ticket ticket;
	
	public Suspendido(Ticket ticket) {
		super();
		this.ticket = ticket;
	}

	@Override
	public void setActivo() {
		this.ticket.setEstado(new Activo(this.ticket));
	}

	@Override
	public void setSuspendido() {
	}

	@Override
	public void setCancelado() {
		this.ticket.setEstado(new Cancelado(this.ticket));
	}

	@Override
	public void setFinalizado() {
		this.ticket.setEstado(new Finalizado(this.ticket));
	}

	@Override
	public Usuario getCreador() {
		return null;
	}
	
	@Override
	public boolean esActivo() {
		return false;
	}


}
