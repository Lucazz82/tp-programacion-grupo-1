package modelos;

import modelos.aspectos.CargaHoraria;
import modelos.aspectos.Estudios;
import modelos.aspectos.Experiencia;
import modelos.aspectos.Locacion;
import modelos.aspectos.PuestoLaboral;
import modelos.aspectos.RangoEtario;
import modelos.aspectos.Remuneracion;
import modelos.comisiones.PuestoLaboralDecorator;
import modelos.comisiones.Rubro;

public class Formulario {
	private Locacion locacion;
	private Remuneracion remuneracion;
	private double v1;
	private double v2;
	private CargaHoraria cargaHoraria;
	private PuestoLaboralDecorator puesto;
	private RangoEtario rangoEtario;
	private Experiencia experiencia;
	private Estudios estudio;
	private Rubro rubro;

	public Formulario(Locacion locacion, Remuneracion remuneracion, double v1, double v2, CargaHoraria cargaHoraria,
			PuestoLaboralDecorator puesto, RangoEtario rangoEtario, Experiencia experiencia, Estudios estudio,
			Rubro rubro) {
		this.locacion = locacion;
		this.remuneracion = remuneracion;
		this.v1 = v1;
		this.v2 = v2;
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

	public double getV1() {
		return v1;
	}

	public double getV2() {
		return v2;
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

}
