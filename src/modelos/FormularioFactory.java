package modelos;

import enums.CargasHorarias;
import enums.EstudiosPrevios;
import enums.Experiencias;
import enums.Locaciones;
import enums.PuestosLaborales;
import enums.RangosEtarios;
import enums.Remuneraciones;
import enums.Rubros;
import modelos.aspectos.CargaCompleta;
import modelos.aspectos.CargaExtendida;
import modelos.aspectos.CargaHoraria;
import modelos.aspectos.CargaMedia;
import modelos.aspectos.Estudios;
import modelos.aspectos.Experiencia;
import modelos.aspectos.HomeOffice;
import modelos.aspectos.Indistinto;
import modelos.aspectos.Locacion;
import modelos.aspectos.Presencial;
import modelos.aspectos.PuestoLaboral;
import modelos.aspectos.RangoEtario;
import modelos.aspectos.Remuneracion;
import modelos.aspectos.factories.EstudiosFactory;
import modelos.aspectos.factories.ExperienciaFactory;
import modelos.aspectos.factories.PuestoLaboralFactory;
import modelos.aspectos.factories.RangoEtarioFactory;
import modelos.aspectos.factories.RemuneracionFactory;
import modelos.comisiones.ComercioInternacional;
import modelos.comisiones.ComercioLocal;
import modelos.comisiones.Rubro;
import modelos.comisiones.Salud;

public class FormularioFactory {

	public Formulario getFormulario(Locaciones locacion, Remuneraciones remuneracion, double v1, double v2,
			CargasHorarias cargaHoraria, PuestosLaborales puestoLaboral, RangosEtarios rangoEtario,
			Experiencias experienciaPrevia, EstudiosPrevios estudios, Rubros rubro) {
		Locacion locacionResultado = null;
		CargaHoraria cargaHorariaResultado = null;
		Rubro rubroResultado = null;
		Experiencia experienciaResultado = null;
		Estudios estudiosResultado = null;
		Remuneracion remuneracionResultado = null;
		RangoEtario rangoEtarioResultado = null;
		PuestoLaboral puestoLaboralResultado = null;
		
		ExperienciaFactory experienciaFactory = new ExperienciaFactory();
		RemuneracionFactory remuneracionFactory = new RemuneracionFactory();
		EstudiosFactory estudiosFactory = new EstudiosFactory();
		PuestoLaboralFactory puestoLaboralFactory= new PuestoLaboralFactory();
		RangoEtarioFactory rangoEtarioFactory= new RangoEtarioFactory();

		switch (locacion) {
		case CUALQUIERA:
			locacionResultado = new Indistinto();
			break;
		case HOME_OFFICE:
			locacionResultado = new HomeOffice();
			break;
		case PRESENCIAL:
			locacionResultado = new Presencial();
			break;
		default:
			break;
		}

		switch (cargaHoraria) {
		case COMPLETA:
			cargaHorariaResultado = new CargaCompleta();
			break;
		case EXTENDIDA:
			cargaHorariaResultado = new CargaExtendida();
			break;
		case MEDIA:
			cargaHorariaResultado = new CargaMedia();
			break;
		default:
			break;
		}

		switch (rubro) {
		case COMECIO_LOCAL:
			rubroResultado = new ComercioLocal();
			break;
		case COMERCIO_INTERNACIONAL:
			rubroResultado = new ComercioInternacional();
			break;
		case SALUD:
			rubroResultado = new Salud();
			break;
		default:
			break;
		}
		
		experienciaResultado = experienciaFactory.getExperiencias(experienciaPrevia);
		remuneracionResultado = remuneracionFactory.getRemuneracion(remuneracion);
		puestoLaboralResultado = puestoLaboralFactory.getPuestoLaboral(puestoLaboral);
		rangoEtarioResultado = rangoEtarioFactory.getRangosEtarios(rangoEtario);
		estudiosResultado = estudiosFactory.getEstudios(estudios);

		return new Formulario(locacionResultado, remuneracionResultado, v1, v2, cargaHorariaResultado, puestoLaboralResultado,
				rangoEtarioResultado, experienciaResultado, estudiosResultado, rubroResultado);
	}

}