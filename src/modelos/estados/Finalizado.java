package modelos.estados;

import modelos.Ticket;
import modelos.Usuario;

public class Finalizado implements IEstado {
	private Ticket ticket;
	
	public Finalizado(Ticket ticket) {
		super();
		this.ticket = ticket;
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

}