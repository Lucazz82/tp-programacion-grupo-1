package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.Register1;

public class Register1Controller implements IController {
	private Register1 vista;

	public Register1Controller() {
		this.vista = new Register1();
		vista.setActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e);
		System.out.println(vista.getUsuario());
		System.out.println(vista.getContrasenia());
		System.out.println(vista.getTipoUsuario());

		IController controller = null;

		switch (vista.getTipoUsuario()) {
		case AGENCIA:
			controller = new Register2AgenciaController();
			break;
		case EMPLEADO:
			controller = new Register2EmpleadoController();
			break;
		case EMPLEADOR:
			controller = new Register2EmpleadorController();
			break;
		default:
			break;
		}

		Sistema.getInstancia().cambiarController(controller);
		vista.setVisible(false);
	}
}
