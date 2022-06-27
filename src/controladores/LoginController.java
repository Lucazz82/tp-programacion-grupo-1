package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

import excepciones.AgenciaInexistenteException;
import excepciones.ContrasenaIncorrectaException;
import excepciones.UsuarioInexistenteException;
import modelos.Agencia;
import modelos.EmpleadoPretenso;
import modelos.Empleador;
import modelos.Logueable;
import modelos.Usuario;
import vista.Login;

public class LoginController extends Controller<Login> {
	
	public LoginController() {
		super(new Login());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();

		if (cmd.equalsIgnoreCase("Login")) {
			try {
				Controller controller = null;
				
				switch (vista.getTipoUsuario()) {
				case AGENCIA:
					Agencia.getInstancia().login(vista.getContrasenia());
					controller = new AgenciaController();
					break;
				case EMPLEADO:
					EmpleadoPretenso empleado = Agencia.getInstancia().buscarEmpleado(vista.getUsuario());
					empleado.login(vista.getContrasenia());
					controller = new EmpleadoController(empleado);
					break;
				case EMPLEADOR:
					Empleador empleador = Agencia.getInstancia().buscarEmpleador(vista.getUsuario());
					empleador.login(vista.getContrasenia());
					controller = new EmpleadorController(empleador);
					break;
				default:
					break;
				}
				
				Sistema.getInstancia().cambiarController(controller);
				
				vista.setVisible(false);
				
			} catch (UsuarioInexistenteException | ContrasenaIncorrectaException | ClassCastException e1) {
				JOptionPane.showMessageDialog(vista, "Usuario o contraseña incorrectos");
			} catch (AgenciaInexistenteException e1) {
				JOptionPane.showMessageDialog(vista, "Primero se debe crear una agencia");
			} 
			
		} else if (cmd.equalsIgnoreCase("Register")) {
			Sistema.getInstancia().cambiarController(new Register1Controller());
			vista.setVisible(false);
		} else if (cmd.equalsIgnoreCase("")) {
			this.vista.intercambiarContrasenia();
		}
	}
}
