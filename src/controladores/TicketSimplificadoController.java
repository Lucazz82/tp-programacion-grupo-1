package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import enums.Locaciones;
import enums.Rubros;
import excepciones.AgenciaInexistenteException;
import modelos.Agencia;
import modelos.Empleador;
import modelos.TicketSimplificado;
import vista.TicketSimplificadoVista;

public class TicketSimplificadoController extends Controller implements ActionListener {
	
	private TicketSimplificadoVista vista;
	private Empleador empleador;
	private Rubros rubro;
	private Locaciones locacion;
	
	public TicketSimplificadoController(Empleador e) {
		this.vista = new TicketSimplificadoVista();
		this.vista.setActionListener(this);
		this.empleador = e;		
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equalsIgnoreCase("Crear Ticket")){
			TicketSimplificado ticket;
			
			this.rubro = this.vista.getRubro();
			this.locacion = this.vista.getLocacion();
			
			ticket= new TicketSimplificado(this.empleador, this.locacion, this.rubro);
			
			try {
				Agencia.getInstancia().agregarTicketABolsa(ticket);
			} catch (AgenciaInexistenteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
	}

}
