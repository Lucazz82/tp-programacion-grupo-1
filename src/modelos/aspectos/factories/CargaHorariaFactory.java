package modelos.aspectos.factories;

import enums.CargasHorarias;
import modelos.aspectos.CargaCompleta;
import modelos.aspectos.CargaExtendida;
import modelos.aspectos.CargaHoraria;
import modelos.aspectos.CargaMedia;

public class CargaHorariaFactory {
	public static CargaHoraria getCargaHoraria(CargasHorarias cargaHoraria) {
		CargaHoraria resultado = null;

		switch (cargaHoraria) {
		case COMPLETA:
			resultado = new CargaCompleta();
			break;
		case EXTENDIDA:
			resultado = new CargaExtendida();
			break;
		case MEDIA:
			resultado = new CargaMedia();
			break;
		}

		return resultado;
	}
}
