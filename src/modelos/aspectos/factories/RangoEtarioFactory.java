package modelos.aspectos.factories;

import enums.RangosEtarios;
import modelos.aspectos.RangoEtario;

public class RangoEtarioFactory {
	public static RangoEtario getRangosEtarios(RangosEtarios rango) {
		RangoEtario resultado = null;
		switch (rango) {
		case ENTRE_40_50:
			resultado = new RangoEtario(1);
			break;
		case MAS_DE_50:
			resultado = new RangoEtario(2);
			break;
		case MENOS_DE_40:
			resultado = new RangoEtario(0);
			break;
		}
		return resultado;
	}

}
