package modelos;

import java.util.Date;

import enums.EstadosTicket;

public abstract class Ticket{
	protected Date fechaAlta;
	protected EstadosTicket estado;
	
	public Ticket() {
		this.fechaAlta=new Date();
		this.estado=EstadosTicket.ACTIVO;
	}
	
	public EstadosTicket getEstado() {
		return estado;
	}
	
	public void setEstado(EstadosTicket estado) {
		this.estado = estado;
	}
	
	public abstract double calcularPuntaje();
}
