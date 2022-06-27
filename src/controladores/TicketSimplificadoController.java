package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import enums.Locaciones;
import enums.Rubros;
import modelos.Empleador;
import modelos.TicketSimplificado;
import vista.TicketSimplificadoVista;

public class TicketSimplificadoController extends Controller<TicketSimplificadoVista> implements ActionListener {
	private Empleador empleador;
	private Rubros rubro;
	private Locaciones locacion;

	public TicketSimplificadoController(Empleador e) {
		super(new TicketSimplificadoVista());
		this.empleador = e;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equalsIgnoreCase("Crear Ticket")) {
			TicketSimplificado ticket;

			this.rubro = this.vista.getRubro();
			this.locacion = this.vista.getLocacion();

			ticket = new TicketSimplificado(this.empleador, this.locacion, this.rubro);
			this.empleador.agregarTicketSimplificado(ticket);
			Thread h = new Thread(this.empleador);
			h.start();
			Sistema.getInstancia().cambiarController(new EmpleadorController(this.empleador));
			this.vista.setVisible(false);
		} else if (e.getActionCommand().equalsIgnoreCase("Volver")) {
			Sistema.getInstancia().cambiarController(new EmpleadorController(this.empleador));
			this.vista.setVisible(false);
		}

	}

}
