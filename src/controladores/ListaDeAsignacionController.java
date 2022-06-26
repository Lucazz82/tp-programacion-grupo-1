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

public class ListaDeAsignacionController extends Controller<ListaDeAsignacionVista> implements FocusListener{
	
	
	
	

	public ListaDeAsignacionController() {
		super(new ListaDeAsignacionVista());
		this.vista.setFocusListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equalsIgnoreCase("Volver")) {
			Sistema.getInstancia().cambiarController(new AgenciaController());
			this.vista.setVisible(false);
		}
		
	}
	
	private void setListaTicketsEmpleadores() throws AgenciaInexistenteException {
		ArrayList<TicketBusquedaEmpleado> ticketsBusquedaEmpleados = new ArrayList<>();
		HashMap<TicketBusquedaEmpleado, HashMap<TicketBusquedaEmpleo, Double>> listasAsignaciones = new HashMap<TicketBusquedaEmpleado, HashMap<TicketBusquedaEmpleo, Double>>();
		listasAsignaciones = Agencia.getInstancia().getListasAsignaciones();
		ticketsBusquedaEmpleados = (ArrayList<TicketBusquedaEmpleado>) listasAsignaciones.keySet();
		
		this.vista.setListaTicketsEmpleadores(ticketsBusquedaEmpleados);
	}
	
	@Override
	public void focusGained(FocusEvent e){
		TicketBusquedaEmpleado ticket = (TicketBusquedaEmpleado)this.vista.getTicketSeleccionado();
		Iterator<TicketOrdenable> iterator = null;
		try {
			iterator = Agencia.getInstancia().getListaAsignacion(ticket);
		} catch (TicketInexistenteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (AgenciaInexistenteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
