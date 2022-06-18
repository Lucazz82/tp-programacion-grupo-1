package vista;

import enums.TiposUsuario;

public interface IRegister {
	public String getUsuario();

	public String getContrasenia();

	public TiposUsuario getTipoUsuario();
}
