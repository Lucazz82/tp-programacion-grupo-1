package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.Register1;

public class RegisterController implements ActionListener, IController {
	private Register1 vista;
	
	public RegisterController() {
		this.vista = new Register1();
		vista.setActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e);
		System.out.println(vista.getUsuario());
		System.out.println(vista.getContrasenia());
		System.out.println(vista.getTipoUsuario());
	}
}
