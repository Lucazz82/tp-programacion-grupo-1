package modelos;

import java.util.Date;

import enums.EstadosTicket;

public abstract class Ticket {
	protected Date fechaAlta;
	protected Formulario formulario;
	protected EstadosTicket estado;
	protected Usuario creador;
	protected Ticket elegido;

	public Ticket(Usuario creador, Formulario formulario) {
		this.fechaAlta = new Date();
		this.estado = EstadosTicket.ACTIVO;
		this.formulario = formulario;
		this.creador = creador;
	}

	public EstadosTicket getEstado() {
		return estado;
	}

	public void setEstado(EstadosTicket estado) {
		if (this.estado != EstadosTicket.CANCELADO && this.estado != EstadosTicket.FINALIZADO) {
			this.estado = estado;

			if (this.estado == EstadosTicket.FINALIZADO) {
				this.creador.finalizarTicket();
			}

			if (this.estado == EstadosTicket.CANCELADO) {
				this.creador.cancelarTicket();
			}

		}
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public Formulario getFormulario() {
		return formulario;
	}

	public Logueable getCreador() {
		return creador;
	}

	public Ticket getElegido() {
		return elegido;
	}

	public void setElegido(Ticket elegido) {
		this.elegido = elegido;
	}

	/**
	 * Enfrenta 2 tickets de distinto tipo <b>Pre: el ticket recibido es de otro
	 * tipo.
	 * 
	 * @return: el puntaje del ticket.
	 */
	public abstract double enfrentar(Ticket o);

	@Override
	public String toString() {
		return "fechaAlta=" + fechaAlta + ", formulario=" + formulario + ", estado=" + estado + ", creador=" + creador;
	}

}
