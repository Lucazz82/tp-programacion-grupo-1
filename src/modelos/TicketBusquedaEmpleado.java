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
		puntaje += this.pesos[1] * this.formulario.getRemuneracion().enfrentar(o.formulario.getRemuneracion());
		puntaje += this.pesos[2] * this.formulario.getCargaHoraria().enfrentar(o.formulario.getCargaHoraria());
		puntaje += this.pesos[3] * this.formulario.getPuesto().enfrentar(o.formulario.getPuesto());
		puntaje += this.pesos[4] * this.formulario.getRangoEtario().enfrentar(o.formulario.getRangoEtario());
		puntaje += this.pesos[5] * this.formulario.getExperiencia().enfrentar(o.formulario.getExperiencia());
		puntaje += this.pesos[6] * this.formulario.getEstudio().enfrentar(o.formulario.getEstudio());

		return puntaje;
	}

	@Override
	public String toString() {
		return "TicketBusquedaEmpleado [" + super.toString() + " pesos=" + Arrays.toString(pesos) + "]";
	}

	@Override
	public double calcularComision() {
		Formulario formulario = this.getFormulario();

		double sueldoOfrecido = 0;
		switch (formulario.getRemuneracion().getPos()) {
		case 1:
			sueldoOfrecido = (formulario.getV2() + formulario.getV1()) / 2;
			break;
		case 0:
			sueldoOfrecido = formulario.getV1();
			break;
		case 2:
			sueldoOfrecido = formulario.getV2();
			break;
		}

		return this.calcularPorcentaje() * sueldoOfrecido;
	}

	@Override
	public double calcularPorcentaje() {
		Empleador empleador = (Empleador) this.creador;
		return this.formulario.getRubro().enfrentar(empleador.getTipoPersona());
	}

}
