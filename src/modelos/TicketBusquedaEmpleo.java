package modelos;

import java.io.Serializable;

public class TicketBusquedaEmpleo extends Ticket {
	private IComision comision;

	public TicketBusquedaEmpleo(Usuario creador, Formulario formulario, IComision comision) {
		super(creador, formulario);
		this.comision = comision;
	}

	public EmpleadoPretenso getCreador() {
		return (EmpleadoPretenso) this.creador;
	}

	public TicketBusquedaEmpleado getElegido() {
		return (TicketBusquedaEmpleado) this.elegido;
	}

	public void setElegido(TicketBusquedaEmpleado elegido) {
		this.elegido = elegido;
	}

	@Override
	public double enfrentar(Ticket o) {
		return o.enfrentar(this);
	}

	@Override
	public String toString() {
		return "TicketBusquedaEmpleo [" + super.toString() + "]";
	}

	@Override
	public double calcularComision() {
		return this.comision.calcularComision();
	}

	@Override
	public double calcularPorcentaje() {
		return this.comision.calcularPorcentaje();
	}
}
