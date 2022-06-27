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
		
		ArrayList<TicketBusquedaEmpleado> tickets = new ArrayList<>();
		Iterator<TicketOrdenable> it = null;
		try {
			it = Agencia.getInstancia().getListaAsignacion(empleado.getTicket());
		} catch (TicketInexistenteException | AgenciaInexistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while (it.hasNext()) {
			tickets.add((TicketBusquedaEmpleado)it.next().getTicket());
		}
		
		this.vista.setListaEmpleadores(tickets);
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
			this.vista.getTicketSeleccionado().setElegido(this.empleado.getTicket());
		} else if (e.getActionCommand().equalsIgnoreCase("Mostrar Ticket")) {
			Sistema.getInstancia().cambiarController(new DatosTicketEmpleadoController(empleado, this.empleado.getTicket()));
			vista.setVisible(false);
		} else if (e.getActionCommand().equalsIgnoreCase("Ticket Simplificado")) {
			Thread h = new Thread(this.empleado);
			h.start();
		} else if (e.getActionCommand().equalsIgnoreCase("Cerrar Sesión")) {
			Sistema.getInstancia().cambiarController(new LoginController());
			vista.setVisible(false);
		}
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
