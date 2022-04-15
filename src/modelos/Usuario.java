package modelos;

public abstract class Usuario {
	private String nombreUsuario;
	private String contrasena;
	private int puntaje;
	
	public Usuario(String nombreUsuario, String contrasena) {
		this.nombreUsuario = nombreUsuario;
		this.contrasena = contrasena;
		this.puntaje = 0;
	}

	public String getnombreUsuario() {
		return nombreUsuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public int getPuntaje() {
		return puntaje;
	}

	@Override
	public String toString() {
		return "nombreUsuario=" + nombreUsuario + ", contrasena=" + contrasena + ", puntaje=" + puntaje;
	}
}
