package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import excepciones.AgenciaInexistenteException;
import excepciones.TicketInexistenteException;
import modelos.Agencia;
import modelos.TicketBusquedaEmpleado;
import modelos.TicketBusquedaEmpleo;
import modelos.TicketOrdenable;
import vista.ListaDeAsignacionVista;

public class ListaDeAsignacionController extends Controller<ListaDeAsignacionVista> implements FocusListener {

	public ListaDeAsignacionController() {
		super(new ListaDeAsignacionVista());
		setListaTicketsEmpleadores();
		this.vista.setFocusListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equalsIgnoreCase("Volver")) {
			Sistema.getInstancia().cambiarController(new AgenciaController());
			this.vista.setVisible(false);
		} else if (e.getActionCommand().equalsIgnoreCase("Buscar")) {
			
		}
	}

	private void setListaTicketsEmpleadores() {
		ArrayList<TicketBusquedaEmpleado> ticketsBusquedaEmpleados = new ArrayList<>();
		HashMap<TicketBusquedaEmpleado, HashMap<TicketBusquedaEmpleo, Double>> listasAsignaciones = new HashMap<TicketBusquedaEmpleado, HashMap<TicketBusquedaEmpleo, Double>>();
		
		try {
			listasAsignaciones = Agencia.getInstancia().getListasAsignaciones();
		} catch (AgenciaInexistenteException e) {
			e.printStackTrace();
		}
		
		for (TicketBusquedaEmpleado ticketBusquedaEmpleado : listasAsignaciones.keySet()) {
			ticketsBusquedaEmpleados.add(ticketBusquedaEmpleado);
		}

		this.vista.setListaTicketsEmpleadores(ticketsBusquedaEmpleados);
	}

	@Override
	public void focusGained(FocusEvent e) {
		TicketBusquedaEmpleado ticket = (TicketBusquedaEmpleado) this.vista.getTicketSeleccionado();
		Iterator<TicketOrdenable> iterator = null;
		try {
			iterator = Agencia.getInstancia().getListaAsignacion(ticket);
		} catch (TicketInexistenteException e1) {
			this.vista.setListaTicketsEmpleados(new ArrayList<>());
			return;
		} catch (AgenciaInexistenteException e1) {
		}
		
		List<TicketOrdenable> actualList = new ArrayList<>();
		while (iterator.hasNext()) {
			actualList.add(iterator.next());
		}
		this.vista.setListaTicketsEmpleados(actualList);
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub

	}

}
