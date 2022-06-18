package vista;

import java.awt.event.ActionListener;

public interface ILogin {
	public void setActionListener(ActionListener actionListener);
	public String getUsuario();
	public String getContrasenia();
}
