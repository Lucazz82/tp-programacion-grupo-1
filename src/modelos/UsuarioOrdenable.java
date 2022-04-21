package modelos;

import java.util.Objects;

public class UsuarioOrdenable implements Comparable<UsuarioOrdenable> {
	private Usuario usuario;
	private Double puntaje;
	
	public UsuarioOrdenable(Usuario usuario, double puntaje) {
		super();
		this.usuario = usuario;
		this.puntaje = puntaje;
	};
	
	/**
	 * Se agrega -1 para que se ordene de mayor a menor
	 */
	@Override
	public int compareTo(UsuarioOrdenable o) {
		return -1 * this.puntaje.compareTo(o.puntaje);
	}

}
