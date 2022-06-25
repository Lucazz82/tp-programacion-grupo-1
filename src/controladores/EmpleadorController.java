package controladores;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Iterator;

import modelos.Agencia;
import modelos.Empleador;
import modelos.TicketBusquedaEmpleado;
import vista.EmpleadorVista;

public class EmpleadorController extends Controller {
	private EmpleadorVista vista;
	private Empleador empleador;
	
	public EmpleadorController(Empleador empleador) {
		this.vista = new EmpleadorVista();
		this.empleador = empleador;
		vista.setActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		
		if (cmd.equalsIgnoreCase("Ver Tickets")) {
			ArrayList<TicketBusquedaEmpleado> tickets = new ArrayList<>();
			Iterator<TicketBusquedaEmpleado> it = empleador.getTickets();
			while (it.hasNext()) {
				tickets.add(it.next());
			}
			vista.setListaTickets(tickets);
		} else if (cmd.equalsIgnoreCase("Desplegar Candidatos")) {
			
		} else if (cmd.equalsIgnoreCase("Elegir Ganador")) {
			
		}
	}
}
