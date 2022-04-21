package modelos;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.SortedMap;
import java.util.TreeSet;

import enums.EstadosTicket;
import excepciones.TicketInexistenteException;
import excepciones.UsuarioInexistenteException;

public class Agencia {
	private static Agencia _instancia=null;
	private ArrayList<EmpleadoPretenso> empleados = new ArrayList<EmpleadoPretenso>();
	private ArrayList<Empleador> empleadores = new ArrayList<Empleador>();
	
	/**
	 * Matriz de puntajes para cada par TicketBusquedaEmpleado y TicketBusquedaEmpleo.<br>
	 * Tiene indice con significado.
	 */
	private HashMap<TicketBusquedaEmpleado, HashMap<TicketBusquedaEmpleo, Double>> listasAsignaciones;
//	private HashMap<Empleador, HashMap<EmpleadoPretenso, Double>> listasAsignaciones;
	private GregorianCalendar fechaLista;
	
	private Agencia() {
		
	}
	
	public static Agencia getInstancia() {
		if (_instancia == null)
			_instancia=new Agencia();
		return _instancia;
	}
	
//	public Usuario buscarUsuario(String nombreUsuario) throws UsuarioInexistenteException {
//		ArrayList<Usuario> usuarios = (ArrayList<Usuario>) empleados.clone();
//		usuarios.addAll(empleadores);
//		
//		int i = 0;		
//		Usuario usuario = usuarios.get(i);
//		while(i < usuarios.size() && usuario.getnombreUsuario().equals(nombreUsuario)) {
//			i++;
//			usuario = usuarios.get(i);
//		}
//		
//		if(i < usuarios.size()) {			
//			return usuario;
//		} else {
//			throw new UsuarioInexistenteException(nombreUsuario + " no existe");
//		}
//	}
	
	public Usuario buscarUsuario(String nombreUsuario) throws UsuarioInexistenteException {
		ArrayList<Usuario> usuarios = (ArrayList<Usuario>) empleados.clone();
		usuarios.addAll(empleadores);
		
		for(Usuario usuario : usuarios) {
			if(usuario.getnombreUsuario().equals(nombreUsuario)) {
				return usuario;
			}
		}
		
		throw new UsuarioInexistenteException(nombreUsuario + " no existe");
	}
	
	public void generarListaAsignacion() {
		for(Empleador empleador : this.empleadores) {
			this.generarListaEmpleador(empleador);
		}
		this.fechaLista = new GregorianCalendar();
	}
	
	/**
	 * Genera todos los puntajes de los tickets de un empleador. <br>
	 * @param empleador empleador cuyos tickets van a ser enfrentados.
	 */
	public void generarListaEmpleador(Empleador empleador) {
		Iterator<TicketBusquedaEmpleado> ticketsEmpleador = empleador.getTickets();
		while(ticketsEmpleador.hasNext()) {
			TicketBusquedaEmpleado ticketEmpleador = ticketsEmpleador.next();
			if(ticketEmpleador.getEstado() == EstadosTicket.ACTIVO) {
				listasAsignaciones.put(ticketEmpleador, new HashMap<TicketBusquedaEmpleo, Double>());
				
				for(EmpleadoPretenso empleado : this.empleados) {				
					TicketBusquedaEmpleo ticketEmpleado = empleado.getTicket();
					
					if(ticketEmpleador.getFormulario().getRubro() == ticketEmpleado.getFormulario().getRubro() && ticketEmpleado.getEstado() == EstadosTicket.ACTIVO) { 
						double puntaje = ticketEmpleador.enfrentar(ticketEmpleado);
						listasAsignaciones.get(ticketEmpleador).put(ticketEmpleado, puntaje);
					}
				}
			}
		}
	}
	
	/**
	 * <b>Pre: </b> El ticket no es null. <br>
	 * 
	 * @param ticketEmpleador el ticket del que se desea obtener su lista de asignacion. <br>
	 * @throws TicketInexistenteException cuando el ticket no posee una lista de asignacion. <br>
	 * @return un iterator de los empleados ordenados por su puntaje de forma descendente.
	 */
	public Iterator<UsuarioOrdenable> getListaAsignacion(TicketBusquedaEmpleado ticketEmpleador) throws TicketInexistenteException {
		ArrayList<UsuarioOrdenable> empleados = new ArrayList<UsuarioOrdenable>();
		HashMap<TicketBusquedaEmpleo, Double> puntajesTicket = listasAsignaciones.get(ticketEmpleador);
		
		if(puntajesTicket == null) {
			throw new TicketInexistenteException("Este ticket no posee una lista de asignacion");
		}
		
		for(TicketBusquedaEmpleo ticket : puntajesTicket.keySet()) {
			UsuarioOrdenable usuario = new UsuarioOrdenable(ticket.getCreador(), puntajesTicket.get(ticket));
			empleados.add(usuario);
		}
		empleados.sort(null);
		return empleados.iterator();
	}
	
	public Iterator<UsuarioOrdenable> getListaAsignacion(TicketBusquedaEmpleo ticketEmpleado) throws TicketInexistenteException {
		ArrayList<UsuarioOrdenable> empleadores = new ArrayList<UsuarioOrdenable>();
		HashMap<TicketBusquedaEmpleado, Double> puntajesTicket = new HashMap<TicketBusquedaEmpleado, Double>();
		
		try {
			for(TicketBusquedaEmpleado ticket : listasAsignaciones.keySet()) {
				double puntaje = listasAsignaciones.get(ticket).get(ticketEmpleado);
				puntajesTicket.put(ticket, puntaje);
			}			
		} catch(NullPointerException e) {
			throw new TicketInexistenteException("Este ticket no posee una lista de asignacion");
		}
		
		
		for(TicketBusquedaEmpleado ticket : puntajesTicket.keySet()) {
			UsuarioOrdenable usuario = new UsuarioOrdenable(ticket.getCreador(), puntajesTicket.get(ticket));
			empleadores.add(usuario);
		}
		empleadores.sort(null);
		return empleadores.iterator();
	}
	
	public void agregarEmpleado(EmpleadoPretenso empleado) {
		this.empleados.add(empleado);
	}
	
	public void agregarEmpleador(Empleador empleador) {
		this.empleadores.add(empleador);
	}

	public Iterator<EmpleadoPretenso> getEmpleados() {
		return empleados.iterator();
	}

	public Iterator<Empleador> getEmpleadores() {
		return empleadores.iterator();
	}

	
}
