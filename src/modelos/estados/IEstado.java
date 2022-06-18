package modelos.estados;

import modelos.Usuario;

public interface IEstado {
	public void setActivo();

	public void setSuspendido();

	public void setCancelado();

	public void setFinalizado();

	public Usuario getCreador();

	public boolean esActivo();
}
