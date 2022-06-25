package controladores;

import java.awt.event.ActionEvent;

import vista.EmpleadorVista;

public class EmpleadorController extends Controller {
	private EmpleadorVista vista;
	
	public EmpleadorController() {
		this.vista = new EmpleadorVista();
		vista.setActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
