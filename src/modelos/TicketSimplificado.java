package modelos;

import java.io.Serializable;
import java.util.Date;

import enums.Locaciones;
import enums.Rubros;
import modelos.aspectos.Locacion;
import modelos.aspectos.factories.LocacionFactory;
import modelos.aspectos.factories.RubroFactory;
import modelos.comisiones.Rubro;

public class TicketSimplificado implements Serializable {
	private Date fechaAlta;
	private Empleador creador;
	private Locacion locacion;
	private Rubro rubro;

	public TicketSimplificado(Empleador creador, Locaciones locacion, Rubros rubro) {
		this.creador = creador;
		this.locacion = LocacionFactory.getLocacion(locacion);
		this.rubro = RubroFactory.getRubro(rubro);
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public Empleador getCreador() {
		return creador;
	}

	public Locacion getLocacion() {
		return locacion;
	}

	public Rubro getRubro() {
		return rubro;
	}

	@Override
	public String toString() {
		return "TicketSimplificado [fechaAlta=" + fechaAlta + ", creador=" + creador + ", locacion=" + locacion
				+ ", rubro=" + rubro + "]";
	}
}
