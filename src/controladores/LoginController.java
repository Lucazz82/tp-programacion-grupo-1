package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

import javax.swing.JOptionPane;

import excepciones.ContrasenaIncorrectaException;
import excepciones.UsuarioInexistenteException;
import modelos.Agencia;
import modelos.Usuario;
import persistencia.AgenciaDTO;
import persistencia.IPersistencia;
import persistencia.PersistenciaBIN;
import persistencia.UtilDTO;
import vista.Login;

public class LoginController implements IController, WindowListener {
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
				Usuario usuario = Agencia.getInstancia().buscarUsuario(vista.getUsuario());
				usuario.login(vista.getContrasenia());
				JOptionPane.showMessageDialog(vista, "Usuario logueado");
			} catch (UsuarioInexistenteException | ContrasenaIncorrectaException e1) {
				JOptionPane.showMessageDialog(vista, "Usuario o contraseña incorrectos");
			}
		} else if (cmd.equalsIgnoreCase("Register")) {
			Sistema.getInstancia().cambiarController(new Register1Controller());
			vista.setVisible(false);
		}
	}

	@Override
	public void windowOpened(WindowEvent e) {
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		IPersistencia<AgenciaDTO> persistencia = new PersistenciaBIN<AgenciaDTO>();	
		try {
			persistencia.persistir("datos.bin", UtilDTO.agenciaDTOFromAgencia());
		} catch (IOException e1) {
			System.out.println("Error al persistir");
		}
	}

	@Override
	public void windowClosed(WindowEvent e) {
		System.out.println("Me cerre");	
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

}
