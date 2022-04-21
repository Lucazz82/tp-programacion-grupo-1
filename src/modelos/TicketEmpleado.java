_package modelos;

import modelos.aspectos.Estudios;

/**
 * Ticket de busqueda de empleado
 *
 */
public class TicketEmpleado extends Ticket {

	private int cantidadEmpleadosSolicitados;
	private int cantidadEmpleadosObtenidos;
	
	public TicketEmpleado(Formulario formulario, int cantidadEmpleadosSolicitados, int cantidadEmpleadosObtenidos) {
		super(formulario);
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
		puntaje += this.formulario.getLocacion().enfrentar(o.formulario.getLocacion());
		puntaje += Remuneracion(this.formulario.getRemuneracion(), o.formulario.getRemuneracion());
		puntaje += this.formulario.getCargaHoraria().enfrentar(o.formulario.getCargaHoraria());
		puntaje += Puesto(this.formulario.getPuesto(), o.formulario.getPuesto());
		puntaje += RangoEtario(this.formulario.getRangoEtario(), o.formulario.getRangoEtario());
		puntaje += Experiencia(this.formulario.getExperiencia(), o.formulario.getExperiencia());
		puntaje += Estudios.enfrentar(this.formulario.getEstudio(), o.formulario.getEstudio());
		
		return puntaje;
	}

	
	
	
}
