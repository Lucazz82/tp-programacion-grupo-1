package modelos.aspectos.factories;

import enums.Remuneraciones;
import modelos.aspectos.Remuneracion;

public class RemuneracionFactory {
	public static Remuneracion getRemuneracion(Remuneraciones remuneracion) {
		Remuneracion resultado = null;
		switch (remuneracion) {
		case ENTRE_V1_V2:
			resultado = new Remuneracion(1);
			break;
		case HASTA_V1:
			resultado = new Remuneracion(0);
			break;
		case MAS_DE_V2:
			resultado = new Remuneracion(2);
			break;
		}
		return resultado;

	}

}
