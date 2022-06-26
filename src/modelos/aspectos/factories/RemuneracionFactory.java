package modelos.aspectos.factories;

import enums.Remuneraciones;
import modelos.aspectos.Remuneracion;

public class RemuneracionFactory {
	public static Remuneracion getRemuneracion(Remuneraciones remuneracion, double v1, double v2) {
		Remuneracion resultado = null;
		switch (remuneracion) {
		case ENTRE_V1_V2:
			resultado = new Remuneracion(remuneracion, 1, v1, v2);
			break;
		case HASTA_V1:
			resultado = new Remuneracion(remuneracion, 0, v1, 0);
			break;
		case MAS_DE_V2:
			resultado = new Remuneracion(remuneracion, 2, 0, v2);
			break;
		}
		return resultado;

	}

}
