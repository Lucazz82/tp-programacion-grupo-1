package modelos;

import modelos.aspectos.Estudios;
import modelos.aspectos.Experiencia;
import modelos.aspectos.RangoEtario;
import modelos.aspectos.Remuneracion;
import modelos.comisiones.Rubro;

public class Formulario {
	private IDoubleDispatch locacion;
	private Remuneracion remuneracion;
	private IDoubleDispatch cargaHoraria;
	private IDoubleDispatch puesto; // Se pone un IDoubleDispatch porque solo se usa el enfrentar
	private RangoEtario rangoEtario;
	private Experiencia experiencia;
	private Estudios estudio;
	private Rubro rubro;

	public Formulario(IDoubleDispatch locacion, Remuneracion remuneracion, IDoubleDispatch cargaHoraria,
			IDoubleDispatch puesto, RangoEtario rangoEtario, Experiencia experiencia, Estudios estudio, Rubro rubro) {
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

	public IDoubleDispatch getLocacion() {
		return locacion;
	}

	public Remuneracion getRemuneracion() {
		return remuneracion;
	}

	public IDoubleDispatch getCargaHoraria() {
		return cargaHoraria;
	}

	public IDoubleDispatch getPuesto() {
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
