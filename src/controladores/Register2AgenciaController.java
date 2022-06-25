package controladores;

import java.awt.event.ActionEvent;

import vista.Register2Agencia;

public class Register2AgenciaController extends Controller {
	private Register2Agencia vista;

	public Register2AgenciaController() {
		this.vista = new Register2Agencia();
		vista.setActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}
}
