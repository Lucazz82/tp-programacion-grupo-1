package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;

import excepciones.AgenciaInexistenteException;
import modelos.Agencia;
import modelos.EmpleadoPretenso;
import vista.EmpleadoVista;

public class EmpleadoController extends Controller<EmpleadoVista> implements FocusListener {
	private EmpleadoPretenso empleado;
	
	public EmpleadoController(EmpleadoPretenso empleado) {
		super(new EmpleadoVista());
		this.empleado = empleado;
		this.mostrarMensajes();
	}
	
	private void mostrarMensajes() {
		for(String s : this.empleado.getMensajes()) {
			JOptionPane.showMessageDialog(vista, s);	
		}
		
		this.empleado.vaciarMensajes();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equalsIgnoreCase("Suspender Ticket")) {
			this.empleado.getTicket().setSuspendido();
		} else if(e.getActionCommand().equalsIgnoreCase("Activar Ticket")) {
			this.empleado.getTicket().setActivo();
		} else if(e.getActionCommand().equalsIgnoreCase("Mostrar Ticket")) {
			Sistema.getInstancia().cambiarController(new DatosTicketEmpleadoController(empleado, empleado.getTicket()));
			vista.setVisible(false);
		} else if(e.getActionCommand().equalsIgnoreCase("Cambiar Ticket")) {
//			Sistema.getInstancia().cambiarController(new TicketEmpleadoController(this.empleado));
//			this.vista.setVisible(false);
		} else if(e.getActionCommand().equalsIgnoreCase("Elegir")) {
			this.vista.getTicketSeleccionado().setElegido(this.empleado.getTicket());
		} else if(e.getActionCommand().equalsIgnoreCase("Ticket Simplificado")) {
			Thread h = new Thread(this.empleado);
			h.start();
		}
		else if (e.getActionCommand().equalsIgnoreCase("Cerrar Sesión")) {
			Sistema.getInstancia().cambiarController(new LoginController());
			vista.setVisible(false);
		}
		this.mostrarMensajes();
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
