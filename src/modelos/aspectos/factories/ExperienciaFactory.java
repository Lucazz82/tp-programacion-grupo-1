package modelos.aspectos.factories;

import enums.Experiencias;
import modelos.aspectos.Experiencia;

public class ExperienciaFactory {
	public static Experiencia getExperiencias(Experiencias experiencia) {
		Experiencia resultado = null;
		switch (experiencia) {
		case MEDIA:
			resultado = new Experiencia(experiencia, 1);
			break;
		case MUCHA:
			resultado = new Experiencia(experiencia, 2);
			break;
		case NADA:
			resultado = new Experiencia(experiencia, 0);
			break;
		}
		return resultado;
	}
}