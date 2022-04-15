package modelos;

public class Empleador extends Usuario {

	private String nombre;
	private String tipoPersona;
	private String rubro;
	
	public Empleador(String nombreUsuario, String contrasena,String nombre,String tipoPersona,String rubro) {
		super(nombreUsuario, contrasena);
		this.nombre = nombre;
		this.tipoPersona = tipoPersona;
		this.rubro = rubro;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getTipoPersona() {
		return tipoPersona;
	}
	
	public String getRubro() {
		return rubro;
	}

	
}
