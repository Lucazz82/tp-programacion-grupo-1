package controladores;

import java.awt.event.ActionEvent;

import modelos.Empleador;
import modelos.Formulario;
import modelos.TicketBusquedaEmpleado;
import vista.PesosEmpleadorVista;

public class PesosController extends Controller<PesosEmpleadorVista> {
	private Empleador empleador;
	private Formulario formulario;

	public PesosController(Empleador empleador, Formulario formulario) {
		super(new PesosEmpleadorVista());
		this.empleador = empleador;
		this.formulario = formulario;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();

		if (cmd.equalsIgnoreCase("Siguiente")) {
			double pesos[] = { vista.getLocacion(), vista.getRemuneracion(), vista.getCargaHoraria(), vista.getPuesto(),
					vista.getRangoEtario(), vista.getExperiencia(), vista.getEstudios() };

			this.empleador.agregarTicket(new TicketBusquedaEmpleado(empleador, formulario, pesos));
			Sistema.getInstancia().cambiarController(new EmpleadorController(empleador));
			vista.setVisible(false);
		}
	}

}
