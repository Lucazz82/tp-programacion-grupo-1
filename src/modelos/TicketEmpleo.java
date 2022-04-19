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
	public double calcularPuntaje() {
//		peso * f(empleador, empleado);
		double[] pesos = new double[7];
		
		for(double peso : pesos) {
			
		}
		
		return 0;
	}
	
}
