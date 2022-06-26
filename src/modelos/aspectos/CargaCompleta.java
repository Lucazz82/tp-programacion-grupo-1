package modelos.aspectos;

import modelos.IDoubleDispatch;

public class CargaCompleta extends CargaHoraria {

	@Override
	public double enfrentar(IDoubleDispatch o) {
		return o.enfrentarSegundo();
	}

	@Override
	public double enfrentarPrimero() {
		return -0.5;
	}

	@Override
	public double enfrentarSegundo() {
		return 1.0;
	}

	@Override
	public double enfrentarTercero() {
		return -0.5;
	}

	@Override
	public String toString() {
		return "Carga Completa";
	}
}
