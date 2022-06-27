package controladores;

import java.awt.event.ActionEvent;

import enums.Remuneraciones;
import modelos.Empleador;
import modelos.Formulario;
import modelos.FormularioFactory;
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
		} else if (cmd.equalsIgnoreCase("comboBoxChanged")) {
			Remuneraciones remuneracion = this.vista.getRemuneracion();

			switch (remuneracion) {
			case ENTRE_V1_V2:
				this.vista.habilitarV1();
				this.vista.habilitarV2();
				break;
			case HASTA_V1:
				this.vista.habilitarV1();
				this.vista.desHabilitarV2();
				break;
			case MAS_DE_V2:
				this.vista.desHabilitarV1();
				this.vista.habilitarV2();
				break;
			default:
				break;
			}
		}
	}
}
