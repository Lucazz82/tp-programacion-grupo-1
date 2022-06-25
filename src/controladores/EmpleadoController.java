package controladores;

import java.awt.event.ActionEvent;

import vista.EmpleadoVista;

public class EmpleadoController extends Controller{
	private EmpleadoVista vista;

	public EmpleadoController() {
		this.vista = new EmpleadoVista();
		vista.setActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equalsIgnoreCase("Suspender Ticket")) {
			
		}else if(e.getActionCommand().equalsIgnoreCase("Activar Ticket")) {
			
		}else if(e.getActionCommand().equalsIgnoreCase("Mostrar Ticket")) {
			
		}else if(e.getActionCommand().equalsIgnoreCase("Cambiar Ticket")) {
			
		}else if(e.getActionCommand().equalsIgnoreCase("Elegir Ganador")) {
			
		}else if(e.getActionCommand().equalsIgnoreCase("Elegir")) {
			
		}else if(e.getActionCommand().equalsIgnoreCase("Ticket Simplificado")) {
			
		}
		
		
	}
	
	
	
}
