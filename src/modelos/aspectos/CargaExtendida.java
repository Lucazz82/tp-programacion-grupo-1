package modelos.aspectos;

import enums.CargasHorarias;
import modelos.IDoubleDispatch;

public class CargaExtendida extends CargaHoraria {
	private CargasHorarias carga = CargasHorarias.EXTENDIDA;

	@Override
	public double enfrentar(IDoubleDispatch o) {
		return o.enfrentarTercero();
	}

	@Override
	public double enfrentarPrimero() {
		return -1;
	}

	@Override
	public double enfrentarSegundo() {
		return -0.5;
	}

	@Override
	public double enfrentarTercero() {
		return 1;
	}

	@Override
	public String toString() {
		return carga.toString();
	}

}
