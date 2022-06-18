package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.Register2Empleador;

public class Register2EmpleadorController implements IController {
	private Register2Empleador vista;

	public Register2EmpleadorController() {
		this.vista = new Register2Empleador();
		vista.setActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

}
