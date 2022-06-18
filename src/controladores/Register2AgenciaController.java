package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.Register2Agencia;

public class Register2AgenciaController implements ActionListener, IController {
	private Register2Agencia vista;

	public Register2AgenciaController() {
		this.vista = new Register2Agencia();
		vista.setActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}
}
