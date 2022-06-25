package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

import excepciones.AgenciaInexistenteException;
import excepciones.ContrasenaIncorrectaException;
import excepciones.UsuarioInexistenteException;
import modelos.Agencia;
import modelos.Logueable;
import modelos.Usuario;
import vista.Login;

public class LoginController extends Controller {
	private Login vista;

	public LoginController() {
		this.vista = new Login();
		vista.setActionListener(this);
		vista.setWindowListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();

		if (cmd.equalsIgnoreCase("Login")) {
			try {
				Logueable usuario = Agencia.getInstancia().buscarUsuario(vista.getUsuario());
				usuario.login(vista.getContrasenia());
				vista.setVisible(false);
//				JOptionPane.showMessageDialog(vista, "Usuario logueado");
			} catch (UsuarioInexistenteException | ContrasenaIncorrectaException e1) {
				JOptionPane.showMessageDialog(vista, "Usuario o contraseña incorrectos");
			} catch (AgenciaInexistenteException e1) {
				JOptionPane.showMessageDialog(vista, "Primero se debe crear una agencia");
			}
			
		} else if (cmd.equalsIgnoreCase("Register")) {
			Sistema.getInstancia().cambiarController(new Register1Controller());
			vista.setVisible(false);
		}
	}
}
