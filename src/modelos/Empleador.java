package modelos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import enums.Rubros;
import enums.TipoPersona;
import modelos.comisiones.Rubro;

public class Empleador extends Usuario {

	private String nombre;
	private ITipoPersona tipoPersona;
	private Rubro rubro;
	private ArrayList<TicketBusquedaEmpleado> tickets = new ArrayList<TicketBusquedaEmpleado>();

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

	@Override
	public String toString() {
		return "Empleador [" + super.toString() + " nombre=" + nombre + ", tipoPersona=" + tipoPersona + ", rubro="
				+ rubro + ", tickets=" + tickets + "]";
	}

	@Override
	public void finalizarTicket() {
		this.puntaje += 50;
	}

	@Override
	public void cancelarTicket() {
	}

	public void puntajePrimerLugar() {
		this.puntaje += 10;
	}

	@Override
	public double calcularComision(Ticket ticket) {
		Formulario formulario = ticket.getFormulario();

		double sueldoOfrecido = 0;
		switch (formulario.getRemuneracion()) {
		case ENTRE_V1_V2:
			sueldoOfrecido = (formulario.getV2() + formulario.getV1()) / 2;
			break;
		case HASTA_V1:
			sueldoOfrecido = formulario.getV1();
			break;
		case MAS_DE_V2:
			sueldoOfrecido = formulario.getV2();
			break;
		}

		return formulario.getRubro().enfrentar(this.tipoPersona) * sueldoOfrecido;
	}

}
