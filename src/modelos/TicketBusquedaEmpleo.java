package modelos;

public class TicketBusquedaEmpleo extends Ticket{
	private boolean resultado;
	
	public TicketBusquedaEmpleo(Usuario creador, Formulario formulario, boolean resultado) {
		super(creador, formulario);
		this.resultado = resultado;
	}

	public void setResultado(boolean resultado) {
		this.resultado = resultado;
	}

	public boolean isResultado() {
		return resultado;
	}

	@Override
	public double enfrentar(Ticket o) {		
		return o.enfrentar(this);
	}
}
