package modelos;

import modelos.aspectos.CargaHoraria;
import modelos.aspectos.Estudios;
import modelos.aspectos.Experiencia;
import modelos.aspectos.Locacion;
import modelos.aspectos.RangoEtario;
import modelos.aspectos.Remuneracion;
import modelos.comisiones.PuestoLaboralDecorator;
import modelos.comisiones.Rubro;

public class Formulario {
	private IDoubleDispatch locacion;
	private Enfrentable<Remuneracion> remuneracion;
	private IDoubleDispatch cargaHoraria;
	private IDoubleDispatch puesto; // Se pone un IDoubleDispatch porque solo se usa el enfrentar
	private Enfrentable<RangoEtario> rangoEtario;
	private Enfrentable<Experiencia> experiencia;
	private Enfrentable<Estudios> estudio;
	private Enfrentable<ITipoPersona> rubro;
	
	public Formulario(IDoubleDispatch locacion, Enfrentable<Remuneracion> remuneracion, IDoubleDispatch cargaHoraria,
			IDoubleDispatch puesto, Enfrentable<RangoEtario> rangoEtario, Enfrentable<Experiencia> experiencia,
			Enfrentable<Estudios> estudio, Enfrentable<ITipoPersona> rubro) {
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

	public Enfrentable<Remuneracion> getRemuneracion() {
		return remuneracion;
	}

	public IDoubleDispatch getCargaHoraria() {
		return cargaHoraria;
	}

	public IDoubleDispatch getPuesto() {
		return puesto;
	}

	public Enfrentable<RangoEtario> getRangoEtario() {
		return rangoEtario;
	}

	public Enfrentable<Experiencia> getExperiencia() {
		return experiencia;
	}

	public Enfrentable<Estudios> getEstudio() {
		return estudio;
	}

	public Enfrentable<ITipoPersona> getRubro() {
		return rubro;
	}

	
}
