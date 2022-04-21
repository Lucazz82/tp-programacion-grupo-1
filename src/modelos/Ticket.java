package modelos;

import java.util.Date;

import enums.EstadosTicket;

public abstract class Ticket{
	protected Date fechaAlta;
	protected Formulario formulario;
	protected EstadosTicket estado;
	
	public Ticket(Formulario formulario) {
		this.fechaAlta=new Date();
		this.estado=EstadosTicket.ACTIVO;
		this.formulario = formulario;
	}
	
	public EstadosTicket getEstado() {
		return estado;
	}
	
	public void setEstado(EstadosTicket estado) {
		this.estado = estado;
	}
	
	public Date getFechaAlta() {
		return fechaAlta;
	}

	public Formulario getFormulario() {
		return formulario;
	}

	/**
	 * Enfrenta 2 tickets de distinto tipo
	 * <b>Pre: el ticket recibido es de otro tipo.
	 * @return: el puntaje del ticket. 
	 */
	public abstract double enfrentar(Ticket o);
}
