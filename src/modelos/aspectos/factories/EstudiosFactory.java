package modelos.aspectos.factories;

import enums.EstudiosPrevios;
import modelos.aspectos.Estudios;

public class EstudiosFactory {
	public static Estudios getEstudios(EstudiosPrevios estudios) {
		Estudios resultado = null;
		switch (estudios) {
		case PRIMARIO:
			resultado = new Estudios(estudios, 0);
			break;
		case SECUNDARIO:
			resultado = new Estudios(estudios, 1);
			break;
		case TERCIARIO:
			resultado = new Estudios(estudios, 2);
			break;
		}
		return resultado;
	}
}
