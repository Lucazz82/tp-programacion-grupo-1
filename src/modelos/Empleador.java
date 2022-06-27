package modelos;

import java.util.ArrayList;
import java.util.Iterator;

import enums.Locaciones;
import enums.Rubros;
import excepciones.AgenciaInexistenteException;
import modelos.comisiones.Rubro;
import util.Util;

public class Empleador extends Usuario implements Runnable {

	private String nombre;
	private ITipoPersona tipoPersona;
	private Rubro rubro;
	private ArrayList<TicketBusquedaEmpleado> tickets = new ArrayList<TicketBusquedaEmpleado>();
	
	private TicketSimplificado ticketSimplificado = null;

	public Empleador(String nombreUsuario, String contrasena, ITipoPersona tipoPersona, Rubro rubro) {
		super(nombreUsuario, contrasena);
		this.tipoPersona = tipoPersona;
		this.rubro = rubro;
	}

	public Empleador(String nombreUsuario, String contrasena, String nombre, ITipoPersona tipoPersona, Rubro rubro) {
		super(nombreUsuario, contrasena);
		this.nombre = nombre;
		this.tipoPersona = tipoPersona;
		this.rubro = rubro;
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

	public ITipoPersona getTipoPersona() {
		return tipoPersona;
	}

	public Rubro getRubro() {
		return rubro;
	}
	
	public void agregarTicketSimplificado(TicketSimplificado ticketSimplificado) {
		this.ticketSimplificado = ticketSimplificado;
	}

	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	public void finalizarTicket() {
		this.puntaje += 50;
	}

	@Override
	public void cancelarTicket() {
	}

	public void puntajeNoElegido() {
		this.puntaje -= 20;
	}

	public void puntajePrimerLugar() {
		this.puntaje += 10;
	}
	
	@Override
	public void run() {
//		Agencia agencia = null;
//		try {
//			agencia = Agencia.getInstancia();
//		} catch (AgenciaInexistenteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
////		agencia.agregarTicketABolsa(new TicketSimplificado(this, Locaciones.CUALQUIERA, Rubros.COMERCIO_INTERNACIONAL));
//		agencia.agregarTicketABolsa(new TicketSimplificado(this, Locaciones.HOME_OFFICE, Rubros.SALUD));
//		Util.espera();
//		agencia.agregarTicketABolsa(new TicketSimplificado(this, Locaciones.CUALQUIERA, Rubros.SALUD));
//		Util.espera();
//		agencia.agregarTicketABolsa(new TicketSimplificado(this, Locaciones.PRESENCIAL, Rubros.COMERCIO_INTERNACIONAL));
		
		try {
			Agencia agencia = Agencia.getInstancia();
			agencia.agregarTicketABolsa(ticketSimplificado);
			System.out.println("Ticket agregado con exito");
		} catch (AgenciaInexistenteException e) {}
	}

}
