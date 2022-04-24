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
	private HashMap<TicketBusquedaEmpleado, HashMap<TicketBusquedaEmpleo, Double>> listasAsignaciones=new HashMap<TicketBusquedaEmpleado, HashMap<TicketBusquedaEmpleo, Double>>();
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
					
					if(ticketEmpleado.getEstado() == EstadosTicket.ACTIVO && ticketEmpleador.getFormulario().getRubro() == ticketEmpleado.getFormulario().getRubro()) { 
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
	public Iterator<TicketOrdenable> getListaAsignacion(TicketBusquedaEmpleado ticketEmpleador) throws TicketInexistenteException {
		ArrayList<TicketOrdenable> cvs = new ArrayList<TicketOrdenable>();
		if(!listasAsignaciones.containsKey(ticketEmpleador))
			throw new TicketInexistenteException("El ticket no tiene una lista de asignacion", ticketEmpleador);
		
		HashMap<TicketBusquedaEmpleo, Double> puntajesTicket = listasAsignaciones.get(ticketEmpleador);
		
		for(Ticket cv : puntajesTicket.keySet()) {
			TicketOrdenable cvOrdenable = new TicketOrdenable(cv, puntajesTicket.get(cv));
			cvs.add(cvOrdenable);
		}
		
		cvs.sort(null);
		
		EmpleadoPretenso empleado = (EmpleadoPretenso) cvs.get(0).getTicket().getCreador();
		empleado.puntajePrimerLugar();
		empleado = (EmpleadoPretenso) cvs.get(cvs.size() - 1).getTicket().getCreador();
		empleado.puntajeUltimoLugar();
		
		return cvs.iterator();
	}
	
	public Iterator<TicketOrdenable> getListaAsignacion(TicketBusquedaEmpleo ticketEmpleado) throws TicketInexistenteException {
		ArrayList<TicketOrdenable> puestosLaborales = new ArrayList<TicketOrdenable>();
		
		for(Ticket puestoLaboral : listasAsignaciones.keySet()) {
			HashMap<TicketBusquedaEmpleo, Double> puntajesTicket = listasAsignaciones.get(puestoLaboral);
			
			if(puntajesTicket.containsKey(ticketEmpleado)) {
				TicketOrdenable puestoOrdenable = new TicketOrdenable(puestoLaboral, puntajesTicket.get(ticketEmpleado));
				puestosLaborales.add(puestoOrdenable);
			}
		}
		
		if(puestosLaborales.isEmpty()) {
			throw new TicketInexistenteException("El ticket no tiene una lista de asignacion", ticketEmpleado);
		}
		
		puestosLaborales.sort(null);
		
		Empleador empleador = (Empleador) puestosLaborales.get(0).getTicket().getCreador();
		empleador.puntajePrimerLugar();
		
		return puestosLaborales.iterator();
	}
		
	public void registrarUsuario(EmpleadoPretenso empleado) {
		this.empleados.add(empleado);
	}
	
	public void registrarUsuario(Empleador empleador) {
		this.empleadores.add(empleador);
	}

	public Iterator<EmpleadoPretenso> getEmpleados() {
		return empleados.iterator();
	}

	public Iterator<Empleador> getEmpleadores() {
		return empleadores.iterator();
	}

	
}
