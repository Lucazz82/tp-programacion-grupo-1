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
import modelos.EmpleadoPretenso;
import modelos.TicketBusquedaEmpleado;
import modelos.TicketOrdenable;
import vista.EmpleadoVista;

public class EmpleadoController extends Controller<EmpleadoVista> implements FocusListener {
	private EmpleadoPretenso empleado;

	public EmpleadoController(EmpleadoPretenso empleado) {
		super(new EmpleadoVista());
		this.empleado = empleado;
		this.vista.setPuntaje(empleado.getPuntaje());

		ArrayList<TicketOrdenable> tickets = new ArrayList<>();
		Iterator<TicketOrdenable> it = null;
		try {
			it = Agencia.getInstancia().getListaAsignacion(empleado.getTicket());
			while (it.hasNext()) {
				tickets.add(it.next());
			}
		} catch (AgenciaInexistenteException e) {
		} catch (TicketInexistenteException e) {
			JOptionPane.showMessageDialog(vista, "El ticket no tiene lista de asignacion");
		}

		this.vista.setListaEmpleadores(tickets);
		this.mostrarMensajes();
	}

	private void mostrarMensajes() {
		for (String s : this.empleado.getMensajes()) {
			JOptionPane.showMessageDialog(vista, s);
		}

		this.empleado.vaciarMensajes();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equalsIgnoreCase("Suspender Ticket")) {
			this.empleado.getTicket().setSuspendido();
			JOptionPane.showMessageDialog(vista, "Ticket suspendido con éxito");

		} else if (e.getActionCommand().equalsIgnoreCase("Activar Ticket")) {
			this.empleado.getTicket().setActivo();
			JOptionPane.showMessageDialog(vista, "Ticket activado con éxito");

		} else if (e.getActionCommand().equalsIgnoreCase("Elegir")) {
			this.empleado.getTicket().setElegido((TicketBusquedaEmpleado) this.vista.getTicketSeleccionado().getTicket());
			JOptionPane.showMessageDialog(vista, "Ticket elegido con éxito");

		} else if (e.getActionCommand().equalsIgnoreCase("Mostrar Ticket")) {
			Sistema.getInstancia()
					.cambiarController(new DatosTicketEmpleadoController(empleado, this.empleado.getTicket()));
			vista.setVisible(false);

		} else if (e.getActionCommand().equalsIgnoreCase("Ticket Simplificado")) {
			Thread h = new Thread(this.empleado);
			h.start();
		} else if (e.getActionCommand().equalsIgnoreCase("Cerrar Sesión")) {
			Sistema.getInstancia().cambiarController(new LoginController());
			vista.setVisible(false);
		}
		this.mostrarMensajes();
	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
	}

}
