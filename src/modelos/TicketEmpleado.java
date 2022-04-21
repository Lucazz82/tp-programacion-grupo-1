_package modelos;

import modelos.aspectos.Estudios;

/**
 * Ticket de busqueda de empleado
 *
 */
public class TicketEmpleado extends Ticket {

	private int cantidadEmpleadosSolicitados;
	private int cantidadEmpleadosObtenidos;
	
	
	public TicketEmpleado(int cantidadEmpleadosSolicitados, int cantidadEmpleadosObtenidos) {
		super();
		this.cantidadEmpleadosSolicitados = cantidadEmpleadosSolicitados;
		this.cantidadEmpleadosObtenidos = cantidadEmpleadosObtenidos;
	}

	public int getCantidadEmpleadosSolicitados() {
		return cantidadEmpleadosSolicitados;
	}
	
	public int getCantidadEmpleadosObtenidos() {
		return cantidadEmpleadosObtenidos;
	}

	@Override
	public double enfrentar(Ticket o) {
		double puntaje = 0;
		puntaje += this.formulario.getCargaHoraria().enfrentar(o.formulario.getCargaHoraria());
		puntaje += Estudios.enfrentar(this.formulario.getEstudio(), o.formulario.getEstudio());
		return puntaje;
	}
	
	
	
}
