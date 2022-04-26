package modelos.aspectos.factories;

import enums.Experiencias;
import modelos.aspectos.Experiencia;

public class ExperienciaFactory {
	public static Experiencia getExperiencia(Experiencias experiencia) {
		Experiencia resultado = null;
		switch (experiencia) {
		case MEDIA:
			resultado = new Experiencia(1);
			break;
		case MUCHA:
			resultado = new Experiencia(2);
			break;
		case NADA:
			resultado = new Experiencia(0);
			break;
		}
		return resultado;
	}
}
