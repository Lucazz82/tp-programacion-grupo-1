package modelos;

import enums.Estudios;
import enums.Experiencias;
import enums.Locaciones;
import enums.PuestosLaborales;
import enums.RangosEtarios;
import enums.Remuneraciones;
import modelos.aspectos.CargaHoraria;

public class Formulario {
	private int locacion;
	private int remuneracion;
	private double v1;
	private double v2;
	private CargaHoraria cargaHoraria;
	private int puesto;
	private int rangoEtario;
	private int experiencia;
	private int estudio;
	
	public Formulario(int locacion, int remuneracion, double v1, double v2,
			CargaHoraria cargaHoraria, int puesto, int rangoEtario, int experiencia,
			int estudio) {
		this.locacion = locacion;
		this.remuneracion = remuneracion;
		this.v1 = v1;
		this.v2 = v2;
		this.cargaHoraria = cargaHoraria;
		this.puesto = puesto;
		this.rangoEtario = rangoEtario;
		this.experiencia = experiencia;
		this.estudio = estudio;
	}

	public Formulario(int locacion, int remuneracion, double v, CargaHoraria cargaHoraria,
			int puesto, int rangoEtario, int experiencia, int estudio) {
		super();
		this.locacion = locacion;
		this.remuneracion = remuneracion;
		
		if(remuneracion == Remuneraciones.HASTA_V1.getPosicion())
			this.v1 = v;
		else if(remuneracion == Remuneraciones.MAS_DE_V2.getPosicion())
			this.v2 = v;
		
		this.cargaHoraria = cargaHoraria;
		this.puesto = puesto;
		this.rangoEtario = rangoEtario;
		this.experiencia = experiencia;
		this.estudio = estudio;
	}

	public int getLocacion() {
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
