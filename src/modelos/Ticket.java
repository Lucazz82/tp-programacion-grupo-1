package modelos;

import java.util.Date;

import enums.EstadosTicket;

public abstract class Ticket implements Comparable<Ticket>{
	protected Date fechaAlta;
	protected EstadosTicket estado;
	protected double puntaje;
	
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

	@Override
	public int compareTo(Ticket o) {
		int res;
		
		if(this.puntaje > o.puntaje) {
			res = 1;
		} else if(this.puntaje < o.puntaje) {
			res = -1;
		} else {
			res = 0;
		}
		
		return res;
	}
	
	
}
