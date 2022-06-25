package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JOptionPane;

import modelos.EmpleadoPretenso;
import vista.EmpleadoVista;

public class EmpleadoController extends Controller implements FocusListener{
	private EmpleadoVista vista;
	private EmpleadoPretenso empleado;

	public EmpleadoController(EmpleadoPretenso empleado) {
		this.vista = new EmpleadoVista();
		this.empleado = empleado;
		vista.setActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equalsIgnoreCase("Suspender Ticket")) {
			this.empleado.getTicket().setSuspendido();
		}else if(e.getActionCommand().equalsIgnoreCase("Activar Ticket")) {
			this.empleado.getTicket().setActivo();
		}else if(e.getActionCommand().equalsIgnoreCase("Mostrar Ticket")) {
			JOptionPane.showMessageDialog(vista, this.empleado.getTicket().toString());
		}else if(e.getActionCommand().equalsIgnoreCase("Cambiar Ticket")) {
			Sistema.getInstancia().cambiarController(new TicketEmpleadoController(this.empleado));
			this.vista.setVisible(false);
		}else if(e.getActionCommand().equalsIgnoreCase("Elegir")) {
			this.vista.getTicketSeleccionado().setElegido(this.empleado.getTicket());
		}else if(e.getActionCommand().equalsIgnoreCase("Ticket Simplificado")) {
			
		}
	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
