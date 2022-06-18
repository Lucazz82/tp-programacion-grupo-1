package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.Login;

public class LoginController implements ActionListener {
	private Login vista;
	
	public LoginController() {
		this.vista = new Login();
		vista.setActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e);
	}
	
}
