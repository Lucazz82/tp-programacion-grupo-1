package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

import excepciones.ContrasenaIncorrectaException;
import excepciones.UsuarioInexistenteException;
import modelos.Agencia;
import modelos.Usuario;
import vista.Login;

public class LoginController implements IController {
	private Login vista;

	public LoginController() {
		this.vista = new Login();
		vista.setActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();

		if (cmd.equalsIgnoreCase("Login")) {
			try {
				Usuario usuario = Agencia.getInstancia().buscarUsuario(vista.getUsuario());
				usuario.login(vista.getContrasenia());
			} catch (UsuarioInexistenteException | ContrasenaIncorrectaException e1) {
				JOptionPane.showMessageDialog(vista, "Usuario o contraseña incorrectos");
			}
		} else if (cmd.equalsIgnoreCase("Register")) {
			Sistema.getInstancia().cambiarController(new Register1Controller());
			vista.setVisible(false);
		}
	}

}
