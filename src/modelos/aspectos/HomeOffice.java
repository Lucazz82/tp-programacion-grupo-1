package modelos.aspectos;

import modelos.IDoubleDispatch;

public class HomeOffice extends Locacion {

	@Override
	public double enfrentar(IDoubleDispatch o) {
		return o.enfrentarPrimero();
	}

	@Override
	public double enfrentarPrimero() {
		return 1;
	}

	@Override
	public double enfrentarSegundo() {
		return -1;
	}

	@Override
	public double enfrentarTercero() {
		return 1;
	}

}
