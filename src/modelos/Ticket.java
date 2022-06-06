package modelos;

import java.util.Date;

import modelos.estados.Activo;
import modelos.estados.IEstado;

public abstract class Ticket implements IComision {
	protected Date fechaAlta;
	protected Formulario formulario;
	protected IEstado estado;
	protected Usuario creador;
	protected Ticket elegido;

	public Ticket(Usuario creador, Formulario formulario) {
		this.fechaAlta = new Date();
		this.estado = new Activo(this);
		this.formulario = formulario;
		this.creador = creador;
	}
	
	public void setEstado(IEstado estado) {
		this.estado = estado;
	}
	
	public void setActivo() {
		this.estado.setActivo();
	}
	
	public void setSuspendido() {
		this.estado.setSuspendido();
	}
	
	public void setCancelado() {
		this.estado.setCancelado();
	}
	
	public void setFinalizado() {
		this.estado.setFinalizado();
	}
	
	public boolean esActivo() {
		return this.estado.esActivo();
	}
	

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public Formulario getFormulario() {
		return formulario;
	}

	public Usuario getCreador() {
		return this.estado.getCreador();
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
