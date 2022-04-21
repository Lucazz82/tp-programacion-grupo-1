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
	
	public abstract double enfrentar(Ticket o);
}
