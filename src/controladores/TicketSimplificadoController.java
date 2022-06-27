package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import enums.Locaciones;
import enums.Rubros;
import excepciones.AgenciaInexistenteException;
import modelos.Agencia;
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
		if (e.getActionCommand().equalsIgnoreCase("Crear Ticket")){
			TicketSimplificado ticket;
			
			this.rubro = this.vista.getRubro();
			this.locacion = this.vista.getLocacion();
			
			ticket= new TicketSimplificado(this.empleador, this.locacion, this.rubro);
//			
//			try {
//				Agencia.getInstancia().agregarTicketABolsa(ticket);
//				JOptionPane.showMessageDialog(vista, "Ticket creado �xito");
//			} catch (AgenciaInexistenteException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
			this.empleador.agregarTicketSimplificado(ticket);
			Thread h = new Thread(this.empleador);
			h.start();
			
		} else if(e.getActionCommand().equalsIgnoreCase("Volver")) {
			Sistema.getInstancia().cambiarController(new EmpleadorController(this.empleador));
			this.vista.setVisible(false);
		}
		
	}

}
