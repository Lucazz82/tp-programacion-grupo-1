package modelos;

public class Coincidencia {
	private TicketBusquedaEmpleado ticketEmpleador;
	private TicketBusquedaEmpleo ticketEmpleado;
	private double comisionEmpleador;
	private double comisionEmpleado;

	public Coincidencia(TicketBusquedaEmpleado ticketEmpleador, TicketBusquedaEmpleo ticketEmpleado,
			double comisionEmpleador, double comisionEmpleado) {
		this.ticketEmpleador = ticketEmpleador;
		this.ticketEmpleado = ticketEmpleado;
		this.comisionEmpleador = comisionEmpleador;
		this.comisionEmpleado = comisionEmpleado;
	}

	public TicketBusquedaEmpleado getTicketEmpleador() {
		return ticketEmpleador;
	}

	public TicketBusquedaEmpleo getTicketEmpleado() {
		return ticketEmpleado;
	}

	public double getComisionEmpleador() {
		return comisionEmpleador;
	}

	public double getComisionEmpleado() {
		return comisionEmpleado;
	}

}
