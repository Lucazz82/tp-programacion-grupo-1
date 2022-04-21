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
	private int remuneracion;
	private double v1;
	private double v2;
	private CargaHoraria cargaHoraria;
	private int puesto;
	private int rangoEtario;
	private int experiencia;
	private int estudio;
	private Rubros rubro;
	
	public Formulario(Locacion locacion, int remuneracion, double v1, double v2,
			CargaHoraria cargaHoraria, int puesto, int rangoEtario, int experiencia,
			int estudio, Rubros rubro) {
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

	public int getRemuneracion() {
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

	public int getPuesto() {
		return puesto;
	}

	public int getRangoEtario() {
		return rangoEtario;
	}

	public int getExperiencia() {
		return experiencia;
	}

	public int getEstudio() {
		return estudio;
	}
	
	
	
}
