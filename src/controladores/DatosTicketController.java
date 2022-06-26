package controladores;

import java.awt.event.ActionEvent;

import modelos.Empleador;
import modelos.Formulario;
import modelos.TicketBusquedaEmpleado;
import vista.DatosTicket;

public class DatosTicketController extends Controller<DatosTicket> {
	private Empleador empleador;
	
	public DatosTicketController(Empleador empleador, TicketBusquedaEmpleado ticket) {
		super(new DatosTicket());
		this.empleador = empleador;
		
		Formulario formulario = ticket.getFormulario();
		
		vista.setLocacion(formulario.getLocacion().toString());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		
		if (cmd.equalsIgnoreCase("Volver")) {
			Sistema.getInstancia().cambiarController(new EmpleadorController(empleador));
			vista.setVisible(false);
		}
	}
}
