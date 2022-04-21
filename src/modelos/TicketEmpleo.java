package modelos;


public class TicketEmpleo extends Ticket{

	private boolean resultado;

	public TicketEmpleo() {
		super();
	}
	
	public void setResultado(boolean resultado) {
		this.resultado = resultado;
	}

	public boolean isResultado() {
		return resultado;
	}

	@Override
	public double enfrentar(Ticket o) {		
		return 0;
		
	}

	
}
