package modelos;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

import excepciones.UsuarioInexistenteException;

public class Agencia {
	private static Agencia _instancia=null;
	private ArrayList<EmpleadoPretenso> empleados = new ArrayList<EmpleadoPretenso>();
	private ArrayList<Empleador> empleadores = new ArrayList<Empleador>();
	
	private HashMap<TicketEmpleo, HashMap<TicketEmpleado, Double>> listasAsignaciones;
	private Date fechaLista;
	
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
	
//	public void generarListaAsignacion() {
//		for(Empleador empleador : this.empleadores) {
//			for(EmpleadoPretenso empleado : this.empleados) {
//				
//				if(!listasAsignaciones.containsKey(empleador)) {
//					listasAsignaciones.put(empleador, new HashMap<EmpleadoPretenso, Double>());
//				}
//				
//				listasAsignaciones.get(empleador).put(empleado, 1.0);// Puntaje
//				
//			}
//		}
//		
//		this.fechaLista = new Date();
//	}
	
	public void generarListaEmpleador(Empleador empleador) {
		Iterator<Ticket> ticketsEmpleador = empleador.getTickets();
		while(ticketsEmpleador.hasNext()) {
			Ticket ticketEmpleador= ticketsEmpleador.next();
			
			for(EmpleadoPretenso empleado : this.empleados) {
				Iterator<Ticket> ticketsEmpleado = empleado.getTickets();
				while(ticketsEmpleado.hasNext()) {
					Ticket ticketEmpleado = ticketsEmpleado.next();
					double puntaje = ticketEmpleador.enfrentar(ticketEmpleado);
				}
			}
		}
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
