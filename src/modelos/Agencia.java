package modelos;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;

import excepciones.AgenciaInexistenteException;
import excepciones.AgenciaYaExistenteException;
import excepciones.ContrasenaIncorrectaException;
import excepciones.TicketInexistenteException;
import excepciones.UsuarioInexistenteException;

public class Agencia implements Logueable {
	private static Agencia _instancia = null;

	private ArrayList<EmpleadoPretenso> empleados = new ArrayList<EmpleadoPretenso>();
	private ArrayList<Empleador> empleadores = new ArrayList<Empleador>();
	private HashMap<TicketBusquedaEmpleado, HashMap<TicketBusquedaEmpleo, Double>> listasAsignaciones = new HashMap<TicketBusquedaEmpleado, HashMap<TicketBusquedaEmpleo, Double>>();
	private ArrayList<Coincidencia> coincidencias = new ArrayList<Coincidencia>();

	private GregorianCalendar fechaLista;

	private String usuario;
	private String contrasenia;

	private BolsaDeTrabajo bolsaDeTrabajo = new BolsaDeTrabajo();

	public void agregarTicketABolsa(TicketSimplificado ticket) {
		bolsaDeTrabajo.agregarTickets(ticket);
	}

	public void busquedaBolsa(EmpleadoPretenso empleado) {
		bolsaDeTrabajo.busqueda(empleado);
	}

	public void devuelveBolsa(TicketSimplificado ticket) {
		bolsaDeTrabajo.devuelve(ticket);
	}

	public void confirmarEleccion(TicketSimplificado ticket) {
		bolsaDeTrabajo.confirmarEleccion(ticket);
	}

	private Agencia(String usuario, String contrasenia) {
		this.usuario = usuario;
		this.contrasenia = contrasenia;
	}

	public synchronized static Agencia getInstancia() throws AgenciaInexistenteException {
		if (_instancia == null)
			throw new AgenciaInexistenteException();

		return _instancia;
	}

	/**
	 * Devuelve el usuario correspondiente al nombre de usuario pasado como
	 * parametro.
	 * 
	 * @param nombreUsuario nombre del usuario a buscar.
	 * @return el usuario correspondiente a ese nombre de usuario.
	 * @throws UsuarioInexistenteException si no existe un usuario con ese nombre de
	 *                                     usuario.
	 */
	public Logueable buscarUsuario(String nombreUsuario) throws UsuarioInexistenteException {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios.addAll(empleados);
		usuarios.addAll(empleadores);

		for (Usuario usuario : usuarios) {
			if (usuario.getnombreUsuario().equals(nombreUsuario)) {
				return usuario;
			}
		}

		if (this.usuario.equals(nombreUsuario))
			return this;
		else
			throw new UsuarioInexistenteException(nombreUsuario + " no existe");
	}

	public Empleador buscarEmpleador(String nombreUsuario) throws UsuarioInexistenteException {
		for (Empleador empleador : this.empleadores) {
			if (empleador.getnombreUsuario().equals(nombreUsuario)) {
				return empleador;
			}
		}

		throw new UsuarioInexistenteException(nombreUsuario + " no existe");
	}

	public EmpleadoPretenso buscarEmpleado(String nombreUsuario) throws UsuarioInexistenteException {
		for (EmpleadoPretenso empleado : this.empleados) {
			if (empleado.getnombreUsuario().equals(nombreUsuario)) {
				return empleado;
			}
		}

		throw new UsuarioInexistenteException(nombreUsuario + " no existe");
	}

	/**
	 * Genera las listas de asignacion de todos los usuarios y las almacena en un
	 * atributo. Ademas setea la fecha en que ocurrio.
	 */
	public void generarListasAsignacion() {
		for (Empleador empleador : this.empleadores) {
			this.generarListaEmpleador(empleador);
		}
		this.fechaLista = new GregorianCalendar();
		this.calcularPuntajes();
	}

	/**
	 * Genera todos los puntajes de los tickets de un empleador.
	 * 
	 * @param empleador empleador cuyos tickets van a ser enfrentados.
	 */
	public void generarListaEmpleador(Empleador empleador) {
		Iterator<TicketBusquedaEmpleado> ticketsEmpleador = empleador.getTickets();
		while (ticketsEmpleador.hasNext()) {
			TicketBusquedaEmpleado ticketEmpleador = ticketsEmpleador.next();
			if (ticketEmpleador.esActivo() && !this.isEnCoincidencias(ticketEmpleador)) {
				listasAsignaciones.put(ticketEmpleador, new HashMap<TicketBusquedaEmpleo, Double>());

				for (EmpleadoPretenso empleado : this.empleados) {
					TicketBusquedaEmpleo ticketEmpleado = empleado.getTicket();

					if (ticketEmpleado != null && ticketEmpleado.esActivo() && ticketEmpleador.getFormulario()
							.getRubro().mismoRubro(ticketEmpleado.getFormulario().getRubro()) && !this.isEnCoincidencias(ticketEmpleado)) {
						double puntaje = ticketEmpleador.enfrentar(ticketEmpleado);
						listasAsignaciones.get(ticketEmpleador).put(ticketEmpleado, puntaje);
					}
				}
			}
		}
	}

	private boolean isEnCoincidencias(TicketBusquedaEmpleado ticketEmpleador) {
		for(Coincidencia coincidencia : coincidencias) {
			if(coincidencia.getTicketEmpleador() == ticketEmpleador) {
				return true;
			}
		}
		return false;
	}
	
	private boolean isEnCoincidencias(TicketBusquedaEmpleo ticketEmpleado) {
		for(Coincidencia coincidencia : coincidencias) {
			if(coincidencia.getTicketEmpleado() == ticketEmpleado) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * @param ticketEmpleador el ticket del que se desea obtener su lista de
	 *                        asignacion. <br>
	 * @throws TicketInexistenteException si el ticket no posee una lista de
	 *                                    asignacion. <br>
	 * @return un iterator de los empleados ordenados por su puntaje de forma
	 *         descendente.
	 */
	public Iterator<TicketOrdenable> getListaAsignacion(TicketBusquedaEmpleado ticketEmpleador)
			throws TicketInexistenteException {
		ArrayList<TicketOrdenable> cvs = new ArrayList<TicketOrdenable>();
		if (!listasAsignaciones.containsKey(ticketEmpleador) || listasAsignaciones.get(ticketEmpleador).isEmpty())
			throw new TicketInexistenteException("El ticket no tiene una lista de asignacion", ticketEmpleador);

		HashMap<TicketBusquedaEmpleo, Double> puntajesTicket = listasAsignaciones.get(ticketEmpleador);

		for (Ticket cv : puntajesTicket.keySet()) {
			TicketOrdenable cvOrdenable = new TicketOrdenable(cv, puntajesTicket.get(cv));
			cvs.add(cvOrdenable);
		}

		cvs.sort(null);

		return cvs.iterator();
	}

	/**
	 * 
	 * @param ticketEmpleado el ticket del que se desea obtener su lista de
	 *                       asignacion. <br>
	 * @return un iterator de los empleados ordenados por su puntaje de forma
	 *         descendente.
	 * @throws TicketInexistenteException si el ticket no posee una lista de
	 *                                    asignacion. <br>
	 */
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
			if(!this.isEnCoincidencias(ticketEmpleador)) {
				try {
					Iterator<TicketOrdenable> lista = this.getListaAsignacion(ticketEmpleador);
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
					// Se puede ejecutar si un ticket se creo despues de ejecutar la lista de
					// asignacion.
				}
			}
		}

		for (EmpleadoPretenso empleado : empleados) {
			if(!this.isEnCoincidencias(empleado.getTicket())) {
				try {
					Iterator<TicketOrdenable> lista = this.getListaAsignacion(empleado.getTicket());
					if (lista.hasNext()) {
						Empleador primero = (Empleador) lista.next().getTicket().getCreador();
						primero.puntajePrimerLugar();
					}
				} catch (TicketInexistenteException e) {
					// Puede ser que el empleado no tenga una lista.
				}				
			}
		}
	}

	/**
	 * Genera la lista de coincidencias entre los tickets de empleado y empleador.
	 */
	public void rondaContratacion() {
		this.empleadoresNoElegidos();

		for (TicketBusquedaEmpleado ticketEmpleador : listasAsignaciones.keySet()) {
			if(!this.isEnCoincidencias(ticketEmpleador)) {
				TicketBusquedaEmpleo elegido = ticketEmpleador.getElegido();
				if (elegido != null && !this.isEnCoincidencias(elegido) && elegido.getElegido() == ticketEmpleador) {
					Coincidencia coincidencia = new Coincidencia(ticketEmpleador, elegido,
							ticketEmpleador.calcularComision(), elegido.calcularComision());
					coincidencias.add(coincidencia);
					ticketEmpleador.setFinalizado();
					elegido.setFinalizado();
					;
				}				
			}
		}
	}

	/**
	 * Les resta puntaje a los empleadores que no fueron elegidos por ningun
	 * empleado.
	 */
	public void empleadoresNoElegidos() {
		ArrayList<Empleador> empleadores = new ArrayList<Empleador>();
		empleadores.addAll(this.empleadores);

		for (EmpleadoPretenso empleado : this.empleados) {
			if (empleado.getTicket().getElegido() != null) {
				Empleador elegido = empleado.getTicket().getElegido().getCreador();
				if (empleadores.contains(elegido)) {
					empleadores.remove(elegido);
				}
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

	public static void registrarAgencia(String usuario, String contrasenia) throws AgenciaYaExistenteException {
		if (_instancia != null)
			throw new AgenciaYaExistenteException();

		_instancia = new Agencia(usuario, contrasenia);
	}

	@Override
	public void login(String contrasena) throws ContrasenaIncorrectaException {
		if (!this.contrasenia.equals(contrasena)) {
			throw new ContrasenaIncorrectaException("Contrasena incorrecta");
		}
	}

	/**** GETTERS Y SETTERS ****/
	public ArrayList<EmpleadoPretenso> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(ArrayList<EmpleadoPretenso> empleados) {
		this.empleados = empleados;
	}

	public ArrayList<Empleador> getEmpleadores() {
		return empleadores;
	}

	public void setEmpleadores(ArrayList<Empleador> empleadores) {
		this.empleadores = empleadores;
	}

	public HashMap<TicketBusquedaEmpleado, HashMap<TicketBusquedaEmpleo, Double>> getListasAsignaciones() {
		return listasAsignaciones;
	}

	public void setListasAsignaciones(
			HashMap<TicketBusquedaEmpleado, HashMap<TicketBusquedaEmpleo, Double>> listasAsignaciones) {
		this.listasAsignaciones = listasAsignaciones;
	}

	public ArrayList<Coincidencia> getCoincidencias() {
		return coincidencias;
	}

	public void setCoincidencias(ArrayList<Coincidencia> coincidencias) {
		this.coincidencias = coincidencias;
	}

	public GregorianCalendar getFechaLista() {
		return fechaLista;
	}

	public void setFechaLista(GregorianCalendar fechaLista) {
		this.fechaLista = fechaLista;
	}

	public String getUsuario() {
		return usuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public BolsaDeTrabajo getBolsaDeTrabajo() {
		return bolsaDeTrabajo;
	}

	public void setBolsaDeTrabajo(BolsaDeTrabajo bolsaDeTrabajo) {
		this.bolsaDeTrabajo = bolsaDeTrabajo;
	}

}
