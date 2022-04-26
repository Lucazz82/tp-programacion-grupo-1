package modelos;

import java.util.Arrays;

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
		puntaje += this.pesos[1] * Remuneracion.enfrentar(this.formulario.getRemuneracion().getPosicion(),
				o.formulario.getRemuneracion().getPosicion());
		puntaje += this.pesos[2] * this.formulario.getCargaHoraria().enfrentar(o.formulario.getCargaHoraria());
		puntaje += this.pesos[3] * PuestoLaboral.enfrentar(this.formulario.getPuesto().getPosicion(),
				o.formulario.getPuesto().getPosicion());
		puntaje += this.pesos[4] * RangoEtario.enfrentar(this.formulario.getRangoEtario().getPosicion(),
				o.formulario.getRangoEtario().getPosicion());
		puntaje += this.pesos[5] * this.formulario.getExperiencia().enfrentar(o.formulario.getExperiencia());
		puntaje += this.pesos[6] * Estudios.enfrentar(this.formulario.getEstudio().getPosicion(),
				o.formulario.getEstudio().getPosicion());

		return puntaje;
	}

	@Override
	public String toString() {
		return "TicketBusquedaEmpleado [" + super.toString() + " pesos=" + Arrays.toString(pesos) + "]";
	}

}
