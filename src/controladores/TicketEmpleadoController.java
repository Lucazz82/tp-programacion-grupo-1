package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

import enums.Locaciones;
import enums.Remuneraciones;
import modelos.EmpleadoPretenso;
import modelos.Formulario;
import modelos.FormularioFactory;
import modelos.IComision;
import modelos.TicketBusquedaEmpleo;
import modelos.aspectos.factories.PuestoLaboralFactory;
import vista.FormularioVista;

public class TicketEmpleadoController extends Controller<FormularioVista> {
	private EmpleadoPretenso empleado;

	public TicketEmpleadoController(EmpleadoPretenso empleado) {
		super(new FormularioVista());
		this.empleado = empleado;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equalsIgnoreCase("Crear Ticket")) {
			IComision comision = PuestoLaboralFactory.getPuestoLaboral(this.vista.getPuestoLaboral(), empleado);
			Formulario formulario = FormularioFactory.getFormulario(this.vista.getLocacion(),
					this.vista.getRemuneracion(), this.vista.getV1(), this.vista.getV2(), this.vista.getCargaHoraria(),
					this.vista.getPuestoLaboral(), this.vista.getRangoEtario(), this.vista.getExperiencias(),
					this.vista.getEstudios(), this.vista.getRubro());
			TicketBusquedaEmpleo ticket = new TicketBusquedaEmpleo(empleado, formulario, comision);
			empleado.setTicket(ticket);
			JOptionPane.showMessageDialog(vista, "Ticket creado con exito");
			Sistema.getInstancia().cambiarController(new LoginController());
			this.vista.setVisible(false);

		} else if (e.getActionCommand().equalsIgnoreCase("comboBoxChanged")) {
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

	@Override
	public void windowOpened(WindowEvent e) {
		JOptionPane.showMessageDialog(vista, "Cree un ticket para finalizar el registro del usuario");
	}

}
