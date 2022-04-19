package modelos.aspectos;

import modelos.Enfrentable;
import modelos.Ticket;

public abstract class Aspecto implements Enfrentable{
	protected Ticket ticketEmpleador;
	protected Ticket ticketEmpleado;
	
	
	public Aspecto(Ticket ticketEmpleador, Ticket ticketEmpleado) {
		this.ticketEmpleador = ticketEmpleador;
		this.ticketEmpleado = ticketEmpleado;
	}
}
