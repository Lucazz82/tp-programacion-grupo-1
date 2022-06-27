package controladores;

import java.awt.event.ActionEvent;

import modelos.Empleador;
import modelos.Formulario;
import modelos.TicketBusquedaEmpleado;
import vista.DatosTicket;

public class DatosTicketEmpleadorController extends Controller<DatosTicket> {
	private Empleador empleador;
	
	public DatosTicketEmpleadorController(Empleador empleador, TicketBusquedaEmpleado ticket) {
		super(new DatosTicket());
		this.empleador = empleador;
		
		Formulario formulario = ticket.getFormulario();
		
		vista.setLocacion(formulario.getLocacion().toString());
		vista.setExperiencia(formulario.getExperiencia().toString());
		vista.setRubro(formulario.getRubro().toString());
		vista.setCargaHoraria(formulario.getCargaHoraria().toString());
		vista.setEstudio(formulario.getEstudio().toString());
		vista.setPuestoLaboral(formulario.getPuesto().toString());
		vista.setRemuneracion(formulario.getRemuneracion().toString());
		vista.setRangoEtario(formulario.getRangoEtario().toString());
		vista.setFecha(ticket.getFechaAlta().toString());
		vista.setElegido(ticket.getElegido() != null ? ticket.getElegido().toString() : "Ninguno");
		vista.setEstado(ticket.stringEstado());
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
