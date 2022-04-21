package modelos;

import java.util.Date;

import enums.EstadosTicket;

public abstract class Ticket{
	protected Date fechaAlta;
	protected Formulario formulario;
	protected EstadosTicket estado;
	protected final Usuario creador;
	
	public Ticket(Usuario creador, Formulario formulario) {
		this.fechaAlta=new Date();
		this.estado=EstadosTicket.ACTIVO;
		this.formulario = formulario;
		this.creador = creador;
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

	public Usuario getCreador() {
		return creador;
	}

	/**
	 * Enfrenta 2 tickets de distinto tipo
	 * <b>Pre: el ticket recibido es de otro tipo.
	 * @return: el puntaje del ticket. 
	 */
	public abstract double enfrentar(Ticket o);
}
