package modelos;

import enums.Estudios;
import enums.Experiencias;
import enums.Locaciones;
import enums.PuestosLaborales;
import enums.RangosEtarios;
import enums.Remuneraciones;
import enums.Rubros;
import modelos.aspectos.CargaHoraria;
import modelos.aspectos.Locacion;

public class Formulario {
	private Locacion locacion;
	private Remuneraciones remuneracion;
	private double v1;
	private double v2;
	private CargaHoraria cargaHoraria;
	private PuestosLaborales puesto;
	private RangosEtarios rangoEtario;
	private Experiencias experiencia;
	private Estudios estudio;
	private Rubros rubro;
	
	public Formulario(Locacion locacion, Remuneraciones remuneracion, double v1, double v2,
			CargaHoraria cargaHoraria, PuestosLaborales puesto, RangosEtarios rangoEtario, Experiencias experiencia,
			Estudios estudio, Rubros rubro) {
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

	public PuestosLaborales getPuesto() {
		return puesto;
	}

	public RangosEtarios getRangoEtario() {
		return rangoEtario;
	}

	public Experiencias getExperiencia() {
		return experiencia;
	}

	public Estudios getEstudio() {
		return estudio;
	}
	
	public Rubros getRubro() {
		return rubro;
	}
	
}
