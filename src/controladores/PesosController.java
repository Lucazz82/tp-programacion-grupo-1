package controladores;

import java.awt.event.ActionEvent;

import modelos.Empleador;
import vista.PesosEmpleadorVista;

public class PesosController extends Controller<PesosEmpleadorVista> {
	private Empleador empleador;
	
	public PesosController(Empleador empleador) {
		super(new PesosEmpleadorVista());
		this.empleador = empleador;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		
		if (cmd.equalsIgnoreCase("Siguiente")) {
			Sistema.getInstancia().cambiarController(null);
		}
		
	}

}
