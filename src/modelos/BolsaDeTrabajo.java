package modelos;

import java.util.ArrayList;

public class BolsaDeTrabajo {
	private ArrayList<TicketSimplificado> tickets = new ArrayList<>();
	
	public void agregarTickets(TicketSimplificado ticket) {
		synchronized (this.tickets) {
			tickets.add(ticket);
			System.out.println("Ticket agregado: " + ticket.getRubro());
			tickets.notifyAll();
		}
	}
	
	public void busqueda(EmpleadoPretenso empleado) {
		synchronized (this.tickets) {	
			System.out.println(empleado.getnombreUsuario() + " busca ticket simplificado.");
			while (empleado.getGanador() == null) {
				for (TicketSimplificado ticket : tickets) {
					if (empleado.getTicket().getFormulario().getRubro().mismoRubro(ticket.getRubro())) {
						empleado.setGanador(ticket);
						tickets.remove(ticket);
						System.out.println(empleado.getnombreUsuario() + " encuentra ticket simplificado.");
						break;
					}
				}
				
				if (empleado.getGanador() == null) {
					try {
						System.out.println(empleado.getnombreUsuario() + " no encuentra coincidencias, espera.");
						tickets.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	public void devuelve(TicketSimplificado ticket) {
		synchronized(this.tickets) {
			tickets.add(ticket);
			System.out.println("Ticket devuelto.");
			tickets.notifyAll();
		}
	}
}
