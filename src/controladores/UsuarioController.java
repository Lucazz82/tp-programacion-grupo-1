package controladores;

import excepciones.ContrasenaIncorrectaException;
import excepciones.UsuarioInexistenteException;
import modelos.Agencia;
import modelos.EmpleadoPretenso;
import modelos.Usuario;

public class UsuarioController {
	public void login(String nombreUsuario, String contrasena) {
		try {
			Usuario usuario = Agencia.getInstancia().buscarUsuario(nombreUsuario);
			usuario.login(contrasena);
		} catch (UsuarioInexistenteException e) {

		} catch (ContrasenaIncorrectaException e) {

		}
	}

	public void registrarEmpleado(String nombreUsuario, String contrasena) {
		Agencia.getInstancia().registrarUsuario(new EmpleadoPretenso(nombreUsuario, contrasena));
	}
}
