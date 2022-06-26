package controladores;

import java.awt.event.ActionEvent;

import modelos.Empleador;
import modelos.Formulario;
import modelos.FormularioFactory;
import modelos.TicketBusquedaEmpleado;
import vista.FormularioVista;

public class TicketEmpleadorController extends Controller<FormularioVista> {
	private Empleador empleador;

	public TicketEmpleadorController(Empleador empleador) {
		super(new FormularioVista());
		this.empleador = empleador;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();

		if (cmd.equalsIgnoreCase("Volver")) {
			Sistema.getInstancia().cambiarController(new EmpleadorController(empleador));
			vista.setVisible(false);
		} else if (cmd.equalsIgnoreCase("Crear Ticket")) {
			// Verificar que los campos no esten vacios
			Formulario formulario = FormularioFactory.getFormulario(vista.getLocacion(), vista.getRemuneracion(),
					vista.getV1(), vista.getV2(), vista.getCargaHoraria(), vista.getPuestoLaboral(),
					vista.getRangoEtario(), vista.getExperiencias(), vista.getEstudios(), vista.getRubro());
			Sistema.getInstancia().cambiarController(new PesosController(empleador, formulario));
			vista.setVisible(false);
		}
	}
}
