package modelos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import enums.Rubros;

public class Empleador extends Usuario {

	private String nombre;
	private String tipoPersona;
	private Rubros rubro;
	private HashMap<String, Double> pesos;
	private ArrayList<TicketBusquedaEmpleado> tickets = new ArrayList<TicketBusquedaEmpleado>();
	

	public Empleador(String nombreUsuario, String contrasena,String nombre,String tipoPersona,Rubros rubro) {
		super(nombreUsuario, contrasena);
		this.nombre = nombre;
		this.tipoPersona = tipoPersona;
		this.rubro = rubro;
		Agencia.getInstancia().agregarEmpleador(this);
	}
	
	public HashMap<String, Double> getPesos() {
		return pesos;
	}
	public void agregarTicket(TicketBusquedaEmpleado ticket) {
		this.tickets.add(ticket);
	}
	
	public Iterator<TicketBusquedaEmpleado> getTickets() {
		return tickets.iterator();
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
