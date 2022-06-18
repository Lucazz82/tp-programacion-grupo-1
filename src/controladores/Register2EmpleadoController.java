package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.Register2Empleado;

public class Register2EmpleadoController implements IController {
	private Register2Empleado vista;

	public Register2EmpleadoController() {
		this.vista = new Register2Empleado();
		vista.setActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

}
