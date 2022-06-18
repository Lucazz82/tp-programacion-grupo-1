package vista;

import java.awt.event.ActionListener;

import enums.TiposUsuario;

public interface IRegister {
	public String getUsuario();

	public String getContrasenia();

	public TiposUsuario getTipoUsuario();
}
