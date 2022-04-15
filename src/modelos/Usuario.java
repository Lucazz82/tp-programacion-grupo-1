package modelos;

public abstract class Usuario {
	private String nombre;
	private String contrasena;
	private int puntaje;
	
	public Usuario(String nombre, String contrasena) {
		this.nombre = nombre;
		this.contrasena = contrasena;
		this.puntaje = 0;
	}

	public String getNombre() {
		return nombre;
	}

	public String getContrasena() {
		return contrasena;
	}

	public int getPuntaje() {
		return puntaje;
	}
}
