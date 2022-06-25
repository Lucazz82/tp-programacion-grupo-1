package controladores;

import java.awt.event.ActionEvent;

import vista.Register2Empleador;

public class Register2EmpleadorController extends Controller {
	private Register2Empleador vista;

	public Register2EmpleadorController() {
		this.vista = new Register2Empleador();
		vista.setActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

}
