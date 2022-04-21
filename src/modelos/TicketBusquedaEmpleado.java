package modelos;

import modelos.aspectos.Estudios;
import modelos.aspectos.Experiencia;
import modelos.aspectos.PuestoLaboral;
import modelos.aspectos.RangoEtario;
import modelos.aspectos.Remuneracion;

/**
 * Ticket de busqueda de empleado
 *
 */
public class TicketBusquedaEmpleado extends Ticket {

	private double[] pesos;
	
	public TicketBusquedaEmpleado(Usuario creador, Formulario formulario, double[] pesos) {
		super(creador, formulario);
		this.pesos = pesos;
	}

	
	@Override
	public double enfrentar(Ticket o) {
		double puntaje = 0;
		puntaje += this.pesos[0] * this.formulario.getLocacion().enfrentar(o.formulario.getLocacion());
		puntaje += this.pesos[1] * Remuneracion.enfrentar(this.formulario.getRemuneracion(), o.formulario.getRemuneracion());
		puntaje += this.pesos[2] * this.formulario.getCargaHoraria().enfrentar(o.formulario.getCargaHoraria());
		puntaje += this.pesos[3] * PuestoLaboral.enfrentar(this.formulario.getPuesto(), o.formulario.getPuesto());
		puntaje += this.pesos[4] * RangoEtario.enfrentar(this.formulario.getRangoEtario(), o.formulario.getRangoEtario());
		puntaje += this.pesos[5] * Experiencia.enfrentar(this.formulario.getExperiencia(), o.formulario.getExperiencia());
		puntaje += this.pesos[6] * Estudios.enfrentar(this.formulario.getEstudio(), o.formulario.getEstudio());
		
		return puntaje;
	}

	
	
	
}
