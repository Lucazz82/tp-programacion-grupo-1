package modelos;

public class TicketEmpleado extends Ticket {

	private int cantidadEmpleadosSolicitados;
	private int cantidadEmpleadosObtenidos;
	
	
	public TicketEmpleado(int cantidadEmpleadosSolicitados, int cantidadEmpleadosObtenidos) {
		super();
		this.cantidadEmpleadosSolicitados = cantidadEmpleadosSolicitados;
		this.cantidadEmpleadosObtenidos = cantidadEmpleadosObtenidos;
	}

	public int getCantidadEmpleadosSolicitados() {
		return cantidadEmpleadosSolicitados;
	}
	
	public int getCantidadEmpleadosObtenidos() {
		return cantidadEmpleadosObtenidos;
	}
	
	
}
