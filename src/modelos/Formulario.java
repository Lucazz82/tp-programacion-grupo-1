package modelos;

import java.io.Serializable;

import modelos.aspectos.CargaHoraria;
import modelos.aspectos.Estudios;
import modelos.aspectos.Experiencia;
import modelos.aspectos.Locacion;
import modelos.aspectos.RangoEtario;
import modelos.aspectos.Remuneracion;
import modelos.comisiones.PuestoLaboralDecorator;
import modelos.comisiones.Rubro;

public class Formulario implements Serializable{
	private Locacion locacion;
	private Remuneracion remuneracion;
	private CargaHoraria cargaHoraria;
	private PuestoLaboralDecorator puesto;
	private RangoEtario rangoEtario;
	private Experiencia experiencia;
	private Estudios estudio;
	private Rubro rubro;

	public Formulario(Locacion locacion, Remuneracion remuneracion, CargaHoraria cargaHoraria,
			PuestoLaboralDecorator puesto, RangoEtario rangoEtario, Experiencia experiencia, Estudios estudio,
			Rubro rubro) {
		super();
		this.locacion = locacion;
		this.remuneracion = remuneracion;
		this.cargaHoraria = cargaHoraria;
		this.puesto = puesto;
		this.rangoEtario = rangoEtario;
		this.experiencia = experiencia;
		this.estudio = estudio;
		this.rubro = rubro;
	}

	public Locacion getLocacion() {
		return locacion;
	}

	public Remuneracion getRemuneracion() {
		return remuneracion;
	}

	public CargaHoraria getCargaHoraria() {
		return cargaHoraria;
	}

	public PuestoLaboralDecorator getPuesto() {
		return puesto;
	}

	public RangoEtario getRangoEtario() {
		return rangoEtario;
	}

	public Experiencia getExperiencia() {
		return experiencia;
	}

	public Estudios getEstudio() {
		return estudio;
	}

	public Rubro getRubro() {
		return rubro;
	}

	@Override
	public String toString() {
		return "Formulario [locacion=" + locacion + ", remuneracion=" + remuneracion + ", cargaHoraria=" + cargaHoraria
				+ ", puesto=" + puesto + ", rangoEtario=" + rangoEtario + ", experiencia=" + experiencia + ", estudio="
				+ estudio + ", rubro=" + rubro + "]";
	}

	
}
