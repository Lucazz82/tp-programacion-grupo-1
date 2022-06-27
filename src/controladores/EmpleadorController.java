package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import excepciones.AgenciaInexistenteException;
import excepciones.TicketInexistenteException;
import modelos.Agencia;
import modelos.Empleador;
import modelos.TicketBusquedaEmpleado;
import modelos.TicketBusquedaEmpleo;
import modelos.TicketOrdenable;
import vista.EmpleadorVista;

public class EmpleadorController extends Controller<EmpleadorVista> implements ListSelectionListener {
	private Empleador empleador;

	public EmpleadorController(Empleador empleador) {
		super(new EmpleadorVista());
		this.empleador = empleador;
		this.setListaTickets();
		this.vista.addSelectionListener(this);
		this.vista.setPuntaje(empleador.getPuntaje());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();

		if (cmd.equalsIgnoreCase("Elegir Ganador")) {
			if (this.vista.isListaCandidatosVisible()) {
				TicketBusquedaEmpleo ticketEmpleado = vista.getCandidatoSeleccionado();
				TicketBusquedaEmpleado ticketEmpleador = vista.getTicketSeleccionado();
				ticketEmpleador.setElegido(ticketEmpleado);
				JOptionPane.showMessageDialog(vista, "Ticket seleccionado con éxito");
			} else {
				JOptionPane.showMessageDialog(vista, "Debe seleccionar un ticket");
			}
			
		} else if (cmd.equalsIgnoreCase("Activar Ticket")) {
			if (vista.getTicketSeleccionado() != null) {
				TicketBusquedaEmpleado seleccionado = vista.getTicketSeleccionado();
				seleccionado.setActivo();
				JOptionPane.showMessageDialog(vista, "Ticket Activado");
			} else {
				JOptionPane.showMessageDialog(vista, "Seleccione un ticket");
			}
			
		} else if (cmd.equalsIgnoreCase("Suspender Ticket")) {
			if (vista.getTicketSeleccionado() != null) {
				TicketBusquedaEmpleado seleccionado = vista.getTicketSeleccionado();
				seleccionado.setSuspendido();
				JOptionPane.showMessageDialog(vista, "Ticket Suspendido");
			} else {
				JOptionPane.showMessageDialog(vista, "Seleccione un ticket");
			}
			
		} else if (cmd.equalsIgnoreCase("Agregar Ticket")) {
			Sistema.getInstancia().cambiarController(new TicketEmpleadorController(empleador));
			vista.setVisible(false);
			
		} else if (cmd.equalsIgnoreCase("Cerrar Sesion")) {
			Sistema.getInstancia().cambiarController(new LoginController());
			vista.setVisible(false);
			
		} else if (cmd.equalsIgnoreCase("Ticket Simplificado")) {
			Sistema.getInstancia().cambiarController(new TicketSimplificadoController(empleador));
			vista.setVisible(false);
			
		} else if (cmd.equalsIgnoreCase("Mostrar Ticket")) {
			if (vista.getTicketSeleccionado() != null) {
				Sistema.getInstancia().cambiarController(
						new DatosTicketEmpleadorController(empleador, vista.getTicketSeleccionado()));
				vista.setVisible(false);
			} else {
				JOptionPane.showMessageDialog(vista, "Seleccione un ticket");
			}
		}
	}

	private void setListaTickets() {
		ArrayList<TicketBusquedaEmpleado> tickets = new ArrayList<>();
		Iterator<TicketBusquedaEmpleado> it = empleador.getTickets();
		while (it.hasNext()) {
			tickets.add(it.next());
		}
		vista.setListaTickets(tickets);
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		TicketBusquedaEmpleado ticket = vista.getTicketSeleccionado();
		ArrayList<TicketBusquedaEmpleo> candidatos = new ArrayList<>();
		try {
			Iterator<TicketOrdenable> candidatosIt = Agencia.getInstancia().getListaAsignacion(ticket);
			while (candidatosIt.hasNext()) {
				candidatos.add((TicketBusquedaEmpleo) candidatosIt.next().getTicket());
			}
			vista.setListaCandidatos(candidatos);
		} catch (AgenciaInexistenteException e1) {
		} catch (TicketInexistenteException e1) {
//			JOptionPane.showMessageDialog(vista, "El ticket no posee una lista de asignacion");
			this.vista.limpiarListaTickets();
		}
	}
}
