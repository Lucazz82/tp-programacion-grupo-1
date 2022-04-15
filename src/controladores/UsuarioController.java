package controladores;

import excepciones.ContrasenaIncorrectaException;
import excepciones.UsuarioInexistenteException;
import modelos.Agencia;
import modelos.Usuario;

public class UsuarioController {
	public void Login(String nombreUsuario, String contrasena) {
		try {
			Usuario usuario = Agencia.getInstancia().buscarUsuario(nombreUsuario);
			usuario.login(contrasena);
		} catch(UsuarioInexistenteException e) {
			
		} catch(ContrasenaIncorrectaException e) {
			
		}
	}
}
