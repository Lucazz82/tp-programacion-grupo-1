package modelos;

import java.util.Date;

import enums.EstadosTicket;

public abstract class Ticket implements IComision {
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

	public Usuario getCreador() {
		Usuario creador = null;

		if (this.estado == EstadosTicket.ACTIVO)
			creador = this.creador;

		return creador;
	}

	/**
	 * Enfrenta 2 tickets de distinto tipo. <br>
	 * <b>Pre:</b> el ticket recibido es del otro tipo.
	 * 
	 * @param o el ticket a enfrentar.
	 * @return el puntaje del enfrentamiento entre tickets.
	 */
	public abstract double enfrentar(Ticket o);

	@Override
	public String toString() {
		return "fechaAlta=" + fechaAlta + ", formulario=" + formulario + ", estado=" + estado + ", creador=" + creador;
	}

}
