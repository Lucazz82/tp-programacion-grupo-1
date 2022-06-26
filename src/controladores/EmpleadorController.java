package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

import excepciones.AgenciaInexistenteException;
import excepciones.TicketInexistenteException;
import modelos.Agencia;
import modelos.Empleador;
import modelos.TicketBusquedaEmpleado;
import modelos.TicketBusquedaEmpleo;
import modelos.TicketOrdenable;
import vista.EmpleadorVista;

public class EmpleadorController extends Controller<EmpleadorVista> implements FocusListener {
	private Empleador empleador;
	
	public EmpleadorController(Empleador empleador) {
		super(new EmpleadorVista());
		this.empleador = empleador;
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
		} else if (cmd.equalsIgnoreCase("Elegir Ganador")) {
			if (vista.isListaCandidatosVisible()) {
				TicketBusquedaEmpleo ticketEmpleado = vista.getCandidatoSeleccionado();
				TicketBusquedaEmpleado ticketEmpleador = vista.getTicketSeleccionado();
				ticketEmpleador.setElegido(ticketEmpleado);
				JOptionPane.showMessageDialog(vista, "Ticket seleccionado éxito");
			}
		} else if (cmd.equalsIgnoreCase("Activar Ticket")) {
			TicketBusquedaEmpleado seleccionado = vista.getTicketSeleccionado();
			seleccionado.setActivo();
		}else if (cmd.equalsIgnoreCase("Suspender Ticket")) {
			TicketBusquedaEmpleado seleccionado = vista.getTicketSeleccionado();
			seleccionado.setSuspendido();
		}
	}

	@Override
	public void focusGained(FocusEvent e) {
		TicketBusquedaEmpleado ticket = vista.getTicketSeleccionado();
		ArrayList<TicketBusquedaEmpleo> candidatos = new ArrayList<>();
		try {
			Iterator<TicketOrdenable> candidatosIt = Agencia.getInstancia().getListaAsignacion(ticket);
			while (candidatosIt.hasNext()) {
				candidatos.add((TicketBusquedaEmpleo)candidatosIt.next().getTicket());
			}
			vista.setListaCandidatos(candidatos);
		} catch (TicketInexistenteException | AgenciaInexistenteException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
	}
}
