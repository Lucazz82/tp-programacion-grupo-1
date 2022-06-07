package modelos.aspectos;

import enums.Locaciones;
import modelos.IDoubleDispatch;

public class Indistinto extends Locacion {

	public Indistinto() {
		super(Locaciones.CUALQUIERA);
	}

	@Override
	public double enfrentar(IDoubleDispatch o) {
		return o.enfrentarTercero();
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
