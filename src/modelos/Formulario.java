package modelos;

import enums.Estudios;
import enums.Experiencias;
import enums.Locaciones;
import enums.PuestosLaborales;
import enums.RangosEtarios;
import enums.Remuneraciones;
import enums.Rubros;
import modelos.aspectos.CargaHoraria;
import modelos.aspectos.Experiencia;
import modelos.aspectos.Locacion;
import modelos.aspectos.PuestoLaboral;
import modelos.comisiones.Rubro;

public class Formulario {
	private Locacion locacion;
	private Remuneraciones remuneracion;
	private double v1;
	private double v2;
	private CargaHoraria cargaHoraria;
	private PuestoLaboral puesto;
	private RangosEtarios rangoEtario;
	private Experiencia experiencia;
	private Estudios estudio;
	private Rubro rubro;

	public Formulario(Locacion locacion, Remuneraciones remuneracion, double v1, double v2, CargaHoraria cargaHoraria,
			PuestoLaboral puesto, RangosEtarios rangoEtario, Experiencia experiencia, Estudios estudio,
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

	public Remuneraciones getRemuneracion() {
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

	public PuestoLaboral getPuesto() {
		return puesto;
	}

	public RangosEtarios getRangoEtario() {
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
