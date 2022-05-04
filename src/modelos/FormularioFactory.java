package modelos;

import enums.CargasHorarias;
import enums.EstudiosPrevios;
import enums.Experiencias;
import enums.Locaciones;
import enums.PuestosLaborales;
import enums.RangosEtarios;
import enums.Remuneraciones;
import enums.Rubros;
import modelos.aspectos.CargaHoraria;
import modelos.aspectos.Estudios;
import modelos.aspectos.Experiencia;
import modelos.aspectos.Locacion;
import modelos.aspectos.RangoEtario;
import modelos.aspectos.Remuneracion;
import modelos.aspectos.factories.CargaHorariaFactory;
import modelos.aspectos.factories.EstudiosFactory;
import modelos.aspectos.factories.ExperienciaFactory;
import modelos.aspectos.factories.LocacionFactory;
import modelos.aspectos.factories.PuestoLaboralFactory;
import modelos.aspectos.factories.RangoEtarioFactory;
import modelos.aspectos.factories.RemuneracionFactory;
import modelos.aspectos.factories.RubroFactory;
import modelos.comisiones.PuestoLaboralDecorator;
import modelos.comisiones.Rubro;

public class FormularioFactory {

	public static Formulario getFormulario(Locaciones locacion, Remuneraciones remuneracion, double v1, double v2,
			CargasHorarias cargaHoraria, PuestosLaborales puestoLaboral, RangosEtarios rangoEtario,
			Experiencias experienciaPrevia, EstudiosPrevios estudios, Rubros rubro) {

		IDoubleDispatch locacionResultado = LocacionFactory.getLocacion(locacion);
		IDoubleDispatch cargaHorariaResultado = CargaHorariaFactory.getCargaHoraria(cargaHoraria);
		Rubro rubroResultado = RubroFactory.getRubro(rubro);
		Experiencia experienciaResultado = ExperienciaFactory.getExperiencias(experienciaPrevia);
		Estudios estudiosResultado = EstudiosFactory.getEstudios(estudios);
		Remuneracion remuneracionResultado = RemuneracionFactory.getRemuneracion(remuneracion, v1, v2);
		RangoEtario rangoEtarioResultado = RangoEtarioFactory.getRangosEtarios(rangoEtario);
		IDoubleDispatch puestoLaboralResultado = PuestoLaboralFactory.getPuestoLaboral(puestoLaboral);

		return new Formulario(locacionResultado, remuneracionResultado, cargaHorariaResultado, puestoLaboralResultado,
				rangoEtarioResultado, experienciaResultado, estudiosResultado, rubroResultado);
	}

}