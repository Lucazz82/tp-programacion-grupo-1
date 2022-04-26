package modelos.aspectos.factories;

import enums.Locaciones;
import modelos.aspectos.HomeOffice;
import modelos.aspectos.Indistinto;
import modelos.aspectos.Locacion;
import modelos.aspectos.Presencial;

public class LocacionFactory {
	public static Locacion getLocacion(Locaciones locacion) {
		Locacion resultado = null;
		
		switch (locacion) {
		case CUALQUIERA:
			resultado = new Indistinto();
			break;
		case HOME_OFFICE:
			resultado = new HomeOffice();
			break;
		case PRESENCIAL:
			resultado = new Presencial();
			break;
		}
		
		return resultado;
	}
}
