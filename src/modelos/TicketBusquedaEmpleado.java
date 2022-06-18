package modelos;

import java.io.Serializable;
import java.util.Arrays;

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

	public Empleador getCreador() {
		return (Empleador) this.creador;
	}

	public TicketBusquedaEmpleo getElegido() {
		return (TicketBusquedaEmpleo) this.elegido;
	}

	public void setElegido(TicketBusquedaEmpleo elegido) {
		this.elegido = elegido;
	}

	@Override
	public String toString() {
		return "TicketBusquedaEmpleado [" + super.toString() + " pesos=" + Arrays.toString(pesos) + "]";
	}

	@Override
	public double calcularComision() {
		double sueldoOfrecido = this.getFormulario().getRemuneracion().getSueldoPretendido();
		return this.calcularPorcentaje() * sueldoOfrecido;
	}

	@Override
	public double calcularPorcentaje() {
		Empleador empleador = (Empleador) this.creador;
		return this.formulario.getRubro().enfrentar(empleador.getTipoPersona());
	}

}
