package modelos;

public class TicketBusquedaEmpleo extends Ticket {
	private boolean resultado;
	private IComision comision;

	public TicketBusquedaEmpleo(Usuario creador, Formulario formulario) {
		super(creador, formulario);
	}

	public void setResultado(boolean resultado) {
		this.resultado = resultado;
	}

	public boolean isResultado() {
		return resultado;
	}
	
	public EmpleadoPretenso getCreador() {
		return (EmpleadoPretenso)this.creador;
	}
	
	public TicketBusquedaEmpleado getElegido() {
		return (TicketBusquedaEmpleado)this.elegido;
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
		return "TicketBusquedaEmpleo [" + super.toString() + " resultado=" + resultado + "]";
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
