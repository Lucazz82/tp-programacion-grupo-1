package controladores;

import java.awt.event.ActionEvent;

import modelos.Empleador;
import vista.PesosEmpleadorVista;

public class PesosController extends Controller{

	private PesosEmpleadorVista vista;
	private Empleador empleador;
	
	public PesosController(Empleador empleador) {
		this.vista = new PesosEmpleadorVista();
		this.empleador = empleador;
		vista.setActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		
		if (cmd.equalsIgnoreCase("Siguiente")) {
			Sistema.getInstancia().cambiarController(null);
		}
		
	}

}
