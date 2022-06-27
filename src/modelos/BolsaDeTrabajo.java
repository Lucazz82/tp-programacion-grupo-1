package modelos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class BolsaDeTrabajo implements Serializable {
	private ArrayList<TicketSimplificado> tickets = new ArrayList<>();
	private HashMap<Empleador, Integer> cantidadTickets = new HashMap<Empleador, Integer>();
	
	public synchronized void agregarTickets(TicketSimplificado ticket) {
		Empleador creador = ticket.getCreador(); 
		
		if(cantidadTickets.containsKey(creador)) {
			int cantidad = cantidadTickets.get(creador);
			
			if(cantidad < 3) {
				cantidadTickets.put(creador, cantidad + 1);
				this.tickets.add(ticket);
			} else {
				System.out.println("No se puede agregar ticket, ya tiene 3");
			}
		} else {
			cantidadTickets.put(creador, 1);
			this.tickets.add(ticket);
		}
		
		System.out.println("Ticket agregado: " + ticket.getRubro());
		this.notifyAll();
	}
	
	public synchronized void busqueda(EmpleadoPretenso empleado) {
		System.out.println(empleado.getnombreUsuario() + " busca ticket simplificado.");
		while (empleado.getGanador() == null) {
			for (TicketSimplificado ticket : tickets) {
				if (empleado.getTicket().getFormulario().getRubro().mismoRubro(ticket.getRubro())) {
					empleado.setGanador(ticket);
					tickets.remove(ticket);
					System.out.println(empleado.getnombreUsuario() + " encuentra ticket simplificado.");
					this.notifyAll();
					break;
				}
			}
			
			if (empleado.getGanador() == null) {
				try {
					System.out.println(empleado.getnombreUsuario() + " no encuentra coincidencias, espera.");
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public synchronized void devuelve(TicketSimplificado ticket) {
		tickets.add(ticket);
		System.out.println("Ticket devuelto.");
		this.notifyAll();
	}
	
	public synchronized void confirmarEleccion(TicketSimplificado ticket) {
		Empleador creador = ticket.getCreador(); 
		int cantidad = cantidadTickets.get(creador);
		cantidadTickets.put(creador, cantidad - 1);
		this.notifyAll();
	}
}
