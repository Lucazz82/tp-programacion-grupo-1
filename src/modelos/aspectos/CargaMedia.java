package modelos.aspectos;

import modelos.IDoubleDispatch;

public class CargaMedia extends CargaHoraria {

	@Override
	public double enfrentar(IDoubleDispatch o) {
		return o.enfrentarPrimero();
	}

	@Override
	public double enfrentarPrimero() {
		return 1.0;
	}

	@Override
	public double enfrentarSegundo() {
		return -0.5;
	}

	@Override
	public double enfrentarTercero() {
		return -1.0;
	}

	@Override
	public String toString() {
		return "Carga Media";
	}

}
