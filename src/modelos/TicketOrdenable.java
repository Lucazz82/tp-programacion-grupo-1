package modelos;

import java.io.Serializable;

public class TicketOrdenable implements Comparable<TicketOrdenable>, Serializable {
	private Ticket ticket;
	private Double puntaje;

	public TicketOrdenable(Ticket ticket, double puntaje) {
		super();
		this.ticket = ticket;
		this.puntaje = puntaje;
	};

	/**
	 * Se agrega -1 para que se ordene de mayor a menor
	 */
	@Override
	public int compareTo(TicketOrdenable o) {
		return -1 * this.puntaje.compareTo(o.puntaje);
	}

	public Ticket getTicket() {
		return ticket;
	}

	public Double getPuntaje() {
		return puntaje;
	}

	@Override
	public String toString() {
		return "TicketOrdenable [ticket=" + ticket + ", puntaje=" + puntaje + "]";
	}
}
