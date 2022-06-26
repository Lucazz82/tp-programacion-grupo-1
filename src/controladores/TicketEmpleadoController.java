package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

import enums.Locaciones;
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
		if(e.getActionCommand().equalsIgnoreCase("Crear Ticket")) {
			IComision comision = PuestoLaboralFactory.getPuestoLaboral(this.vista.getPuestoLaboral(), empleado);
			Formulario formulario = FormularioFactory.getFormulario(this.vista.getLocacion(), this.vista.getRemuneracion(), this.vista.getV1(), this.vista.getV2(), this.vista.getCargaHoraria(), this.vista.getPuestoLaboral(), this.vista.getRangoEtario(), this.vista.getExperiencias(), this.vista.getEstudios(), this.vista.getRubro());
			TicketBusquedaEmpleo ticket = new TicketBusquedaEmpleo(empleado, formulario, comision);
			empleado.setTicket(ticket);
			JOptionPane.showMessageDialog(vista, "Ticket creado con exito");
			Sistema.getInstancia().cambiarController(new LoginController());
			this.vista.setVisible(false);
			
		}
	}



	@Override
	public void windowOpened(WindowEvent e) {
		JOptionPane.showMessageDialog(vista, "Cree un ticket para finalizar el registro del usuario");
	}
	
	

}
