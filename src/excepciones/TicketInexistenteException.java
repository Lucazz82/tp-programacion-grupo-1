package excepciones;

import modelos.Ticket;

public class TicketInexistenteException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Ticket ticket;

	public TicketInexistenteException(String msg, Ticket ticket) {
		super(msg);
		this.ticket = ticket;
	}

	public Ticket getTicket() {
		return ticket;
	}

}
