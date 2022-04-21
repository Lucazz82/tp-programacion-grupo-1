package modelos;

public class TicketBusquedaEmpleo extends Ticket{
	private boolean resultado;
	
	public TicketBusquedaEmpleo(Usuario creador, Formulario formulario) {
		super(creador, formulario);
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
