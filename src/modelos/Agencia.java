package modelos;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;

import enums.EstadosTicket;
import excepciones.TicketInexistenteException;
import excepciones.UsuarioInexistenteException;

public class Agencia {
	private static Agencia _instancia = null;

	private ArrayList<EmpleadoPretenso> empleados = new ArrayList<EmpleadoPretenso>();
	private ArrayList<Empleador> empleadores = new ArrayList<Empleador>();
	private HashMap<TicketBusquedaEmpleado, HashMap<TicketBusquedaEmpleo, Double>> listasAsignaciones = new HashMap<TicketBusquedaEmpleado, HashMap<TicketBusquedaEmpleo, Double>>();
	private ArrayList<Coincidencia> coincidencias = new ArrayList<Coincidencia>();
	private GregorianCalendar fechaLista;

	private Agencia() {

	}

	public static Agencia getInstancia() {
		if (_instancia == null)
			_instancia = new Agencia();
		return _instancia;
	}

	public Logueable buscarUsuario(String nombreUsuario) throws UsuarioInexistenteException {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios.addAll(empleados);
		usuarios.addAll(empleadores);

		for (Usuario usuario : usuarios) {
			if (usuario.getnombreUsuario().equals(nombreUsuario)) {
				return usuario;
			}
		}

		throw new UsuarioInexistenteException(nombreUsuario + " no existe");
	}

	public void generarListasAsignacion() {
		for (Empleador empleador : this.empleadores) {
			this.generarListaEmpleador(empleador);
		}
		this.fechaLista = new GregorianCalendar();
	}

	/**
	 * Genera todos los puntajes de los tickets de un empleador. <br>
	 * 
	 * @param empleador empleador cuyos tickets van a ser enfrentados.
	 */
	public void generarListaEmpleador(Empleador empleador) {
		Iterator<TicketBusquedaEmpleado> ticketsEmpleador = empleador.getTickets();
		while (ticketsEmpleador.hasNext()) {
			TicketBusquedaEmpleado ticketEmpleador = ticketsEmpleador.next();
			if (ticketEmpleador.getEstado() == EstadosTicket.ACTIVO) {
				listasAsignaciones.put(ticketEmpleador, new HashMap<TicketBusquedaEmpleo, Double>());

				for (EmpleadoPretenso empleado : this.empleados) {
					TicketBusquedaEmpleo ticketEmpleado = empleado.getTicket();

					if (ticketEmpleado.getEstado() == EstadosTicket.ACTIVO && ticketEmpleador.getFormulario().getRubro()
							.mismoRubro(ticketEmpleado.getFormulario().getRubro())) {
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
	 * @param ticketEmpleador el ticket del que se desea obtener su lista de
	 *                        asignacion. <br>
	 * @throws TicketInexistenteException cuando el ticket no posee una lista de
	 *                                    asignacion. <br>
	 * @return un iterator de los empleados ordenados por su puntaje de forma
	 *         descendente.
	 */
	public Iterator<TicketOrdenable> getListaAsignacion(TicketBusquedaEmpleado ticketEmpleador)
			throws TicketInexistenteException {
		ArrayList<TicketOrdenable> cvs = new ArrayList<TicketOrdenable>();
		if (!listasAsignaciones.containsKey(ticketEmpleador))
			throw new TicketInexistenteException("El ticket no tiene una lista de asignacion", ticketEmpleador);

		HashMap<TicketBusquedaEmpleo, Double> puntajesTicket = listasAsignaciones.get(ticketEmpleador);

		for (Ticket cv : puntajesTicket.keySet()) {
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

	public Iterator<TicketOrdenable> getListaAsignacion(TicketBusquedaEmpleo ticketEmpleado)
			throws TicketInexistenteException {
		ArrayList<TicketOrdenable> puestosLaborales = new ArrayList<TicketOrdenable>();

		for (Ticket puestoLaboral : listasAsignaciones.keySet()) {
			HashMap<TicketBusquedaEmpleo, Double> puntajesTicket = listasAsignaciones.get(puestoLaboral);

			if (puntajesTicket.containsKey(ticketEmpleado)) {
				TicketOrdenable puestoOrdenable = new TicketOrdenable(puestoLaboral,
						puntajesTicket.get(ticketEmpleado));
				puestosLaborales.add(puestoOrdenable);
			}
		}

		if (puestosLaborales.isEmpty()) {
			throw new TicketInexistenteException("El ticket no tiene una lista de asignacion", ticketEmpleado);
		}

		puestosLaborales.sort(null);

		Empleador empleador = (Empleador) puestosLaborales.get(0).getTicket().getCreador();
		empleador.puntajePrimerLugar();

		return puestosLaborales.iterator();
	}

	/**
	 * Modifica los puntajes de los usuarios segun su posicion en las listas de
	 * asignacion.
	 * 
	 * <b>Pre: </b> Existen las listas de asignacion.
	 */
	public void calcularPuntajes() {
		for (TicketBusquedaEmpleado ticketEmpleador : listasAsignaciones.keySet()) {
			try {
				Iterator<TicketOrdenable> lista = this.getListaAsignacion(ticketEmpleador);
				if (lista.hasNext()) {
					Empleador primero = (Empleador) lista.next().getTicket().getCreador();
					primero.puntajePrimerLugar();
				}
			} catch (TicketInexistenteException e) {
				// Jamas se va a ejecutar
				e.printStackTrace();
			}
		}

		for (EmpleadoPretenso empleado : empleados) {
			try {
				Iterator<TicketOrdenable> lista = this.getListaAsignacion(empleado.getTicket());
				if (lista.hasNext()) {
					EmpleadoPretenso primero = (EmpleadoPretenso) lista.next().getTicket().getCreador();
					primero.puntajePrimerLugar();
				}
				EmpleadoPretenso ultimo = null;
				// Empieza por el 2do. Si tiene un solo elemento consideramos que es primero no
				// ultimo.
				while (lista.hasNext()) {
					ultimo = (EmpleadoPretenso) lista.next().getTicket().getCreador();
				}
				if (ultimo != null)
					ultimo.puntajeUltimoLugar();
			} catch (TicketInexistenteException e) {
				// Puede ser que el empleado no tenga una lista.
				e.printStackTrace();
			}
		}
	}

	public void rondaContratacion() {
		this.empleadoresNoElegidos();

		for (TicketBusquedaEmpleado ticketEmpleador : listasAsignaciones.keySet()) {
			TicketBusquedaEmpleo elegido = ticketEmpleador.getElegido();
			if (elegido.getElegido() == ticketEmpleador) {
				Coincidencia coincidencia = new Coincidencia(ticketEmpleador, elegido,
						ticketEmpleador.calcularComision(), elegido.calcularComision());
				coincidencias.add(coincidencia);
				ticketEmpleador.setEstado(EstadosTicket.FINALIZADO);
				elegido.setEstado(EstadosTicket.FINALIZADO);
			}
		}
	}

	public void empleadoresNoElegidos() {
		ArrayList<Empleador> empleadores = new ArrayList<Empleador>();
		empleadores.addAll(this.empleadores);

		for (EmpleadoPretenso empleado : this.empleados) {
			Empleador elegido = empleado.getTicket().getElegido().getCreador();
			if (empleadores.contains(elegido)) {
				empleadores.remove(elegido);
			}
		}

		for (Empleador empleador : empleadores) {
			empleador.puntajeNoElegido();
		}
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

	public GregorianCalendar getFechaLista() {
		return fechaLista;
	}

	public Iterator<Coincidencia> getCoincidencias() {
		return this.coincidencias.iterator();
	}
}
