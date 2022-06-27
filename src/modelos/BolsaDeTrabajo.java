package modelos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

public class BolsaDeTrabajo extends Observable implements Serializable {
	private ArrayList<TicketSimplificado> tickets = new ArrayList<>();
	private HashMap<Empleador, Integer> cantidadTickets = new HashMap<Empleador, Integer>();
	
	public synchronized void agregarTickets(TicketSimplificado ticket) {
		Empleador creador = ticket.getCreador(); 
		
		if(cantidadTickets.containsKey(creador)) {
			int cantidad = cantidadTickets.get(creador);
			
			if(cantidad < 3) {
				cantidadTickets.put(creador, cantidad + 1);
				this.tickets.add(ticket);
				this.setChanged();
				this.notifyObservers("Ticket agregado: " + ticket.getRubro());
			} else {
				this.setChanged();
				this.notifyObservers("No se puede agregar ticket, ya tiene 3");
			}
		} else {
			cantidadTickets.put(creador, 1);
			this.tickets.add(ticket);
			this.setChanged();
			this.notifyObservers("Ticket agregado: " + ticket.getRubro());
		}
		
		this.notifyAll();
	}
	
	public synchronized void busqueda(EmpleadoPretenso empleado) {
		while (empleado.getGanador() == null) {
			for (TicketSimplificado ticket : tickets) {
				if (empleado.getTicket().getFormulario().getRubro().mismoRubro(ticket.getRubro())) {
					empleado.setGanador(ticket);
					tickets.remove(ticket);
					this.notifyAll();
					break;
				}
			}
			
			if (empleado.getGanador() == null) {
				try {
					this.setChanged();
					this.notifyObservers(empleado.getnombreUsuario() + " no encuentra coincidencias, espera.");
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public synchronized void devuelve(TicketSimplificado ticket) {
		tickets.add(ticket);
		this.notifyAll();
	}
	
	public synchronized void confirmarEleccion(TicketSimplificado ticket) {
		Empleador creador = ticket.getCreador(); 
		int cantidad = cantidadTickets.get(creador);
		cantidadTickets.put(creador, cantidad - 1);
		this.notifyAll();
	}
	
	public void agregarObservador(Observer o) {
		this.addObserver(o);
	}
}
