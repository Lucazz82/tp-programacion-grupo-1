package modelos;

import enums.Rubros;

public class Empleador extends Usuario {

	private String nombre;
	private String tipoPersona;
	private Rubros rubro;
	
	public Empleador(String nombreUsuario, String contrasena,String nombre,String tipoPersona,Rubros rubro) {
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
	
	public Rubros getRubro() {
		return rubro;
	}

	
}
